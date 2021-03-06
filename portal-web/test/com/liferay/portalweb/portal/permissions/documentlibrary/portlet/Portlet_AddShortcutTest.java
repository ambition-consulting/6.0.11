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

package com.liferay.portalweb.portal.permissions.documentlibrary.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Portlet_AddShortcutTest extends BaseTestCase {
	public void testPortlet_AddShortcut() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/web/guest/home/");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"link=Document Library Permissions Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Document Library Permissions Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Portlet2 Temporary2 Folder2",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Add Shortcut"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded right null']/ul/li[1]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded right null']/ul/li[1]/a"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Select']",
					RuntimeVariables.replace(""));
				selenium.waitForPopUp("toGroup",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("name=toGroup");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				boolean CommunityPresent1 = selenium.isElementPresent(
						"link=My Community");

				if (CommunityPresent1) {
					label = 2;

					continue;
				}

				selenium.close();
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 2:

				boolean CommunityPresent2 = selenium.isElementPresent(
						"link=My Community");

				if (!CommunityPresent2) {
					label = 3;

					continue;
				}

				selenium.click("link=My Community");
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 3:
				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("My Community"),
					selenium.getText("_20_toGroupName"));
				selenium.clickAt("_20_selectToFileEntryButton",
					RuntimeVariables.replace(""));
				selenium.waitForPopUp("toGroup",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("name=toGroup");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				boolean FolderPresent1 = selenium.isElementPresent(
						"link=My1 Community1 Folder1");

				if (FolderPresent1) {
					label = 4;

					continue;
				}

				selenium.close();
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 4:

				boolean FolderPresent2 = selenium.isElementPresent(
						"link=My1 Community1 Folder1");

				if (!FolderPresent2) {
					label = 7;

					continue;
				}

				selenium.clickAt("link=My1 Community1 Folder1",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				boolean DocumentPresent1 = selenium.isElementPresent(
						"link=My1 Community1 Document1");
				Thread.sleep(5000);

				if (DocumentPresent1) {
					label = 5;

					continue;
				}

				selenium.close();
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 5:

				boolean DocumentPresent2 = selenium.isElementPresent(
						"link=My1 Community1 Document1");

				if (!DocumentPresent2) {
					label = 6;

					continue;
				}

				selenium.click("link=My1 Community1 Document1");
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 6:
			case 7:
				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace(
						"My1 Community1 Document1"),
					selenium.getText("_20_toFileEntryTitle"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"Your request processed successfully."));
				assertTrue(selenium.isElementPresent(
						"link=My1 Community1 Document1"));

			case 100:
				label = -1;
			}
		}
	}
}