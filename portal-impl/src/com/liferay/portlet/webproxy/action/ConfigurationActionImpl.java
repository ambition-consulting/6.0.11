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

package com.liferay.portlet.webproxy.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
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

		String initUrl = ParamUtil.getString(actionRequest, "initUrl");

		if (!initUrl.startsWith("/") &&
			!StringUtil.startsWith(initUrl, "http://") &&
			!StringUtil.startsWith(initUrl, "https://") &&
			!StringUtil.startsWith(initUrl, "mhtml://")) {

			initUrl = HttpUtil.getProtocol(actionRequest) + "://" + initUrl;
		}

		String scope = ParamUtil.getString(actionRequest, "scope");
		String proxyHost = ParamUtil.getString(actionRequest, "proxyHost");
		String proxyPort = ParamUtil.getString(actionRequest, "proxyPort");
		String proxyAuthentication = ParamUtil.getString(
			actionRequest, "proxyAuthentication");
		String proxyAuthenticationUsername = ParamUtil.getString(
			actionRequest, "proxyAuthenticationUsername");
		String proxyAuthenticationPassword = ParamUtil.getString(
			actionRequest, "proxyAuthenticationPassword");
		String proxyAuthenticationHost = ParamUtil.getString(
			actionRequest, "proxyAuthenticationHost");
		String proxyAuthenticationDomain = ParamUtil.getString(
			actionRequest, "proxyAuthenticationDomain");
		String stylesheet = ParamUtil.getString(actionRequest, "stylesheet");

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("initUrl", initUrl);
		preferences.setValue("scope", scope);
		preferences.setValue("proxyHost", proxyHost);
		preferences.setValue("proxyPort", proxyPort);
		preferences.setValue("proxyAuthentication", proxyAuthentication);
		preferences.setValue(
			"proxyAuthenticationUsername", proxyAuthenticationUsername);
		preferences.setValue(
			"proxyAuthenticationPassword", proxyAuthenticationPassword);
		preferences.setValue(
			"proxyAuthenticationHost", proxyAuthenticationHost);
		preferences.setValue(
			"proxyAuthenticationDomain", proxyAuthenticationDomain);
		preferences.setValue("stylesheet", stylesheet);

		preferences.store();

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/web_proxy/configuration.jsp";
	}

}