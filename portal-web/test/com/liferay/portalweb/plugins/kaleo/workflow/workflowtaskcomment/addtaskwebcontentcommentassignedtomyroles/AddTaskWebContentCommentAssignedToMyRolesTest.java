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

package com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.addtaskwebcontentcommentassignedtomyroles;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTaskWebContentCommentAssignedToMyRolesTest extends BaseTestCase {
	public void testAddTaskWebContentCommentAssignedToMyRoles()
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
		selenium.clickAt("link=Workflow", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Submissions", RuntimeVariables.replace(""));
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
		selenium.clickAt("link=Be the first.", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_151_postReplyBody0")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_151_postReplyBody0",
			RuntimeVariables.replace("Workflow Task Comment"));
		selenium.saveScreenShotAndSource();
		selenium.keyPress("_151_postReplyBody0",
			RuntimeVariables.replace("\\48"));
		selenium.keyPress("_151_postReplyBody0", RuntimeVariables.replace("\\8"));
		selenium.clickAt("//input[@value='Reply']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Workflow Task Comment"),
			selenium.getText("//td[2]/div[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//a[@class='user-name']"));
	}
}