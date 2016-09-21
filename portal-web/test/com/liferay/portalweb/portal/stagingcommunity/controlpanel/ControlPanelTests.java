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

package com.liferay.portalweb.portal.stagingcommunity.controlpanel;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ControlPanelTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(ControlPanelTest.class);
		testSuite.addTestSuite(CreateRolesTest.class);
		testSuite.addTestSuite(DefineContentAdministratorRolesTest.class);
		testSuite.addTestSuite(CA_PortalRolesTest.class);
		testSuite.addTestSuite(DefineContentCreatorRolesTest.class);
		testSuite.addTestSuite(CC_PortalRolesTest.class);
		testSuite.addTestSuite(CC_BlogsRolesTest.class);
		testSuite.addTestSuite(DefineContentPublisherRolesTest.class);
		testSuite.addTestSuite(CP_PortalRolesTest.class);
		testSuite.addTestSuite(AddContentAdministratorTest.class);
		testSuite.addTestSuite(AddContentCreatorTest.class);
		testSuite.addTestSuite(AddContentPublisherTest.class);
		testSuite.addTestSuite(AssignMembersTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(LogoutTest.class);

		return testSuite;
	}

}