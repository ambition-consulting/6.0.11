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

package com.liferay.portalweb.portlet.calendar.event.addeventrepeatingdailyweekday;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddEventRepeatingDailyWeekDayTest extends BaseTestCase {
	public void testAddEventRepeatingDailyWeekDay() throws Exception {
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
		selenium.select("_8_startDateMonth",
			RuntimeVariables.replace("label=January"));
		selenium.select("_8_startDateDay", RuntimeVariables.replace("label=1"));
		selenium.select("_8_startDateYear",
			RuntimeVariables.replace("label=2010"));
		selenium.type("_8_title",
			RuntimeVariables.replace("Daily Week Day Repeating Event"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@name='_8_recurrenceType' and @value='3']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@name='_8_dailyType' and @value='1']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@name='_8_endDateType' and @value='2']",
			RuntimeVariables.replace(""));
		selenium.select("_8_endDateMonth",
			RuntimeVariables.replace("label=January"));
		selenium.select("_8_endDateDay", RuntimeVariables.replace("label=1"));
		selenium.select("_8_endDateYear", RuntimeVariables.replace("label=2011"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
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
		selenium.clickAt("link=Events", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Daily Week Day Repeating Event",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Daily Week Day Repeating Event"),
			selenium.getText("//div[1]/h1/span"));
		assertEquals(RuntimeVariables.replace("1/1/10"),
			selenium.getText("//dl[@class='property-list']/dd[1]"));
		assertEquals(RuntimeVariables.replace("1/1/11"),
			selenium.getText("//dl[@class='property-list']/dd[2]"));
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
		selenium.clickAt("link=Events", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		selenium.clickAt("//td[6]/ul/li/strong/a", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals("January", selenium.getSelectedLabel("_8_startDateMonth"));
		assertEquals("1", selenium.getSelectedLabel("_8_startDateDay"));
		assertEquals("2010", selenium.getSelectedLabel("_8_startDateYear"));
		assertEquals("Daily Week Day Repeating Event",
			selenium.getValue("_8_title"));
		assertTrue(selenium.isChecked(
				"//input[@name='_8_recurrenceType' and @value='3']"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked(
				"//input[@name='_8_dailyType' and @value='1']"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked(
				"//input[@name='_8_endDateType' and @value='2']"));
		selenium.saveScreenShotAndSource();
		assertEquals("January", selenium.getSelectedLabel("_8_endDateMonth"));
		assertEquals("1", selenium.getSelectedLabel("_8_endDateDay"));
		assertEquals("2011", selenium.getSelectedLabel("_8_endDateYear"));
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
		selenium.clickAt("link=Year", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("//select", RuntimeVariables.replace("label=2010"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//a[contains(@href, 'javascript:_8_updateCalendar(1, 1, 2010);')]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a[contains(@href, 'javascript:_8_updateCalendar(1, 1, 2010);')]",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"link=Daily Week Day Repeating Event"));
		selenium.clickAt("link=Year", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("//select", RuntimeVariables.replace("label=2010"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//a[contains(@href, 'javascript:_8_updateCalendar(1, 5, 2010);')]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a[contains(@href, 'javascript:_8_updateCalendar(1, 5, 2010);')]",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"link=Daily Week Day Repeating Event"));
		selenium.clickAt("link=Year", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("//select", RuntimeVariables.replace("label=2010"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//a[contains(@href, 'javascript:_8_updateCalendar(1, 6, 2010);')]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a[contains(@href, 'javascript:_8_updateCalendar(1, 6, 2010);')]",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent(
				"link=Daily Week Day Repeating Event"));
	}
}