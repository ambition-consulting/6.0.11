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

package com.liferay.portalweb.portal.stagingorganization.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserContentAdministratorTest extends BaseTestCase {
	public void testAddUserContentAdministrator() throws Exception {
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
		selenium.clickAt("link=Users", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Add", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_125_screenName",
			RuntimeVariables.replace("ContentAdministrator"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_emailAddress",
			RuntimeVariables.replace("CA@liferay.com"));
		selenium.saveScreenShotAndSource();
		selenium.select("_125_prefixId", RuntimeVariables.replace("label=Mr."));
		selenium.type("_125_firstName",
			RuntimeVariables.replace("Administrator"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_lastName", RuntimeVariables.replace("Liferay"));
		selenium.saveScreenShotAndSource();
		selenium.select("_125_suffixId", RuntimeVariables.replace("label=PhD."));
		selenium.select("_125_birthdayMonth",
			RuntimeVariables.replace("label=May"));
		selenium.select("_125_birthdayDay", RuntimeVariables.replace("label=22"));
		selenium.select("_125_birthdayYear",
			RuntimeVariables.replace("label=1985"));
		selenium.select("_125_male", RuntimeVariables.replace("label=Male"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("passwordLink", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_125_password1")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_125_password1", RuntimeVariables.replace("test"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_password2", RuntimeVariables.replace("test"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
	}
}