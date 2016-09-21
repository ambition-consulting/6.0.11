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

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class SetUtil {

	public static <E> Set<E> fromArray(E[] array) {
		if ((array == null) || (array.length == 0)) {
			return new HashSet<E>();
		}

		Set<E> set = new HashSet<E>(array.length);

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		return set;
	}

	public static Set<Long> fromArray(long[] array) {
		if ((array == null) || (array.length == 0)) {
			return new HashSet<Long>();
		}

		Set<Long> set = new HashSet<Long>(array.length);

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		return set;
	}

	@SuppressWarnings("rawtypes")
	public static <E> Set<E> fromCollection(Collection<E> c) {
		if ((c != null) && (Set.class.isAssignableFrom(c.getClass()))) {
			return (Set)c;
		}

		if ((c == null) || (c.size() == 0)) {
			return new HashSet<E>();
		}

		return new HashSet<E>(c);
	}

	public static <E> Set<E> fromEnumeration(Enumeration<E> enu) {
		Set<E> set = new HashSet<E>();

		while (enu.hasMoreElements()) {
			set.add(enu.nextElement());
		}

		return set;
	}

	public static Set<String> fromFile(File file) throws IOException {
		Set<String> set = new HashSet<String>();

		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new FileReader(file));

		String s = StringPool.BLANK;

		while ((s = unsyncBufferedReader.readLine()) != null) {
			set.add(s);
		}

		unsyncBufferedReader.close();

		return set;
	}

	public static Set<String> fromFile(String fileName) throws IOException {
		return fromFile(new File(fileName));
	}

	public static <E> Set<E> fromIterator(Iterator<E> itr) {
		Set<E> set = new HashSet<E>();

		while (itr.hasNext()) {
			set.add(itr.next());
		}

		return set;
	}

	public static <E> Set<E> fromList(List<E> array) {
		if ((array == null) || (array.size() == 0)) {
			return new HashSet<E>();
		}

		return new HashSet<E>(array);
	}

	public static Set<String> fromString(String s) {
		return fromArray(StringUtil.split(s, StringPool.NEW_LINE));
	}

}