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

package com.liferay.portal.kernel.portlet;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletClassLoaderUtil {

	public static ClassLoader getClassLoader() {
		return _classLoader;
	}

	public static String getServletContextName() {
		return _servletContextName;
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static void setServletContextName(String servletContextName) {
		_servletContextName = servletContextName;
	}

	private static ClassLoader _classLoader;
	private static String _servletContextName;

}