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

package com.liferay.portalweb.portal.stagingorganization.blogs;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddRoleContentAdministratorTest.class);
		testSuite.addTestSuite(AddRoleContentCreatorTest.class);
		testSuite.addTestSuite(AddRoleContentPublisherTest.class);
		testSuite.addTestSuite(DefinePermissionsRoleCAOrganizationTest.class);
		testSuite.addTestSuite(DefinePermissionsRoleCCBlogsTest.class);
		testSuite.addTestSuite(DefinePermissionsRoleCCOrganizationTest.class);
		testSuite.addTestSuite(DefinePermissionsRoleCPOrganizationTest.class);
		testSuite.addTestSuite(AddUserContentAdministratorTest.class);
		testSuite.addTestSuite(AddUserContentCreatorTest.class);
		testSuite.addTestSuite(AddUserContentPublisherTest.class);
		testSuite.addTestSuite(AddOrganizationTest.class);
		testSuite.addTestSuite(AssignMembersTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(LoginTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(ActivateStagingOrganizationTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(CC_LoginTest.class);
		testSuite.addTestSuite(CC_AddStagedPortletTest.class);
		testSuite.addTestSuite(CC_SendPortletProposalTest.class);
		testSuite.addTestSuite(CC_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoPortletPreApprovalTest.class);
		testSuite.addTestSuite(CP_LoginTest.class);
		testSuite.addTestSuite(CP_AssertCannotPublishProposalTest.class);
		testSuite.addTestSuite(CP_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_ApprovePortletProposalTest.class);
		testSuite.addTestSuite(CA_AssignPortletPublicationTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoPortletPrePublishTest.class);
		testSuite.addTestSuite(CP_LoginTest.class);
		testSuite.addTestSuite(CP_PublishPortletToLiveTest.class);
		testSuite.addTestSuite(CP_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertPortletPresentTest.class);
		testSuite.addTestSuite(CC_LoginTest.class);
		testSuite.addTestSuite(CC_AddStagedContentTest.class);
		testSuite.addTestSuite(CC_SendContentProposalTest.class);
		testSuite.addTestSuite(CC_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoContentPreApprovalTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_ApproveContentProposalTest.class);
		testSuite.addTestSuite(CA_AssignContentPublicationTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoContentPrePublishTest.class);
		testSuite.addTestSuite(CP_LoginTest.class);
		testSuite.addTestSuite(CP_PublishContentToLiveTest.class);
		testSuite.addTestSuite(CP_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertContentPresentTest.class);
		testSuite.addTestSuite(LoginTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}

}