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

package com.liferay.portalweb.portal.permissions.webcontent.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AssertCannotEnterControlPanelTest extends BaseTestCase {
	public void testGuest_AssertCannotEnterControlPanel()
		throws Exception {
		selenium.open("/web/guest/home/");
		assertFalse(selenium.isElementPresent("link=Control Panel"));
	}
}