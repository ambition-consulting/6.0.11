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

import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.AggregateClassLoader;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.spring.util.FilterClassLoader;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletBeanFactoryPostProcessor
	implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
		ConfigurableListableBeanFactory beanFactory) {

		ClassLoader beanClassLoader =
			AggregateClassLoader.getAggregateClassLoader(
				new ClassLoader[] {
					PortletClassLoaderUtil.getClassLoader(),
					PortalClassLoaderUtil.getClassLoader()
				});

		beanClassLoader = new FilterClassLoader(beanClassLoader);

		beanFactory.setBeanClassLoader(beanClassLoader);
	}

}