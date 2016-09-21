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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationpage.mergeorganizationpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertNotMergeOrganizationPageTest extends BaseTestCase {
	public void testAssertNotMergeOrganizationPage() throws Exception {
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Organizations", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_126_keywords", RuntimeVariables.replace("Selenium"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Actions"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='View Pages']",
			RuntimeVariables.replace(""));
		selenium.waitForPopUp("", RuntimeVariables.replace("5000"));
		selenium.selectPopUp("");
		assertFalse(selenium.isElementPresent("link=Welcome"));
		assertTrue(selenium.isElementPresent("link=Selenium Test Home Page"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.saveScreenShotAndSource();
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isElementPresent("link=Welcome"));
		assertFalse(selenium.isElementPresent("link=Selenium Test Home Page"));
	}
}