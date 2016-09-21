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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwebcontentlocalized;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentLocalizedTest extends BaseTestCase {
	public void testViewWebContentLocalized() throws Exception {
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
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("Hello World Localized Article"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertEquals("Hello World Page Name", selenium.getValue("page-name"));
		assertEquals("Hello World Page Description",
			selenium.getValue("page-description"));
		selenium.select("_15_languageId",
			RuntimeVariables.replace("label=Chinese (China)"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertEquals("\u4e16\u754c\u60a8\u597d Page Name",
			selenium.getValue("page-name"));
		assertEquals("\u4e16\u754c\u60a8\u597d Page Description",
			selenium.getValue("page-description"));
		selenium.select("_15_languageId",
			RuntimeVariables.replace("label=English (United States)"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
	}
}