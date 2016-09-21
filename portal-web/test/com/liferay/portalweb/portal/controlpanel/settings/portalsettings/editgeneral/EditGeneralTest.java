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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.editgeneral;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditGeneralTest extends BaseTestCase {
	public void testEditGeneral() throws Exception {
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
		selenium.clickAt("link=Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("generalLink", RuntimeVariables.replace(""));
		selenium.type("_130_legalId", RuntimeVariables.replace("LIFE"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_sicCode", RuntimeVariables.replace("1234"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_tickerSymbol", RuntimeVariables.replace("LFRY"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_industry", RuntimeVariables.replace("Web Portal"));
		selenium.saveScreenShotAndSource();
		selenium.type("_130_type", RuntimeVariables.replace("Open Source"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals("LIFE", selenium.getValue("_130_legalId"));
		assertEquals("1234", selenium.getValue("_130_sicCode"));
		assertEquals("LFRY", selenium.getValue("_130_tickerSymbol"));
		assertEquals("Web Portal", selenium.getValue("_130_industry"));
		assertEquals("Open Source", selenium.getValue("_130_type"));
	}
}