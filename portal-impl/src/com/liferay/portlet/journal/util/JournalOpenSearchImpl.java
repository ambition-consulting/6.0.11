/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portlet.journal.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalContentSearch;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */
public class JournalOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/journal/open_search";

	public static final String TITLE = "Liferay Journal Search: ";

	public String getPortletId() {
		return JournalIndexer.PORTLET_ID;
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

	protected String getLayoutURL(ThemeDisplay themeDisplay, String articleId)
		throws Exception {

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		List<JournalContentSearch> contentSearches =
			JournalContentSearchLocalServiceUtil.getArticleContentSearches(
				articleId);

		for (JournalContentSearch contentSearch : contentSearches) {
			if (LayoutPermissionUtil.contains(
					permissionChecker, contentSearch.getGroupId(),
					contentSearch.isPrivateLayout(),
					contentSearch.getLayoutId(), ActionKeys.VIEW)) {

				if (contentSearch.isPrivateLayout()) {
					if (!GroupLocalServiceUtil.hasUserGroup(
							themeDisplay.getUserId(),
							contentSearch.getGroupId())) {

						continue;
					}
				}

				Layout hitLayout = LayoutLocalServiceUtil.getLayout(
					contentSearch.getGroupId(), contentSearch.isPrivateLayout(),
					contentSearch.getLayoutId());

				return PortalUtil.getLayoutURL(hitLayout, themeDisplay);
			}
		}

		return null;
	}

	protected String getURL(
			ThemeDisplay themeDisplay, long groupId, Document result,
			PortletURL portletURL)
		throws Exception {

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		Layout layout = themeDisplay.getLayout();

		String articleId = result.get(Field.ENTRY_CLASS_PK);
		String version = result.get("version");

		List<Long> hitLayoutIds =
			JournalContentSearchLocalServiceUtil.getLayoutIds(
				layout.getGroupId(), layout.isPrivateLayout(), articleId);

		for (Long hitLayoutId : hitLayoutIds) {
			if (LayoutPermissionUtil.contains(
					permissionChecker, layout.getGroupId(),
					layout.isPrivateLayout(), hitLayoutId, ActionKeys.VIEW)) {

				Layout hitLayout = LayoutLocalServiceUtil.getLayout(
					layout.getGroupId(), layout.isPrivateLayout(),
					hitLayoutId.longValue());

				return PortalUtil.getLayoutURL(hitLayout, themeDisplay);
			}
		}

		String layoutURL = getLayoutURL(themeDisplay, articleId);

		if (layoutURL != null) {
			return layoutURL;
		}

		StringBundler sb = new StringBundler(7);

		sb.append(themeDisplay.getPathMain());
		sb.append("/journal/view_article_content?groupId=");
		sb.append(groupId);
		sb.append("&articleId=");
		sb.append(articleId);
		sb.append("&version=");
		sb.append(version);

		return sb.toString();
	}

}