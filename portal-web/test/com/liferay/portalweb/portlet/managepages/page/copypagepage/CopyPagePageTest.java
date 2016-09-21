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

package com.liferay.portalweb.portlet.managepages.page.copypagepage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CopyPagePageTest extends BaseTestCase {
	public void testCopyPagePage() throws Exception {
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
						if (selenium.isElementPresent(
									"link=Manage Pages Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.click(RuntimeVariables.replace(
						"link=Manage Pages Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Manage Pages Test Page"),
					selenium.getText("//li[2]/span/a"));
				assertFalse(selenium.isElementPresent(
						"//section[@id='portlet_58']/header/h1"));
				assertFalse(selenium.isElementPresent(
						"//section[@id='portlet_47']/header/h1"));
				assertFalse(selenium.isTextPresent("Sign In"));
				assertFalse(selenium.isTextPresent("Hello World"));
				selenium.clickAt("main-content", RuntimeVariables.replace(""));
				selenium.clickAt("dockbar", RuntimeVariables.replace(""));
				selenium.clickAt("navigation", RuntimeVariables.replace(""));
				selenium.clickAt("//div/div[3]/div/ul/li[1]/a",
					RuntimeVariables.replace("Manage Pages"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Liferay")
												.equals(selenium.getText(
										"//div/div[3]/a"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();

				boolean welcomePresent = selenium.isElementPresent(
						"//li/ul/li[1]/div/div[3]/a");

				if (welcomePresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//li/div/div[1]", RuntimeVariables.replace(""));

			case 2:

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//li[1]/ul/li/div/div[3]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("//li[2]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.select("_88_type",
					RuntimeVariables.replace("label=Portlet"));
				assertEquals(RuntimeVariables.replace(
						"- Welcome - Manage Pages Test Page"),
					selenium.getText("_88_copyLayoutId"));
				selenium.select("_88_copyLayoutId",
					RuntimeVariables.replace("label=regexp:-\\sWelcome"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div"));
				selenium.open("/web/guest/home/");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"link=Manage Pages Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Manage Pages Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Manage Pages Test Page"),
					selenium.getText("//li[2]/span/a"));
				assertEquals(RuntimeVariables.replace("Sign In"),
					selenium.getText("//section[@id='portlet_58']/header/h1"));
				assertEquals(RuntimeVariables.replace("Hello World"),
					selenium.getText("//section[@id='portlet_47']/header/h1"));

			case 100:
				label = -1;
			}
		}
	}
}