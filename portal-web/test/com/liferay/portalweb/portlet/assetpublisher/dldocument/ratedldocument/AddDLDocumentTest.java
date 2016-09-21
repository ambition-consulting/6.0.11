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

package com.liferay.portalweb.portlet.assetpublisher.dldocument.ratedldocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDLDocumentTest extends BaseTestCase {
	public void testAddDLDocument() throws Exception {
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
				selenium.clickAt("//div/ul/li/strong/a",
					RuntimeVariables.replace("Add New"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Document Library Document"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Select']",
					RuntimeVariables.replace(""));
				selenium.waitForPopUp("folder",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("name=folder");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				boolean choose1Present = selenium.isElementPresent(
						"//td[4]/input");

				if (choose1Present) {
					label = 2;

					continue;
				}

				selenium.close();
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

			case 2:

				boolean choose2Present = selenium.isElementPresent(
						"//td[4]/input");

				if (!choose2Present) {
					label = 3;

					continue;
				}

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Choose']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.click("//input[@value='Choose']");

			case 3:
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Folder Name")
												.equals(selenium.getText(
										"_20_folderName"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("Folder Name"),
					selenium.getText("_20_folderName"));
				selenium.type("_20_file",
					RuntimeVariables.replace(
						"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portlet\\assetpublisher\\dldocument\\ratedldocument\\dependencies\\AP_test_document.txt"));
				selenium.saveScreenShotAndSource();
				selenium.type("_20_title",
					RuntimeVariables.replace("AP DL Document Title"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("AP DL Document Title")
												.equals(selenium.getText(
										"//h3[@class='asset-title']/a"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace("AP DL Document Title"),
					selenium.getText("//h3[@class='asset-title']/a"));
				assertEquals(RuntimeVariables.replace("AP DL Document Title"),
					selenium.getText("xPath=(//span[@class='taglib-text'])[2]"));

			case 100:
				label = -1;
			}
		}
	}
}