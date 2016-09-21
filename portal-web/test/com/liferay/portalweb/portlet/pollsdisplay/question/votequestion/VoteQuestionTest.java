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

package com.liferay.portalweb.portlet.pollsdisplay.question.votequestion;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class VoteQuestionTest extends BaseTestCase {
	public void testVoteQuestion() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Polls Display Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//span[2]/span/span/input",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Vote']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Thank you for your vote."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isTextPresent("Thank you for your vote."));
		assertEquals(RuntimeVariables.replace("0%"),
			selenium.getText("//tr[2]/td[1]"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("Test Choice A"),
			selenium.getText("//tr[2]/td[5]"));
		assertEquals(RuntimeVariables.replace("100%"),
			selenium.getText("//tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("Test Choice B"),
			selenium.getText("//tr[3]/td[7]"));
		assertEquals(RuntimeVariables.replace("0%"),
			selenium.getText("//tr[4]/td[1]"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[4]/td[2]"));
		assertEquals(RuntimeVariables.replace("Test Choice C"),
			selenium.getText("//tr[4]/td[5]"));
		assertTrue(selenium.isTextPresent("Total Votes: 1"));
		assertFalse(selenium.isElementPresent("//input[@value='Vote']"));
		assertFalse(selenium.isElementPresent("//span[1]/span/span/input"));
		assertFalse(selenium.isElementPresent("//span[2]/span/span/input"));
		assertFalse(selenium.isElementPresent("//span[3]/span/span/input"));
	}
}