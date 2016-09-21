/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.xslcontent.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.xslcontent.util.XSLContentUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Hugo Huijser
 * @author Samuel Kong
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

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String[] validUrlPrefixes = getValidUrlPrefixes(themeDisplay);

		String xmlURL = ParamUtil.getString(actionRequest, "xmlURL");

		xmlURL = XSLContentUtil.replaceUrlTokens(themeDisplay, xmlURL);

		String xslURL = ParamUtil.getString(actionRequest, "xslURL");

		xslURL = XSLContentUtil.replaceUrlTokens(themeDisplay, xslURL);

		if (!hasValidUrlPrefix(validUrlPrefixes, xmlURL)) {
			SessionErrors.add(actionRequest, "xmlURL");
		}
		else if (!hasValidUrlPrefix(validUrlPrefixes, xslURL)) {
			SessionErrors.add(actionRequest, "xslURL");
		}
		else {
			String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					actionRequest, portletResource);

			preferences.setValue("xml-url", xmlURL);
			preferences.setValue("xsl-url", xslURL);

			preferences.store();

			SessionMessages.add(
				actionRequest, portletConfig.getPortletName() + ".doConfigure");
		}
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/xsl_content/configuration.jsp";
	}

	protected String[] getValidUrlPrefixes(ThemeDisplay themeDisplay) {
		String validUrlPrefixes = PropsUtil.get(
			"xsl.content.valid.url.prefixes");

		validUrlPrefixes = XSLContentUtil.replaceUrlTokens(
			themeDisplay, validUrlPrefixes);

		return StringUtil.split(validUrlPrefixes);
	}

	protected boolean hasValidUrlPrefix(String[] validUrlPrefixes, String url) {
		if (validUrlPrefixes.length == 0) {
			return true;
		}

		for (String validUrlPrefix : validUrlPrefixes) {
			if (StringUtil.startsWith(url, validUrlPrefix)) {
				return true;
			}
		}

		return false;
	}

}