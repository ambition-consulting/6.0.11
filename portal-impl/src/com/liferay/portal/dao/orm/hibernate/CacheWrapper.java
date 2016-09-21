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

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.cache.CacheRegistryItem;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated
 */
public class CacheWrapper implements Cache, CacheRegistryItem {

	public CacheWrapper(Cache cache) {
		_cache = cache;
		_registryName = cache.getRegionName();

		if (_log.isDebugEnabled()) {
			_log.debug("Creating cache for " + _registryName);
		}

		CacheRegistryUtil.register(this);
	}

	public void clear() throws CacheException {
		_cache.clear();
	}

	public void destroy() throws CacheException {
		_cache.destroy();
	}

	public Object get(Object key) throws CacheException {
		return _cache.get(key);
	}

	public long getElementCountInMemory() {
		return _cache.getElementCountInMemory();
	}

	public long getElementCountOnDisk() {
		return _cache.getElementCountOnDisk();
	}

	public String getRegionName() {
		return _cache.getRegionName();
	}

	public String getRegistryName() {
		return _registryName;
	}

	public long getSizeInMemory() {
		return _cache.getSizeInMemory();
	}

	public int getTimeout() {
		return _cache.getTimeout();
	}

	public void lock(Object key) throws CacheException {
		_cache.lock(key);
	}

	public long nextTimestamp() {
		return _cache.nextTimestamp();
	}

	public void put(Object key, Object value) throws CacheException {
		if (CacheRegistryUtil.isActive()) {
			_cache.put(key, value);
		}
	}

	public Object read(Object key) throws CacheException {
		return _cache.read(key);
	}

	public void remove(Object key) throws CacheException {
		_cache.remove(key);
	}

	public Map<?, ?> toMap() {
		return _cache.toMap();
	}

	public void unlock(Object key) throws CacheException {
		_cache.unlock(key);
	}

	public void update(Object key, Object value) throws CacheException {
		if (CacheRegistryUtil.isActive()) {
			_cache.update(key, value);
		}
	}

	public void invalidate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Invalidating cache for " + _registryName);
		}

		_cache.clear();
	}

	private static Log _log = LogFactoryUtil.getLog(CacheWrapper.class);

	private Cache _cache;
	private String _registryName;

}