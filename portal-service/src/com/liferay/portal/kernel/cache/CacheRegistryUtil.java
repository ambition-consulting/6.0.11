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

package com.liferay.portal.kernel.cache;

/**
 * @author Brian Wing Shun Chan
 */
public class CacheRegistryUtil {

	public static void clear() {
		getCacheRegistry().clear();
	}

	public static void clear(String name) {
		getCacheRegistry().clear(name);
	}

	public static CacheRegistry getCacheRegistry() {
		return _cacheRegistry;
	}

	public static boolean isActive() {
		return getCacheRegistry().isActive();
	}

	public static void register(CacheRegistryItem cacheRegistryItem) {
		getCacheRegistry().register(cacheRegistryItem);
	}

	public static void setActive(boolean active) {
		getCacheRegistry().setActive(active);
	}

	public static void setCacheRegistry(CacheRegistry cacheRegistry) {
		_cacheRegistry = cacheRegistry;
	}

	public static void unregister(String name) {
		getCacheRegistry().unregister(name);
	}

	private static CacheRegistry _cacheRegistry;

}