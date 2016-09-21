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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.portletpermissions.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemovePortletPermissionsGuestViewTest extends BaseTestCase {
	public void testRemovePortletPermissionsGuestView()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/web/guest/home");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"link=Blogs Portlet Permissions Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Blogs Portlet Permissions Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//img[@alt='Configuration']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Permissions",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("_86_rowIds", RuntimeVariables.replace(""));
				assertEquals(RuntimeVariables.replace("Guest"),
					selenium.getText(
						"//tr[@class='portlet-section-body results-row']/td[2]"));
				assertEquals(RuntimeVariables.replace("Regular"),
					selenium.getText(
						"//tr[@class='portlet-section-body results-row']/td[3]"));
				assertEquals(RuntimeVariables.replace("View"),
					selenium.getText(
						"//tr[@class='portlet-section-body results-row']/td[4]"));
				selenium.clickAt("//input[@value='Update Permissions']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean viewPermissionsAvailable = selenium.isPartialText("_86_current_actions",
						"View");

				if (!viewPermissionsAvailable) {
					label = 2;

					continue;
				}

				selenium.addSelection("_86_current_actions",
					RuntimeVariables.replace("label=View"));
				selenium.clickAt("//img[@onclick='self.focus();']",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (!selenium.isPartialText("_86_current_actions",
									"View")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertFalse(selenium.isPartialText("_86_current_actions", "View"));

			case 2:
				selenium.clickAt("//input[@value='Finished']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"Your request processed successfully."));

			case 100:
				label = -1;
			}
		}
	}
}