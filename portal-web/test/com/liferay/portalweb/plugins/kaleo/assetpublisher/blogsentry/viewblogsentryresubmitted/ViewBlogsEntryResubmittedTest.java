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

package com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentryresubmitted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryResubmittedTest extends BaseTestCase {
	public void testViewBlogsEntryResubmitted() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Asset Publisher Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Asset Publisher Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//p"));
		assertFalse(selenium.isTextPresent("Blogs Entry Title"));
		assertFalse(selenium.isTextPresent("Blogs Entry Content"));
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
		selenium.clickAt("link=My Workflow Tasks", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("//div[@id='myTasksPanel']/div[2]/div[1]"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//td[3]/a"));
		assertTrue(selenium.isElementPresent("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//td[3]/a"));
		assertTrue(selenium.isElementPresent("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[5]/a"));
	}
}