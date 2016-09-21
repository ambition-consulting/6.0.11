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
public class AddOrganizationAddressTest extends BaseTestCase {
	public void testAddOrganizationAddress() throws Exception {
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
				selenium.clickAt("addressesLink", RuntimeVariables.replace(""));
				selenium.type("_126_addressStreet1_0",
					RuntimeVariables.replace("12345 Selenium St"));
				selenium.saveScreenShotAndSource();
				selenium.type("_126_addressCity0",
					RuntimeVariables.replace("Diamond Bar"));
				selenium.saveScreenShotAndSource();
				selenium.type("_126_addressZip0",
					RuntimeVariables.replace("41111"));
				selenium.saveScreenShotAndSource();
				selenium.select("_126_addressCountryId0",
					RuntimeVariables.replace("label=United States"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace(
									"AlabamaAlaskaArizonaArkansasCaliforniaColoradoConnecticutDelawareDistrict of ColumbiaFloridaGeorgiaHawaiiIdahoIllinoisIndianaIowaKansasKentucky Louisiana MaineMarylandMassachusettsMichiganMinnesotaMississippiMissouriMontanaNebraskaNevadaNew HampshireNew JerseyNew MexicoNew YorkNorth CarolinaNorth DakotaOhioOklahoma OregonPennsylvaniaPuerto RicoRhode IslandSouth CarolinaSouth DakotaTennesseeTexasUtahVermontVirginiaWashingtonWest VirginiaWisconsinWyoming")
												.equals(selenium.getText(
										"_126_addressRegionId0"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.select("_126_addressRegionId0",
					RuntimeVariables.replace("label=California"));
				selenium.select("_126_addressTypeId0",
					RuntimeVariables.replace("label=Billing"));
				selenium.clickAt("_126_addressMailing0Checkbox",
					RuntimeVariables.replace(""));
				selenium.clickAt("_126_addressPrimary0",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertEquals("12345 Selenium St",
					selenium.getValue("_126_addressStreet1_0"));
				assertEquals("Diamond Bar",
					selenium.getValue("_126_addressCity0"));
				assertEquals("41111", selenium.getValue("_126_addressZip0"));
				assertEquals("Billing",
					selenium.getSelectedLabel("_126_addressTypeId0"));

			case 100:
				label = -1;
			}
		}
	}
}