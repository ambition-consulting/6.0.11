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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveViewPortletPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotViewPortletTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowViewPortletPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertViewPortletTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveConfigurePortletPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotConfigurePortletTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowConfigurePortletPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertConfigurePortletTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveConfigurePortletPermissionsTest.class);
		testSuite.addTestSuite(
			SA_DisableAllowAccessInControlPanelPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_ControlPanelTest.class);
		testSuite.addTestSuite(Portlet_AssertNoAccessInControlPanelTest.class);
		testSuite.addTestSuite(Portlet_EndControlPanelTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveAddEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotAddEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowAddEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AddEntryTest.class);
		testSuite.addTestSuite(Portlet_DeleteOwnEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveAddEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_AddTemporaryEntryTest.class);
		testSuite.addTestSuite(SA_RemoveViewEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotViewEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowViewEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertViewEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotAddCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AddCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RemoveEditCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotEditCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowEditCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_EditCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveEditCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RemoveDeleteCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotDeleteCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowDeleteCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_DeleteCommentTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveDeleteCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RemovePermissionsEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(
			Portlet_AssertCannotEditEntryPermissionsTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowPermissionsEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertEditEntryPermissionsTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemovePermissionsEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_RemoveEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotEditEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_EditEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_RemoveEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_RemoveDeleteEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotDeleteEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_AllowDeleteEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_DeleteEntryTest.class);
		testSuite.addTestSuite(Portlet_LogoutTest.class);
		testSuite.addTestSuite(SA_LoginTest.class);
		testSuite.addTestSuite(SA_CleanUpTest.class);
		testSuite.addTestSuite(SA_LogoutTest.class);

		return testSuite;
	}

}