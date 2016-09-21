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

package com.liferay.portalweb.portal.permissions.blogs.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AssertActionsTest extends BaseTestCase {
	public void testGuest_AssertActions() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Permissions Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Blogs Permissions Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("//input[@value='Search']"));
		assertTrue(selenium.isElementPresent(
				"link=Permissions Blogs Test Entry"));
		assertFalse(selenium.isElementPresent("link=Edit"));
		assertFalse(selenium.isElementPresent("link=Permissions"));
		assertFalse(selenium.isElementPresent("link=Delete"));
		assertFalse(selenium.isElementPresent(
				"//input[@value='Add Blog Entry']"));
		selenium.clickAt("link=Permissions Blogs Test Entry",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent("link=Add Comment"));
		assertFalse(selenium.isElementPresent("link=Edit"));
		assertFalse(selenium.isElementPresent("link=Permissions"));
		assertFalse(selenium.isElementPresent("link=Delete"));
		assertTrue(selenium.isElementPresent("link=Sign in to vote."));
	}
}