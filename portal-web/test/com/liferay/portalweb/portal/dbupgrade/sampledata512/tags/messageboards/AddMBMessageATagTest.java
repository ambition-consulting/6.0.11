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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMBMessageATagTest extends BaseTestCase {
	public void testAddMBMessageATag() throws Exception {
		selenium.open("/user/joebloggs/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Communities I Own")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Communities I Own", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_29_name",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Communities']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//b", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_19_subject",
			RuntimeVariables.replace("MessageA TagA TestA"));
		selenium.saveScreenShotAndSource();
		selenium.type("_19_textArea",
			RuntimeVariables.replace("This is a messageA tagA testA."));
		selenium.saveScreenShotAndSource();
		selenium.type("//tr[9]/td[2]/input[2]",
			RuntimeVariables.replace("selenium"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("MessageA TagA TestA"),
			selenium.getText("//div[@class='subject']/b"));
		assertTrue(selenium.isPartialText("//div[@class='tags']", "selenium"));
		assertEquals(RuntimeVariables.replace("This is a messageA tagA testA."),
			selenium.getText("//div[@class='thread-body']"));
	}
}