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

package com.liferay.portal.cache.transactional;

import com.liferay.portal.kernel.cache.BasePortalCache;
import com.liferay.portal.kernel.cache.PortalCache;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Shuyang Zhou
 */
public class TransactionalPortalCache extends BasePortalCache {

	public TransactionalPortalCache(PortalCache portalCache) {
		_portalCache = portalCache;
	}

	public Collection<Object> get(Collection<String> keys) {
		List<Object> values = new ArrayList<Object>(keys.size());

		for (String key : keys) {
			values.add(get(key));
		}

		return values;
	}

	public Object get(String key) {
		Object result = null;

		if (TransactionalPortalCacheHelper.isEnabled()) {
			result = TransactionalPortalCacheHelper.get(_portalCache, key);

			if (result == _nullHolder) {
				return null;
			}
		}

		if (result == null) {
			result = _portalCache.get(key);
		}

		return result;
	}

	public void put(String key, Object obj) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (obj == null) {
				obj = _nullHolder;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, obj);
		}
		else {
			_portalCache.put(key, obj);
		}
	}

	public void put(String key, Object obj, int timeToLive) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (obj == null) {
				obj = _nullHolder;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, obj);
		}
		else {
			_portalCache.put(key, obj, timeToLive);
		}
	}

	public void put(String key, Serializable obj) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (obj == null) {
				obj = _nullHolder;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, obj);
		}
		else {
			_portalCache.put(key, obj);
		}
	}

	public void put(String key, Serializable obj, int timeToLive) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (obj == null) {
				obj = _nullHolder;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, obj);
		}
		else {
			_portalCache.put(key, obj, timeToLive);
		}
	}

	public void remove(String key) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			TransactionalPortalCacheHelper.remove(_portalCache, key);
		}

		_portalCache.remove(key);
	}

	public void removeAll() {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			TransactionalPortalCacheHelper.removeAll(_portalCache);
		}

		_portalCache.removeAll();
	}

	private static Serializable _nullHolder = new String();

	private PortalCache _portalCache;

}