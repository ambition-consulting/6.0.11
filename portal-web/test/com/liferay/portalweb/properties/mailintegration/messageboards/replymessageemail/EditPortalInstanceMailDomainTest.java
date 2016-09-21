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
public class EditPortalInstanceMailDomainTest extends BaseTestCase {
	public void testEditPortalInstanceMailDomain() throws Exception {
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
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Portal Instances", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("localhost"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("191"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[4]/a", RuntimeVariables.replace("liferay.com"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_135_mx", RuntimeVariables.replace("gmail.com"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("localhost"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("gmail.com"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("191"),
			selenium.getText("//td[5]/a"));
	}
}