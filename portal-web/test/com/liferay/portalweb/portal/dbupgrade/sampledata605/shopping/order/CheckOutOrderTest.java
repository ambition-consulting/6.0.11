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

package com.liferay.portalweb.portal.dbupgrade.sampledata605.shopping.order;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CheckOutOrderTest extends BaseTestCase {
	public void testCheckOutOrder() throws Exception {
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
				selenium.clickAt("link=Communities",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_134_name",
					RuntimeVariables.replace("Shopping Order Community"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Shopping Order Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Cart", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Checkout']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_34_billingStreet",
					RuntimeVariables.replace("1234 Sesame Street"));
				selenium.saveScreenShotAndSource();
				selenium.type("_34_billingCity",
					RuntimeVariables.replace("Gotham City"));
				selenium.saveScreenShotAndSource();
				selenium.select("_34_billingStateSel",
					RuntimeVariables.replace("label=California"));
				selenium.type("_34_billingZip",
					RuntimeVariables.replace("90028"));
				selenium.saveScreenShotAndSource();
				selenium.type("_34_billingCountry",
					RuntimeVariables.replace("USA"));
				selenium.saveScreenShotAndSource();
				selenium.type("_34_billingPhone",
					RuntimeVariables.replace("626-589-1453"));
				selenium.saveScreenShotAndSource();

				boolean sameAsBillingChecked = selenium.isChecked(
						"_34_shipToBillingCheckbox");

				if (sameAsBillingChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_34_shipToBillingCheckbox",
					RuntimeVariables.replace(""));

			case 2:
				assertTrue(selenium.isChecked("_34_shipToBillingCheckbox"));
				selenium.saveScreenShotAndSource();
				selenium.select("_34_ccType",
					RuntimeVariables.replace("label=Visa"));
				selenium.type("_34_ccNumber",
					RuntimeVariables.replace("4111111111111111"));
				selenium.saveScreenShotAndSource();
				selenium.select("_34_ccExpYear",
					RuntimeVariables.replace("label=2011"));
				selenium.type("_34_comments",
					RuntimeVariables.replace("Please take care of my order."));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Continue']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent("1234 Sesame Street"));
				selenium.clickAt("//input[@value='Finished']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"Thank you for your purchase."));
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
				selenium.clickAt("link=Communities",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_134_name",
					RuntimeVariables.replace("Shopping Order Community"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Shopping Order Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Orders", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Checkout", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"Please take care of my order."));

			case 100:
				label = -1;
			}
		}
	}
}