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

package com.liferay.portalweb.portal.controlpanel.users.userphonenumber.adduserphonenumber;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserPhoneNumberTest extends BaseTestCase {
	public void testAddUserPhoneNumber() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Users", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean basicVisible = selenium.isVisible("link=\u00ab Basic");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 2:
				selenium.type("_125_keywords",
					RuntimeVariables.replace("selen01"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//td[2]/a",
					RuntimeVariables.replace("User Name"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("phoneNumbersLink",
					RuntimeVariables.replace(""));
				selenium.type("_125_phoneNumber0",
					RuntimeVariables.replace("123-123-1234"));
				selenium.saveScreenShotAndSource();
				selenium.type("_125_phoneExtension0",
					RuntimeVariables.replace("123"));
				selenium.saveScreenShotAndSource();
				selenium.select("_125_phoneTypeId0",
					RuntimeVariables.replace("label=Business"));
				selenium.clickAt("_125_phonePrimary0",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertEquals("1231231234",
					selenium.getValue("_125_phoneNumber0"));
				assertEquals("123", selenium.getValue("_125_phoneExtension0"));
				assertEquals("Business",
					selenium.getSelectedLabel("_125_phoneTypeId0"));

			case 100:
				label = -1;
			}
		}
	}
}