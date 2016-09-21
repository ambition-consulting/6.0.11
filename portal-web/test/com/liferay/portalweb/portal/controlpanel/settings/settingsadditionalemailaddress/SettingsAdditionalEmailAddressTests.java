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

package com.liferay.portalweb.portal.controlpanel.settings.settingsadditionalemailaddress;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsadditionalemailaddress.addsettingsadditionalemailaddress.AddSettingsAdditionalEmailAddressTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsadditionalemailaddress.addsettingsadditionalemailaddressmultiple.AddSettingsAdditionalEmailAddressMultipleTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsadditionalemailaddress.deletesettingsadditionalemailaddress.DeleteSettingsAdditionalEmailAddressTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SettingsAdditionalEmailAddressTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsAdditionalEmailAddressTests.suite());
		testSuite.addTest(
			AddSettingsAdditionalEmailAddressMultipleTests.suite());
		testSuite.addTest(DeleteSettingsAdditionalEmailAddressTests.suite());

		return testSuite;
	}

}