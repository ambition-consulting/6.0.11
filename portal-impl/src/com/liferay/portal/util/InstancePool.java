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

package com.liferay.portal.util;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated This class has been repackaged at
 *			   <code>com.liferay.portal.kernel.util</code>.
 */
public class InstancePool {

	public static Object get(String className) {
		return com.liferay.portal.kernel.util.InstancePool.get(className);
	}

	public static void put(String className, Object obj) {
		com.liferay.portal.kernel.util.InstancePool.put(className, obj);
	}

}