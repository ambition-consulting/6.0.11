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

package com.liferay.counter.service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceTestCase;
import com.liferay.portal.service.PortalServiceUtil;

/**
 * @author Michael Young
 */
public class CounterLocalServiceTest extends BaseServiceTestCase {

	public void testCounterRollback() throws Exception {
		long counterValue = nextLong() + 1;

		try {
			PortalServiceUtil.testCounterRollback();
		}
		catch (SystemException e) {
		}

		assertTrue(nextLong() > counterValue);
	}

}