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
public class AssertPrivatePageFriendlyURLTest extends BaseTestCase {
	public void testAssertPrivatePageFriendlyURL() throws Exception {
		selenium.open("/group/alpha/");
		Thread.sleep(5000);
		assertEquals("http://localhost:8080/group/alpha/",
			selenium.getLocation());
		assertEquals(RuntimeVariables.replace("Virtual Hosting Community"),
			selenium.getText("//li[2]/span/a"));
		assertTrue(selenium.isElementPresent("link=Private Page"));
		selenium.clickAt("link=Private Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals("http://localhost:8080/group/alpha/private-page",
			selenium.getLocation());
	}
}