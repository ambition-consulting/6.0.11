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

package com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddress;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserAddressTest extends BaseTestCase {
	public void testAddUserAddress() throws Exception {
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
				selenium.clickAt("link=Users", RuntimeVariables.replace(""));
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
				selenium.type("_125_keywords",
					RuntimeVariables.replace("selen01"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//td[2]/a",
					RuntimeVariables.replace("User Name"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("addressesLink",
					RuntimeVariables.replace("Addresses"));
				selenium.type("_125_addressStreet1_0",
					RuntimeVariables.replace("123 Liferay Ln."));
				selenium.saveScreenShotAndSource();
				selenium.select("_125_addressCountryId0",
					RuntimeVariables.replace("label=United States"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace(
									"AlabamaAlaskaArizonaArkansasCaliforniaColoradoConnecticutDelawareDistrict of ColumbiaFloridaGeorgiaHawaiiIdahoIllinoisIndianaIowaKansasKentucky Louisiana MaineMarylandMassachusettsMichiganMinnesotaMississippiMissouriMontanaNebraskaNevadaNew HampshireNew JerseyNew MexicoNew YorkNorth CarolinaNorth DakotaOhioOklahoma OregonPennsylvaniaPuerto RicoRhode IslandSouth CarolinaSouth DakotaTennesseeTexasUtahVermontVirginiaWashingtonWest VirginiaWisconsinWyoming")
												.equals(selenium.getText(
										"_125_addressRegionId0"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.select("_125_addressRegionId0",
					RuntimeVariables.replace("label=California"));
				selenium.type("_125_addressZip0",
					RuntimeVariables.replace("91234"));
				selenium.saveScreenShotAndSource();
				selenium.type("_125_addressCity0",
					RuntimeVariables.replace("Ray of Light"));
				selenium.saveScreenShotAndSource();
				selenium.select("_125_addressTypeId0",
					RuntimeVariables.replace("label=Personal"));
				selenium.clickAt("_125_addressMailing0Checkbox",
					RuntimeVariables.replace(""));
				selenium.clickAt("_125_addressPrimary0",
					RuntimeVariables.replace(""));
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
						if (RuntimeVariables.replace(
									"AlabamaAlaskaArizonaArkansasCaliforniaColoradoConnecticutDelawareDistrict of ColumbiaFloridaGeorgiaHawaiiIdahoIllinoisIndianaIowaKansasKentucky Louisiana MaineMarylandMassachusettsMichiganMinnesotaMississippiMissouriMontanaNebraskaNevadaNew HampshireNew JerseyNew MexicoNew YorkNorth CarolinaNorth DakotaOhioOklahoma OregonPennsylvaniaPuerto RicoRhode IslandSouth CarolinaSouth DakotaTennesseeTexasUtahVermontVirginiaWashingtonWest VirginiaWisconsinWyoming")
												.equals(selenium.getText(
										"_125_addressRegionId0"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals("123 Liferay Ln.",
					selenium.getValue("_125_addressStreet1_0"));
				assertEquals("Personal",
					selenium.getSelectedLabel("_125_addressTypeId0"));
				assertEquals("91234", selenium.getValue("_125_addressZip0"));
				assertEquals("Ray of Light",
					selenium.getValue("_125_addressCity0"));
				assertEquals("United States",
					selenium.getSelectedLabel("_125_addressCountryId0"));
				assertEquals("California",
					selenium.getSelectedLabel("_125_addressRegionId0"));
				assertTrue(selenium.isChecked("_125_addressPrimary0"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isChecked("_125_addressMailing0Checkbox"));
				selenium.saveScreenShotAndSource();

			case 100:
				label = -1;
			}
		}
	}
}