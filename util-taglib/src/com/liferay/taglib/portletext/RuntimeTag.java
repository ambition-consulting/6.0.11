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

package com.liferay.taglib.portletext;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.PipingServletResponse;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.layoutconfiguration.util.RuntimePortletUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class RuntimeTag extends TagSupport {

	public static void doTag(
			String portletName, PageContext pageContext,
			ServletContext servletContext, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		doTag(
			portletName, null, pageContext, servletContext, request, response);
	}

	public static void doTag(
			String portletName, String queryString, PageContext pageContext,
			ServletContext servletContext, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		doTag(
			portletName, queryString, null, pageContext, servletContext,
			request, response);
	}

	public static void doTag(
			String portletName, String queryString, String defaultPreferences,
			PageContext pageContext, ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		if (pageContext != null) {
			response = new PipingServletResponse(
				response, pageContext.getOut());
		}

		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		RenderRequest renderRequest = null;

		if ((portletRequest != null) &&
			(portletRequest instanceof RenderRequest)) {

			renderRequest = (RenderRequest)portletRequest;
		}

		PortletResponse portletResponse = (PortletResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		RenderResponse renderResponse = null;

		if ((portletResponse != null) &&
			(portletResponse instanceof RenderResponse)) {

			renderResponse = (RenderResponse)portletResponse;
		}

		String portletId = portletName;

		try {
			request.setAttribute(WebKeys.RENDER_PORTLET_RESOURCE, Boolean.TRUE);

			if (Validator.isNotNull(defaultPreferences)) {
				PortletPreferencesFactoryUtil.getPortletSetup(
					request, portletId, defaultPreferences);
			}

			RuntimePortletUtil.processPortlet(
				servletContext, request, response, renderRequest,
				renderResponse, portletId, queryString, true);
		}
		finally {
			request.removeAttribute(WebKeys.RENDER_PORTLET_RESOURCE);
		}
	}

	public int doEndTag() throws JspException {
		try {
			HttpServletRequest request =
				(HttpServletRequest)pageContext.getRequest();

			Layout layout = (Layout)request.getAttribute(WebKeys.LAYOUT);

			if (layout == null) {
				return EVAL_PAGE;
			}

			ServletContext servletContext =
				(ServletContext)request.getAttribute(WebKeys.CTX);

			HttpServletResponse response =
				(HttpServletResponse)pageContext.getResponse();

			doTag(
				_portletName, _queryString, _defaultPreferences, pageContext,
				servletContext, request, response);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new JspException(e);
		}
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
	}

	public void setQueryString(String queryString) {
		_queryString = queryString;
	}

	public void setDefaultPreferences(String defaultPreferences) {
		_defaultPreferences = defaultPreferences;
	}

	private static Log _log = LogFactoryUtil.getLog(RuntimeTag.class);

	private String _portletName;
	private String _queryString;
	private String _defaultPreferences;

}