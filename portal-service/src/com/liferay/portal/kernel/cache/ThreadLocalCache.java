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

import com.liferay.portal.kernel.util.StringBundler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuyang Zhou
 */
public class ThreadLocalCache<T> {

	public ThreadLocalCache(String name, Lifecycle lifecycle) {
		_name = name;
		_lifecycle = lifecycle;
	}

	public T get(String key) {
		if (_cache == null) {
			return null;
		}
		else {
			return _cache.get(key);
		}
	}

	public Lifecycle getLifecycle() {
		return _lifecycle;
	}

	public String getName() {
		return _name;
	}

	public void put(String key, T obj) {
		if (_cache == null) {
			_cache = new HashMap<String, T>();
		}

		_cache.put(key, obj);
	}

	public void remove(String key) {
		if (_cache != null) {
			_cache.remove(key);
		}
	}

	public void removeAll() {
		if (_cache != null) {
			_cache.clear();
		}
	}

	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cache=");
		sb.append(_cache.toString());
		sb.append(", lifecycle=");
		sb.append(_lifecycle);
		sb.append(", name=");
		sb.append(_name);
		sb.append("}");

		return sb.toString();
	}

	private Map<String, T> _cache;
	private Lifecycle _lifecycle;
	private String _name;

}