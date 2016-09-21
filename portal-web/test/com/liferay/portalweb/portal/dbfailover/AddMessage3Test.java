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

package com.liferay.portalweb.portal.dbfailover;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMessage3Test extends BaseTestCase {
	public void testAddMessage3() throws Exception {
		selenium.open("/user/joebloggs/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("link=Test Category"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"//input[@value=\"Post New Thread\"]"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_subject", RuntimeVariables.replace("Test Message 3"));
		selenium.saveScreenShotAndSource();
		selenium.type("_19_textArea",
			RuntimeVariables.replace("This is Test Message 3."));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Publish']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//td[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("This is Test Message 3."));
		assertTrue(selenium.isElementPresent("link=Test Message 3"));
		selenium.click(RuntimeVariables.replace("link=Test Category"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Test Message 3"));
		System.out.println("Sample data 3 added successfully.\n");
	}
}