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

package com.liferay.portalweb.portal.dbupgrade.sampledata527.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchTagsTest extends BaseTestCase {
	public void testSearchTags() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_134_name",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[1]/a",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium1"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium2"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium3"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementPresent("link=MessageC TagC TestC"));
		assertTrue(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isElementPresent("link=Message3 Tag3 Test3"));
	}
}