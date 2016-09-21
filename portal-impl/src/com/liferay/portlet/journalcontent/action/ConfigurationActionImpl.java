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

package com.liferay.portlet.journalcontent.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends BaseConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		String articleId = ParamUtil.getString(
			actionRequest, "articleId").toUpperCase();
		String templateId = ParamUtil.getString(
			actionRequest, "templateId").toUpperCase();
		boolean showAvailableLocales = ParamUtil.getBoolean(
			actionRequest, "showAvailableLocales");
		String[] extensions = actionRequest.getParameterValues("extensions");
		boolean enablePrint = ParamUtil.getBoolean(
			actionRequest, "enablePrint");
		boolean enableRatings = ParamUtil.getBoolean(
			actionRequest, "enableRatings");
		boolean enableComments = ParamUtil.getBoolean(
			actionRequest, "enableComments");
		boolean enableCommentRatings = ParamUtil.getBoolean(
			actionRequest, "enableCommentRatings");

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("group-id", String.valueOf(groupId));
		preferences.setValue("article-id", articleId);
		preferences.setValue("template-id", templateId);
		preferences.setValue(
			"show-available-locales", String.valueOf(showAvailableLocales));
		preferences.setValues("extensions", extensions);
		preferences.setValue("enable-print", String.valueOf(enablePrint));
		preferences.setValue("enable-ratings", String.valueOf(enableRatings));
		preferences.setValue("enable-comments", String.valueOf(enableComments));
		preferences.setValue(
			"enable-comment-ratings", String.valueOf(enableCommentRatings));

		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();

			updateContentSearch(actionRequest, portletResource, articleId);

			SessionMessages.add(
				actionRequest, portletConfig.getPortletName() + ".doConfigure");
		}

		actionResponse.sendRedirect(
			ParamUtil.getString(actionRequest, "redirect"));
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/journal_content/configuration.jsp";
	}

	protected void updateContentSearch(
			ActionRequest actionRequest, String portletResource,
			String articleId)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		JournalContentSearchLocalServiceUtil.updateContentSearch(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(),
			portletResource, articleId, true);
	}

}