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

package com.liferay.portalweb.portal.controlpanel.webcontent.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertImportLARTest extends BaseTestCase {
	public void testAssertImportLAR() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Test Web Content Article"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertEquals(RuntimeVariables.replace("Test Web Content Article 2"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//tr[4]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//tr[4]/td[5]/a"));
		selenium.clickAt("link=Structures", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("TEST"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Test Web Content Structure\nThis is a test web content structure!"),
			selenium.getText("//td[3]/a"));
		selenium.clickAt("link=Templates", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("TEST"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Test Web Content Template\n This is a test web content template!"),
			selenium.getText("//td[3]/a"));
	}
}