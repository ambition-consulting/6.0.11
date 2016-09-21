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
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Brian Wing Shun Chan
 * @author Sandeep Soni
 */
public abstract class PortalClassLoaderServletContextListener
	extends BasePortalLifecycle implements ServletContextListener {

	public PortalClassLoaderServletContextListener() {
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		portalDestroy();
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		_servletContextEvent = servletContextEvent;

		ServletContext servletContext = servletContextEvent.getServletContext();

		_servletContextName = servletContext.getServletContextName();

		Thread currentThread = Thread.currentThread();

		_portletClassLoader = currentThread.getContextClassLoader();

		registerPortalLifecycle();
	}

	protected void doPortalDestroy() {
		PortletClassLoaderUtil.setClassLoader(_portletClassLoader);
		PortletClassLoaderUtil.setServletContextName(_servletContextName);

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortalClassLoaderUtil.getClassLoader());

			_servletContextListener.contextDestroyed(_servletContextEvent);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);

			PortletClassLoaderUtil.setClassLoader(null);
			PortletClassLoaderUtil.setServletContextName(null);
		}
	}

	protected void doPortalInit() {
		PortletClassLoaderUtil.setClassLoader(_portletClassLoader);
		PortletClassLoaderUtil.setServletContextName(_servletContextName);

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortalClassLoaderUtil.getClassLoader());

			_servletContextListener = getInstance();

			_servletContextListener.contextInitialized(_servletContextEvent);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	protected abstract ServletContextListener getInstance() throws Exception;

	private static Log _log = LogFactoryUtil.getLog(
		PortalClassLoaderServletContextListener.class);

	private ServletContextEvent _servletContextEvent;
	private ServletContextListener _servletContextListener;
	private ClassLoader _portletClassLoader;
	private String _servletContextName;

}