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

import javax.portlet.PortletPreferences;

/**
 * @author Brian Wing Shun Chan
 */
public class PrefsPropsUtil {

	public static String getString(long companyId, String key)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArrayMethodKey1, companyId, key);

		if (returnObj != null) {
			return (String)returnObj;
		}
		else {
			return null;
		}
	}

	public static String getString(String key)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArrayMethodKey2, key);

		if (returnObj != null) {
			return (String)returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(
			long companyId, String name, String delimiter)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray1, companyId, name, delimiter);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(
			long companyId, String name, String delimiter,
			String[] defaultValue)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray2, companyId, name, delimiter, defaultValue);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(
			PortletPreferences preferences, long companyId, String name,
			String delimiter)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray3, preferences, companyId, name, delimiter);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(
			PortletPreferences preferences, long companyId, String name,
			String delimiter, String[] defaultValue)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray4, preferences, companyId, name, delimiter,
			defaultValue);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(String name, String delimiter)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray5, name, delimiter);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	public static String[] getStringArray(
			String name, String delimiter, String[] defaultValue)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _getStringArray6, name, delimiter, defaultValue);

		if (returnObj != null) {
			return (String[])returnObj;
		}
		else {
			return null;
		}
	}

	private static final String _CLASS_NAME =
		"com.liferay.portal.util.PrefsPropsUtil";

	private static MethodKey _getStringArray1 = new MethodKey(
		_CLASS_NAME, "getStringArray", long.class, String.class, String.class);
	private static MethodKey _getStringArray2 = new MethodKey(
		_CLASS_NAME, "getStringArray", long.class, String.class, String.class,
		String[].class);
	private static MethodKey _getStringArray3 = new MethodKey(
		_CLASS_NAME, "getStringArray", PortletPreferences.class, long.class,
		String.class, String.class);
	private static MethodKey _getStringArray4 = new MethodKey(
		_CLASS_NAME, "getStringArray", PortletPreferences.class, long.class,
		String.class, String.class, String[].class);
	private static MethodKey _getStringArray5 = new MethodKey(
		_CLASS_NAME, "getStringArray", String.class, String.class);
	private static MethodKey _getStringArray6 = new MethodKey(
		_CLASS_NAME, "getStringArray", String.class, String.class,
		String[].class);
	private static MethodKey _getStringArrayMethodKey1 = new MethodKey(
		_CLASS_NAME, "getString", long.class, String.class);
	private static MethodKey _getStringArrayMethodKey2 = new MethodKey(
		_CLASS_NAME, "getString", String.class);

}