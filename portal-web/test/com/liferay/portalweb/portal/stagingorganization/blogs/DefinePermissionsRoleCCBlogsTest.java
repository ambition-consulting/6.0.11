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
public class DefinePermissionsRoleCCBlogsTest extends BaseTestCase {
	public void testDefinePermissionsRoleCCBlogs() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Organization Content Creator"),
			selenium.getText("//tr[10]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Organization"),
			selenium.getText("//tr[10]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"This is the Content Creator Role."),
			selenium.getText("//tr[10]/td[3]/a"));
		selenium.clickAt("//tr[10]/td[4]/ul/li/strong/a",
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
		assertEquals(RuntimeVariables.replace("Organization Content Creator"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"Add Permissions (Changing the value of this field will reload the page.)"),
			selenium.getText("//label[@for='_128_add-permissions']"));
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.check("//input[@value='com.liferay.portlet.blogsADD_ENTRY']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogsPERMISSIONS']");
		selenium.uncheck("//input[@value='com.liferay.portlet.blogsSUBSCRIBE']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryDELETE_DISCUSSION']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryPERMISSIONS']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE_DISCUSSION']");
		selenium.uncheck(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//section/div/div/div/div[3]"));
	}
}