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

package com.liferay.portalweb.portal.controlpanel.webcontent.templates.addtemplateassociated;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddStructureTest extends BaseTestCase {
	public void testAddStructure() throws Exception {
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
		selenium.clickAt("link=Structures", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Structure']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_newStructureId",
			RuntimeVariables.replace("StructureID"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_name",
			RuntimeVariables.replace("Web Content Structure Name"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_description",
			RuntimeVariables.replace("Web Content Structure Description"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_structure_el0_name", RuntimeVariables.replace("Itp"));
		selenium.saveScreenShotAndSource();
		selenium.select("_15_structure_el0_type",
			RuntimeVariables.replace("label=Link to Page"));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_structure_el0_name",
			RuntimeVariables.replace("title"));
		selenium.saveScreenShotAndSource();
		selenium.select("_15_structure_el0_type",
			RuntimeVariables.replace("label=Text"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace("STRUCTUREID"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Structure Name\nWeb Content Structure Description"),
			selenium.getText("//td[3]/a"));
	}
}