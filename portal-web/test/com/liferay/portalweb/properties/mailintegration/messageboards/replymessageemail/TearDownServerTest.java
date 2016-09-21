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
public class TearDownServerTest extends BaseTestCase {
	public void testTearDownServer() throws Exception {
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
				selenium.clickAt("link=Server Administration",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Mail", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_137_pop3Host", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.type("_137_pop3Port", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();

				boolean popSecureChecked = selenium.isChecked(
						"_137_pop3SecureCheckbox");

				if (!popSecureChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_137_pop3SecureCheckbox",
					RuntimeVariables.replace(""));

			case 2:
				selenium.type("_137_pop3User", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.type("_137_pop3Password", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.type("_137_smtpHost", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.type("_137_smtpPort", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();

				boolean smtpSecureChecked = selenium.isChecked(
						"_137_smtpSecureCheckbox");

				if (!smtpSecureChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("_137_smtpSecureCheckbox",
					RuntimeVariables.replace(""));

			case 3:
				selenium.type("_137_smtpUser", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.type("_137_smtpPassword", RuntimeVariables.replace(""));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Portal Instances",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//td[4]/a", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_135_virtualHost",
					RuntimeVariables.replace("localhost"));
				selenium.saveScreenShotAndSource();
				selenium.type("_135_mx", RuntimeVariables.replace("liferay.com"));
				selenium.saveScreenShotAndSource();
				selenium.type("_135_maxUsers", RuntimeVariables.replace("0"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

			case 100:
				label = -1;
			}
		}
	}
}