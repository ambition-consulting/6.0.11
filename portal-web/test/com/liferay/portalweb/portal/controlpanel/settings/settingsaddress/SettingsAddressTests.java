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

package com.liferay.portalweb.portal.controlpanel.settings.settingsaddress;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddress.AddSettingsAddressTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddresscitynull.AddSettingsAddressCityNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddressmultiple.AddSettingsAddressMultipleTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddressstreetnull.AddSettingsAddressStreetNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.addsettingsaddresszipnull.AddSettingsAddressZipNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.settingsaddress.deletesettingsaddress.DeleteSettingsAddressTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SettingsAddressTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsAddressTests.suite());
		testSuite.addTest(AddSettingsAddressCityNullTests.suite());
		testSuite.addTest(AddSettingsAddressMultipleTests.suite());
		testSuite.addTest(AddSettingsAddressStreetNullTests.suite());
		testSuite.addTest(AddSettingsAddressZipNullTests.suite());
		testSuite.addTest(DeleteSettingsAddressTests.suite());

		return testSuite;
	}

}