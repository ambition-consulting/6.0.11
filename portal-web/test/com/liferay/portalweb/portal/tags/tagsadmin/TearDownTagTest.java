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

package com.liferay.portalweb.portal.tags.tagsadmin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownTagTest extends BaseTestCase {
	public void testTearDownTag() throws Exception {
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
				selenium.clickAt("link=Tags", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				Thread.sleep(500);

				boolean tag1Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 2:
				Thread.sleep(500);

				boolean tag2Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag2Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 3:
				Thread.sleep(500);

				boolean tag3Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag3Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 4:
				Thread.sleep(500);

				boolean tag4Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag4Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 5:
				Thread.sleep(500);

				boolean tag5Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag5Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 6:
				Thread.sleep(500);

				boolean tag6Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag6Present) {
					label = 7;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 7:
				Thread.sleep(500);

				boolean tag7Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag7Present) {
					label = 8;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 8:
				Thread.sleep(500);

				boolean tag8Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag8Present) {
					label = 9;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 9:
				Thread.sleep(500);

				boolean tag9Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag9Present) {
					label = 10;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 10:
				Thread.sleep(500);

				boolean tag10Present = selenium.isElementPresent(
						"//div[4]/ul/li/span/a");

				if (!tag10Present) {
					label = 11;

					continue;
				}

				selenium.clickAt("//div[4]/ul/li/span/a",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Delete']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this tag[\\s\\S]$"));
				selenium.saveScreenShotAndSource();

			case 11:
			case 100:
				label = -1;
			}
		}
	}
}