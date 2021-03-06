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

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * @author Brian Wing Shun Chan
 */
public class SetPortletClassLoaderServlet extends HttpServlet {

	public void init(ServletConfig servletConfig) {
		ServletContext servletContext = servletConfig.getServletContext();

		Thread currentThread = Thread.currentThread();

		ClassLoader portletClassLoader = currentThread.getContextClassLoader();

		servletContext.setAttribute(
			PortletServlet.PORTLET_CLASS_LOADER, portletClassLoader);
	}

}