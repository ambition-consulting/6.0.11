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

package com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletshowavailablelocales;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTemplateLocalizedTest extends BaseTestCase {
	public void testAddTemplateLocalized() throws Exception {
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
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Templates", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Template']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_newTemplateId", RuntimeVariables.replace("LOCALIZED"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_name",
			RuntimeVariables.replace("Test Localized Template"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_description",
			RuntimeVariables.replace("This is a test localized template."));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace(""));
		selenium.waitForPopUp("structure", RuntimeVariables.replace("30000"));
		selenium.selectWindow("structure");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=LOCALIZED")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click("link=LOCALIZED");
		selenium.selectWindow("null");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("link=Test Localized Structure"));
		selenium.type("_15_xsl",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portlet\\webcontentdisplay\\webcontent\\viewwcdwebcontentlocalized\\dependencies\\LocalizedTemplate.htm"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertTrue(selenium.isElementPresent("link=LOCALIZED"));
		assertTrue(selenium.isTextPresent("Test Localized Template"));
	}
}