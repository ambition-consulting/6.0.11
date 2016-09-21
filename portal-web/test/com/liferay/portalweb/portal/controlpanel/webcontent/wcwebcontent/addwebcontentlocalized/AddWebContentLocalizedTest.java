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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwebcontentlocalized;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentLocalizedTest extends BaseTestCase {
	public void testAddWebContentLocalized() throws Exception {
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
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Web Content']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_title",
			RuntimeVariables.replace("Hello World Localized Article"));
		selenium.saveScreenShotAndSource();
		selenium.click("//fieldset/div/div/span/span/input");
		assertTrue(selenium.getConfirmation()
						   .matches("^Selecting a template will change the structure, available input fields, and available templates[\\s\\S] Do you want to proceed[\\s\\S]$"));
		selenium.saveScreenShotAndSource();
		selenium.waitForPopUp("template", RuntimeVariables.replace("30000"));
		selenium.selectWindow("template");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=LOCALIZED")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click("link=LOCALIZED");
		selenium.selectWindow("null");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertTrue(selenium.isPartialText("//fieldset/div/div/div/div/span",
				"Test Localized Structure"));
		assertFalse(selenium.isChecked("//span[2]/div/span/span/span/input[2]"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//span[2]/div/span/span/span/input[2]",
			RuntimeVariables.replace("Localized"));
		assertTrue(selenium.isChecked("//span[2]/div/span/span/span/input[2]"));
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isChecked(
				"//li[2]/span[2]/div/span/span/span/input[2]"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//li[2]/span[2]/div/span/span/span/input[2]",
			RuntimeVariables.replace("Localized"));
		assertTrue(selenium.isChecked(
				"//li[2]/span[2]/div/span/span/span/input[2]"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save as Draft']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent(
							"Your request processed successfully.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		selenium.type("page-name",
			RuntimeVariables.replace("Hello World Page Name"));
		selenium.saveScreenShotAndSource();
		selenium.type("page-description",
			RuntimeVariables.replace("Hello World Page Description"));
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_15_languageId")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.select("_15_languageId",
			RuntimeVariables.replace("label=Chinese (China)"));
		assertTrue(selenium.getConfirmation()
						   .matches("^Would you like to save the changes made to this language[\\s\\S]$"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		selenium.type("page-name",
			RuntimeVariables.replace("\u4e16\u754c\u60a8\u597d Page Name"));
		selenium.saveScreenShotAndSource();
		selenium.type("page-description",
			RuntimeVariables.replace(
				"\u4e16\u754c\u60a8\u597d Page Description"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent(
							"Your request processed successfully.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=Hello World Localized Article")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"link=Hello World Localized Article"));
	}
}