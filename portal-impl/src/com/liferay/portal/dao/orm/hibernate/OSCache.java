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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;

import com.opensymphony.oscache.base.CacheEntry;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

import java.util.Map;

import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.Timestamper;

/**
 * @author	   Mathias Bogaert
 * @author	   Brian Wing Shun Chan
 * @deprecated
 */
public class OSCache implements Cache {

	public OSCache(int refreshPeriod, String cron, String region) {
		_refreshPeriod = refreshPeriod;
		_cron = cron;
		_regionName = region;
		_regionGroups = new String[] {region};
	}

	public void clear() throws CacheException {
		_cache.flushGroup(_regionName);
	}

	public void destroy() throws CacheException {
		synchronized (_cache) {
			_cache.destroy();
		}
	}

	public Object get(Object key) throws CacheException {
		String keyString = _encodeKey(key);

		try {
			return _cache.getFromCache(keyString, _refreshPeriod, _cron);
		}
		catch (NeedsRefreshException nre) {
			_cache.cancelUpdate(keyString);

			return null;
		}
	}

	public long getElementCountOnDisk() {
		return -1;
	}

	public long getElementCountInMemory() {
		return -1;
	}

	public String getRegionName() {
		return _regionName;
	}

	public long getSizeInMemory() {
		return -1;
	}

	public int getTimeout() {
		return CacheEntry.INDEFINITE_EXPIRY;
	}

	public void lock(Object key) throws CacheException {
	}

	public long nextTimestamp() {
		return Timestamper.next();
	}

	public void put(Object key, Object value) throws CacheException {
		_cache.putInCache(_encodeKey(key), value, _regionGroups);
	}

	public Object read(Object key) throws CacheException {
		return get(key);
	}

	public void remove(Object key) throws CacheException {
		_cache.flushEntry(_encodeKey(key));
	}

	public Map<Object, Object> toMap() {
		return null;
	}

	public void unlock(Object key) throws CacheException {
	}

	public void update(Object key, Object value) throws CacheException {
		_cache.flushEntry(_encodeKey(key));

		put(key, value);
	}

	private String _encodeKey(Object key) {
		String keyString = String.valueOf(key);

		if (_log.isDebugEnabled()) {
			_log.debug("Key " + keyString);
		}

		return keyString;
	}

	private static Log _log = LogFactoryUtil.getLog(OSCache.class);

	private static GeneralCacheAdministrator _cache =
		new GeneralCacheAdministrator(PropsUtil.getProperties());

	private int _refreshPeriod;
	private String _cron;
	private String _regionName;
	private String[] _regionGroups;

}