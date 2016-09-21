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

package com.liferay.portalweb.plugins.socialnetworking;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialNetworkingTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageTest.class);
		testSuite.addTestSuite(AddFriendsPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddFriendsActivitiesPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddMapPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddMeetupsPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddMembersPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddMembersActivitiesPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddSummaryPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(AddWallPortletTest.class);
		testSuite.addTestSuite(RemovePortletTest.class);
		testSuite.addTestSuite(DeletePageTest.class);

		return testSuite;
	}

}