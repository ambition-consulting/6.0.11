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

package com.liferay.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Brian Wing Shun Chan
 */
public class UniqueList<E> extends ArrayList<E> {

	public UniqueList() {
		super();
	}

	public boolean add(E e) {
		if (!contains(e)) {
			return super.add(e);
		}
		else {
			return false;
		}
	}

	public void add(int index, E e) {
		if (!contains(e)) {
			super.add(index, e);
		}
	}

	public boolean addAll(Collection<? extends E> c) {
		c = new ArrayList<E>(c);

		Iterator<? extends E> itr = c.iterator();

		while (itr.hasNext()) {
			E e = itr.next();

			if (contains(e)) {
				itr.remove();
			}
		}

		return super.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		c = new ArrayList<E>(c);

		Iterator<? extends E> itr = c.iterator();

		while (itr.hasNext()) {
			E e = itr.next();

			if (contains(e)) {
				itr.remove();
			}
		}

		return super.addAll(index, c);
	}

	public E set(int index, E e) {
		if (!contains(e)) {
			return super.set(index, e);
		}
		else {
			return e;
		}
	}

}