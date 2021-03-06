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

package com.liferay.portalweb.portal.controlpanel.settings.settingsadditionalemailaddress.addsettingsadditionalemailaddressmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownSettingsIdentificationTest extends BaseTestCase {
	public void testTearDownSettingsIdentification() throws Exception {
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("additionalEmailAddressesLink",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("additionalEmailAddressesLink",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("additionalEmailAddressesLink",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("additionalEmailAddressesLink",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("additionalEmailAddressesLink",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
	}
}