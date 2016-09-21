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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.portal.controlpanel.admin.AdminTests;
import com.liferay.portalweb.portal.controlpanel.blogs.BlogsTests;
import com.liferay.portalweb.portal.controlpanel.bookmarks.BookmarksTests;
import com.liferay.portalweb.portal.controlpanel.calendar.CalendarTests;
import com.liferay.portalweb.portal.controlpanel.communities.CommunitiesTests;
import com.liferay.portalweb.portal.controlpanel.messageboards.MessageBoardsTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.OrganizationTests;
import com.liferay.portalweb.portal.controlpanel.pagetemplates.PageTemplatesTests;
import com.liferay.portalweb.portal.controlpanel.passwordpolicies.PasswordPoliciesTests;
import com.liferay.portalweb.portal.controlpanel.polls.PollsTests;
import com.liferay.portalweb.portal.controlpanel.settings.SettingsTests;
import com.liferay.portalweb.portal.controlpanel.usergroup.UserGroupTests;
import com.liferay.portalweb.portal.controlpanel.users.UsersTests;
import com.liferay.portalweb.portal.controlpanel.virtualhosting.VirtualHostingTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.WebContentTests;
import com.liferay.portalweb.portal.login.LoginTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ControlPanelTestSuite extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(AdminTests.suite());
		testSuite.addTest(BlogsTests.suite());
		testSuite.addTest(BookmarksTests.suite());
		testSuite.addTest(CalendarTests.suite());
		testSuite.addTest(CommunitiesTests.suite());
		testSuite.addTest(MessageBoardsTests.suite());
		testSuite.addTest(OrganizationTests.suite());
		testSuite.addTest(PageTemplatesTests.suite());
		testSuite.addTest(PasswordPoliciesTests.suite());
		testSuite.addTest(PollsTests.suite());
		testSuite.addTest(SettingsTests.suite());
		testSuite.addTest(UserGroupTests.suite());
		testSuite.addTest(UsersTests.suite());
		testSuite.addTest(VirtualHostingTests.suite());
		testSuite.addTest(WebContentTests.suite());

		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}

}