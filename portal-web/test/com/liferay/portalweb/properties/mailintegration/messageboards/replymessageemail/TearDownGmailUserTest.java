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

package com.liferay.portalweb.properties.mailintegration.messageboards.replymessageemail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownGmailUserTest extends BaseTestCase {
	public void testTearDownGmailUser() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.openWindow("http://www.gmail.com/",
					RuntimeVariables.replace("gmail"));
				selenium.waitForPopUp("gmail", RuntimeVariables.replace(""));
				selenium.selectWindow("gmail");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);
				Thread.sleep(5000);

				boolean signedIn = selenium.isElementPresent(
						"//div[4]/div/nobr/a[2]");

				if (!signedIn) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[4]/div/nobr/a[2]",
					RuntimeVariables.replace("Sign Out"));

			case 2:

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("Email")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.type("Email",
					RuntimeVariables.replace("liferay.qa.testing.60x"));
				selenium.saveScreenShotAndSource();
				selenium.type("Passwd",
					RuntimeVariables.replace("loveispatient"));
				selenium.saveScreenShotAndSource();

				boolean staySignedInChecked = selenium.isChecked(
						"PersistentCookie");

				if (staySignedInChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("PersistentCookie",
					RuntimeVariables.replace(""));

			case 3:
				selenium.clickAt("signIn", RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//input[@type='checkbox']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@type='checkbox']",
					RuntimeVariables.replace("All"));
				Thread.sleep(5000);

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"//div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[3]")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[3]"));
				selenium.clickAt("//div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[3]",
					RuntimeVariables.replace("Delete"));
				Thread.sleep(5000);
				Thread.sleep(5000);

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//div[4]/div/nobr/a[2]")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//div[4]/div/nobr/a[2]",
					RuntimeVariables.replace("Sign Out"));
				Thread.sleep(5000);
				Thread.sleep(5000);
				selenium.close();
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 100:
				label = -1;
			}
		}
	}
}