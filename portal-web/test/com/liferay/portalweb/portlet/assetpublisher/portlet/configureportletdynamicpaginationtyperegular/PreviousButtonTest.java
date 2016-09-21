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

package com.liferay.portalweb.portlet.assetpublisher.portlet.configureportletdynamicpaginationtyperegular;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PreviousButtonTest extends BaseTestCase {
	public void testPreviousButton() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Asset Publisher Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Last", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=First"));
		assertTrue(selenium.isElementPresent("link=Previous"));
		assertFalse(selenium.isElementPresent("link=Next"));
		assertFalse(selenium.isElementPresent("link=Last"));
		assertEquals("3",
			selenium.getSelectedLabel("//div[2]/span/span/span[1]/select"));
		selenium.clickAt("link=Previous", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=First"));
		assertTrue(selenium.isElementPresent("link=Previous"));
		assertTrue(selenium.isElementPresent("link=Next"));
		assertTrue(selenium.isElementPresent("link=Last"));
		assertEquals("2",
			selenium.getSelectedLabel("//div[2]/span/span/span[1]/select"));
		selenium.clickAt("link=Previous", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent("link=First"));
		assertFalse(selenium.isElementPresent("link=Previous"));
		assertTrue(selenium.isElementPresent("link=Next"));
		assertTrue(selenium.isElementPresent("link=Last"));
		assertEquals("1",
			selenium.getSelectedLabel("//div[2]/span/span/span[1]/select"));
	}
}