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

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class PropsUtil {

	public static String get(String key) {
		String value = null;

		try {
			Object returnObj = PortalClassInvoker.invoke(
				false, _getMethodKey1, key);

			if (returnObj != null) {
				value = (String)returnObj;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return value;
	}

	public static String get(String key, Filter filter) {
		String value = null;

		try {
			Object returnObj = PortalClassInvoker.invoke(
				false, _getMethodKey2, key, filter);

			if (returnObj != null) {
				value = (String)returnObj;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return value;
	}

	public static String[] getArray(String key) {
		String[] value = null;

		try {
			Object returnObj = PortalClassInvoker.invoke(
				false, _getArrayMethodKey, key);

			if (returnObj != null) {
				value = (String[])returnObj;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return value;
	}

	public static Properties getProperties() {
		Properties properties = null;

		try {
			Object returnObj = PortalClassInvoker.invoke(
				false, _getPropertiesMethodKey1);

			if (returnObj != null) {
				properties = (Properties)returnObj;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return properties;
	}

	public static Properties getProperties(
		String prefix, boolean removePrefix) {

		Properties properties = null;

		try {
			Object returnObj = PortalClassInvoker.invoke(
				false, _getPropertiesMethodKey2, prefix, removePrefix);

			if (returnObj != null) {
				properties = (Properties)returnObj;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return properties;
	}

	private static final String _CLASS_NAME =
		"com.liferay.portal.util.PropsUtil";

	private static Log _log = LogFactoryUtil.getLog(PropsUtil.class);

	private static MethodKey _getArrayMethodKey = new MethodKey(
		_CLASS_NAME, "getArray", String.class);
	private static MethodKey _getMethodKey1 = new MethodKey(
		_CLASS_NAME, "get", String.class);
	private static MethodKey _getMethodKey2 = new MethodKey(
		_CLASS_NAME, "get", String.class, Filter.class);
	private static MethodKey _getPropertiesMethodKey1 = new MethodKey(
		_CLASS_NAME, "getProperties");
	private static MethodKey _getPropertiesMethodKey2 = new MethodKey(
		_CLASS_NAME, "getProperties", String.class, boolean.class);

}