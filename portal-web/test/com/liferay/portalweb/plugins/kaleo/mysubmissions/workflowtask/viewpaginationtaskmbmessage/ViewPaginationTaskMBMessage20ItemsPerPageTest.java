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

package com.liferay.portalweb.plugins.kaleo.mysubmissions.workflowtask.viewpaginationtaskmbmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPaginationTaskMBMessage20ItemsPerPageTest extends BaseTestCase {
	public void testViewPaginationTaskMBMessage20ItemsPerPage()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=My Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 1 - 20 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		selenium.select("_158_page", RuntimeVariables.replace("label=2"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 21 - 21 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		selenium.select("_158_page", RuntimeVariables.replace("label=1"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 1 - 20 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		selenium.clickAt("//div[@class='page-links']/a[1]",
			RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 21 - 21 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		selenium.clickAt("//div[@class='page-links']/a[2]",
			RuntimeVariables.replace("Previous"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 1 - 20 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		selenium.clickAt("//div[@class='page-links']/a[2]",
			RuntimeVariables.replace("Last"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 21 - 21 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/a[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		selenium.clickAt("//div[@class='page-links']/a[1]",
			RuntimeVariables.replace("First"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Showing 1 - 20 of 21 results."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace(
				"Items per Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='delta-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("5 10 20 30 50 75"),
			selenium.getText("_158_itemsPerPage"));
		assertEquals(RuntimeVariables.replace(
				"Page (Changing the value of this field will reload the page.)"),
			selenium.getText("//div[@class='page-selector']/span/span/label"));
		assertEquals(RuntimeVariables.replace("1 2"),
			selenium.getText("_158_page"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//div[@class='page-links']/span[1]"));
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='page-links']/span[2]"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//div[@class='page-links']/a[1]"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//div[@class='page-links']/a[2]"));
	}
}