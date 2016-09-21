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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwebcontentlocalized;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddStructureLocalizedTest extends BaseTestCase {
	public void testAddStructureLocalized() throws Exception {
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
		selenium.clickAt("//input[@value=\"Add Structure\"]",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_newStructureId",
			RuntimeVariables.replace("LOCALIZED"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_name",
			RuntimeVariables.replace("Test Localized Structure"));
		selenium.saveScreenShotAndSource();
		selenium.type("_15_description",
			RuntimeVariables.replace("This is a test localized structure."));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_15_editorButton", RuntimeVariables.replace(""));
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_15_xsdContent")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_15_xsdContent",
			RuntimeVariables.replace(
				"<root> \n\n <dynamic-element name='page-name' type='text'></dynamic-element> \n\n <dynamic-element name='page-description' type='text'></dynamic-element> \n\n</root>"));
		selenium.saveScreenShotAndSource();
		selenium.click("//input[@value='Update']");
		Thread.sleep(5000);
		assertEquals("page-name", selenium.getValue("_15_structure_el0_name"));
		assertEquals("page-description",
			selenium.getValue("_15_structure_el1_name"));
		selenium.clickAt("//input[@value=\"Save\"]",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=LOCALIZED"));
		assertTrue(selenium.isTextPresent("Test Localized Structure"));
	}
}