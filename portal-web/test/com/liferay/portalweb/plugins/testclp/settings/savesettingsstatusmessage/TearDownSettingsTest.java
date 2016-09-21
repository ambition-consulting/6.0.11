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

package com.liferay.portalweb.plugins.testclp.settings.savesettingsstatusmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownSettingsTest extends BaseTestCase {
	public void testTearDownSettings() throws Exception {
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
						if (selenium.isElementPresent("link=Test CLP Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Test CLP Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//ul[@class='chat-tabs']/li[2]/div[1]/span",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("statusMessage")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.type("statusMessage", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();

				boolean onlineStatusChecked = selenium.isChecked("onlineStatus");

				if (onlineStatusChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("onlineStatus", RuntimeVariables.replace(""));

			case 2:

				boolean playSoundChecked = selenium.isChecked("playSound");

				if (playSoundChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("playSound", RuntimeVariables.replace(""));

			case 3:
				selenium.clickAt("saveSettings", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (!selenium.isElementPresent(
									"//li[@class='chat-settings saved']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("saveSettings", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (!selenium.isElementPresent(
									"//li[@class='chat-settings saved']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertFalse(selenium.isElementPresent(
						"//li[@class='chat-settings saved']"));

			case 100:
				label = -1;
			}
		}
	}
}