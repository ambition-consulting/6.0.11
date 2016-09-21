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
 * @author Brian Wing Shun Chan
 */
public class PropsUtil_IW {
	public static PropsUtil_IW getInstance() {
		return _instance;
	}

	public void addProperties(java.util.Properties properties) {
		PropsUtil.addProperties(properties);
	}

	public boolean contains(java.lang.String key) {
		return PropsUtil.contains(key);
	}

	public java.lang.String get(java.lang.String key) {
		return PropsUtil.get(key);
	}

	public java.lang.String get(java.lang.String key,
		com.liferay.portal.kernel.configuration.Filter filter) {
		return PropsUtil.get(key, filter);
	}

	public java.lang.String[] getArray(java.lang.String key) {
		return PropsUtil.getArray(key);
	}

	public java.lang.String[] getArray(java.lang.String key,
		com.liferay.portal.kernel.configuration.Filter filter) {
		return PropsUtil.getArray(key, filter);
	}

	public java.util.Properties getProperties() {
		return PropsUtil.getProperties();
	}

	public java.util.Properties getProperties(java.lang.String prefix,
		boolean removePrefix) {
		return PropsUtil.getProperties(prefix, removePrefix);
	}

	public void reload() {
		PropsUtil.reload();
	}

	public void removeProperties(java.util.Properties properties) {
		PropsUtil.removeProperties(properties);
	}

	public void set(java.lang.String key, java.lang.String value) {
		PropsUtil.set(key, value);
	}

	private PropsUtil_IW() {
	}

	private static PropsUtil_IW _instance = new PropsUtil_IW();
}