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

package com.liferay.portalweb.portlet.breadcrumb.portlet.viewportletbreadcrumb;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletBreadcrumbTest extends BaseTestCase {
	public void testViewPortletBreadcrumb() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Breadcrumb Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Breadcrumb Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//div[@class='portlet-body']/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("Breadcrumb Test Page"),
			selenium.getText("//div[@class='portlet-body']/ul/li[2]"));
		assertFalse(selenium.isElementPresent(
				"//div[@class='portlet-body']/ul/li[3]"));
		selenium.clickAt("link=Child Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//div[@class='portlet-body']/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("Breadcrumb Test Page"),
			selenium.getText("//div[@class='portlet-body']/ul/li[2]"));
		assertEquals(RuntimeVariables.replace("Child Test Page"),
			selenium.getText("//div[@class='portlet-body']/ul/li[3]"));
	}
}