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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwebcontentreviewdate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentReviewDateTest extends BaseTestCase {
	public void testAddWebContentReviewDate() throws Exception {
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
		selenium.clickAt("//input[@value='Add Web Content']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_15_title", RuntimeVariables.replace("Web Content Name"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"_15_structure_el_TextAreaField_content")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("cke_contents_CKEditor1")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//textarea")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.selectFrame(
			"//iframe[@id='_15_structure_el_TextAreaField_content']");
		selenium.selectFrame("//td[@id='cke_contents_CKEditor1']/iframe");
		selenium.type("//body", RuntimeVariables.replace("Web Content Content"));
		selenium.selectFrame("relative=top");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//select[@id='_15_reviewDateMonth' and @disabled='disabled']"));
		assertTrue(selenium.isElementPresent(
				"//select[@id='_15_reviewDateDay' and @disabled='disabled']"));
		assertTrue(selenium.isElementPresent(
				"//select[@id='_15_reviewDateYear' and @disabled='disabled']"));
		assertTrue(selenium.isElementPresent(
				"//select[@name='_15_reviewDateHour' and @disabled='disabled']"));
		assertTrue(selenium.isElementPresent(
				"//select[@name='_15_reviewDateMinute' and @disabled='disabled']"));
		assertTrue(selenium.isElementPresent(
				"//select[@name='_15_reviewDateAmPm' and @disabled='disabled']"));
		assertTrue(selenium.isChecked("_15_neverReviewCheckbox"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_15_neverReviewCheckbox",
			RuntimeVariables.replace("Never Review"));
		assertFalse(selenium.isChecked("_15_neverReviewCheckbox"));
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isElementPresent(
				"//select[@id='_15_reviewDateMonth' and @disabled='disabled']"));
		assertFalse(selenium.isElementPresent(
				"//select[@id='_15_reviewDateDay' and @disabled='disabled']"));
		assertFalse(selenium.isElementPresent(
				"//select[@id='_15_reviewDateYear' and @disabled='disabled']"));
		assertFalse(selenium.isElementPresent(
				"//select[@name='_15_reviewDateHour' and @disabled='disabled']"));
		assertFalse(selenium.isElementPresent(
				"//select[@name='_15_reviewDateMinute' and @disabled='disabled']"));
		assertFalse(selenium.isElementPresent(
				"//select[@name='_15_reviewDateAmPm' and @disabled='disabled']"));
		selenium.select("_15_reviewDateMonth",
			RuntimeVariables.replace("label=December"));
		selenium.select("_15_reviewDateDay",
			RuntimeVariables.replace("label=31"));
		selenium.select("_15_reviewDateYear",
			RuntimeVariables.replace("label=2015"));
		selenium.select("_15_reviewDateHour",
			RuntimeVariables.replace("label=12"));
		selenium.select("_15_reviewDateMinute",
			RuntimeVariables.replace("label=:00"));
		selenium.select("_15_reviewDateAmPm",
			RuntimeVariables.replace("label=AM"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		assertFalse(selenium.isChecked("_15_neverReviewCheckbox"));
		selenium.saveScreenShotAndSource();
		assertEquals("December",
			selenium.getSelectedLabel("_15_reviewDateMonth"));
		assertEquals("31", selenium.getSelectedLabel("_15_reviewDateDay"));
		assertEquals("2015", selenium.getSelectedLabel("_15_reviewDateYear"));
		assertEquals("12", selenium.getSelectedLabel("_15_reviewDateHour"));
		assertEquals(":00", selenium.getSelectedLabel("_15_reviewDateMinute"));
		assertEquals("AM", selenium.getSelectedLabel("_15_reviewDateAmPm"));
	}
}