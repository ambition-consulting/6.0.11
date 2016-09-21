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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.File;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * @author Shuyang Zhou
 */
public class DirectServletRegistry {

	public static Servlet getServlet(String path) {
		return _instance._getServlet(path);
	}

	public static void putServlet(String path, Servlet servlet) {
		_instance._putServlet(path, servlet);
	}

	private DirectServletRegistry() {
	}

	private long _getJspFileLastModified(String path, Servlet servlet) {
		ServletConfig servletConfig = servlet.getServletConfig();

		ServletContext servletContext = servletConfig.getServletContext();

		String rootPath = servletContext.getRealPath(StringPool.BLANK);

		File file = new File(rootPath, path);

		return file.lastModified();
	}

	private Servlet _getServlet(String path) {
		ServletInfo servletInfo = _servletInfos.get(path);

		if (servletInfo == null) {
			return null;
		}

		Servlet servlet = servletInfo.getServlet();

		if (_DIRECT_SERVLET_CONTEXT_RELOAD) {
			long lastModified = _getJspFileLastModified(path, servlet);

			if ((lastModified == 0) ||
				(lastModified > servletInfo.getLastModified())) {

				_servletInfos.remove(path);

				servlet = null;
			}
		}

		return servlet;
	}

	private void _putServlet(String path, Servlet servlet) {
		if (_servletInfos.containsKey(path)) {
			return;
		}

		long lastModified = 1;

		if (_DIRECT_SERVLET_CONTEXT_RELOAD) {
			lastModified = _getJspFileLastModified(path, servlet);
		}

		if (lastModified > 0) {
			ServletInfo servletInfo = new ServletInfo();

			servletInfo.setLastModified(lastModified);
			servletInfo.setServlet(servlet);

			_servletInfos.put(path, servletInfo);
		}
	}

	private static boolean _DIRECT_SERVLET_CONTEXT_RELOAD =
		GetterUtil.getBoolean(
			PropsUtil.get(PropsKeys.DIRECT_SERVLET_CONTEXT_RELOAD));

	private static DirectServletRegistry _instance =
		new DirectServletRegistry();

	private Map<String, ServletInfo> _servletInfos =
		new ConcurrentHashMap<String, ServletInfo>();

	private class ServletInfo {

		public long getLastModified() {
			return _lastModified;
		}

		public Servlet getServlet() {
			return _servlet;
		}

		public void setLastModified(long lastModified) {
			_lastModified = lastModified;
		}

		public void setServlet(Servlet servlet) {
			_servlet = servlet;
		}

		private long _lastModified;
		private Servlet _servlet;

	}

}