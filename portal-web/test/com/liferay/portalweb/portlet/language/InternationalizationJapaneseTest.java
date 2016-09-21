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

package com.liferay.portalweb.portlet.language;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class InternationalizationJapaneseTest extends BaseTestCase {
	public void testInternationalizationJapanese() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//img[@alt='\u65e5\u672c\u8a9e (\u65e5\u672c)']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"//img[@alt='\u65e5\u672c\u8a9e (\u65e5\u672c)']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		selenium.clickAt("//nav/ul/li[2]/a/span", RuntimeVariables.replace(""));
		selenium.typeKeys("//input",
			RuntimeVariables.replace(
				"\u8a00\u8a9e\u30c6\u30b9\u30c8\u30da\u30fc\u30b8"));
		selenium.saveScreenShotAndSource();
		selenium.type("//input",
			RuntimeVariables.replace(
				"\u8a00\u8a9e\u30c6\u30b9\u30c8\u30da\u30fc\u30b8"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("save", RuntimeVariables.replace(""));
		Thread.sleep(5000);
		selenium.clickAt("//img[@alt='English (United States)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
	}
}