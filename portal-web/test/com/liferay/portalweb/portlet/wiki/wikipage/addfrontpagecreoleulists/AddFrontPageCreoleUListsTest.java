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

package com.liferay.portalweb.portlet.wiki.wikipage.addfrontpagecreoleulists;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageCreoleUListsTest extends BaseTestCase {
	public void testAddFrontPageCreoleULists() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Wiki Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Wiki Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=This page is empty. Edit it to add some text.",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_36_content",
			RuntimeVariables.replace(
				"* Item\n** Subitem\n* Item\n** Subitem\n** Subitem\n* Item\n** Subitem\n** Subitem\n** Subitem"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("Item Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[1]/ul/li"));
		assertEquals(RuntimeVariables.replace("Item Subitem Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[2]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[2]//li[1]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[2]//li[2]"));
		assertEquals(RuntimeVariables.replace("Item Subitem Subitem Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[3]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[3]//li[1]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[3]//li[2]"));
		assertEquals(RuntimeVariables.replace("Subitem"),
			selenium.getText("//div[@class='wiki-body']/ul/li[3]//li[3]"));
	}
}