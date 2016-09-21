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

package com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessagetable;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBMessageTableTest extends BaseTestCase {
	public void testViewMBMessageTable() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Asset Publisher Test Page")) {
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
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText("//th[1]"));
		assertEquals(RuntimeVariables.replace("AP MB Message Subject"),
			selenium.getText("//tr[2]/td[1]/a"));
		selenium.clickAt("//tr[2]/td[1]/a",
			RuntimeVariables.replace("AP MB Message Subject"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("AP MB Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertTrue(selenium.isPartialText("//div[@class='asset-content']",
				"AP MB Message Body."));
		assertEquals(RuntimeVariables.replace("View in Context \u00bb"),
			selenium.getText("//div[@class='asset-more']/a"));
		selenium.clickAt("//div[@class='asset-more']/a",
			RuntimeVariables.replace("View in Context \u00bb"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("AP MB Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("AP MB Message Subject"),
			selenium.getText("//div[@class='subject']/a/strong"));
		assertEquals(RuntimeVariables.replace("AP MB Message Body."),
			selenium.getText("//div[@class='thread-body']"));
	}
}