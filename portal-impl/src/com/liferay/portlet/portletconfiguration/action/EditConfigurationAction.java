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

package com.liferay.portlet.portletconfiguration.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.ResourceServingConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.portletconfiguration.util.PortletConfigurationUtil;

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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditConfigurationAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		Portlet portlet = null;

		try {
			portlet = getPortlet(actionRequest);
		}
		catch (PrincipalException pe) {
			SessionErrors.add(
				actionRequest, PrincipalException.class.getName());

			setForward(actionRequest, "portlet.portlet_configuration.error");

			return;
		}

		ConfigurationAction configurationAction = getConfigurationAction(
			portlet);

		if (configurationAction != null) {
			configurationAction.processAction(
				portletConfig, actionRequest, actionResponse);
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		Portlet portlet = null;

		try {
			portlet = getPortlet(renderRequest);
		}
		catch (PrincipalException pe) {
			SessionErrors.add(
				renderRequest, PrincipalException.class.getName());

			return mapping.findForward("portlet.portlet_configuration.error");
		}

		renderResponse.setTitle(getTitle(portlet, renderRequest));

		ConfigurationAction configurationAction = getConfigurationAction(
			portlet);

		if (configurationAction != null) {
			String path = configurationAction.render(
				portletConfig, renderRequest, renderResponse);

			if (_log.isDebugEnabled()) {
				_log.debug("Configuration action returned render path " + path);
			}

			if (Validator.isNotNull(path)) {
				renderRequest.setAttribute(
					WebKeys.CONFIGURATION_ACTION_PATH, path);
			}
			else {
				_log.error("Configuration action returned a null path");
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.portlet_configuration.edit_configuration"));
	}

	public void serveResource(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		Portlet portlet = null;

		try {
			portlet = getPortlet(resourceRequest);
		}
		catch (PrincipalException pe) {
			return;
		}

		ResourceServingConfigurationAction resourceServingConfigurationAction =
			(ResourceServingConfigurationAction)getConfigurationAction(
				portlet);

		if (resourceServingConfigurationAction != null) {
			resourceServingConfigurationAction.serveResource(
				portletConfig, resourceRequest, resourceResponse);
		}
	}

	protected ConfigurationAction getConfigurationAction(Portlet portlet)
		throws Exception {

		if (portlet == null) {
			return null;
		}

		ConfigurationAction configurationAction =
			portlet.getConfigurationActionInstance();

		if (configurationAction == null) {
			_log.error(
				"Configuration action for portlet " + portlet.getPortletId() +
					" is null");
		}

		return configurationAction;
	}

	protected Portlet getPortlet(PortletRequest portletRequest)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		String portletId = ParamUtil.getString(
			portletRequest, "portletResource");

		if (!PortletPermissionUtil.contains(
				permissionChecker, themeDisplay.getPlid(), portletId,
				ActionKeys.CONFIGURATION)) {

			throw new PrincipalException();
		}

		return PortletLocalServiceUtil.getPortletById(companyId, portletId);
	}

	protected String getTitle(Portlet portlet, RenderRequest renderRequest)
		throws Exception {

		ServletContext servletContext =
			(ServletContext)renderRequest.getAttribute(WebKeys.CTX);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletSetup =
			PortletPreferencesFactoryUtil.getPortletSetup(
				renderRequest, portlet.getPortletId());

		String title = PortletConfigurationUtil.getPortletTitle(
			portletSetup, themeDisplay.getLanguageId());

		if (Validator.isNull(title)) {
			title = PortalUtil.getPortletTitle(
				portlet, servletContext, themeDisplay.getLocale());
		}

		return title;
	}

	private static Log _log = LogFactoryUtil.getLog(
		EditConfigurationAction.class);

}