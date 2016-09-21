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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.MultiValueMap;

import java.util.Set;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public abstract class MultiValueMapTestCase extends BaseTestCase {

	public void testDelete() {
		String name = multiValueMap.getClass().getSimpleName();

		multiValueMap.put(5, "hello");
		multiValueMap.put(5, "world");
		multiValueMap.put(10, "world");
		multiValueMap.put(10, "wide");
		multiValueMap.put(10, "web");
		multiValueMap.put(5, "hello");

		assertEquals(name, 5, multiValueMap.size());

		multiValueMap.remove(10);

		assertEquals(name, 2, multiValueMap.size());

		Set<String> values = multiValueMap.getAll(5);

		assertNotNull(name, values);

		assertTrue(name, values.contains("hello"));
		assertTrue(name, values.contains("world"));
	}

	public void testMultipleInsert() {
		String name = multiValueMap.getClass().getSimpleName();

		multiValueMap.put(5, "hello");
		multiValueMap.put(5, "world");
		multiValueMap.put(10, "world");
		multiValueMap.put(10, "wide");
		multiValueMap.put(10, "web");
		multiValueMap.put(5, "hello");

		assertEquals(name, 5, multiValueMap.size());

		Set<String> values = multiValueMap.getAll(5);

		assertNotNull(name, values);

		assertTrue(name, values.contains("hello"));
		assertTrue(name, values.contains("world"));
	}

	protected MultiValueMap<Integer, String> multiValueMap;

}