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
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.cache.ThreadLocalCacheManager;
import com.liferay.portal.kernel.deploy.hot.HotDeployUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.ClearThreadLocalUtil;
import com.liferay.portal.kernel.util.ClearTimerThreadUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.util.InitUtil;

import java.beans.PropertyDescriptor;

import java.lang.reflect.Field;

import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @author Michael Young
 * @author Shuyang Zhou
 */
public class PortalContextLoaderListener extends ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		HotDeployUtil.reset();
		InstancePool.reset();
		MethodCache.reset();
		PortletBagPool.reset();

		ReferenceRegistry.releaseReferences();

		InitUtil.init();

		super.contextInitialized(event);

		ApplicationContext applicationContext =
			ContextLoader.getCurrentWebApplicationContext();

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		BeanLocator beanLocator = new BeanLocatorImpl(
			portalClassLoader, applicationContext);

		PortalBeanLocatorUtil.setBeanLocator(beanLocator);

		ClassLoader classLoader = portalClassLoader;

		while (classLoader != null) {
			CachedIntrospectionResults.clearClassLoader(classLoader);

			classLoader = classLoader.getParent();
		}

		AutowireCapableBeanFactory autowireCapableBeanFactory =
			applicationContext.getAutowireCapableBeanFactory();

		clearFilteredPropertyDescriptorsCache(autowireCapableBeanFactory);
	}

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);

		ThreadLocalCacheManager.destroy();

		try {
			ClearThreadLocalUtil.clearThreadLocal();
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		try {
			ClearTimerThreadUtil.clearTimerThread();
		}
		catch(Exception e) {
			_log.error(e, e);
		}
	}

	protected void clearFilteredPropertyDescriptorsCache(
		AutowireCapableBeanFactory autowireCapableBeanFactory) {

		try {
			Map<Class<?>, PropertyDescriptor[]>
				filteredPropertyDescriptorsCache =
					(Map<Class<?>, PropertyDescriptor[]>)
						_filteredPropertyDescriptorsCacheField.get(
							autowireCapableBeanFactory);

			filteredPropertyDescriptorsCache.clear();
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Field _filteredPropertyDescriptorsCacheField;

	private static Log _log = LogFactoryUtil.getLog(
		PortalContextLoaderListener.class);

	static {
		try {
			_filteredPropertyDescriptorsCacheField =
				ReflectionUtil.getDeclaredField(
					AbstractAutowireCapableBeanFactory.class,
					"filteredPropertyDescriptorsCache");
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

}