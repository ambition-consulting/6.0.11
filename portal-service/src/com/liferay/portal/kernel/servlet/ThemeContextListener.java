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

import com.liferay.portal.kernel.deploy.hot.HotDeployEvent;
import com.liferay.portal.kernel.deploy.hot.HotDeployUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class ThemeContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		HotDeployUtil.fireDeployEvent(
			new HotDeployEvent(servletContext, contextClassLoader));
	}

	public void contextDestroyed(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		HotDeployUtil.fireUndeployEvent(
			new HotDeployEvent(servletContext, contextClassLoader));
	}

}