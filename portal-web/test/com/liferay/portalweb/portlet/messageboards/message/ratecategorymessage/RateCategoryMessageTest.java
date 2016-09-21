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

package com.liferay.portalweb.portlet.messageboards.message.ratecategorymessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateCategoryMessageTest extends BaseTestCase {
	public void testRateCategoryMessage() throws Exception {
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
		selenium.clickAt("link=T\u00e9st M\u00e9ssag\u00e9",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isPartialText(
				"//div[@class='taglib-ratings thumbs']/div/div/div", "0 Votes"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[1]",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("+1 (1 Vote)")
										.equals(selenium.getText(
								"//div[@class='taglib-ratings thumbs']/div/div/div"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("-1 (1 Vote)")
										.equals(selenium.getText(
								"//div[@class='taglib-ratings thumbs']/div/div/div"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("0 (0 Votes)")
										.equals(selenium.getText(
								"//div[@class='taglib-ratings thumbs']/div/div/div"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
	}
}