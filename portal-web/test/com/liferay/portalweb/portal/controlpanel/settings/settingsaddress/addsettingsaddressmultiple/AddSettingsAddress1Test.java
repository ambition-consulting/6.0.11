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

package com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddressmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSettingsAddress1Test extends BaseTestCase {
	public void testAddSettingsAddress1() throws Exception {
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
		selenium.type("_130_addressStreet1_0",
			RuntimeVariables.replace("123. Liferay Ln."));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_addressCity0",
			RuntimeVariables.replace("Rays of Light"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_addressZip0", RuntimeVariables.replace("12345"));
		selenium.saveScreenShotAndSource();
		selenium.select("_130_addressTypeId0",
			RuntimeVariables.replace("label=Billing"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_130_addressStreet1_0")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals("123. Liferay Ln.",
			selenium.getValue("_130_addressStreet1_0"));
		assertEquals("Rays of Light", selenium.getValue("_130_addressCity0"));
		assertEquals("12345", selenium.getValue("_130_addressZip0"));
		assertEquals("Billing", selenium.getSelectedLabel("_130_addressTypeId0"));
	}
}