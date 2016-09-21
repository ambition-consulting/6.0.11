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

package com.liferay.portalweb.portlet.recentbloggers.entry.viewusernameandimage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUserNameAndImageTest extends BaseTestCase {
	public void testViewUserNameAndImage() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Recent Bloggers Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Recent Bloggers Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//div[@class='user-profile-image']/a/img[@alt='Joe Bloggs']"));
		assertTrue(selenium.isElementPresent("//a[@class='user-name']"));
		assertTrue(selenium.isTextPresent("Posts:"));
		assertTrue(selenium.isTextPresent("Stars:"));
		assertTrue(selenium.isTextPresent("Date:"));
		assertFalse(selenium.isElementPresent("//th[1]"));
		assertFalse(selenium.isElementPresent("//th[2]"));
		assertFalse(selenium.isElementPresent("//th[3]"));
	}
}