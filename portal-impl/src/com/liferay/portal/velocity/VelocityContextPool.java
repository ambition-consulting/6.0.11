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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.servlet.ServletContextPool;

import javax.servlet.ServletContext;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated This class has been renamed to {@link ServletContextPool}.
 */
public class VelocityContextPool {

	public static boolean containsKey(String servletContextName) {
		return ServletContextPool.containsKey(servletContextName);
	}

	public static ServletContext get(String servletContextName) {
		return ServletContextPool.get(servletContextName);
	}

	public static void put(
		String servletContextName, ServletContext servletContext) {

		ServletContextPool.put(servletContextName, servletContext);
	}

	public static ServletContext remove(String servletContextName) {
		return ServletContextPool.remove(servletContextName);
	}

}