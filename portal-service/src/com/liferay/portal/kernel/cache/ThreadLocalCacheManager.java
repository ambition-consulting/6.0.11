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

import com.liferay.portal.kernel.util.InitialThreadLocal;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuyang Zhou
 */
public class ThreadLocalCacheManager {

	public static void clearAll(Lifecycle lifecycle) {
		Map<Lifecycle, Map<String, ThreadLocalCache<?>>> threadLocalCacheMaps =
			_threadLocalCacheMaps.get();

		Map<String, ThreadLocalCache<?>> threadLocalCacheMap =
			threadLocalCacheMaps.get(lifecycle);

		if (threadLocalCacheMap != null) {
			threadLocalCacheMap.clear();
		}
	}

	public static void destroy() {
		_threadLocalCacheMaps.remove();
	}

	public static <T> ThreadLocalCache<T> getThreadLocalCache(
		Lifecycle lifecycle, String name) {

		Map<Lifecycle, Map<String, ThreadLocalCache<?>>> threadLocalCacheMaps =
			_threadLocalCacheMaps.get();

		Map<String, ThreadLocalCache<?>> threadLocalCacheMap =
			threadLocalCacheMaps.get(lifecycle);

		if (threadLocalCacheMap == null) {
			threadLocalCacheMap = new HashMap<String, ThreadLocalCache<?>>();

			threadLocalCacheMaps.put(lifecycle, threadLocalCacheMap);
		}

		ThreadLocalCache<?> threadLocalCache = threadLocalCacheMap.get(name);

		if (threadLocalCache == null) {
			threadLocalCache = new ThreadLocalCache<T>(name, lifecycle);

			threadLocalCacheMap.put(name, threadLocalCache);
		}

		return (ThreadLocalCache<T>)threadLocalCache;
	}

	private static ThreadLocal<Map<Lifecycle, Map<String, ThreadLocalCache<?>>>>
		_threadLocalCacheMaps = new InitialThreadLocal
			<Map<Lifecycle, Map<String, ThreadLocalCache<?>>>>(
				ThreadLocalCacheManager.class + "._threadLocalCacheMaps",
				new EnumMap<Lifecycle, Map<String, ThreadLocalCache<?>>>(
					Lifecycle.class));

}