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

import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Enumeration;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Shuyang Zhou
 */
public class DirectServletContext implements ServletContext {

	public DirectServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	public Object getAttribute(String name) {
		return _servletContext.getAttribute(name);
	}

	public Enumeration<String> getAttributeNames() {
		return _servletContext.getAttributeNames();
	}

	public ServletContext getContext(String uriPath) {
		return _servletContext.getContext(uriPath);
	}

	public String getContextPath() {
		return _servletContext.getContextPath();
	}

	public String getInitParameter(String name) {
		return _servletContext.getInitParameter(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return _servletContext.getInitParameterNames();
	}

	public int getMajorVersion() {
		return _servletContext.getMajorVersion();
	}

	public String getMimeType(String file) {
		return _servletContext.getMimeType(file);
	}

	public int getMinorVersion() {
		return _servletContext.getMinorVersion();
	}

	public RequestDispatcher getNamedDispatcher(String name) {
		return _servletContext.getNamedDispatcher(name);
	}

	public String getRealPath(String path) {
		return _servletContext.getRealPath(path);
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		Servlet servlet = DirectServletRegistry.getServlet(path);

		if (servlet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No servlet found for " + path);
			}

			return _servletContext.getRequestDispatcher(path);
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug("Servlet found for " + path);
			}

			return new DirectRequestDispatcher(servlet);
		}
	}

	public URL getResource(String path) throws MalformedURLException {
		return _servletContext.getResource(path);
	}

	public InputStream getResourceAsStream(String path) {
		return _servletContext.getResourceAsStream(path);
	}

	public Set<String> getResourcePaths(String path) {
		return _servletContext.getResourcePaths(path);
	}

	public String getServerInfo() {
		return _servletContext.getServerInfo();
	}

	/**
	 * @deprecated
	 */
	public Servlet getServlet(String name) throws ServletException {
		return _servletContext.getServlet(name);
	}

	public String getServletContextName() {
		return _servletContext.getServletContextName();
	}

	/**
	 * @deprecated
	 */
	public Enumeration<String> getServletNames() {
		return _servletContext.getServletNames();
	}

	/**
	 * @deprecated
	 */
	public Enumeration<Servlet> getServlets() {
		return _servletContext.getServlets();
	}

	/**
	 * @deprecated
	 */
	public void log(Exception exception, String message) {
		_servletContext.log(exception, message);
	}

	public void log(String message) {
		_servletContext.log(message);
	}

	public void log(String message, Throwable t) {
		_servletContext.log(message, t);
	}

	public void removeAttribute(String name) {
		_servletContext.removeAttribute(name);
	}

	public void setAttribute(String name, Object value) {
		_servletContext.setAttribute(name, value);
	}

	private static Log _log = LogFactoryUtil.getLog(DirectServletContext.class);

	private ServletContext _servletContext;

}