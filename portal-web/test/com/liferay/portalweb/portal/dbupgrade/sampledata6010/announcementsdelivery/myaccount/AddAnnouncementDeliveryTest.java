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

package com.liferay.portalweb.portal.dbupgrade.sampledata6010.announcementsdelivery.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAnnouncementDeliveryTest extends BaseTestCase {
	public void testAddAnnouncementDelivery() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=My Account", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("announcementsLink",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"_2_announcementsTypegeneralEmailCheckbox")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();

				boolean generalEmailChecked = selenium.isChecked(
						"_2_announcementsTypegeneralEmailCheckbox");

				if (generalEmailChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_2_announcementsTypegeneralEmailCheckbox",
					RuntimeVariables.replace(""));

			case 2:

				boolean generalSmsChecked = selenium.isChecked(
						"_2_announcementsTypegeneralSmsCheckbox");

				if (generalSmsChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("_2_announcementsTypegeneralSmsCheckbox",
					RuntimeVariables.replace(""));

			case 3:

				boolean newsEmailChecked = selenium.isChecked(
						"_2_announcementsTypenewsEmailCheckbox");

				if (newsEmailChecked) {
					label = 4;

					continue;
				}

				selenium.clickAt("_2_announcementsTypenewsEmailCheckbox",
					RuntimeVariables.replace(""));

			case 4:

				boolean newsSmsChecked = selenium.isChecked(
						"_2_announcementsTypenewsSmsCheckbox");

				if (newsSmsChecked) {
					label = 5;

					continue;
				}

				selenium.clickAt("_2_announcementsTypenewsSmsCheckbox",
					RuntimeVariables.replace(""));

			case 5:

				boolean testEmailChecked = selenium.isChecked(
						"_2_announcementsTypetestEmailCheckbox");

				if (testEmailChecked) {
					label = 6;

					continue;
				}

				selenium.clickAt("_2_announcementsTypetestEmailCheckbox",
					RuntimeVariables.replace(""));

			case 6:

				boolean testSmsChecked = selenium.isChecked(
						"_2_announcementsTypetestSmsCheckbox");

				if (testSmsChecked) {
					label = 7;

					continue;
				}

				selenium.clickAt("_2_announcementsTypetestSmsCheckbox",
					RuntimeVariables.replace(""));

			case 7:
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isChecked(
						"_2_announcementsTypegeneralEmailCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isChecked(
						"_2_announcementsTypegeneralSmsCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent(
						"//input[@id='_2_announcementsTypegeneralWebsiteCheckbox' and @disabled='']"));
				assertTrue(selenium.isChecked(
						"_2_announcementsTypenewsSmsCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isChecked(
						"_2_announcementsTypenewsSmsCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent(
						"//input[@id='_2_announcementsTypenewsWebsiteCheckbox' and @disabled='']"));
				assertTrue(selenium.isChecked(
						"_2_announcementsTypetestEmailCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isChecked(
						"_2_announcementsTypetestSmsCheckbox"));
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent(
						"//input[@id='_2_announcementsTypetestWebsiteCheckbox' and @disabled='']"));

			case 100:
				label = -1;
			}
		}
	}
}