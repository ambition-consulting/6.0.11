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

package com.liferay.portalweb.portlet.directory.organizations.advancedsearchorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchOrganizationStreetTest extends BaseTestCase {
	public void testAdvancedSearchOrganizationStreet()
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
						if (selenium.isVisible("link=Directory Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Directory Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Organizations",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean advancedVisible = selenium.isVisible(
						"link=Advanced \u00bb");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace(""));

			case 2:

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("_11_andOperator")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.select("_11_andOperator",
					RuntimeVariables.replace("label=Any"));
				selenium.type("_11_street",
					RuntimeVariables.replace("12345 Test Street"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//div[2]/span[2]/span/input",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_11_street", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent("link=Test Organization"));
				selenium.type("_11_street",
					RuntimeVariables.replace("123456 Test1 Street1"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//div[2]/span[2]/span/input",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_11_street", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.select("_11_andOperator",
					RuntimeVariables.replace("label=All"));
				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));
				assertFalse(selenium.isTextPresent("Test Organization"));

			case 100:
				label = -1;
			}
		}
	}
}