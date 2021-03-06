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

package com.liferay.util.servlet;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.PwdGenerator;
import com.liferay.util.SystemProperties;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class SessionParameters {

	public static final boolean USE_SESSION_PARAMETERS = GetterUtil.getBoolean(
		SystemProperties.get(SessionParameters.class.getName()), true);

	public static final String KEY = SessionParameters.class.getName();

	// Servlet Request

	public static String get(HttpServletRequest request, String parameter) {
		return get(request.getSession(), parameter);
	}

	public static String get(HttpSession session, String parameter) {
		if (!USE_SESSION_PARAMETERS) {
			return parameter;
		}

		Map<String, String> parameters = _getParameters(session);

		String newParameter = parameters.get(parameter);

		if (newParameter == null) {
			newParameter =
				PwdGenerator.getPassword() + StringPool.UNDERLINE + parameter;

			parameters.put(parameter, newParameter);
		}

		return newParameter;
	}

	private static Map<String, String> _getParameters(HttpSession session) {
		Map<String, String> parameters = null;

		try {
			parameters = (Map<String, String>)session.getAttribute(KEY);

			if (parameters == null) {
				parameters = new HashMap<String, String>();

				session.setAttribute(KEY, parameters);
			}
		}
		catch (IllegalStateException ise) {
			parameters = new HashMap<String, String>();
		}

		return parameters;
	}

	// Portlet Request

	public static String get(PortletRequest portletRequest, String parameter) {
		return get(portletRequest.getPortletSession(), parameter);
	}

	public static String get(PortletSession portletSession, String parameter) {
		if (!USE_SESSION_PARAMETERS) {
			return parameter;
		}

		Map<String, String> parameters = _getParameters(portletSession);

		String newParameter = parameters.get(parameter);

		if (newParameter == null) {
			newParameter =
				PwdGenerator.getPassword() + StringPool.UNDERLINE + parameter;

			parameters.put(parameter, newParameter);
		}

		return newParameter;
	}

	private static Map<String, String> _getParameters(
		PortletSession portletSession) {

		Map<String, String> parameters = null;

		try {
			parameters = (Map<String, String>)portletSession.getAttribute(KEY);

			if (parameters == null) {
				parameters = new LinkedHashMap<String, String>();

				portletSession.setAttribute(KEY, parameters);
			}
		}
		catch (IllegalStateException ise) {
			parameters = new LinkedHashMap<String, String>();
		}

		return parameters;
	}

}