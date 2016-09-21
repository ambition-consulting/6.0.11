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

package com.liferay.portalweb.portlet.documentlibrarydisplay.document.viewfolderdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewFolderDocumentTest extends BaseTestCase {
	public void testViewFolderDocument() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=Document Library Display Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Document Library Display Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a/strong", RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Test1 Document1"),
			selenium.getText("//a/span/span"));
		assertEquals(RuntimeVariables.replace("This is test1 document1."),
			selenium.getText("//div[@class='file-entry-list-description']"));
		selenium.clickAt("//a/span/span",
			RuntimeVariables.replace("Test1 Document1"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Version: 1.0"),
			selenium.getText("//span[@class='workflow-version']"));
		assertEquals(RuntimeVariables.replace("Test1 Document1"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("This is test1 document1."),
			selenium.getText("//div[@class='lfr-asset-description']"));
	}
}