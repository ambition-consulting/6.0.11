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

package com.liferay.portal.cache.memory;

import com.liferay.portal.kernel.cache.BasePortalCache;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Brian Wing Shun Chan
 */
public class MemoryPortalCache extends BasePortalCache {

	public MemoryPortalCache(int initialCapacity) {
		 _map = new ConcurrentHashMap<String, Object>(initialCapacity);
	}

	public Collection<Object> get(Collection<String> keys) {
		List<Object> values = new ArrayList<Object>(keys.size());

		for (String key : keys) {
			values.add(get(key));
		}

		return values;
	}

	public Object get(String key) {
		String processedKey = processKey(key);

		return _map.get(processedKey);
	}

	public void put(String key, Object obj) {
		String processedKey = processKey(key);

		_map.put(processedKey, obj);
	}

	public void put(String key, Object obj, int timeToLive) {
		String processedKey = processKey(key);

		_map.put(processedKey, obj);
	}

	public void put(String key, Serializable obj) {
		String processedKey = processKey(key);

		_map.put(processedKey, obj);
	}

	public void put(String key, Serializable obj, int timeToLive) {
		String processedKey = processKey(key);

		_map.put(processedKey, obj);
	}

	public void remove(String key) {
		String processedKey = processKey(key);

		_map.remove(processedKey);
	}

	public void removeAll() {
		_map.clear();
	}

	private Map<String, Object> _map;

}