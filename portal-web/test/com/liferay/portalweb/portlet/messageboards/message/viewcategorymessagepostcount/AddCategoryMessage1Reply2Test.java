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

package com.liferay.portalweb.portlet.messageboards.message.viewcategorymessagepostcount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCategoryMessage1Reply2Test extends BaseTestCase {
	public void testAddCategoryMessage1Reply2() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//div[5]/table/tbody/tr[1]/td[2]/div[1]/ul/li[2]/span/a/span",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals("RE: T\u00e9st1 M\u00e9ssag\u00e91",
			selenium.getValue("_19_subject"));
		selenium.type("_19_textArea",
			RuntimeVariables.replace("This is a test1 message1 reply2."));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("T\u00e9st1 M\u00e9ssag\u00e91"),
			selenium.getText("//div[1]/h1/span"));
		assertEquals(RuntimeVariables.replace(
				"RE: T\u00e9st1 M\u00e9ssag\u00e91"),
			selenium.getText("//a/strong"));
		assertEquals(RuntimeVariables.replace(
				"RE: T\u00e9st1 M\u00e9ssag\u00e91"),
			selenium.getText(
				"//div[6]/table/tbody/tr[1]/td[2]/div[1]/div/a/strong"));
		assertEquals(RuntimeVariables.replace(
				"This is a test1 message1 reply2."),
			selenium.getText("//div[6]/table/tbody/tr[1]/td[2]/div[2]"));
	}
}