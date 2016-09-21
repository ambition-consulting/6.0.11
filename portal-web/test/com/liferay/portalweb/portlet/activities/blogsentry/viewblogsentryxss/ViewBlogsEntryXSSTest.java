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

package com.liferay.portalweb.portlet.activities.blogsentry.viewblogsentryxss;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryXSSTest extends BaseTestCase {
	public void testViewBlogsEntryXSS() throws Exception {
		selenium.open("/group/joebloggs/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Activities Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Activities Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Joe wrote a new blog entry, <script>alert(hello)</script>, in Liferay."),
			selenium.getText("//td[2]/div[1]"));
		assertEquals(RuntimeVariables.replace("<script>alert(hello)</script>"),
			selenium.getText("//td[2]/div[1]/a[1]"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//td[2]/div[1]/a[2]"));
	}
}