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

package com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddressmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserAddress2Test extends BaseTestCase {
	public void testAddUserAddress2() throws Exception {
		selenium.open("/web/guest/home");

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
		selenium.clickAt("link=Users", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_125_keywords", RuntimeVariables.replace("selen01"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("User Name"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//div[2]/div/span/span/button[1]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//div[2]/div/span/span/button[1]",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_125_addressStreet1_2")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_125_addressStreet1_2",
			RuntimeVariables.replace("123 Lets"));
		selenium.saveScreenShotAndSource();
		selenium.select("_125_addressTypeId2",
			RuntimeVariables.replace("label=Other"));
		selenium.type("_125_addressStreet2_2",
			RuntimeVariables.replace("897 Hope"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_addressZip2", RuntimeVariables.replace("00000"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_addressStreet3_2",
			RuntimeVariables.replace("7896 This"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_addressCity2", RuntimeVariables.replace("Works"));
		selenium.saveScreenShotAndSource();
		selenium.select("_125_addressCountryId2",
			RuntimeVariables.replace("label=Canada"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"AlbertaBritish ColumbiaManitobaNew BrunswickNewfoundland and LabradorNorthwest TerritoriesNova ScotiaNunavutOntarioPrince Edward IslandQuebecSaskatchewanYukon")
										.equals(selenium.getText(
								"_125_addressRegionId2"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.select("_125_addressRegionId2",
			RuntimeVariables.replace("label=Ontario"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if ("Canada".equals(selenium.getSelectedLabel(
								"_125_addressCountryId1"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if ("Ontario".equals(selenium.getSelectedLabel(
								"_125_addressRegionId1"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		assertEquals("123 Lets", selenium.getValue("_125_addressStreet1_1"));
		assertEquals("Other", selenium.getSelectedLabel("_125_addressTypeId1"));
		assertEquals("897 Hope", selenium.getValue("_125_addressStreet2_1"));
		assertEquals("00000", selenium.getValue("_125_addressZip1"));
		assertEquals("7896 This", selenium.getValue("_125_addressStreet3_1"));
		assertEquals("Works", selenium.getValue("_125_addressCity1"));
		assertEquals("Canada",
			selenium.getSelectedLabel("_125_addressCountryId1"));
		assertEquals("Ontario",
			selenium.getSelectedLabel("_125_addressRegionId1"));
	}
}