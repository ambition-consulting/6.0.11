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

package com.liferay.portalweb.portlet.directory.organizations.viewsuborganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSuborganizationTest extends BaseTestCase {
	public void testViewSuborganization() throws Exception {
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
						if (selenium.isVisible("link=Directory Test Page")) {
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
				selenium.type("_11_keywords",
					RuntimeVariables.replace("Test Organization"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Test Organization"),
					selenium.getText("//td[1]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("Regular Organization"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("Diamond Bar"),
					selenium.getText("//td[4]/a"));
				assertEquals(RuntimeVariables.replace("California"),
					selenium.getText("//td[5]/a"));
				assertEquals(RuntimeVariables.replace("United States"),
					selenium.getText("//td[6]/a"));
				selenium.clickAt("//td[7]/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("View Suborganizations"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Test Child"),
					selenium.getText("//td[1]/a"));
				assertEquals(RuntimeVariables.replace("Test Organization"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("Regular Organization"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("Cerritos"),
					selenium.getText("//td[4]/a"));
				assertEquals(RuntimeVariables.replace("Florida"),
					selenium.getText("//td[5]/a"));
				assertEquals(RuntimeVariables.replace("United States"),
					selenium.getText("//td[6]/a"));
				selenium.clickAt("//td[1]/a",
					RuntimeVariables.replace("Test Child"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Test Child"),
					selenium.getText(
						"//div[@class='organization-information']/div[1]/h2"));
				assertEquals(RuntimeVariables.replace("Type"),
					selenium.getText("//dl[@class='property-list']/dt[1]"));
				assertEquals(RuntimeVariables.replace("Regular Organization"),
					selenium.getText("//dl[@class='property-list']/dd[1]"));
				assertEquals(RuntimeVariables.replace("Parent Organization"),
					selenium.getText("//dl[@class='property-list']/dt[2]"));
				assertEquals(RuntimeVariables.replace("Test Organization"),
					selenium.getText("//dl[@class='property-list']/dd[2]"));
				assertEquals(RuntimeVariables.replace(
						"Billing 11111 Main Street USA\n 90210, Cerritos (Mailing)"),
					selenium.getText("//li[@class='primary']"));

			case 100:
				label = -1;
			}
		}
	}
}