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

package com.liferay.portal.freemarker;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;

import freemarker.cache.ConcurrentCacheStorage;

/**
 * @author Mika Koivisto
 */
public class LiferayCacheStorage implements ConcurrentCacheStorage {

	public static final String CACHE_NAME = LiferayCacheStorage.class.getName();

	public void clear() {
		_cache.removeAll();
	}

	public Object get(Object key) {
		return _cache.get(key.toString());
	}

	public boolean isConcurrent() {
		return true;
	}

	public void put(Object key, Object value) {
		_cache.put(key.toString(), value);
	}

	public void remove(Object key) {
		_cache.remove(key.toString());
	}

	private static PortalCache _cache = SingleVMPoolUtil.getCache(CACHE_NAME);

}