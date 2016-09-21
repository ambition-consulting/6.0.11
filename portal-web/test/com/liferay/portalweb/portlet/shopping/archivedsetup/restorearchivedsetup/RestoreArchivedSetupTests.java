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

package com.liferay.portalweb.portlet.shopping.archivedsetup.restorearchivedsetup;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RestoreArchivedSetupTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageShoppingTest.class);
		testSuite.addTestSuite(AddPortletShoppingTest.class);
		testSuite.addTestSuite(SaveArchivedSetupTest.class);
		testSuite.addTestSuite(ConfigurePortletAcceptedCreditCardTest.class);
		testSuite.addTestSuite(AssertAcceptedCreditCardTest.class);
		testSuite.addTestSuite(RestoreArchivedSetupTest.class);
		testSuite.addTestSuite(AssertRestoreArchivedSetupTest.class);
		testSuite.addTestSuite(TearDownArchivedSetupTest.class);
		testSuite.addTestSuite(TearDownConfigurationTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}