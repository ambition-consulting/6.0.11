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

package com.liferay.portalweb.properties.mailintegration.messageboards.replymessageemail;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ReplyMessageEmailTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(ConfigureServerAdministrationMailTest.class);
		testSuite.addTestSuite(EditPortalInstanceMailDomainTest.class);
		testSuite.addTestSuite(AddUserGmailTest.class);
		testSuite.addTestSuite(AssignMemberCommunityTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(
			ConfigurePortletMessageBoardsEmailFromTest.class);
		testSuite.addTestSuite(AddCategoryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(TearDownGmailServerTest.class);
		testSuite.addTestSuite(TearDownGmailUserTest.class);
		testSuite.addTestSuite(SignInUserGmailTest.class);
		testSuite.addTestSuite(SubscribeCategoryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(AddCategoryMessageTest.class);
		testSuite.addTestSuite(ReplyMessageEmailTest.class);
		testSuite.addTestSuite(ViewMessageEmailReplyTest.class);
		testSuite.addTestSuite(TearDownGmailServerTest.class);
		testSuite.addTestSuite(TearDownGmailUserTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownServerTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}

}