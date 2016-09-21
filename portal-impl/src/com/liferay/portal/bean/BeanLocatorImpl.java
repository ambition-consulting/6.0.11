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

package com.liferay.portal.bean;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.lang.reflect.Proxy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;

/**
 * @author Brian Wing Shun Chan
 */
public class BeanLocatorImpl implements BeanLocator {

	public static final String VELOCITY_SUFFIX = ".velocity";

	public BeanLocatorImpl(
		ClassLoader classLoader, ApplicationContext applicationContext) {

		_classLoader = classLoader;
		_applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return _applicationContext;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	public String[] getNames() {
		return _applicationContext.getBeanDefinitionNames();
	}

	public Class<?> getType(String name) {
		try {
			return _applicationContext.getType(name);
		}
		catch (Exception e) {
			throw new BeanLocatorException(e);
		}
	}

	public Object locate(String name) throws BeanLocatorException {
		try {
			return doLocate(name);
		}
		catch (Exception e) {
			throw new BeanLocatorException(e);
		}
	}

	protected Object doLocate(String name) throws Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("Locating " + name);
		}

		if (name.endsWith(VELOCITY_SUFFIX)) {
			Object bean = _velocityBeans.get(name);

			if (bean == null) {
				String originalName = name.substring(
					0, name.length() - VELOCITY_SUFFIX.length());

				bean = _applicationContext.getBean(originalName);

				Class<?>[] interfaces = bean.getClass().getInterfaces();

				List<Class<?>> interfacesList = ListUtil.fromArray(interfaces);

				Iterator<Class<?>> itr = interfacesList.iterator();

				while (itr.hasNext()) {
					Class<?> classObj = itr.next();

					try {
						_classLoader.loadClass(classObj.getName());
					}
					catch (Exception e) {
						itr.remove();
					}
				}

				bean = Proxy.newProxyInstance(
					_classLoader,
					interfacesList.toArray(new Class<?>[interfacesList.size()]),
					new VelocityBeanHandler(bean, _classLoader));

				_velocityBeans.put(name, bean);
			}

			return bean;
		}
		else {
			return _applicationContext.getBean(name);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BeanLocatorImpl.class);

	private ApplicationContext _applicationContext;
	private ClassLoader _classLoader;
	private Map<String, Object> _velocityBeans =
		new ConcurrentHashMap<String, Object>();

}