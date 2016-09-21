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

package com.liferay.portalweb.plugins.knowledgebaseadmin.article.addarticle;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddArticleTest extends BaseTestCase {
	public void testAddArticle() throws Exception {
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
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Knowledge Base Admin",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Add Article']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("_1_WAR_knowledgebaseportlet_title",
			RuntimeVariables.replace("Knowledge Base Admin Article Title"));
		selenium.saveScreenShotAndSource();
		Thread.sleep(5000);
		selenium.selectFrame(
			"//iframe[@id='_1_WAR_knowledgebaseportlet_editor']");
		selenium.selectFrame("//td[@id='cke_contents_CKEditor1']/iframe");
		selenium.type("//body",
			RuntimeVariables.replace("Knowledge Base Admin Article Content"));
		selenium.selectFrame("relative=top");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace(
				"Knowledge Base Admin Article Title"),
			selenium.getText("//div[4]/div/div[2]/div[1]/div[1]/span/a/span"));
		assertEquals(RuntimeVariables.replace("exact:Version: 1.0"),
			selenium.getText("//td[5]/div/span[1]"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//span[2]/strong"));
	}
}