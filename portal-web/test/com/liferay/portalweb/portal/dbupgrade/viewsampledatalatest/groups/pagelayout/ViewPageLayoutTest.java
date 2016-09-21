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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.pagelayout;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPageLayoutTest extends BaseTestCase {
	public void testViewPageLayout() throws Exception {
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
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_134_name",
			RuntimeVariables.replace("Group Page Layout Community"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Page Layout Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("main-content", RuntimeVariables.replace(""));
		selenium.clickAt("dockbar", RuntimeVariables.replace(""));
		selenium.clickAt("navigation", RuntimeVariables.replace(""));
		assertTrue(selenium.isElementPresent(
				"//div[@id='column-1' and @class='aui-w50 portlet-column portlet-column-first aui-dd-drop']"));
		assertTrue(selenium.isElementPresent(
				"//div[@id='column-2' and @class='aui-w50 portlet-column portlet-column-last aui-dd-drop']"));
		assertEquals(RuntimeVariables.replace("Breadcrumb"),
			selenium.getText(
				"//div[@id='column-1' and @class='aui-w50 portlet-column portlet-column-first aui-dd-drop']//h1"));
		assertEquals(RuntimeVariables.replace("Navigation"),
			selenium.getText(
				"//div[@id='column-2' and @class='aui-w50 portlet-column portlet-column-last aui-dd-drop']//h1"));
		assertFalse(selenium.isElementPresent(
				"//div[@id='column-1' and @class='aui-w30 portlet-column portlet-column-first aui-dd-drop']"));
		assertFalse(selenium.isElementPresent(
				"//div[@id='column-2' and @class='aui-w70 portlet-column portlet-column-last aui-dd-drop']"));
	}
}