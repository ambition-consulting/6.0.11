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

package com.liferay.portalweb.portal.controlpanel.settings.settingsphonenumber;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsphonenumber.addsettingsphonenumber.AddSettingsPhoneNumberTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsphonenumber.addsettingsphonenumbermultiple.AddSettingsPhoneNumberMultipleTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsphonenumber.deletesettingsphonenumber.DeleteSettingsPhoneNumberTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SettingsPhoneNumberTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsPhoneNumberTests.suite());
		testSuite.addTest(AddSettingsPhoneNumberMultipleTests.suite());
		testSuite.addTest(DeleteSettingsPhoneNumberTests.suite());

		return testSuite;
	}

}