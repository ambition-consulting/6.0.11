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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationservice.addorganizationservice;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationServiceTest extends BaseTestCase {
	public void testAddOrganizationService() throws Exception {
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

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("servicesLink")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("servicesLink", RuntimeVariables.replace(""));
				selenium.select("_126_orgLaborTypeId0",
					RuntimeVariables.replace("label=Training"));
				selenium.select("_126_sunOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_sunClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_monOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_monClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_tueOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_tueClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_wedOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_wedClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_thuOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_thuClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_friOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_friClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.select("_126_satOpen0",
					RuntimeVariables.replace("label=09:00"));
				selenium.select("_126_satClose0",
					RuntimeVariables.replace("label=05:00"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertEquals("Training",
					selenium.getSelectedLabel("_126_orgLaborTypeId0"));

			case 100:
				label = -1;
			}
		}
	}
}