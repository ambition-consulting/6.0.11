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

package com.liferay.portalweb.portal.permissions.announcements;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AnnouncementsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AddPageTest.class);
		testSuite.addTestSuite(SA_AddPortletTest.class);
		testSuite.addTestSuite(SA_AddGeneralAnnouncementTest.class);
		testSuite.addTestSuite(SA_AddCAAnnouncementTest.class);
		testSuite.addTestSuite(SA_AddMemberAnnouncementTest.class);
		testSuite.addTestSuite(SA_AddGuestAnnouncementTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(CA_LoginTest.class);
		testSuite.addTestSuite(CA_AssertViewTest.class);
		testSuite.addTestSuite(CA_AssertActionsTest.class);
		testSuite.addTestSuite(CA_LogoutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertViewTest.class);
		testSuite.addTestSuite(Member_DismissAnnouncementTest.class);
		testSuite.addTestSuite(Member_AssertActionsTest.class);
		testSuite.addTestSuite(Member_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertViewTest.class);
		testSuite.addTestSuite(Guest_AssertActionsTest.class);
		testSuite.addTestSuite(SA_TearDownTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}