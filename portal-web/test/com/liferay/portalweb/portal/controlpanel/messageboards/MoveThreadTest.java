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

package com.liferay.portalweb.portal.controlpanel.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveThreadTest extends BaseTestCase {
	public void testMoveThread() throws Exception {
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
				selenium.clickAt("link=Message Boards",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//tr[4]/td[1]/a[1]/strong",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);
				selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"));
				selenium.clickAt("link=Move Thread",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("_19_addExplanationPostCheckbox",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("_19_subject")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.typeKeys("_19_subject",
					RuntimeVariables.replace("Moved to Sujr"));
				selenium.saveScreenShotAndSource();
				selenium.type("_19_subject",
					RuntimeVariables.replace("Moved to Sujr"));
				selenium.saveScreenShotAndSource();
				selenium.type("_19_textArea",
					RuntimeVariables.replace(
						"Trust and paths will be straightened."));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Select']",
					RuntimeVariables.replace(""));
				selenium.waitForPopUp("category",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("category");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				boolean CategoriesPresent = selenium.isElementPresent(
						"link=Categories");

				if (!CategoriesPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Categories", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

			case 2:
				selenium.click("//input[@value='Choose']");
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);
				assertTrue(selenium.isElementPresent("link=Sujr"));
				selenium.clickAt("//input[@value='Move Thread']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isElementPresent("link=Sujr"));
				assertTrue(selenium.isElementPresent(
						"link=T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"));
				assertTrue(selenium.isTextPresent(
						"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"));
				assertTrue(selenium.isTextPresent(
						"Trust and paths will be straightened."));
				assertFalse(selenium.isElementPresent(
						"link=T\u00e9st Subcat\u00e9gory"));
				assertFalse(selenium.isElementPresent(
						"link=T\u00e9st Cat\u00e9gory"));

			case 100:
				label = -1;
			}
		}
	}
}