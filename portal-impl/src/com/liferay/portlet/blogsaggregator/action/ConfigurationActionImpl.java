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

package com.liferay.portlet.blogsaggregator.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
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
 * @author Jorge Ferrer
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

		String selectionMethod = ParamUtil.getString(
			actionRequest, "selectionMethod");
		String organizationId = ParamUtil.getString(
			actionRequest, "organizationId");
		String displayStyle = ParamUtil.getString(
			actionRequest, "displayStyle");
		int max = ParamUtil.getInteger(actionRequest, "max");
		boolean enableRssSubscription = ParamUtil.getBoolean(
			actionRequest, "enableRssSubscription");
		boolean showTags = ParamUtil.getBoolean(
			actionRequest, "showTags");

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("selection-method", selectionMethod);
		preferences.setValue("organization-id", organizationId);
		preferences.setValue("display-style", displayStyle);
		preferences.setValue("max", String.valueOf(max));
		preferences.setValue(
			"enable-rss-subscription", String.valueOf(enableRssSubscription));
		preferences.setValue("show-tags", String.valueOf(showTags));

		preferences.store();

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/blogs_aggregator/configuration.jsp";
	}

}