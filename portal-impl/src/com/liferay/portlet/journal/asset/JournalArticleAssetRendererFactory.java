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

package com.liferay.portlet.journal.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.service.permission.JournalArticlePermission;
import com.liferay.portlet.journal.service.permission.JournalPermission;

import javax.portlet.PortletURL;

/**
 * @author Julio Camarero
 * @author Juan Fernández
 * @author Raymond Augé
 */
public class JournalArticleAssetRendererFactory
	extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = JournalArticle.class.getName();

	public static final String TYPE = "content";

	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		JournalArticle article = null;

		try {
			article = JournalArticleLocalServiceUtil.getArticle(classPK);
		}
		catch (NoSuchArticleException nsae) {
			JournalArticleResource articleResource =
				JournalArticleResourceLocalServiceUtil.getArticleResource(
					classPK);

			int status = WorkflowConstants.STATUS_ANY;

			if (type == TYPE_LATEST_APPROVED) {
				status = WorkflowConstants.STATUS_APPROVED;
			}

			article =
				JournalArticleLocalServiceUtil.getLatestArticle(
					articleResource.getGroupId(),
					articleResource.getArticleId(), status);
		}

		return new JournalArticleAssetRenderer(article);
	}

	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
		throws PortalException, SystemException {

		JournalArticle article = JournalArticleServiceUtil.getArticleByUrlTitle(
			groupId, urlTitle);

		return new JournalArticleAssetRenderer(article);
	}

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType() {
		return TYPE;
	}

	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletURL addAssetURL = null;

		if (JournalPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(), ActionKeys.ADD_ARTICLE)) {

			addAssetURL = liferayPortletResponse.createRenderURL(
				PortletKeys.JOURNAL);

			addAssetURL.setParameter("struts_action", "/journal/edit_article");
			addAssetURL.setParameter(
				"groupId", String.valueOf(themeDisplay.getScopeGroupId()));
		}

		return addAssetURL;
	}

	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return JournalArticlePermission.contains(
			permissionChecker, classPK, actionId);
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

}