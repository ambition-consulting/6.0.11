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

package com.liferay.portal.cache;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.PortalCacheManager;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 */
public class MultiVMPoolImpl implements MultiVMPool {

	public void clear() {
		_portalCacheManager.clearAll();
	}

	public void clear(String name) {
		PortalCache portalCache = getCache(name);

		portalCache.removeAll();
	}

	public Object get(String name, String key) {
		PortalCache portalCache = getCache(name);

		return portalCache.get(key);
	}

	/**
	 * @deprecated
	 */
	public Object get(PortalCache portalCache, String key) {
		return portalCache.get(key);
	}

	public PortalCache getCache(String name) {
		return _portalCacheManager.getCache(name);
	}

	public PortalCache getCache(String name, boolean blocking) {
		return _portalCacheManager.getCache(name, blocking);
	}

	public void put(String name, String key, Object obj) {
		PortalCache portalCache = getCache(name);

		portalCache.put(key, obj);
	}

	/**
	 * @deprecated
	 */
	public void put(PortalCache portalCache, String key, Object obj) {
		portalCache.put(key, obj);
	}

	public void put(String name, String key, Serializable obj) {
		PortalCache portalCache = getCache(name);

		portalCache.put(key, obj);
	}

	/**
	 * @deprecated
	 */
	public void put(PortalCache portalCache, String key, Serializable obj) {
		portalCache.put(key, obj);
	}

	public void remove(String name, String key) {
		PortalCache portalCache = getCache(name);

		portalCache.remove(key);
	}

	/**
	 * @deprecated
	 */
	public void remove(PortalCache portalCache, String key) {
		portalCache.remove(key);
	}

	public void removeCache(String name) {
		_portalCacheManager.removeCache(name);
	}

	public void setPortalCacheManager(PortalCacheManager portalCacheManager) {
		_portalCacheManager = portalCacheManager;
	}

	private PortalCacheManager _portalCacheManager;

}