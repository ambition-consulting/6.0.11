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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.advancedsearchorganizationaddress;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchOrganizationAddressStreetTest extends BaseTestCase {
	public void testAdvancedSearchOrganizationAddressStreet()
		throws Exception {
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

				boolean advancedPresent = selenium.isVisible(
						"link=Advanced \u00bb");

				if (!advancedPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace(""));

			case 2:
				selenium.type("_126_street",
					RuntimeVariables.replace("12345 Selenium St"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//div[2]/span[2]/span/input",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_126_street", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Selenium"),
					selenium.getText("//td[2]/a"));

				boolean basicPresent = selenium.isVisible("link=\u00ab Basic");

				if (!basicPresent) {
					label = 3;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 3:
			case 100:
				label = -1;
			}
		}
	}
}