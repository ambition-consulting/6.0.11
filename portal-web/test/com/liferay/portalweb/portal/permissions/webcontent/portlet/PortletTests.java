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

package com.liferay.portalweb.portal.permissions.webcontent.portlet;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(
			CA_AddMemberWCDConfigurationPermissionsTest.class);
		testSuite.addTestSuite(
			CA_AddMemberWCLConfigurationPermissionsTest.class);
		testSuite.addTestSuite(
			CA_AddMemberWCSConfigurationPermissionsTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertEditWCDConfigurationTest.class);
		testSuite.addTestSuite(Member_AssertEditWCLConfigurationTest.class);
		testSuite.addTestSuite(Member_AssertEditWCSConfigurationTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(
			CA_RemoveMemberWCDConfigurationPermissionsTest.class);
		testSuite.addTestSuite(
			CA_RemoveMemberWCLConfigurationPermissionsTest.class);
		testSuite.addTestSuite(
			CA_RemoveMemberWCSConfigurationPermissionsTest.class);
		testSuite.addTestSuite(CA_RemoveMemberWCDViewPermissionsTest.class);
		testSuite.addTestSuite(CA_RemoveMemberWCLViewPermissionsTest.class);
		testSuite.addTestSuite(CA_RemoveMemberWCSViewPermissionsTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCDTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCLTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCSTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_RestoreMemberWCDViewPermissionsTest.class);
		testSuite.addTestSuite(CA_RestoreMemberWCLViewPermissionsTest.class);
		testSuite.addTestSuite(CA_RestoreMemberWCSViewPermissionsTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertViewWCDTest.class);
		testSuite.addTestSuite(Member_AssertViewWCLTest.class);
		testSuite.addTestSuite(Member_AssertViewWCSTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_CleanUpTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}