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

package com.liferay.portalweb.portal.permissions.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Member_AssertActionsTest extends BaseTestCase {
	public void testMember_AssertActions() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Message Boards Permissions Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Permissions Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("//input[@value='Search']"));
		assertEquals(RuntimeVariables.replace("RSS"),
			selenium.getText("//div[2]/div/span/a/span[1]"));
		assertTrue(selenium.isElementPresent("link=Subscribe"));
		assertFalse(selenium.isElementPresent("//input[@value='Add Category']"));
		assertFalse(selenium.isElementPresent("link=Delete"));
		assertFalse(selenium.isElementPresent("link=Edit"));
		assertFalse(selenium.isElementPresent("link=Banned Users"));
		assertFalse(selenium.isElementPresent("//img[@alt='Permissions']"));
		assertTrue(selenium.isElementPresent("link=Permissions Test 1"));
		selenium.clickAt("link=Permissions Test 1", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Test Thread 1"));
		assertFalse(selenium.isElementPresent("link=Edit"));
		assertFalse(selenium.isElementPresent("link=Move"));
		assertFalse(selenium.isElementPresent("link=Delete"));
		assertTrue(selenium.isElementPresent(
				"//input[@value='Post New Thread']"));
		selenium.clickAt("link=Test Thread 1", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Reply"));
		assertTrue(selenium.isElementPresent("link=Reply with Quote"));
		assertFalse(selenium.isElementPresent("link=Delete"));
		assertFalse(selenium.isElementPresent("link=Edit"));
		assertFalse(selenium.isElementPresent("link=Permissions"));
	}
}