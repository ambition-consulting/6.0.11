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

package com.liferay.portalweb.portal.controlpanel.webcontent.templates.addtemplateassociated;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTemplateAssociatedTest extends BaseTestCase {
	public void testAddTemplateAssociated() throws Exception {
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
						if (selenium.isElementPresent("link=Control Panel")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Web Content",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("link=Templates", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Add Template']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				selenium.type("_15_newTemplateId",
					RuntimeVariables.replace("TemplateIDAssociated"));
				selenium.saveScreenShotAndSource();
				selenium.type("_15_name",
					RuntimeVariables.replace(
						"Web Content Template Name Associated"));
				selenium.saveScreenShotAndSource();
				selenium.type("_15_description",
					RuntimeVariables.replace(
						"Web Content Template Description Associated"));
				selenium.saveScreenShotAndSource();
				selenium.clickAt("//input[@value='Select']",
					RuntimeVariables.replace(""));
				selenium.waitForPopUp("structure",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("name=structure");
				selenium.saveScreenShotAndSource();
				Thread.sleep(5000);

				boolean templatePresentA = selenium.isElementPresent(
						"link=STRUCTUREID");

				if (templatePresentA) {
					label = 2;

					continue;
				}

				selenium.close();

			case 2:

				boolean templatePresentB = selenium.isElementPresent(
						"link=STRUCTUREID");

				if (!templatePresentB) {
					label = 3;

					continue;
				}

				selenium.click("link=STRUCTUREID");

			case 3:
				selenium.selectWindow("null");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Web Content Structure Name"),
					selenium.getText("_15_structureName"));
				selenium.clickAt("_15_editorButton",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("_15_xslContent")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.type("_15_xslContent",
					RuntimeVariables.replace(
						"<h1>$title.getData()</h1>\n\n<a href=\"$ltp.getUrl()\">See Page</a>"));
				selenium.saveScreenShotAndSource();

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//input[@value='Update']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.saveScreenShotAndSource();
				selenium.click("//input[@value='Update']");
				Thread.sleep(5000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.saveScreenShotAndSource();
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div"));
				assertEquals(RuntimeVariables.replace("TEMPLATEIDASSOCIATED"),
					selenium.getText("//tr[4]/td[2]/a"));
				assertEquals(RuntimeVariables.replace(
						"Web Content Template Name Associated\n Web Content Template Description Associated"),
					selenium.getText("//tr[4]/td[3]/a"));

			case 100:
				label = -1;
			}
		}
	}
}