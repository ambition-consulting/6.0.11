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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationwebsite.addorganizationwebsiteinvalid;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationWebsiteInvalidTest extends BaseTestCase {
	public void testAddOrganizationWebsiteInvalid() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:

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
				selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
				selenium.type("_126_websiteUrl0",
					RuntimeVariables.replace("www.liferay.com"));
				selenium.saveScreenShotAndSource();
				selenium.select("_126_websiteTypeId0",
					RuntimeVariables.replace("label=Public"));
				selenium.clickAt("_126_websitePrimary0",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"You have entered invalid data. Please try again."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertEquals(RuntimeVariables.replace(
						"Please enter a valid URL."),
					selenium.getText("//div[7]/div[1]"));

			case 100:
				label = -1;
			}
		}
	}
}