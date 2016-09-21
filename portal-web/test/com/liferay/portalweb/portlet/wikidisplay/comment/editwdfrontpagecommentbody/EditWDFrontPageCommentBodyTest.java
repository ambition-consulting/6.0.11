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

package com.liferay.portalweb.portlet.wikidisplay.comment.editwdfrontpagecommentbody;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditWDFrontPageCommentBodyTest extends BaseTestCase {
	public void testEditWDFrontPageCommentBody() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Wiki Display Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"This is a wiki page test comment."),
			selenium.getText("//td[2]/div[1]"));
		selenium.clickAt("//td[4]/span/a/span", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//tr[2]/td/div/textarea")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("//tr[2]/td/div/textarea",
			RuntimeVariables.replace(
				"This is a wiki page test comment. Edited."));
		selenium.saveScreenShotAndSource();
		selenium.keyPress("//tr[2]/td/div/textarea",
			RuntimeVariables.replace("\\48"));
		selenium.keyPress("//tr[2]/td/div/textarea",
			RuntimeVariables.replace("\\8"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace(
				"This is a wiki page test comment. Edited."),
			selenium.getText("//td[2]/div[1]"));
		assertNotEquals(RuntimeVariables.replace(
				"This is a wiki page test comment."),
			selenium.getText("//td[2]/div[1]"));
	}
}