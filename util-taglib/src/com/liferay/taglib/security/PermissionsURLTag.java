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

package com.liferay.taglib.security;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsURLTag extends TagSupport {

	/**
	 * @deprecated
	 */
	public static void doTag(
			String redirect, String modelResource,
			String modelResourceDescription, String resourcePrimKey, String var,
			PageContext pageContext)
		throws Exception {

		doTag(
			redirect, modelResource, modelResourceDescription, resourcePrimKey,
			var, null, pageContext);
	}

	public static void doTag(
			String redirect, String modelResource,
			String modelResourceDescription, String resourcePrimKey, String var,
			int[] roleTypes, PageContext pageContext)
		throws Exception {

		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		Layout layout = themeDisplay.getLayout();

		if (Validator.isNull(redirect)) {
			redirect = PortalUtil.getCurrentURL(request);
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, PortletKeys.PORTLET_CONFIGURATION, layout.getPlid(),
			PortletRequest.RENDER_PHASE);

		if (themeDisplay.isStatePopUp()) {
			portletURL.setWindowState(LiferayWindowState.POP_UP);
		}
		else {
			portletURL.setWindowState(WindowState.MAXIMIZED);
		}

		portletURL.setParameter(
			"struts_action", "/portlet_configuration/edit_permissions");
		portletURL.setParameter("redirect", redirect);

		if (!themeDisplay.isStateMaximized()) {
			portletURL.setParameter("returnToFullPageURL", redirect);
		}

		portletURL.setParameter("portletResource", portletDisplay.getId());
		portletURL.setParameter("modelResource", modelResource);
		portletURL.setParameter(
			"modelResourceDescription", modelResourceDescription);
		portletURL.setParameter("resourcePrimKey", resourcePrimKey);

		if (roleTypes != null) {
			portletURL.setParameter("roleTypes", StringUtil.merge(roleTypes));
		}

		String portletURLToString = portletURL.toString();

		if (Validator.isNotNull(var)) {
			pageContext.setAttribute(var, portletURLToString);
		}
		else {
			JspWriter jspWriter = pageContext.getOut();

			jspWriter.write(portletURLToString);
		}
	}

	public int doEndTag() throws JspException {
		try {
			doTag(
				_redirect, _modelResource, _modelResourceDescription,
				_resourcePrimKey, _var, _roleTypes, pageContext);
		}
		catch (Exception e) {
			throw new JspException(e);
		}

		return EVAL_PAGE;
	}

	public void setRedirect(String redirect) {
		_redirect = redirect;
	}

	public void setModelResource(String modelResource) {
		_modelResource = modelResource;
	}

	public void setModelResourceDescription(String modelResourceDescription) {
		_modelResourceDescription = modelResourceDescription;
	}

	public void setResourcePrimKey(String resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public void setRoleTypes(int[] roleTypes) {
		_roleTypes = roleTypes;
	}

	public void setVar(String var) {
		_var = var;
	}

	private String _redirect;
	private String _modelResource;
	private String _modelResourceDescription;
	private String _resourcePrimKey;
	private int[] _roleTypes;
	private String _var;

}