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

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.PortletFilterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.filter.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletServlet extends HttpServlet {

	public static final String PORTLET_APP =
		"com.liferay.portal.model.PortletApp";

	public static final String PORTLET_CLASS_LOADER = "PORTLET_CLASS_LOADER";

	public static final String PORTLET_SERVLET_CONFIG =
		"com.liferay.portal.kernel.servlet.PortletServletConfig";

	public static final String PORTLET_SERVLET_FILTER_CHAIN =
		"com.liferay.portal.kernel.servlet.PortletServletFilterChain";

	public static final String PORTLET_SERVLET_REQUEST =
		"com.liferay.portal.kernel.servlet.PortletServletRequest";

	public static final String PORTLET_SERVLET_RESPONSE =
		"com.liferay.portal.kernel.servlet.PortletServletResponse";

	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		String portletId = (String)request.getAttribute(WebKeys.PORTLET_ID);

		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		PortletResponse portletResponse = (PortletResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		String lifecycle = (String)request.getAttribute(
			PortletRequest.LIFECYCLE_PHASE);

		FilterChain filterChain = (FilterChain)request.getAttribute(
			PORTLET_SERVLET_FILTER_CHAIN);

		LiferayPortletSession portletSession =
			(LiferayPortletSession)portletRequest.getPortletSession();

		portletRequest.setAttribute(WebKeys.PORTLET_ID, portletId);
		portletRequest.setAttribute(PORTLET_SERVLET_CONFIG, getServletConfig());
		portletRequest.setAttribute(PORTLET_SERVLET_REQUEST, request);
		portletRequest.setAttribute(PORTLET_SERVLET_RESPONSE, response);

		HttpSession session = request.getSession();

		PortletSessionTracker.add(session);

		portletSession.setHttpSession(session);

		try {
			PortletFilterUtil.doFilter(
				portletRequest, portletResponse, lifecycle, filterChain);
		}
		catch (PortletException pe) {
			_log.error(pe, pe);

			throw new ServletException(pe);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PortletServlet.class);

}