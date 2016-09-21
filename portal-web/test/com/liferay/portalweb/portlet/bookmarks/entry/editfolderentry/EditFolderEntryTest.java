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

package com.liferay.portalweb.portlet.bookmarks.entry.editfolderentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFolderEntryTest extends BaseTestCase {
	public void testEditFolderEntry() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Bookmarks Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Test Folder Entry"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[5]/ul/li/strong/a", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_28_name",
			RuntimeVariables.replace("Test Folder Entry Edited"));
		selenium.saveScreenShotAndSource();
		selenium.type("_28_url",
			RuntimeVariables.replace("http://www.alloyui.com"));
		selenium.saveScreenShotAndSource();
		selenium.type("_28_comments",
			RuntimeVariables.replace("This is a test folder entry. Edited."));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Test Folder Entry Edited"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.alloyui.com"),
			selenium.getText("//td[2]/a"));
		assertNotEquals(RuntimeVariables.replace("Test Folder Entry"),
			selenium.getText("//td[1]/a"));
		assertNotEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
	}
}