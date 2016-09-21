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

package com.liferay.portalweb.portal.permissions.documentlibrary.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Portlet_AssertViewFolderTest extends BaseTestCase {
	public void testPortlet_AssertViewFolder() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=Document Library Permissions Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Document Library Permissions Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Portlet2 Temporary2 Folder2"));
		selenium.clickAt("link=Portlet2 Temporary2 Folder2",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Documents Home"),
			selenium.getText("//span[1]/a/span"));
		assertEquals(RuntimeVariables.replace("Recent Documents"),
			selenium.getText("//span[2]/a/span"));
		assertEquals(RuntimeVariables.replace("My Documents"),
			selenium.getText("//span[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Portlet2 Temporary2 Folder2"),
			selenium.getText("//h1[@class='header-title']/span"));
	}
}