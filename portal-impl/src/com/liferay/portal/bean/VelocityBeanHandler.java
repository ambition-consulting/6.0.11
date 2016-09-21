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

import java.lang.Object;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Brian Wing Shun Chan
 */
public class VelocityBeanHandler implements InvocationHandler {

	public VelocityBeanHandler(Object bean, ClassLoader classLoader) {
		_bean = bean;
		_classLoader = classLoader;
	}

	public Object getBean() {
		return _bean;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if ((_classLoader != null) &&
				(contextClassLoader != _classLoader)) {

				currentThread.setContextClassLoader(_classLoader);
			}

			return method.invoke(_bean, args);
		}
		catch (InvocationTargetException ite) {
			return null;
		}
		finally {
			if ((_classLoader != null) &&
				(contextClassLoader != _classLoader)) {

				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	private Object _bean;
	private ClassLoader _classLoader;

}