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

package com.liferay.portlet.journalarticles.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

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
		String type = ParamUtil.getString(actionRequest, "type");
		String structureId = ParamUtil.getString(actionRequest, "structureId");
		String pageURL = ParamUtil.getString(actionRequest, "pageURL");
		int pageDelta = ParamUtil.getInteger(actionRequest, "pageDelta");
		String orderByCol = ParamUtil.getString(actionRequest, "orderByCol");
		String orderByType = ParamUtil.getString(actionRequest, "orderByType");

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("group-id", String.valueOf(groupId));
		preferences.setValue("type", type);
		preferences.setValue("structure-id", structureId);
		preferences.setValue("page-url", pageURL);
		preferences.setValue("page-delta", String.valueOf(pageDelta));
		preferences.setValue("order-by-col", orderByCol);
		preferences.setValue("order-by-type", orderByType);

		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();

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

		return "/html/portlet/journal_articles/configuration.jsp";
	}

}