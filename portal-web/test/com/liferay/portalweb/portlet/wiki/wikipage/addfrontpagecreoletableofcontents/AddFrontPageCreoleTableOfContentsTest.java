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

package com.liferay.portalweb.portlet.wiki.wikipage.addfrontpagecreoletableofcontents;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageCreoleTableOfContentsTest extends BaseTestCase {
	public void testAddFrontPageCreoleTableOfContents()
		throws Exception {
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
				"<<TableOfContents>>\n== Unit ==\n=== Chapter ===\n==== Section ===="));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("Table of Contents [-]"),
			selenium.getText("//div[@class='collapsebox']/h4"));
		assertEquals(RuntimeVariables.replace("[-]"),
			selenium.getText("//div[@class='collapsebox']//a"));
		assertEquals(RuntimeVariables.replace("1 Unit"),
			selenium.getText("//div[@class='toc-index']//li[1]/a"));
		assertEquals(RuntimeVariables.replace("1.1 Chapter"),
			selenium.getText("//div[@class='toc-index']//li[2]/a"));
		assertEquals(RuntimeVariables.replace("1.1.1 Section"),
			selenium.getText("//div[@class='toc-index']//li[3]/a"));
		assertEquals(RuntimeVariables.replace("Unit #"),
			selenium.getText("//div/h2"));
		assertEquals(RuntimeVariables.replace("Chapter #"),
			selenium.getText("//div/h3"));
		assertEquals(RuntimeVariables.replace("Section #"),
			selenium.getText("//div[6]/div/h4"));
	}
}