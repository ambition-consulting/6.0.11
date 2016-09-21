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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddressmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationAddress3Test extends BaseTestCase {
	public void testAddOrganizationAddress3() throws Exception {
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
				selenium.clickAt("link=Organizations",
					RuntimeVariables.replace(""));
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
				selenium.type("_126_keywords",
					RuntimeVariables.replace("Selenium"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Selenium"),
					selenium.getText("//td[2]/a"));
				selenium.clickAt("//td[2]/a", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("addressesLink", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//div[2]/span/span/button[1]")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//div[2]/span/span/button[1]",
					RuntimeVariables.replace("Add Row"));
				Thread.sleep(5000);
				selenium.type("_126_addressStreet1_3",
					RuntimeVariables.replace("12345 Selenium St"));
				selenium.saveScreenShotAndSource();
				selenium.type("_126_addressCity3",
					RuntimeVariables.replace("Diamond Bar"));
				selenium.saveScreenShotAndSource();
				selenium.type("_126_addressZip3",
					RuntimeVariables.replace("41111"));
				selenium.saveScreenShotAndSource();
				selenium.select("_126_addressCountryId3",
					RuntimeVariables.replace("label=United States"));
				Thread.sleep(5000);
				selenium.select("_126_addressRegionId3",
					RuntimeVariables.replace("label=California"));
				selenium.select("_126_addressTypeId3",
					RuntimeVariables.replace("label=Billing"));
				Thread.sleep(5000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("_126_addressStreet1_2")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals("12345 Selenium St",
					selenium.getValue("_126_addressStreet1_2"));
				assertEquals("Diamond Bar",
					selenium.getValue("_126_addressCity2"));
				assertEquals("41111", selenium.getValue("_126_addressZip2"));
				assertEquals("United States",
					selenium.getSelectedLabel("_126_addressCountryId2"));
				assertEquals("California",
					selenium.getSelectedLabel("_126_addressRegionId2"));
				assertEquals("Billing",
					selenium.getSelectedLabel("_126_addressTypeId2"));

			case 100:
				label = -1;
			}
		}
	}
}