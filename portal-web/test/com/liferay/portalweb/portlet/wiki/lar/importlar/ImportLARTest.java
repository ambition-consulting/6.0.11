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

package com.liferay.portalweb.portlet.wiki.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportLARTest extends BaseTestCase {
	public void testImportLAR() throws Exception {
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
						if (selenium.isElementPresent("link=Wiki Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Wiki Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//strong/a", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Export / Import")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Export / Import",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Import", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_86_importFileName",
					RuntimeVariables.replace(
						"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portlet\\wiki\\lar\\importlar\\dependencies\\Wiki-Selenium.portlet.lar"));
				selenium.saveScreenShotAndSource();

				boolean deleteBeforeChecked = selenium.isChecked(
						"_86_DELETE_PORTLET_DATACheckbox");

				if (deleteBeforeChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_86_DELETE_PORTLET_DATACheckbox",
					RuntimeVariables.replace(
						"Delete portlet data before importing."));

			case 2:

				boolean dataChecked = selenium.isChecked(
						"_86_PORTLET_DATACheckbox");

				if (dataChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("_86_PORTLET_DATACheckbox",
					RuntimeVariables.replace(""));

			case 3:
				selenium.clickAt("//input[@value='Import']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertTrue(selenium.isTextPresent(
						"Your request processed successfully."));

			case 100:
				label = -1;
			}
		}
	}
}