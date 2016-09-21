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

package com.liferay.portalweb.portal.controlpanel.settings.settingswebsite;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingswebsite.addsettingswebsite.AddSettingsWebsiteTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingswebsite.addsettingswebsitemultiple.AddSettingsWebsiteMultipleTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingswebsite.addsettingswebsiteurlinvalid.AddSettingsWebsiteUrlInvalidTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingswebsite.deletesettingswebsite.DeleteSettingsWebsiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SettingsWebsiteTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsWebsiteTests.suite());
		testSuite.addTest(AddSettingsWebsiteMultipleTests.suite());
		testSuite.addTest(AddSettingsWebsiteUrlInvalidTests.suite());
		testSuite.addTest(DeleteSettingsWebsiteTests.suite());

		return testSuite;
	}

}