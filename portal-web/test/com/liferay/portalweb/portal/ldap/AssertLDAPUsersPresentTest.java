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

package com.liferay.portalweb.portal.ldap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertLDAPUsersPresentTest extends BaseTestCase {
	public void testAssertLDAPUsersPresent() throws Exception {
		selenium.click(RuntimeVariables.replace("link=Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("link=Users"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("//span/input", RuntimeVariables.replace("jane"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("Jane"));
		assertTrue(selenium.isTextPresent("Smith"));
		assertTrue(selenium.isTextPresent("janesmith"));
		selenium.type("//span/input", RuntimeVariables.replace("luke"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("Luke"));
		assertTrue(selenium.isTextPresent("Skywalker"));
		assertTrue(selenium.isTextPresent("lukeskywalker"));
		selenium.type("//span/input", RuntimeVariables.replace("martin"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("Martin"));
		assertTrue(selenium.isTextPresent("Luther"));
		assertTrue(selenium.isTextPresent("martinluther"));
		System.out.println("LDAP Users have been imported into Liferay.\n");
	}
}