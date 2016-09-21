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

package com.liferay.portalweb.portlet.pagecomments.comment.editcommentreplybodyspace;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditCommentReplyBodySpaceTest extends BaseTestCase {
	public void testEditCommentReplyBodySpace() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Page Comments Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("This is a test reply comment."),
			selenium.getText("//tr[5]/td[2]/div[1]"));
		selenium.clickAt("//tr[5]/td[2]/table[1]/tbody/tr/td[4]/span/a/span",
			RuntimeVariables.replace(""));
		selenium.type("_107_editReplyBody2", RuntimeVariables.replace(" "));
		selenium.saveScreenShotAndSource();
		selenium.keyPress("_107_editReplyBody2",
			RuntimeVariables.replace("\\48"));
		selenium.keyPress("_107_editReplyBody2", RuntimeVariables.replace("\\8"));
		selenium.clickAt("//tr[5]/td[2]/table[2]/tbody/tr[2]/td/input[1]",
			RuntimeVariables.replace(""));
		Thread.sleep(5000);
		assertTrue(selenium.isVisible("_107_editReplyBody2"));
		assertTrue(selenium.isVisible(
				"//tr[5]/td[2]/table[2]/tbody/tr[2]/td/input[1]"));
		assertFalse(selenium.isTextPresent(
				"Your request processed successfully."));
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Page Comments Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("This is a test reply comment."),
			selenium.getText("//tr[5]/td[2]/div[1]"));
	}
}