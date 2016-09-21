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

package com.liferay.portalweb.portlet.translator;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslateEnglishJapaneseTest extends BaseTestCase {
	public void testTranslateEnglishJapanese() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Translator Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("link=Translator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_26_id",
			RuntimeVariables.replace("label=English to Japanese"));
		selenium.type("_26_text",
			RuntimeVariables.replace(
				"My name is JR Skywalker, fluent in over 6 million forms of communication."));
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace("//input[@value='Translate']"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent(
				"\u79c1\u306e\u540d\u524d\u306f\u30b3\u30df\u30e5\u30cb\u30b1\u30fc\u30b7\u30e7\u30f3\u306e6,000,000\u306e\u5f62\u614b\u306b\u6d41\u66a2\u306a\u30b8\u30e5\u30cb\u30a2Skywalker\u3067\u3042\u308b\u3002"));
	}
}