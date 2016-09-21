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

package com.liferay.portalweb.portal.cluster.cluster1;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class N1_AssertMessageBoardsContentUpdatedTest extends BaseTestCase {
	public void testN1_AssertMessageBoardsContentUpdated()
		throws Exception {
		selenium.open("/web/guest/home/");
		selenium.type("_58_login", RuntimeVariables.replace("test@liferay.com"));
		selenium.saveScreenShotAndSource();
		selenium.type("_58_password", RuntimeVariables.replace("test"));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Sign In']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("link=Test Category 2"));
		assertEquals(RuntimeVariables.replace("Node: [$CLUSTER_NODE_1$]"),
			selenium.getText("//div[@id='content']/div[3]"));
	}
}