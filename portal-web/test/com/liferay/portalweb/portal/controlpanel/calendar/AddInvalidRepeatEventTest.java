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

package com.liferay.portalweb.portal.controlpanel.calendar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddInvalidRepeatEventTest extends BaseTestCase {
	public void testAddInvalidRepeatEvent() throws Exception {
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
		selenium.clickAt("link=Calendar", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@value='Add Event']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_8_allDayCheckbox")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("_8_allDayCheckbox", RuntimeVariables.replace(""));
		selenium.typeKeys("_8_title",
			RuntimeVariables.replace("Invalid Repeat Test Event"));
		selenium.saveScreenShotAndSource();
		selenium.type("_8_title",
			RuntimeVariables.replace("Invalid Repeat Test Event"));
		selenium.saveScreenShotAndSource();
		selenium.select("_8_startDateMonth",
			RuntimeVariables.replace("label=February"));
		selenium.select("_8_startDateDay", RuntimeVariables.replace("label=25"));
		selenium.select("_8_startDateYear",
			RuntimeVariables.replace("label=2009"));
		selenium.clickAt("//input[@name='_8_recurrenceType' and @value='3']",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_8_dailyInterval")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_8_dailyInterval", RuntimeVariables.replace("1"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@name='_8_endDateType' and @value='2']",
			RuntimeVariables.replace(""));
		selenium.select("_8_endDateMonth",
			RuntimeVariables.replace("label=February"));
		selenium.select("_8_endDateDay", RuntimeVariables.replace("label=24"));
		selenium.select("_8_endDateYear", RuntimeVariables.replace("label=2009"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"You have entered invalid data. Please try again."));
		assertTrue(selenium.isTextPresent("Please enter a valid end date."));
	}
}