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

package com.liferay.portalweb.plugins.kaleo.mysubmissions.workflowtask.viewtaskwebcontentassignedtouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTaskWebContentAssignedToUserTest extends BaseTestCase {
	public void testViewTaskWebContentAssignedToUser()
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
		selenium.clickAt("link=My Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[6]/a"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Single Approver: Web Content Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Withdraw Submission"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded right null']/ul/li[1]/a"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Portal Content Reviewer role."),
			selenium.getText("//div[@class='task-activity task-type-1']/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[@class='task-activity task-type-1']/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"userfn userln assigned the task to himself."),
			selenium.getText(
				"//div[@class='task-activity task-type-1'][2]/div[2]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText(
				"//div[@class='task-activity task-type-1'][2]/div[3]"));
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText("//td/a"));
	}
}