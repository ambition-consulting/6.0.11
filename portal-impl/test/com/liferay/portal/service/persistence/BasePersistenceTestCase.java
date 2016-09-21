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

package com.liferay.portal.service.persistence;

import com.liferay.portal.util.BaseTestCase;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class BasePersistenceTestCase extends BaseTestCase {

	public void setUp() throws Exception {
		super.setUp();

		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = false;
	}

	public void tearDown() throws Exception {
		super.tearDown();

		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = true;
	}

}