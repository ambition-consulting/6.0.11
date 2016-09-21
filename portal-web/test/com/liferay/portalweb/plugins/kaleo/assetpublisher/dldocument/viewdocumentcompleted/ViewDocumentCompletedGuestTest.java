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

package com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentcompleted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDocumentCompletedGuestTest extends BaseTestCase {
	public void testViewDocumentCompletedGuest() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Asset Publisher Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Asset Publisher Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent("//section"));
		assertEquals(RuntimeVariables.replace("Asset Publisher"),
			selenium.getText("//h1/span[2]"));
		assertEquals(RuntimeVariables.replace("test_document.txt"),
			selenium.getText("//h3/a"));
		assertEquals(RuntimeVariables.replace("test_document.txt"),
			selenium.getText("//span/a/span"));
		assertTrue(selenium.isPartialText("//div[2]/a", "Read More"));
		assertFalse(selenium.isTextPresent("There are no results."));
		selenium.clickAt("//div[2]/a", RuntimeVariables.replace("Read More"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("test_document.txt"),
			selenium.getText("//div[1]/h1/span"));
		assertEquals(RuntimeVariables.replace("test_document.txt"),
			selenium.getText("//div[2]/div[1]/div/a"));
	}
}