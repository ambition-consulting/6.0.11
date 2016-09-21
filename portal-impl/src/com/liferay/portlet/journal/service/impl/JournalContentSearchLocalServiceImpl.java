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

package com.liferay.portlet.journal.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.journal.model.JournalContentSearch;
import com.liferay.portlet.journal.service.base.JournalContentSearchLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */
public class JournalContentSearchLocalServiceImpl
	extends JournalContentSearchLocalServiceBaseImpl {

	public void checkContentSearches(long companyId)
		throws PortalException, SystemException {

		if (_log.isInfoEnabled()) {
			_log.info("Checking journal content search for " + companyId);
		}

		List<Layout> layouts = new ArrayList<Layout>();

		List<Group> groups = groupLocalService.search(
			companyId, null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Group group : groups) {

			// Private layouts

			deleteOwnerContentSearches(group.getGroupId(), true);

			layouts.addAll(
				layoutLocalService.getLayouts(group.getGroupId(), true));

			// Public layouts

			deleteOwnerContentSearches(group.getGroupId(), false);

			layouts.addAll(
				layoutLocalService.getLayouts(group.getGroupId(), false));
		}

		for (Layout layout : layouts) {
			LayoutTypePortlet layoutTypePortlet =
				(LayoutTypePortlet)layout.getLayoutType();

			List<String> portletIds = layoutTypePortlet.getPortletIds();

			for (String portletId : portletIds) {
				String rootPortletId = PortletConstants.getRootPortletId(
					portletId);

				if (rootPortletId.equals(PortletKeys.JOURNAL_CONTENT)) {
					PortletPreferences preferences =
						portletPreferencesLocalService.getPreferences(
							layout.getCompanyId(),
							PortletKeys.PREFS_OWNER_ID_DEFAULT,
							PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
							layout.getPlid(), portletId);

					String articleId = preferences.getValue(
						"article-id", StringPool.BLANK);

					if (Validator.isNotNull(articleId)) {
						updateContentSearch(
							layout.getGroupId(), layout.isPrivateLayout(),
							layout.getLayoutId(), portletId, articleId);
					}
				}
			}
		}
	}

	public void deleteArticleContentSearch(
			long groupId, boolean privateLayout, long layoutId,
			String portletId, String articleId)
		throws PortalException, SystemException {

		journalContentSearchPersistence.removeByG_P_L_P_A(
			groupId, privateLayout, layoutId, portletId, articleId);
	}

	public void deleteArticleContentSearches(long groupId, String articleId)
		throws SystemException {

		journalContentSearchPersistence.removeByG_A(groupId, articleId);
	}

	public void deleteLayoutContentSearches(
			long groupId, boolean privateLayout, long layoutId)
		throws SystemException {

		journalContentSearchPersistence.removeByG_P_L(
			groupId, privateLayout, layoutId);
	}

	public void deleteOwnerContentSearches(long groupId, boolean privateLayout)
		throws SystemException {

		journalContentSearchPersistence.removeByG_P(groupId, privateLayout);
	}

	public List<JournalContentSearch> getArticleContentSearches()
		throws SystemException {

		return journalContentSearchPersistence.findAll();
	}

	public List<JournalContentSearch> getArticleContentSearches(
			long groupId, String articleId)
		throws SystemException {

		return journalContentSearchPersistence.findByG_A(groupId, articleId);
	}

	public List<JournalContentSearch> getArticleContentSearches(
			String articleId)
		throws SystemException {

		return journalContentSearchPersistence.findByArticleId(articleId);
	}

	public List<Long> getLayoutIds(
			long groupId, boolean privateLayout, String articleId)
		throws SystemException {

		List<Long> layoutIds = new ArrayList<Long>();

		List<JournalContentSearch> contentSearches =
			journalContentSearchPersistence.findByG_P_A(
				groupId, privateLayout, articleId);

		for (JournalContentSearch contentSearch : contentSearches) {
			layoutIds.add(contentSearch.getLayoutId());
		}

		return layoutIds;
	}

	public int getLayoutIdsCount(
			long groupId, boolean privateLayout, String articleId)
		throws SystemException {

		return journalContentSearchPersistence.countByG_P_A(
			groupId, privateLayout, articleId);
	}

	public int getLayoutIdsCount(String articleId) throws SystemException {
		return journalContentSearchPersistence.countByArticleId(articleId);
	}

	public JournalContentSearch updateContentSearch(
			long groupId, boolean privateLayout, long layoutId,
			String portletId, String articleId)
		throws PortalException, SystemException {

		return updateContentSearch(
			groupId, privateLayout, layoutId, portletId, articleId, false);
	}

	public JournalContentSearch updateContentSearch(
			long groupId, boolean privateLayout, long layoutId,
			String portletId, String articleId, boolean purge)
		throws PortalException, SystemException {

		if (purge) {
			journalContentSearchPersistence.removeByG_P_L_P(
				groupId, privateLayout, layoutId, portletId);
		}

		Group group = groupPersistence.findByPrimaryKey(groupId);

		JournalContentSearch contentSearch =
			journalContentSearchPersistence.fetchByG_P_L_P_A(
				groupId, privateLayout, layoutId, portletId, articleId);

		if (contentSearch == null) {
			long contentSearchId = counterLocalService.increment();

			contentSearch = journalContentSearchPersistence.create(
				contentSearchId);

			contentSearch.setGroupId(groupId);
			contentSearch.setCompanyId(group.getCompanyId());
			contentSearch.setPrivateLayout(privateLayout);
			contentSearch.setLayoutId(layoutId);
			contentSearch.setPortletId(portletId);
			contentSearch.setArticleId(articleId);
		}

		journalContentSearchPersistence.update(contentSearch, false);

		return contentSearch;
	}

	public List<JournalContentSearch> updateContentSearch(
			long groupId, boolean privateLayout, long layoutId,
			String portletId, String[] articleIds)
		throws PortalException, SystemException {

		journalContentSearchPersistence.removeByG_P_L_P(
			groupId, privateLayout, layoutId, portletId);

		List<JournalContentSearch> contentSearches =
			new ArrayList<JournalContentSearch>();

		for (String articleId : articleIds) {
			JournalContentSearch contentSearch = updateContentSearch(
				groupId, privateLayout, layoutId, portletId, articleId, false);

			contentSearches.add(contentSearch);
		}

		return contentSearches;
	}

	private static Log _log = LogFactoryUtil.getLog(
		JournalContentSearchLocalServiceImpl.class);

}