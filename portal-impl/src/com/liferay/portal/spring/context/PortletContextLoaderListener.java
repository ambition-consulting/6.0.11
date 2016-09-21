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

package com.liferay.portal.spring.context;

import com.liferay.portal.bean.BeanLocatorImpl;
import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.MethodCache;

import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Brian Wing Shun Chan
 * @see	   PortletApplicationContext
 * @see	   PortletContextLoader
 */
public class PortletContextLoaderListener extends ContextLoaderListener {

	public void contextDestroyed(ServletContextEvent event) {
		ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader();

		ServletContext servletContext = event.getServletContext();

		try {
			Class<?> beanLocatorUtilClass = Class.forName(
				"com.liferay.util.bean.PortletBeanLocatorUtil", true,
				classLoader);

			Method setBeanLocatorMethod = beanLocatorUtilClass.getMethod(
				"setBeanLocator", new Class[] {BeanLocator.class});

			setBeanLocatorMethod.invoke(
				beanLocatorUtilClass, new Object[] {null});

			PortletBeanLocatorUtil.setBeanLocator(
				servletContext.getServletContextName(), null);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		super.contextDestroyed(event);
	}

	public void contextInitialized(ServletContextEvent event) {
		MethodCache.reset();

		super.contextInitialized(event);

		PortletBeanFactoryCleaner.readBeans();

		ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader();

		ServletContext servletContext = event.getServletContext();

		ApplicationContext applicationContext =
			WebApplicationContextUtils.getWebApplicationContext(servletContext);

		BeanLocator beanLocator = new BeanLocatorImpl(
			classLoader, applicationContext);

		try {
			Class<?> beanLocatorUtilClass = Class.forName(
				"com.liferay.util.bean.PortletBeanLocatorUtil", true,
				classLoader);

			Method setBeanLocatorMethod = beanLocatorUtilClass.getMethod(
				"setBeanLocator", new Class[] {BeanLocator.class});

			setBeanLocatorMethod.invoke(
				beanLocatorUtilClass, new Object[] {beanLocator});

			PortletBeanLocatorUtil.setBeanLocator(
				servletContext.getServletContextName(), beanLocator);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		servletContext.removeAttribute(
			WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}

	protected ContextLoader createContextLoader() {
		return new PortletContextLoader();
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortletContextLoaderListener.class);

}