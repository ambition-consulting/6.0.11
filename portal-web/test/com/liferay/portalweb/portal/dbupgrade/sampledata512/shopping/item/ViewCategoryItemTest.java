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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.shopping.item;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCategoryItemTest extends BaseTestCase {
	public void testViewCategoryItem() throws Exception {
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
			RuntimeVariables.replace("Shopping Item Community"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search Communities']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Shopping Item Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//td[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//td[2]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("1111"), selenium.getText("//b"));
		assertEquals(RuntimeVariables.replace(
				"Item Test\n \n This is an item test. \n Limited: Time Only \n\n Price for 1 Items and Above: $9.99\n \n Availability: In Stock"),
			selenium.getText("//td[3]"));
		assertEquals(RuntimeVariables.replace(
				"Item Test\n \n This is an item test. \n Limited: Time Only \n\n Price for 1 Items and Above: $9.99\n \n Availability: In Stock"),
			selenium.getText("//td[3]"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//span[2]"));
	}
}