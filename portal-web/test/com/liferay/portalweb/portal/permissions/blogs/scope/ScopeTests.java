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

package com.liferay.portalweb.portal.permissions.blogs.scope;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ScopeTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AddScopeBlogsPageTest.class);
		testSuite.addTestSuite(SA_AddScopeBlogsPortletTest.class);
		testSuite.addTestSuite(SA_AddPortalScopePermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Scope_LoginTest.class);
		testSuite.addTestSuite(Scope_AddGuestPortalScopeEntryTest.class);
		testSuite.addTestSuite(Scope_AddScopePortalScopeEntryTest.class);
		testSuite.addTestSuite(Scope_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemovePortalScopePermissionsTest.class);
		testSuite.addTestSuite(SA_AddCommunityScopePermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Scope_LoginTest.class);
		testSuite.addTestSuite(Scope_AssertCannotAddPortalScopeEntryTest.class);
		testSuite.addTestSuite(Scope_AddScopeCommunityScopeEntryTest.class);
		testSuite.addTestSuite(Scope_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveCommunityScopePermissionsTest.class);
		testSuite.addTestSuite(SA_CleanUpTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}