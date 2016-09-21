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

package com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignMembersOrganizationTest extends BaseTestCase {
	public void testAssignMembersOrganization() throws Exception {
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

				boolean basic1Visible = selenium.isVisible("link=\u00ab Basic");

				if (!basic1Visible) {
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
				selenium.clickAt("//strong/a", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Available", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean basic2Visible = selenium.isVisible("link=\u00ab Basic");

				if (!basic2Visible) {
					label = 3;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 3:
				selenium.type("_126_keywords",
					RuntimeVariables.replace("Selenium"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean userChecked = selenium.isChecked("_126_rowIds");

				if (userChecked) {
					label = 4;

					continue;
				}

				selenium.clickAt("_126_rowIds", RuntimeVariables.replace(""));

			case 4:
				selenium.clickAt("//input[@value='Update Associations']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));

			case 100:
				label = -1;
			}
		}
	}
}