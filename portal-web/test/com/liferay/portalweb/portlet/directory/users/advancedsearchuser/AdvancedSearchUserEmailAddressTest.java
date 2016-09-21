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

package com.liferay.portalweb.portlet.directory.users.advancedsearchuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchUserEmailAddressTest extends BaseTestCase {
	public void testAdvancedSearchUserEmailAddress() throws Exception {
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
						if (selenium.isElementPresent(
									"link=Directory Test Page")) {
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
				selenium.clickAt("link=Users", RuntimeVariables.replace(""));
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
				selenium.type("_11_emailAddress",
					RuntimeVariables.replace("testemail1@liferay.com"));
				selenium.saveScreenShotAndSource();
				selenium.click(RuntimeVariables.replace(
						"//div[2]/span[2]/span/input"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_11_emailAddress", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent("link=TestFirst1"));
				selenium.type("_11_emailAddress",
					RuntimeVariables.replace("testemail1liferay.com"));
				selenium.saveScreenShotAndSource();
				selenium.click(RuntimeVariables.replace(
						"//div[2]/span[2]/span/input"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.select("_11_andOperator",
					RuntimeVariables.replace("label=All"));
				selenium.type("_11_emailAddress", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));
				assertFalse(selenium.isTextPresent("TestFirst1"));

			case 100:
				label = -1;
			}
		}
	}
}