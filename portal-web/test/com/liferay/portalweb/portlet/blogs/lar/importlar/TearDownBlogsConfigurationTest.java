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

package com.liferay.portalweb.portlet.blogs.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownBlogsConfigurationTest extends BaseTestCase {
	public void testTearDownBlogsConfiguration() throws Exception {
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
						if (selenium.isVisible("link=Blogs Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Blogs Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//strong/a",
					RuntimeVariables.replace("Options"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.click(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("link=Display Settings")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Display Settings",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("_86_pageDelta")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.select("_86_pageDelta",
					RuntimeVariables.replace("label=5"));
				selenium.select("_86_pageDisplayStyle",
					RuntimeVariables.replace("label=Full Content"));

				boolean enableFlagsChecked = selenium.isChecked(
						"_86_enableFlagsCheckbox");

				if (enableFlagsChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_86_enableFlagsCheckbox",
					RuntimeVariables.replace(""));

			case 2:

				boolean enableRatingsChecked = selenium.isChecked(
						"_86_enableRatingsCheckbox");

				if (enableRatingsChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("_86_enableRatingsCheckbox",
					RuntimeVariables.replace(""));

			case 3:

				boolean enableCommentsChecked = selenium.isChecked(
						"_86_enableCommentsCheckbox");

				if (enableCommentsChecked) {
					label = 4;

					continue;
				}

				selenium.clickAt("_86_enableCommentsCheckbox",
					RuntimeVariables.replace(""));

			case 4:

				boolean enableCommentRatingsChecked = selenium.isChecked(
						"_86_enableCommentRatingsCheckbox");

				if (enableCommentRatingsChecked) {
					label = 5;

					continue;
				}

				selenium.clickAt("_86_enableCommentRatingsCheckbox",
					RuntimeVariables.replace(""));

			case 5:
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();

			case 100:
				label = -1;
			}
		}
	}
}