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

package com.liferay.portalweb.plugins.googlemaps;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class GetDirectionsTest extends BaseTestCase {
	public void testGetDirections() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Google Maps Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Google Maps Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("//input[1]",
			RuntimeVariables.replace("17730 Antonio Ave, Cerritos, CA, 90703"));
		selenium.saveScreenShotAndSource();
		selenium.type("//input[3]",
			RuntimeVariables.replace("11947 Del Amo Blvd, Cerritos, CA, 90703"));
		selenium.saveScreenShotAndSource();
		selenium.click("//input[@value='Get Directions']");
		Thread.sleep(5000);
		selenium.selectWindow("name=undefined");
		selenium.saveScreenShotAndSource();
		assertEquals("11947 Del Amo Blvd, Cerritos, CA, 90703",
			selenium.getValue("d_d"));
		assertEquals("17730 Antonio Ave, Cerritos, CA, 90703",
			selenium.getValue("d_daddr"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
	}
}