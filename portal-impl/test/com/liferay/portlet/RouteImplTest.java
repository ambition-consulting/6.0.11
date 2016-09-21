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

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.Route;
import com.liferay.portal.util.BaseTestCase;
import com.liferay.portal.util.InitUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Connor McKay
 */
public class RouteImplTest extends BaseTestCase {

	public RouteImplTest() {
		InitUtil.initWithSpring();
	}

	public void testNonMatchingRoute() {
		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("action", "view");
		parameters.put("id", "bob");

		Map<String, String> originalParameters =
			new HashMap<String, String>(parameters);

		Route route = new RouteImpl("{action}/{id:\\d+}");

		String url = route.parametersToUrl(parameters);

		assertNull(url);
		assertEquals(originalParameters, parameters);
	}

}