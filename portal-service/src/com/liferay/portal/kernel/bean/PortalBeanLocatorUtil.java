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

package com.liferay.portal.kernel.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalBeanLocatorUtil {

	public static BeanLocator getBeanLocator() {
		return _beanLocator;
	}

	public static Object locate(String name) throws BeanLocatorException {
		if (_beanLocator == null) {
			_log.error("BeanLocator is null");

			throw new BeanLocatorException("BeanLocator has not been set");
		}
		else {
			Thread currentThread = Thread.currentThread();

			ClassLoader contextClassLoader =
				currentThread.getContextClassLoader();

			ClassLoader beanClassLoader = _beanLocator.getClassLoader();

			try {
				if (contextClassLoader != beanClassLoader) {
					currentThread.setContextClassLoader(beanClassLoader);
				}

				return _beanLocator.locate(name);
			}
			finally {
				if (contextClassLoader != beanClassLoader) {
					currentThread.setContextClassLoader(contextClassLoader);
				}
			}
		}
	}

	public static void setBeanLocator(BeanLocator beanLocator) {
		if (_log.isDebugEnabled()) {
			_log.debug("Setting BeanLocator " + beanLocator.hashCode());
		}

		_beanLocator = beanLocator;
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortalBeanLocatorUtil.class);

	private static BeanLocator _beanLocator;

}