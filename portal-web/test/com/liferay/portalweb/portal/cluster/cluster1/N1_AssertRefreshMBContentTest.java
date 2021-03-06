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

package com.liferay.portalweb.portal.cluster.cluster1;

import com.liferay.portalweb.portal.BaseTestCase;

/**
 * @author Brian Wing Shun Chan
 */
public class N1_AssertRefreshMBContentTest extends BaseTestCase {
	public void testN1_AssertRefreshMBContent() throws Exception {
		selenium.refresh();
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Test Category 2"));
		selenium.refresh();
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Test Category 2"));
		selenium.refresh();
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Test Category 2"));
	}
}