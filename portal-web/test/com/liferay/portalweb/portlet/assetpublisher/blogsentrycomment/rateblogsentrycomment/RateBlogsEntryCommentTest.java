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

package com.liferay.portalweb.portlet.assetpublisher.blogsentrycomment.rateblogsentrycomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateBlogsEntryCommentTest extends BaseTestCase {
	public void testRateBlogsEntryComment() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Asset Publisher Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isPartialText(
							"//div[@class='aui-rating-label-element']",
							"0 Votes")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isPartialText(
				"//div[@class='aui-rating-label-element']", "0 Votes"));
		selenium.clickAt("//td[2]/table[1]/tbody/tr/td[1]/div/div/div/a[1]",
			RuntimeVariables.replace("Rate this as good."));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("+1 (1 Vote)")
										.equals(selenium.getText(
								"//div[@class='aui-rating-label-element']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		selenium.clickAt("//td[2]/table[1]/tbody/tr/td[1]/div/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("-1 (1 Vote)")
										.equals(selenium.getText(
								"//div[@class='aui-rating-label-element']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//td[2]/table[1]/tbody/tr/td[1]/div/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertFalse(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
	}
}