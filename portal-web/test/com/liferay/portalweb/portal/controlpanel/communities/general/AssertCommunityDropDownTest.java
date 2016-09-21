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

package com.liferay.portalweb.portal.controlpanel.communities.general;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertCommunityDropDownTest extends BaseTestCase {
	public void testAssertCommunityDropDown() throws Exception {
		selenium.open("/web/guest/home/");
		assertEquals(RuntimeVariables.replace("Test Community"),
			selenium.getText("//li[6]/a/span[1]"));
		assertEquals(RuntimeVariables.replace("Public"),
			selenium.getText("//li[6]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("Test Community"),
			selenium.getText("//li[7]/a/span[1]"));
		assertEquals(RuntimeVariables.replace("Private"),
			selenium.getText("//li[7]/a/span[2]"));
	}
}