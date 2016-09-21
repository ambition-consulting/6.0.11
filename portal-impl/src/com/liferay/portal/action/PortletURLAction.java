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

package com.liferay.portal.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletModeFactory;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.util.servlet.ServletResponseUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Eduardo Lundgren
 * @deprecated As of 6.2.0 with no direct replacement
 */
public class PortletURLAction extends Action {

	public static final boolean PORTLET_URL_GENERATE_BY_PATH_ENABLED =
		GetterUtil.getBoolean(PropsUtil.get(
			"portlet.url.generate.by.path.enabled"));

	public static final String[] PORTLET_URL_GENERATE_BY_PATH_WHITELIST =
		PropsUtil.getArray("portlet.url.generate.by.path.whitelist");

	@Override
	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		String portletId = ParamUtil.getString(request, "portletId");

		String rootPortletId = PortletConstants.getRootPortletId(portletId);

		String[] portletUrlGenerateByPathWhitelist =
			PORTLET_URL_GENERATE_BY_PATH_WHITELIST;

		if (!PORTLET_URL_GENERATE_BY_PATH_ENABLED &&
			!ArrayUtil.contains(
				portletUrlGenerateByPathWhitelist, rootPortletId)) {

			response.sendError(HttpServletResponse.SC_FORBIDDEN);

			return null;
		}

		try {
			String portletURL = getPortletURL(request);

			ServletResponseUtil.write(response, portletURL);
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);
		}

		return null;
	}

	protected String getPortletURL(HttpServletRequest request)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String cacheability = ParamUtil.getString(request, "cacheability");
		boolean copyCurrentRenderParameters = ParamUtil.getBoolean(
			request, "copyCurrentRenderParameters");
		long doAsUserId = ParamUtil.getLong(request, "doAsUserId");
		String doAsUserLanguageId = ParamUtil.getString(
			request, "doAsUserLanguageId");
		boolean encrypt = ParamUtil.getBoolean(request, "encrypt");
		boolean escapeXml = ParamUtil.getBoolean(request, "escapeXml");
		String lifecycle = ParamUtil.getString(request, "lifecycle");
		String name = ParamUtil.getString(request, "name");
		boolean portletConfiguration = ParamUtil.getBoolean(
			request, "portletConfiguration");
		String portletId = ParamUtil.getString(request, "portletId");
		String portletMode = ParamUtil.getString(request, "portletMode");
		String resourceId = ParamUtil.getString(request, "resourceId");
		String returnToFullPageURL = ParamUtil.getString(
			request, "returnToFullPageURL");
		boolean secure = ParamUtil.getBoolean(request, "secure");
		String windowState = ParamUtil.getString(request, "windowState");

		PortletURLImpl portletURL = new PortletURLImpl(
			request, portletId, themeDisplay.getPlid(), lifecycle);

		if (Validator.isNotNull(cacheability)) {
			portletURL.setCacheability(cacheability);
		}

		portletURL.setCopyCurrentRenderParameters(copyCurrentRenderParameters);

		if (doAsUserId > 0) {
			portletURL.setDoAsUserId(doAsUserId);
		}

		if (Validator.isNotNull(doAsUserLanguageId)) {
			portletURL.setDoAsUserLanguageId(doAsUserLanguageId);
		}

		portletURL.setEncrypt(encrypt);
		portletURL.setEscapeXml(escapeXml);

		if (lifecycle.equals(PortletRequest.ACTION_PHASE) &&
			Validator.isNotNull(name)) {

			portletURL.setParameter(ActionRequest.ACTION_NAME, name);
		}

		portletURL.setPortletId(portletId);

		if (portletConfiguration) {
			String portletResource = ParamUtil.getString(
				request, "portletResource");
			String previewWidth = ParamUtil.getString(request, "previewWidth");

			portletURL.setParameter(
				"struts_action", "/portlet_configuration/edit_configuration");
			portletURL.setParameter("returnToFullPageURL", returnToFullPageURL);
			portletURL.setParameter("portletResource", portletResource);
			portletURL.setParameter("previewWidth", previewWidth);
		}

		if (Validator.isNotNull(portletMode)) {
			portletURL.setPortletMode(
				PortletModeFactory.getPortletMode(portletMode));
		}

		if (Validator.isNotNull(resourceId)) {
			portletURL.setResourceID(resourceId);
		}

		if (!themeDisplay.isStateMaximized()) {
			if (Validator.isNotNull(returnToFullPageURL)) {
				portletURL.setParameter(
					"returnToFullPageURL", returnToFullPageURL);
			}
		}

		portletURL.setSecure(secure);

		if (Validator.isNotNull(windowState)) {
			portletURL.setWindowState(
				WindowStateFactory.getWindowState(windowState));
		}

		String parameterMapString = ParamUtil.getString(
			request, "parameterMap");

		if (Validator.isNotNull(parameterMapString)) {
			Map<String, String> parameterMap =
				(Map<String, String>)JSONFactoryUtil.deserialize(
					parameterMapString);

			for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
				portletURL.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return portletURL.toString();
	}

}