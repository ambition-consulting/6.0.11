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

package com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitemmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCategoryItem2Test extends BaseTestCase {
	public void testAddCategoryItem2() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Shopping Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Shopping Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Categories", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Item']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_34_sku", RuntimeVariables.replace("1112"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_name",
			RuntimeVariables.replace(
				"M. Saech - How to Play Guitar - for Dummies."));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_description",
			RuntimeVariables.replace(
				"Noted guitarist and performer (for one) lays down how to thrash with the might battle axe of music."));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_price0", RuntimeVariables.replace("$16.99"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_stockQuantity", RuntimeVariables.replace("200"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertTrue(selenium.isTextPresent(
				"M. Saech - How to Play Guitar - for Dummies.\nNoted guitarist and performer (for one) lays down how to thrash with the might battle axe of music."));
	}
}