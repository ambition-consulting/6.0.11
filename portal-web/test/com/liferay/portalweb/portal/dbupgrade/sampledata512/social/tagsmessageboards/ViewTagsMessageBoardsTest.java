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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.social.tagsmessageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTagsMessageBoardsTest extends BaseTestCase {
	public void testViewTagsMessageBoards() throws Exception {
		selenium.open("/web/joebloggs/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Activities Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Activities Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("Joe wrote a new message board post."));
		assertTrue(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isTextPresent("This is a message1 tag1 test1."));
		assertTrue(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isTextPresent("This is a message2 tag2 test2."));
		assertTrue(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertTrue(selenium.isTextPresent("This is a message3 tag3 test3."));
		assertTrue(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isTextPresent("This is a messageA tagA testA."));
		assertTrue(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isTextPresent("This is a messageB tagB testB."));
		assertTrue(selenium.isElementPresent("link=MessageC TagC TestC"));
		assertTrue(selenium.isTextPresent("This is a messageC tagC testC."));
	}
}