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

package com.liferay.portal.kernel.spring.context;

import com.liferay.portal.kernel.servlet.PortalClassLoaderServletContextListener;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import javax.servlet.ServletContextListener;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletContextLoaderListener
	extends PortalClassLoaderServletContextListener {

	protected ServletContextListener getInstance() throws Exception {
		Class<?> classObj = Class.forName(
			_CLASS_NAME, true, PortalClassLoaderUtil.getClassLoader());

		return (ServletContextListener)classObj.newInstance();
	}

	private static final String _CLASS_NAME =
		"com.liferay.portal.spring.context.PortletContextLoaderListener";

}