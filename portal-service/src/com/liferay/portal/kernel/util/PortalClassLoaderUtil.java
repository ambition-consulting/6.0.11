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

package com.liferay.portal.kernel.util;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalClassLoaderUtil {

	public static ClassLoader getClassLoader() {
		return _classLoader;
	}

	public static void setClassLoader(ClassLoader contextClassLoader) {
		if (ServerDetector.isJOnAS() && JavaProps.isJDK6()) {
			_classLoader = new URLClassLoader(new URL[0], contextClassLoader);
		}
		else {
			_classLoader = contextClassLoader;
		}
	}

	private static ClassLoader _classLoader;

}