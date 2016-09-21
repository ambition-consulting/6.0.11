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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.expirewebcontentapproved;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpireWebContentApprovedTest extends BaseTestCase {
	public void testExpireWebContentApproved() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Web Content Name Approved"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertFalse(selenium.isChecked("_15_rowIds"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_15_rowIds", RuntimeVariables.replace(""));
		assertTrue(selenium.isChecked("_15_rowIds"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Expire']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to expire the selected web content[\\s\\S]$"));
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace("Web Content Name Approved"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Expired"),
			selenium.getText("//td[5]/a"));
	}
}