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

package com.liferay.portalweb.portlet.blogs.portlet.configureportletdisplaystylefullcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEntryDisplayStyleFullContentTest extends BaseTestCase {
	public void testViewEntryDisplayStyleFullContent()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Blogs Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Blogs Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText("//div[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace("Content."),
			selenium.getText("//div[@class='entry-body']/p"));
		assertFalse(selenium.isElementPresent("//div[@class='entry-body']/a"));
		assertFalse(selenium.isTextPresent("Read More"));
		selenium.clickAt("//div[@class='entry-title']/a",
			RuntimeVariables.replace("Title"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Content."),
			selenium.getText("//div[@class='entry-body']/p"));
	}
}