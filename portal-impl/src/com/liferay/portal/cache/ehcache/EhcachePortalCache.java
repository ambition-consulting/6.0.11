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

package com.liferay.portal.cache.ehcache;

import com.liferay.portal.kernel.cache.BasePortalCache;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * @author Brian Wing Shun Chan
 */
public class EhcachePortalCache extends BasePortalCache {

	public EhcachePortalCache(Ehcache cache) {
		_cache = cache;
	}

	public Object get(String key) {
		String processedKey = processKey(key);

		Element element = _cache.get(processedKey);

		if (element == null) {
			return null;
		}
		else {
			return element.getObjectValue();
		}
	}

	public Collection<Object> get(Collection<String> keys) {
		List<Object> values = new ArrayList<Object>(keys.size());

		for (String key : keys) {
			values.add(get(key));
		}

		return values;
	}

	public void put(String key, Object obj) {
		Element element = createElement(key, obj);

		_cache.put(element);
	}

	public void put(String key, Object obj, int timeToLive) {
		Element element = createElement(key, obj);

		element.setTimeToLive(timeToLive);

		_cache.put(element);
	}

	public void put(String key, Serializable obj) {
		Element element = createElement(key, obj);

		_cache.put(element);
	}

	public void put(String key, Serializable obj, int timeToLive) {
		Element element = createElement(key, obj);

		element.setTimeToLive(timeToLive);

		_cache.put(element);
	}

	public void remove(String key) {
		String processedKey = processKey(key);

		_cache.remove(processedKey);
	}

	public void removeAll() {
		_cache.removeAll();
	}

	protected Element createElement(String key, Object obj) {
		String processedKey = processKey(key);

		Element element = new Element(processedKey, obj);

		return element;
	}

	private Ehcache _cache;

}