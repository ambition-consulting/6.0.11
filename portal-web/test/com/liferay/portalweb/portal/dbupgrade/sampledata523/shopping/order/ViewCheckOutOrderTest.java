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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.shopping.order;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCheckOutOrderTest extends BaseTestCase {
	public void testViewCheckOutOrder() throws Exception {
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
			RuntimeVariables.replace("Shopping Order Community"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Shopping Order Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Orders", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//td[2]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Order #:"),
			selenium.getText("//td[1]"));
		assertEquals(RuntimeVariables.replace("Order Date:"),
			selenium.getText("//tr[2]/td[1]"));
		assertEquals(RuntimeVariables.replace("Last Modified:"),
			selenium.getText("//tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("First Name:"),
			selenium.getText("//td[1]/table/tbody/tr[1]/td[1]"));
		assertEquals(RuntimeVariables.replace("First Name:"),
			selenium.getText("//td[2]/table/tbody/tr[1]/td[1]"));
		assertEquals(RuntimeVariables.replace("Bloggs"),
			selenium.getText("//td[1]/table/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("Bloggs"),
			selenium.getText("//td[2]/table/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//td[1]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//td[2]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("1234 Sesame Street"),
			selenium.getText("//tr[5]/td[2]"));
		assertEquals(RuntimeVariables.replace("1234 Sesame Street"),
			selenium.getText("//td[2]/table/tbody/tr[5]/td[2]"));
		assertEquals(RuntimeVariables.replace("Gotham City:"),
			selenium.getText("//tr[6]/td[2]"));
		assertEquals(RuntimeVariables.replace("Gotham City:"),
			selenium.getText("//td[2]/table/tbody/tr[6]/td[2]"));
		assertEquals(RuntimeVariables.replace("CA"),
			selenium.getText("//tr[7]/td[2]"));
		assertEquals(RuntimeVariables.replace("CA"),
			selenium.getText("//td[2]/table/tbody/tr[7]/td[2]"));
		assertEquals(RuntimeVariables.replace("90028"),
			selenium.getText("//tr[8]/td[2]"));
		assertEquals(RuntimeVariables.replace("90028"),
			selenium.getText("//td[2]/table/tbody/tr[8]/td[2]"));
		assertEquals(RuntimeVariables.replace("USA"),
			selenium.getText("//tr[9]/td[2]"));
		assertEquals(RuntimeVariables.replace("USA"),
			selenium.getText("//td[2]/table/tbody/tr[9]/td[2]"));
		assertTrue(selenium.isPartialText("//tr[10]/td[2]", "626-589-1453"));
		assertTrue(selenium.isPartialText("//td[2]/table/tbody/tr[10]/td[2]",
				"626-589-1453"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//table[3]/tbody/tr[1]/td[2]"));
		assertEquals(RuntimeVariables.replace("exact:Type:"),
			selenium.getText("//table[3]/tbody/tr[2]/td[1]"));
		assertEquals(RuntimeVariables.replace("exact:Number:"),
			selenium.getText("//table[3]/tbody/tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("Expiration Date:"),
			selenium.getText("//table[3]/tbody/tr[4]/td[1]"));
		assertEquals(RuntimeVariables.replace("exact:Subtotal:"),
			selenium.getText("//table[4]/tbody/tr[1]/td[1]"));
		assertEquals(RuntimeVariables.replace("exact:Total:"),
			selenium.getText("//table[4]/tbody/tr[4]/td[1]"));
	}
}