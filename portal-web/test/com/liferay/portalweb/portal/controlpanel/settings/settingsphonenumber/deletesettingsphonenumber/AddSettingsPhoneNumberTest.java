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

package com.liferay.portalweb.portal.controlpanel.settings.settingsphonenumber.deletesettingsphonenumber;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSettingsPhoneNumberTest extends BaseTestCase {
	public void testAddSettingsPhoneNumber() throws Exception {
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
		selenium.clickAt("phoneNumbersLink", RuntimeVariables.replace(""));
		selenium.type("_130_phoneNumber0",
			RuntimeVariables.replace("123-123-1234"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_phoneExtension0", RuntimeVariables.replace("123"));
		selenium.saveScreenShotAndSource();
		selenium.select("_130_phoneTypeId0",
			RuntimeVariables.replace("label=Other"));
		selenium.clickAt("_130_phonePrimary0", RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals("1231231234", selenium.getValue("_130_phoneNumber0"));
		assertEquals("123", selenium.getValue("_130_phoneExtension0"));
		assertEquals("Other", selenium.getSelectedLabel("_130_phoneTypeId0"));
		assertTrue(selenium.isChecked("_130_phonePrimary0"));
		selenium.saveScreenShotAndSource();
	}
}