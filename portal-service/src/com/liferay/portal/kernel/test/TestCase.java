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

package com.liferay.portal.kernel.test;

import com.liferay.portal.kernel.util.MapUtil;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TestCase extends junit.framework.TestCase {

	protected void assertEquals(double expected, double actual)
		throws Exception {

		assertEquals(expected, actual, 0);
	}

	protected void assertEquals(
		Map<String, ?> expected, Map<String, ?> actual) {

		assertEquals(
			"The maps are different sizes", expected.size(), actual.size());

		for (String name : expected.keySet()) {
			assertEquals(
				"The values for key '" + name + "' are different",
				MapUtil.getString(expected, name),
				MapUtil.getString(actual, name));
		}
	}

	protected void assertLessThan(double expected, double actual)
		throws Exception {

		if (actual > expected) {
			fail(actual + " is not less than " + expected);
		}
	}

}