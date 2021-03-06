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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAnnouncementDeliveryTest extends BaseTestCase {
	public void testViewAnnouncementDelivery() throws Exception {
		selenium.open("/web/guest/home");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Joe Bloggs")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Joe Bloggs", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("announcementsLink", RuntimeVariables.replace(""));
		assertTrue(selenium.isChecked(
				"_2_announcementsTypegeneralEmailCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked("_2_announcementsTypegeneralSmsCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypegeneralWebsiteCheckbox' and @disabled='']"));
		assertTrue(selenium.isChecked("_2_announcementsTypenewsSmsCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked("_2_announcementsTypenewsSmsCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypenewsWebsiteCheckbox' and @disabled='']"));
		assertTrue(selenium.isChecked("_2_announcementsTypetestEmailCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isChecked("_2_announcementsTypetestSmsCheckbox"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypetestWebsiteCheckbox' and @disabled='']"));
	}
}