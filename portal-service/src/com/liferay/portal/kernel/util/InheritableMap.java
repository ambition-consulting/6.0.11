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

package com.liferay.portal.kernel.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Young
 * @author Connor McKay
 */
public class InheritableMap<K, V> extends HashMap<K, V> {

	public InheritableMap() {
		super();
	}

	public InheritableMap(Map<? extends K, ? extends V> map) {
		super(map);
	}

	public void clear() {
		super.clear();
		_parentMap = null;
	}

	public boolean containsKey(Object key) {
		if (_parentMap != null && _parentMap.containsKey(key)) {
		 	return true;
		}
		else {
			return super.containsKey(key);
		}
	}

	public boolean containsValue(Object value) {
		if ((_parentMap != null) && _parentMap.containsValue(value)) {
			return true;
		}
		else {
			return super.containsValue(value);
		}
	}

	public V get(Object key) {
	 	if (super.containsKey(key)) {
			return super.get(key);
		}
		else if (_parentMap != null) {
			return _parentMap.get(key);
		}

		return null;
	}

	public Map<K, V> getParentMap() {
		return _parentMap;
	}

	public V remove(Object key) {
		if (super.containsKey(key)) {
			return super.remove(key);
		}
		else if (_parentMap != null) {
			return _parentMap.remove(key);
		}

		return null;
	}

	public void setParentMap(Map<? extends K, ? extends V> parentMap) {
		_parentMap = (Map<K, V>)parentMap;
	}

	private Map<K, V> _parentMap;

}