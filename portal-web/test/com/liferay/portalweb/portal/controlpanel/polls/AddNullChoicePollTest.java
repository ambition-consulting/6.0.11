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

package com.liferay.portalweb.portal.controlpanel.polls;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddNullChoicePollTest extends BaseTestCase {
	public void testAddNullChoicePoll() throws Exception {
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
		selenium.clickAt("link=Polls", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Question']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_25_title_en_US",
			RuntimeVariables.replace("Null Choice Poll Test Title"));
		selenium.saveScreenShotAndSource();
		selenium.type("_25_description_en_US",
			RuntimeVariables.replace("Null Choice Poll Test Description"));
		selenium.saveScreenShotAndSource();
		selenium.type("_25_choiceDescriptiona_en_US",
			RuntimeVariables.replace("Null Choice Poll Test Choice A"));
		selenium.saveScreenShotAndSource();
		selenium.type("_25_choiceDescriptionb_en_US",
			RuntimeVariables.replace("Null Choice Poll Test Choice B"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Choice']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_25_choiceDescriptionc_en_US",
			RuntimeVariables.replace(""));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"You have entered invalid data. Please try again"));
		assertTrue(selenium.isTextPresent("Please enter valid choices."));
	}
}