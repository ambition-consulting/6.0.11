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
public class DefinePermissionsRoleCPOrganizationTest extends BaseTestCase {
	public void testDefinePermissionsRoleCPOrganization()
		throws Exception {
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
		selenium.clickAt("link=Roles", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Organization Content Publisher"),
			selenium.getText("//tr[11]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Organization"),
			selenium.getText("//tr[11]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"This is the Content Publisher Role."),
			selenium.getText("//tr[11]/td[3]/a"));
		selenium.clickAt("//tr[11]/td[4]/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Define Permissions"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Organization Content Publisher"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"Add Permissions (Changing the value of this field will reload the page.)"),
			selenium.getText("//label[@for='_128_add-permissions']"));
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Organization Administration"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.check(
			"//input[@value='com.liferay.portal.model.OrganizationAPPROVE_PROPOSAL']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationASSIGN_MEMBERS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationASSIGN_REVIEWER']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationASSIGN_USER_ROLES']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationDELETE']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_ARCHIVED_SETUPS']");
		selenium.check(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_LAYOUTS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_STAGING']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_SUBORGANIZATIONS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_TEAMS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationMANAGE_USERS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationPERMISSIONS']");
		selenium.check(
			"//input[@value='com.liferay.portal.model.OrganizationPUBLISH_STAGING']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationUPDATE']");
		selenium.uncheck(
			"//input[@value='com.liferay.portal.model.OrganizationVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//section/div/div/div/div[3]"));
	}
}