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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.address.myaccount;

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
				if (selenium.isElementPresent("link=My Account")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=My Account", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Addresses", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//div[7]/div[1]/input")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//div[7]/div[1]/input", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_2_street1",
			RuntimeVariables.replace("1220 Brea Canyon Rd"));
		selenium.saveScreenShotAndSource();
		selenium.select("_2_countryId",
			RuntimeVariables.replace("label=United States"));
		selenium.type("_2_street2", RuntimeVariables.replace("Ste 12"));
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"AlabamaAlaskaArizonaArkansasCaliforniaColoradoConnecticutDelawareDistrict of ColumbiaFloridaGeorgiaHawaiiIdahoIllinoisIndianaIowaKansasKentuckyLouisianaMaineMarylandMassachusettsMichiganMinnesotaMississippiMissouriMontanaNebraskaNevadaNew HampshireNew JerseyNew MexicoNew YorkNorth CarolinaNorth DakotaOhioOklahomaOregonPennsylvaniaPuerto RicoRhode IslandSouth CarolinaSouth DakotaTennesseeTexasUtahVermontVirginiaWashingtonWest VirginiaWisconsinWyoming")
										.equals(selenium.getText("_2_regionId"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.select("_2_regionId",
			RuntimeVariables.replace("label=California"));
		selenium.type("_2_street3", RuntimeVariables.replace("Walnut"));
		selenium.saveScreenShotAndSource();
		selenium.select("_2_typeId", RuntimeVariables.replace("label=Business"));
		selenium.type("_2_city", RuntimeVariables.replace("Los Angeles"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_2_mailingCheckbox", RuntimeVariables.replace(""));
		selenium.clickAt("_2_primaryCheckbox", RuntimeVariables.replace(""));
		selenium.type("_2_zip", RuntimeVariables.replace("91789"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[2]/div/div/div"));
		assertEquals(RuntimeVariables.replace(
				"1220 Brea Canyon Rd\nSte 12\nWalnut"),
			selenium.getText("//div[7]/div[2]/table/tbody/tr[2]/td[1]"));
		assertEquals(RuntimeVariables.replace("Los Angeles"),
			selenium.getText("//div[7]/div[2]/table/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("91789"),
			selenium.getText("//tr[2]/td[3]"));
		assertEquals(RuntimeVariables.replace("Business"),
			selenium.getText("//td[4]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText("//td[5]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText("//td[6]"));
	}
}