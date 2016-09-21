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

package com.liferay.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.URLEncoder;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletApp;
import com.liferay.portal.servlet.NamespaceServletRequest;
import com.liferay.portal.struts.StrutsURLEncoder;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.servlet.DynamicServletRequest;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 */
public class PortletRequestDispatcherImpl implements PortletRequestDispatcher {

	public PortletRequestDispatcherImpl(
		RequestDispatcher requestDispatcher, boolean named,
		PortletContextImpl portletContextImpl) {

		this(requestDispatcher, named, portletContextImpl, null);
	}

	public PortletRequestDispatcherImpl(
		RequestDispatcher requestDispatcher, boolean named,
		PortletContextImpl portletContextImpl, String path) {

		_requestDispatcher = requestDispatcher;
		_named = named;
		_portlet = portletContextImpl.getPortlet();
		_portletContextImpl = portletContextImpl;
		_path = path;
	}

	public void forward(
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws IllegalStateException, IOException, PortletException {

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			portletResponse);

		if (response.isCommitted()) {
			throw new IllegalStateException("Response is already committed");
		}

		try {
			dispatch(portletRequest, portletResponse, false, false);
		}
		catch (ServletException se) {
			_log.error(se, se);

			throw new PortletException(se);
		}
	}

	public void include(
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws IOException, PortletException {

		try {
			dispatch(portletRequest, portletResponse, false, true);
		}
		catch (ServletException se) {
			_log.error(se, se);

			throw new PortletException(se);
		}
	}

	public void include(
			PortletRequest portletRequest, PortletResponse portletResponse,
			boolean strutsURLEncoder)
		throws IOException, PortletException {

		try {
			dispatch(portletRequest, portletResponse, strutsURLEncoder, true);
		}
		catch (ServletException se) {
			_log.error(se, se);

			throw new PortletException(se);
		}
	}

	public void include(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			dispatch(renderRequest, renderResponse, false, true);
		}
		catch (ServletException se) {
			_log.error(se, se);

			throw new PortletException(se);
		}
	}

	protected void dispatch(
			PortletRequest portletRequest, PortletResponse portletResponse,
			boolean strutsURLEncoder, boolean include)
		throws IOException, ServletException {

		if (!include) {
			if (portletResponse instanceof MimeResponseImpl) {
				MimeResponseImpl mimeResponseImpl =
					(MimeResponseImpl)portletResponse;

				if (mimeResponseImpl.isCalledFlushBuffer()) {
					throw new IllegalStateException();
				}
			}
		}

		PortletRequestImpl portletRequestImpl =
			PortletRequestImpl.getPortletRequestImpl(portletRequest);
		PortletResponseImpl portletResponseImpl =
			PortletResponseImpl.getPortletResponseImpl(portletResponse);

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			portletResponse);

		request.setAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST, portletRequest);
		request.setAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE, portletResponse);

		String pathInfo = null;
		String queryString = null;
		String requestURI = null;
		String servletPath = null;

		if (_path != null) {
			String pathNoQueryString = _path;

			int pos = _path.indexOf(CharPool.QUESTION);

			if (pos != -1) {
				pathNoQueryString = _path.substring(0, pos);
				queryString = _path.substring(pos + 1, _path.length());

				Map<String, String[]> queryParams =
					new HashMap<String, String[]>();

				String[] queryParamsArray = StringUtil.split(
					queryString, StringPool.AMPERSAND);

				for (int i = 0; i < queryParamsArray.length; i++) {
					String[] nameValuePair = StringUtil.split(
						queryParamsArray[i], StringPool.EQUAL);

					String name = nameValuePair[0];
					String value = StringPool.BLANK;

					if (nameValuePair.length == 2) {
						value = nameValuePair[1];
					}

					String[] values = queryParams.get(name);

					if (values == null) {
						queryParams.put(name, new String[] {value});
					}
					else {
						String[] newValues = new String[values.length + 1];

						System.arraycopy(
							values, 0, newValues, 0, values.length);

						newValues[newValues.length - 1] = value;

						queryParams.put(name, newValues);
					}
				}

				DynamicServletRequest dynamicRequest = null;

				if (portletRequestImpl.isPrivateRequestAttributes()) {
					String portletNamespace = PortalUtil.getPortletNamespace(
						portletRequestImpl.getPortletName());

					dynamicRequest = new NamespaceServletRequest(
						request, portletNamespace, portletNamespace);
				}
				else {
					dynamicRequest = new DynamicServletRequest(request);
				}

				for (Map.Entry<String, String[]> entry :
						queryParams.entrySet()) {

					String name = entry.getKey();
					String[] values = entry.getValue();

					String[] oldValues = dynamicRequest.getParameterValues(
						name);

					if (oldValues == null) {
						dynamicRequest.setParameterValues(name, values);
					}
					else {
						String[] newValues = ArrayUtil.append(
							values, oldValues);

						dynamicRequest.setParameterValues(name, newValues);
					}
				}

				request = dynamicRequest;
			}

			Portlet portlet = portletRequestImpl.getPortlet();

			PortletApp portletApp = portlet.getPortletApp();

			Set<String> servletURLPatterns = portletApp.getServletURLPatterns();

			for (String urlPattern : servletURLPatterns) {
				if (urlPattern.endsWith("/*")) {
					pos = urlPattern.indexOf("/*");

					urlPattern = urlPattern.substring(0, pos);

					if (pathNoQueryString.startsWith(urlPattern)) {
						pathInfo = pathNoQueryString.substring(
							urlPattern.length());
						servletPath = urlPattern;

						break;
					}
				}
			}

			if ((pathInfo == null) && (servletPath == null)) {
				pathInfo = pathNoQueryString;
				servletPath = pathNoQueryString;
			}

			requestURI = portletRequest.getContextPath() + pathNoQueryString;
		}

		PortletServletRequest portletServletRequest = new PortletServletRequest(
			request, portletRequestImpl, pathInfo, queryString, requestURI,
			servletPath, _named, include);

		PortletServletResponse portletServletResponse =
			new PortletServletResponse(response, portletResponseImpl, include);

		URLEncoder urlEncoder = _portlet.getURLEncoderInstance();

		if (urlEncoder != null) {
			portletResponseImpl.setURLEncoder(urlEncoder);
		}
		else if (strutsURLEncoder) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			URLEncoder strutsURLEncoderObj = new StrutsURLEncoder(
				portletServletRequest.getContextPath(),
				themeDisplay.getPathMain(),
				(String)_portletContextImpl.getAttribute(
					Globals.SERVLET_KEY),
				(LiferayPortletURL)portletResponseImpl.createRenderURL());

			portletResponseImpl.setURLEncoder(strutsURLEncoderObj);
		}

		if (include) {
			_requestDispatcher.include(
				portletServletRequest, portletServletResponse);
		}
		else {
			_requestDispatcher.forward(
				portletServletRequest, portletServletResponse);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortletRequestDispatcherImpl.class);

	private RequestDispatcher _requestDispatcher;
	private boolean _named;
	private Portlet _portlet;
	private PortletContextImpl _portletContextImpl;
	private String _path;

}