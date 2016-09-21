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

package com.liferay.portalweb.portal.tags.wiki.addfrontpagetag;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageTest extends BaseTestCase {
	public void testAddFrontPage() throws Exception {
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
				"==Test Wiki Article==\n\n//this is italics//\n\n**bold**\n\n[[http://www.liferay.com|Link to website]]\n\n*this is a list item\n**this is a sub list item"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("Test Wiki Article#"),
			selenium.getText("//div[@class='wiki-body']/h2"));
		assertEquals(RuntimeVariables.replace("this is italics"),
			selenium.getText("//i"));
		assertEquals(RuntimeVariables.replace("bold"), selenium.getText("//b"));
		assertTrue(selenium.isElementPresent("link=Link to website"));
		assertEquals(RuntimeVariables.replace(
				"this is a list item this is a sub list item"),
			selenium.getText("//div[@class='wiki-body']/ul/li"));
	}
}