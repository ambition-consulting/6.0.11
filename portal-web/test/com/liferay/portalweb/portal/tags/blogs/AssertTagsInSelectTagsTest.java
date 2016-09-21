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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertTagsInSelectTagsTest extends BaseTestCase {
	public void testAssertTagsInSelectTags() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Tags Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Tags1 Blogs1 Test1 Entry1",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("select", RuntimeVariables.replace(""));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium1 liferay1"),
			selenium.getText("//label[1]"));
		assertTrue(selenium.isElementPresent("//label[1]/input"));
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText("//label[2]"));
		assertTrue(selenium.isElementPresent("//label[2]/input"));
		assertEquals(RuntimeVariables.replace("selenium3 liferay3"),
			selenium.getText("//label[3]"));
		assertTrue(selenium.isElementPresent("//label[3]/input"));
		assertEquals(RuntimeVariables.replace("selenium4 liferay4"),
			selenium.getText("//label[4]"));
		assertTrue(selenium.isElementPresent("//label[4]/input"));
		selenium.clickAt("closethick", RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Cancel']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
	}
}