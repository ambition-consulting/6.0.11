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

package com.liferay.portalweb.plugins.googleadsense;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAdSenseTest extends BaseTestCase {
	public void testAddAdSense() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Google Adsense Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Google Adsense Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Options"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_86_adClient")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("_86_adClient", RuntimeVariables.replace("pub-0000000000"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_adChannel", RuntimeVariables.replace("12345678"));
		selenium.saveScreenShotAndSource();
		selenium.select("_86_adType", RuntimeVariables.replace("label=Text"));
		selenium.select("_86_adFormat",
			RuntimeVariables.replace("label=(728 x 90) - Leaderboard"));
		selenium.type("_86_colorBorder", RuntimeVariables.replace("FFFFFF"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_colorBg", RuntimeVariables.replace("0000FF"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_colorLink", RuntimeVariables.replace("FFFFFF"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_colorText", RuntimeVariables.replace("000000"));
		selenium.saveScreenShotAndSource();
		selenium.type("_86_colorUrl", RuntimeVariables.replace("008000"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"You have successfully updated the setup.")
										.equals(selenium.getText(
								"//div[@class='portlet-msg-success']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}