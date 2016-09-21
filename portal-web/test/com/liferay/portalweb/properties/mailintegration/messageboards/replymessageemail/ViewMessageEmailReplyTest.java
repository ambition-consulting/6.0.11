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
public class ViewMessageEmailReplyTest extends BaseTestCase {
	public void testViewMessageEmailReply() throws Exception {
		selenium.open("/web/guest/home/");
		Thread.sleep(60000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText("//td[4]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("MB Message Subject"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		assertTrue(selenium.isPartialText("//td[6]/a", "By: userfn userln"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Message Subject"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("MB Message Subject"),
			selenium.getText("//div[1]/h1/span"));
		assertEquals(RuntimeVariables.replace("MB Message Subject"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace(
				"Re: [MB Category Name] MB Message Subject"),
			selenium.getText("//tr[2]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("MB Message Subject"),
			selenium.getText("//div/a/strong"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[1]/div/div/div[2]/a"));
		assertEquals(RuntimeVariables.replace("MB Message Body"),
			selenium.getText("//td[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Re: [MB Category Name] MB Message Subject"),
			selenium.getText(
				"//div[5]/table/tbody/tr[1]/td[2]/div[1]/div/a/strong"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText(
				"//div[5]/table/tbody/tr[1]/td[1]/div/div/div[2]/a"));
		assertEquals(RuntimeVariables.replace("MB Message Email Reply"),
			selenium.getText("//div[5]/table/tbody/tr[1]/td[2]/div[2]"));
	}
}