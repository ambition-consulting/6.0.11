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

package com.liferay.portalweb.portal.controlpanel.virtualhosting;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertPrivatePageHostURLTest extends BaseTestCase {
	public void testAssertPrivatePageHostURL() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("http://www.baker.com:8080/");
				Thread.sleep(5000);

				boolean LoggedOut = selenium.isElementPresent("_58_login");

				if (!LoggedOut) {
					label = 2;

					continue;
				}

				selenium.type("_58_login",
					RuntimeVariables.replace("test@liferay.com"));
				selenium.saveScreenShotAndSource();
				selenium.type("_58_password", RuntimeVariables.replace("test"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("_58_rememberMeCheckbox",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

			case 2:
				assertEquals("http://www.baker.com:8080/",
					selenium.getLocation());
				assertEquals(RuntimeVariables.replace(
						"Virtual Hosting Community"),
					selenium.getText("//li[2]/span/a"));
				assertTrue(selenium.isElementPresent("link=Private Page"));
				selenium.clickAt("link=Private Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals("http://www.baker.com:8080/private-page",
					selenium.getLocation());

			case 100:
				label = -1;
			}
		}
	}
}