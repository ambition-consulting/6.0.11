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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class MapBackedSet<E> extends AbstractSet<E> implements Serializable {

	public MapBackedSet(Map<E, Boolean> backedMap) {
		if (!backedMap.isEmpty()) {
			throw new IllegalArgumentException("Map is not empty");
		}

		_backedMap = backedMap;
		_backedMapKeySet = backedMap.keySet();
	}

	public boolean add(E element) {
		if (_backedMap.put(element, Boolean.TRUE) == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void clear() {
		_backedMap.clear();
	}

	public boolean contains(Object obj) {
		return _backedMap.containsKey(obj);
	}

	public boolean containsAll(Collection<?> collection) {
		return _backedMapKeySet.containsAll(collection);
	}

	public boolean equals(Object obj) {
		if ((obj == this) || _backedMapKeySet.equals(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return _backedMapKeySet.hashCode();
	}

	public boolean isEmpty() {
		return _backedMap.isEmpty();
	}

	public Iterator<E> iterator() {
		return _backedMapKeySet.iterator();
	}

	public boolean remove(Object obj) {
		if (_backedMap.remove(obj) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean removeAll(Collection<?> collection) {
		return _backedMapKeySet.removeAll(collection);
	}

	public boolean retainAll(Collection<?> collection) {
		return _backedMapKeySet.retainAll(collection);
	}

	public int size() {
		return _backedMap.size();
	}

	public Object[] toArray() {
		return _backedMapKeySet.toArray();
	}

	public <T> T[] toArray(T[] array) {
		return _backedMapKeySet.toArray(array);
	}

	public String toString() {
		return _backedMapKeySet.toString();
	}

	private void readObject(ObjectInputStream objectInputStream)
		throws ClassNotFoundException, IOException {

		objectInputStream.defaultReadObject();

		_backedMapKeySet = _backedMap.keySet();
	}

	private final Map<E, Boolean> _backedMap;
	private transient Set<E> _backedMapKeySet;

}