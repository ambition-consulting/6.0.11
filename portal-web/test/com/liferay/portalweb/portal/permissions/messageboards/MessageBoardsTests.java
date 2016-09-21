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

package com.liferay.portalweb.portal.permissions.messageboards;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_AddPageTest.class);
		testSuite.addTestSuite(CA_AddPortletTest.class);
		testSuite.addTestSuite(CA_AddCategoryTest.class);
		testSuite.addTestSuite(CA_AddMessageTest.class);
		testSuite.addTestSuite(CA_AssertActionsTest.class);
		testSuite.addTestSuite(CA_DeleteMessageTest.class);
		testSuite.addTestSuite(CA_DeleteCategoryTest.class);
		testSuite.addTestSuite(CA_AddCategoryTest.class);
		testSuite.addTestSuite(CA_AddMessageTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertActionsTest.class);
		testSuite.addTestSuite(Member_ViewMessageTest.class);
		testSuite.addTestSuite(Member_ReplyMessageTest.class);
		testSuite.addTestSuite(Member_PostNewThreadTest.class);
		testSuite.addTestSuite(Member_EditThreadTest.class);
		testSuite.addTestSuite(Member_DeleteMessageTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(Guest_ViewTest.class);
		testSuite.addTestSuite(Guest_AssertActionsTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}