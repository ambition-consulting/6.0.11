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

package com.liferay.portalweb.portal.controlpanel.users.user.addusermultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUser3Test extends BaseTestCase {
	public void testAddUser3() throws Exception {
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

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Users")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Users", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Add", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_125_prefixId", RuntimeVariables.replace("label=Mr."));
		selenium.type("_125_screenName", RuntimeVariables.replace("selenium03"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_emailAddress",
			RuntimeVariables.replace("test03@selenium.com"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_firstName", RuntimeVariables.replace("selen03"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_middleName", RuntimeVariables.replace("lenn"));
		selenium.saveScreenShotAndSource();
		selenium.type("_125_lastName", RuntimeVariables.replace("nium03"));
		selenium.saveScreenShotAndSource();
		selenium.select("_125_prefixId", RuntimeVariables.replace("label=Ms."));
		selenium.select("_125_birthdayMonth",
			RuntimeVariables.replace("label=August"));
		selenium.select("_125_birthdayDay", RuntimeVariables.replace("label=5"));
		selenium.select("_125_birthdayYear",
			RuntimeVariables.replace("label=1991"));
		selenium.select("_125_male", RuntimeVariables.replace("label=Female"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals("selenium03", selenium.getValue("_125_screenName"));
		assertEquals("test03@selenium.com",
			selenium.getValue("_125_emailAddress"));
		assertEquals("selen03", selenium.getValue("_125_firstName"));
		assertEquals("lenn", selenium.getValue("_125_middleName"));
		assertEquals("nium03", selenium.getValue("_125_lastName"));
	}
}