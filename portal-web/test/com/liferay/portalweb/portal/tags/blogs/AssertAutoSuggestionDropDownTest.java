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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertAutoSuggestionDropDownTest extends BaseTestCase {
	public void testAssertAutoSuggestionDropDown() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Tags Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Tags3 Blogs3 Test3 Entry3")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Tags3 Blogs3 Test3 Entry3",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("main-content", RuntimeVariables.replace(""));
		selenium.clickAt("navigation", RuntimeVariables.replace(""));
		selenium.clickAt("dockbar", RuntimeVariables.replace(""));
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//li[2]/span/span/input")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("//li[2]/span/span/input", RuntimeVariables.replace(""));
		selenium.saveScreenShotAndSource();
		selenium.typeKeys("//li[2]/span/span/input",
			RuntimeVariables.replace("selenium"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium1 liferay1"),
			selenium.getText("//div[6]/div/div/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText("//div[6]/div/div/ul/li[2]"));
		assertEquals(RuntimeVariables.replace("selenium3 liferay3"),
			selenium.getText("//div[6]/div/div/ul/li[3]"));
		assertEquals(RuntimeVariables.replace("selenium4 liferay4"),
			selenium.getText("//div[6]/div/div/ul/li[4]"));
		selenium.typeKeys("//li[2]/span/span/input",
			RuntimeVariables.replace("2*"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText("//div[6]/div/div/ul/li[1]"));
		assertFalse(selenium.isVisible("//div[6]/div/div/ul/li[2]"));
		assertFalse(selenium.isVisible("//div[6]/div/div/ul/li[3]"));
		assertFalse(selenium.isVisible("//div[6]/div/div/ul/li[4]"));
	}
}