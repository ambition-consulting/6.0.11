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

package com.liferay.portalweb.portal.permissions.webcontent.workflow;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WorkFlowTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(Writer_LoginTest.class);
		testSuite.addTestSuite(Writer_AddArticleTest.class);
		testSuite.addTestSuite(Writer_ConfigureWCDPortletTest.class);
		testSuite.addTestSuite(Writer_ConfigureWCLPortletTest.class);
		testSuite.addTestSuite(Writer_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_AssertCannotViewWCDPreApprovalTest.class);
		testSuite.addTestSuite(CA_AssertCannotViewWCLPreApprovalTest.class);
		testSuite.addTestSuite(CA_AssertCannotSearchWCSPreApprovalTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertCannotViewWCDPreApprovalTest.class);
		testSuite.addTestSuite(Guest_AssertCannotViewWCLPreApprovalTest.class);
		testSuite.addTestSuite(
			Guest_AssertCannotSearchWCSPreApprovalTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCDPreApprovalTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCLPreApprovalTest.class);
		testSuite.addTestSuite(
			Member_AssertCannotSearchWCSPreApprovalTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(Publisher_LoginTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotViewWCDPreApprovalTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotViewWCLPreApprovalTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotSearchWCSPreApprovalTest.class);
		testSuite.addTestSuite(Publisher_LogoutTest.class);
		testSuite.addTestSuite(Writer_LoginTest.class);
		testSuite.addTestSuite(Writer_AssertCannotViewWCDPreApprovalTest.class);
		testSuite.addTestSuite(Writer_AssertCannotViewWCLPreApprovalTest.class);
		testSuite.addTestSuite(
			Writer_AssertCannotSearchWCSPreApprovalTest.class);
		testSuite.addTestSuite(Writer_LogoutTest.class);
		testSuite.addTestSuite(Publisher_LoginTest.class);
		testSuite.addTestSuite(Publisher_ApproveArticleTest.class);
		testSuite.addTestSuite(Publisher_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_AssertViewWCDContentTest.class);
		testSuite.addTestSuite(CA_AssertViewWCLContentTest.class);
		testSuite.addTestSuite(CA_AssertSearchWCSPortletTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertViewWCDContentTest.class);
		testSuite.addTestSuite(Guest_AssertViewWCLContentTest.class);
		testSuite.addTestSuite(Guest_AssertSearchWCSPortletTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertViewWCDContentTest.class);
		testSuite.addTestSuite(Member_AssertViewWCLContentTest.class);
		testSuite.addTestSuite(Member_AssertSearchWCSPortletTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(Publisher_LoginTest.class);
		testSuite.addTestSuite(Publisher_AssertViewWCDContentTest.class);
		testSuite.addTestSuite(Publisher_AssertViewWCLContentTest.class);
		testSuite.addTestSuite(Publisher_AssertSearchWCSPortletTest.class);
		testSuite.addTestSuite(Publisher_LogoutTest.class);
		testSuite.addTestSuite(Writer_LoginTest.class);
		testSuite.addTestSuite(Writer_AssertViewWCDContentTest.class);
		testSuite.addTestSuite(Writer_AssertViewWCLContentTest.class);
		testSuite.addTestSuite(Writer_AssertSearchWCSPortletTest.class);
		testSuite.addTestSuite(Writer_LogoutTest.class);
		testSuite.addTestSuite(Publisher_LoginTest.class);
		testSuite.addTestSuite(Publisher_ExpireArticleTest.class);
		testSuite.addTestSuite(Publisher_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_AssertCannotViewWCDPostExpireTest.class);
		testSuite.addTestSuite(CA_AssertCannotViewWCLPostExpireTest.class);
		testSuite.addTestSuite(CA_AssertCannotSearchWCSPostExpireTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertCannotViewWCDPostExpireTest.class);
		testSuite.addTestSuite(Guest_AssertCannotViewWCLPostExpireTest.class);
		testSuite.addTestSuite(Guest_AssertCannotSearchWCSPostExpireTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCDPostExpireTest.class);
		testSuite.addTestSuite(Member_AssertCannotViewWCLPostExpireTest.class);
		testSuite.addTestSuite(
			Member_AssertCannotSearchWCSPostExpireTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(Publisher_LoginTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotViewWCDPostExpireTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotViewWCLPostExpireTest.class);
		testSuite.addTestSuite(
			Publisher_AssertCannotSearchWCSPostExpireTest.class);
		testSuite.addTestSuite(Publisher_LogoutTest.class);
		testSuite.addTestSuite(Writer_LoginTest.class);
		testSuite.addTestSuite(Writer_AssertCannotViewWCDPostExpireTest.class);
		testSuite.addTestSuite(Writer_AssertCannotViewWCLPostExpireTest.class);
		testSuite.addTestSuite(
			Writer_AssertCannotSearchWCSPostExpireTest.class);
		testSuite.addTestSuite(Writer_EditOwnArticleTest.class);
		testSuite.addTestSuite(Writer_DeleteOwnArticleTest.class);
		testSuite.addTestSuite(Writer_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_CleanUpTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}