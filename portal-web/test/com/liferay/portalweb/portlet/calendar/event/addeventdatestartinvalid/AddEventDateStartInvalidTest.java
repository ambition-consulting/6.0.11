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

package com.liferay.portalweb.portlet.calendar.event.addeventdatestartinvalid;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddEventDateStartInvalidTest extends BaseTestCase {
	public void testAddEventDateStartInvalid() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Calendar Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Calendar Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_8_title",
			RuntimeVariables.replace("Invalid Start Date Test Event"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_8_startDateMonth",
			RuntimeVariables.replace("Start Date Month"));
		selenium.select("_8_startDateMonth",
			RuntimeVariables.replace("label=February"));
		Thread.sleep(5000);
		selenium.select("_8_startDateMonth",
			RuntimeVariables.replace("label=February"));
		assertFalse(selenium.isPartialText("_8_startDateDay", "30"));
	}
}