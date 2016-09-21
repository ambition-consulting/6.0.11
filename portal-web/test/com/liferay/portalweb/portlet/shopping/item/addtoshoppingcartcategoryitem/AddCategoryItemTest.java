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

package com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitem;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCategoryItemTest extends BaseTestCase {
	public void testAddCategoryItem() throws Exception {
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
		selenium.type("_34_sku", RuntimeVariables.replace("1111"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_name", RuntimeVariables.replace("Item Test"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_description",
			RuntimeVariables.replace("This is an item test."));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_stockQuantity", RuntimeVariables.replace("50"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_properties",
			RuntimeVariables.replace("Limited Time Only"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("_34_requiresShippingCheckbox"));
		selenium.clickAt("_34_requiresShippingCheckbox",
			RuntimeVariables.replace(""));
		assertTrue(selenium.isChecked("_34_requiresShippingCheckbox"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_price0", RuntimeVariables.replace("$9.99"));
		selenium.saveScreenShotAndSource();
		selenium.type("_34_minQuantity0", RuntimeVariables.replace("1"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertTrue(selenium.isTextPresent(
				"Item Test\nThis is an item test.\nLimited: Time Only"));
	}
}