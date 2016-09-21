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

package com.liferay.portalweb.portal.controlpanel.usergroup;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(AddUserGroupTest.class);
		testSuite.addTestSuite(AddAsteriskUserGroupNameTest.class);
		testSuite.addTestSuite(AddCommaUserGroupNameTest.class);
		testSuite.addTestSuite(AddDuplicateUserGroupNameTest.class);
		testSuite.addTestSuite(AddNullUserGroupNameTest.class);
		testSuite.addTestSuite(AddNumberUserGroupNameTest.class);
		testSuite.addTestSuite(ApplyUserGroupTest.class);
		testSuite.addTestSuite(AssertApplyUserGroupTest.class);
		testSuite.addTestSuite(AssertCannotDeleteApplyUserGroupTest.class);
		testSuite.addTestSuite(RemoveApplyUserGroupTest.class);
		testSuite.addTestSuite(AssertRemoveApplyUserGroupTest.class);
		testSuite.addTestSuite(SearchUserGroupTest.class);
		testSuite.addTestSuite(AddTemporaryUserGroupTest.class);
		testSuite.addTestSuite(DeleteTemporaryUserGroupTest.class);
		testSuite.addTestSuite(TearDownTest.class);

		return testSuite;
	}

}