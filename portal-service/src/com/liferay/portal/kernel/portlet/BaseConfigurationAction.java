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

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class BaseConfigurationAction
	implements ConfigurationAction, ResourceServingConfigurationAction {

	public final static String PREFERENCES_PREFIX = "preferences--";

	public String getParameter(PortletRequest portletRequest, String name) {
		name = PREFERENCES_PREFIX.concat(name).concat(StringPool.DOUBLE_DASH);

		return ParamUtil.getString(portletRequest, name);
	}

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		UnicodeProperties properties = PropertiesParamUtil.getProperties(
			actionRequest, PREFERENCES_PREFIX);

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		for (Map.Entry<String, String> entry : properties.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();

			portletPreferences.setValue(name, value);
		}

		Map<String, String[]> portletPreferencesMap =
			(Map<String, String[]>)actionRequest.getAttribute(
				WebKeys.PORTLET_PREFERENCES_MAP);

		if (portletPreferencesMap != null) {
			for (Map.Entry<String, String[]> entry :
					portletPreferencesMap.entrySet()) {

				String name = entry.getKey();
				String[] values = entry.getValue();

				portletPreferences.setValues(name, values);
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			SessionMessages.add(
				actionRequest, portletConfig.getPortletName() + ".doConfigure");
		}
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configJSP = selPortletConfig.getInitParameter("config-jsp");

		if (Validator.isNotNull(configJSP)) {
			return configJSP;
		}

		return "/configuration.jsp";
	}

	public void serveResource(
			PortletConfig portletConfig, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse)
		throws Exception {
	}

	public void setPreference(
		PortletRequest portletRequest, String name, String value) {

		setPreference(portletRequest, name, new String[] {value});
	}

	public void setPreference(
		PortletRequest portletRequest, String name, String[] values) {

		Map<String, String[]> portletPreferencesMap =
			(Map<String, String[]>)portletRequest.getAttribute(
				WebKeys.PORTLET_PREFERENCES_MAP);

		if (portletPreferencesMap == null) {
			portletPreferencesMap = new HashMap<String, String[]>();

			portletRequest.setAttribute(
				WebKeys.PORTLET_PREFERENCES_MAP, portletPreferencesMap);
		}

		portletPreferencesMap.put(name, values);
	}

	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest)
		throws SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(
			portletRequest, "portletResource");

		Portlet selPortlet = PortletLocalServiceUtil.getPortletById(
			themeDisplay.getCompanyId(), portletResource);

		ServletContext servletContext =
			(ServletContext)portletRequest.getAttribute(WebKeys.CTX);

		PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(
			selPortlet, servletContext);

		return selPortletConfig;
	}

}