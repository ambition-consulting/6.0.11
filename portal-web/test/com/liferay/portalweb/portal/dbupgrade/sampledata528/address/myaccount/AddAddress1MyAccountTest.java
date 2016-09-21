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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.address.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAddress1MyAccountTest extends BaseTestCase {
	public void testAddAddress1MyAccount() throws Exception {
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
		selenium.clickAt("link=My Account", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("addressesLink", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_2_addressStreet1_0")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_2_addressStreet1_0",
			RuntimeVariables.replace("1220 Brea Canyon Rd"));
		selenium.saveScreenShotAndSource();
		selenium.type("_2_addressStreet2_0", RuntimeVariables.replace("Ste 12"));
		selenium.saveScreenShotAndSource();
		selenium.select("_2_addressTypeId0",
			RuntimeVariables.replace("label=Business"));
		selenium.type("_2_addressZip0", RuntimeVariables.replace("91789"));
		selenium.saveScreenShotAndSource();
		selenium.type("_2_addressStreet3_0", RuntimeVariables.replace("Walnut"));
		selenium.saveScreenShotAndSource();
		selenium.type("_2_addressCity0", RuntimeVariables.replace("Los Angeles"));
		selenium.saveScreenShotAndSource();
		selenium.select("_2_addressCountryId0",
			RuntimeVariables.replace("label=United States"));
		selenium.clickAt("_2_addressPrimary0", RuntimeVariables.replace(""));
		selenium.clickAt("_2_addressMailing0Checkbox",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"AlabamaAlaskaArizonaArkansasCaliforniaColoradoConnecticutDelawareDistrict of ColumbiaFloridaGeorgiaHawaiiIdahoIllinoisIndianaIowaKansasKentucky Louisiana MaineMarylandMassachusettsMichiganMinnesotaMississippiMissouriMontanaNebraskaNevadaNew HampshireNew JerseyNew MexicoNew YorkNorth CarolinaNorth DakotaOhioOklahoma OregonPennsylvaniaPuerto RicoRhode IslandSouth CarolinaSouth DakotaTennesseeTexasUtahVermontVirginiaWashingtonWest VirginiaWisconsinWyoming")
										.equals(selenium.getText(
								"_2_addressRegionId0"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.select("_2_addressRegionId0",
			RuntimeVariables.replace("label=California"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if ("United States".equals(selenium.getSelectedLabel(
								"_2_addressCountryId0"))) {
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
				if ("California".equals(selenium.getSelectedLabel(
								"_2_addressRegionId0"))) {
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
			selenium.getText("//div[2]/div/div/div"));
		assertEquals("1220 Brea Canyon Rd",
			selenium.getValue("_2_addressStreet1_0"));
		assertEquals("Ste 12", selenium.getValue("_2_addressStreet2_0"));
		assertEquals("Business", selenium.getSelectedLabel("_2_addressTypeId0"));
		assertEquals("91789", selenium.getValue("_2_addressZip0"));
		assertEquals("Walnut", selenium.getValue("_2_addressStreet3_0"));
		assertEquals("Los Angeles", selenium.getValue("_2_addressCity0"));
		assertEquals("United States",
			selenium.getSelectedLabel("_2_addressCountryId0"));
		assertTrue(selenium.isChecked("_2_addressPrimary0"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked("_2_addressMailing0Checkbox"));
		selenium.saveScreenShotAndSource();
		assertEquals("California",
			selenium.getSelectedLabel("_2_addressRegionId0"));
	}
}