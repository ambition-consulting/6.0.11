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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.stagingorganization.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewOrganizationStagingOrganizationWCDTest extends BaseTestCase {
	public void testViewOrganizationStagingOrganizationWCD()
		throws Exception {
		selenium.open("/web/staging-organization-wcd/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Page Staging Organization Web Content Display")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Page Staging Organization Web Content Display",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible public-page']"));
		selenium.clickAt("link=View Staged Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible public-page']"));
		assertEquals(RuntimeVariables.replace("WC Web Content Content"),
			selenium.getText("//p"));
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Organization Staging Organization Web Content Display (Staging)"),
			selenium.getText("//h2/a"));
		assertTrue(selenium.isElementPresent("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isElementPresent("//td[6]/a"));
		assertTrue(selenium.isElementPresent("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
		selenium.open("/web/staging-organization-wcd/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Page Staging Organization Web Content Display")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Page Staging Organization Web Content Display",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible public-page']"));
		assertFalse(selenium.isTextPresent("WC Web Content Content"));
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Organization Staging Organization Web Content Display (Staging)"),
			selenium.getText("//h2/a"));
		assertTrue(selenium.isElementPresent("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isElementPresent("//td[6]/a"));
		assertTrue(selenium.isElementPresent("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
	}
}