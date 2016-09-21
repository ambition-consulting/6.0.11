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

package com.liferay.portalweb.plugins.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFormTest extends BaseTestCase {
	public void testEditForm() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Web Form Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Web Form Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Suggestions"),
			selenium.getText("//legend/span"));
		assertEquals(RuntimeVariables.replace(
				"Your input is valuable to us. Please send us your suggestions."),
			selenium.getText("//em"));
		assertEquals(RuntimeVariables.replace("Name"),
			selenium.getText("//label"));
		assertEquals(RuntimeVariables.replace("Rating"),
			selenium.getText("//span[2]/span/label"));
		assertEquals(RuntimeVariables.replace(
				"Excellent Good Satisfactory Poor"),
			selenium.getText("//select"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//span[3]/span/label"));
		selenium.click("//strong/a");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_86_title_en_US")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_86_title_en_US", RuntimeVariables.replace("Feed Back"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_description_en_US",
			RuntimeVariables.replace("Please let us know what you think!"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_fieldLabel1_en_US",
			RuntimeVariables.replace("Your Name"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_fieldLabel2_en_US",
			RuntimeVariables.replace("Rate Us!"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_fieldLabel3_en_US",
			RuntimeVariables.replace("Additional Comments"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//div[2]/span[1]/span/input",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@id='p_p_id_86_']/div/div"));
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Web Form Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Web Form Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Feed Back"),
			selenium.getText("//legend/span"));
		assertEquals(RuntimeVariables.replace(
				"Please let us know what you think!"), selenium.getText("//em"));
		assertEquals(RuntimeVariables.replace("Your Name"),
			selenium.getText("//label"));
		assertEquals(RuntimeVariables.replace("Rate Us!"),
			selenium.getText("//span[2]/span/label"));
		assertEquals(RuntimeVariables.replace(
				"Excellent Good Satisfactory Poor"),
			selenium.getText("//select"));
		assertEquals(RuntimeVariables.replace("Additional Comments"),
			selenium.getText("//span[3]/span/label"));
	}
}