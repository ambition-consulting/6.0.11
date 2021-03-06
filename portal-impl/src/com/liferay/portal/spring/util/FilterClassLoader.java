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

package com.liferay.portal.spring.util;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class FilterClassLoader extends ClassLoader {

	public FilterClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.startsWith("net.sf.ehcache.") ||
			name.startsWith("org.aopalliance.") ||
			name.startsWith("org.hibernate.") ||
			name.startsWith("org.springframework.")) {

			ClassLoader portalClassLoader =
				PortalClassLoaderUtil.getClassLoader();

			return portalClassLoader.loadClass(name);
		}
		else {
			return super.loadClass(name);
		}
	}

}