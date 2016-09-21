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

package com.liferay.portalweb.portal.controlpanel.communities.community;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.communities.community.joincommunityinactive.JoinCommunityInactiveTests;
import com.liferay.portalweb.portal.controlpanel.communities.community.joincommunityopen.JoinCommunityOpenTests;
import com.liferay.portalweb.portal.controlpanel.communities.community.joincommunityprivate.JoinCommunityPrivateTests;
import com.liferay.portalweb.portal.controlpanel.communities.community.joincommunityrestricted.JoinCommunityRestrictedTests;
import com.liferay.portalweb.portal.controlpanel.communities.community.leavecommunity.LeaveCommunityTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CommunityTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(JoinCommunityInactiveTests.suite());
		testSuite.addTest(JoinCommunityOpenTests.suite());
		testSuite.addTest(JoinCommunityPrivateTests.suite());
		testSuite.addTest(JoinCommunityRestrictedTests.suite());
		testSuite.addTest(LeaveCommunityTests.suite());

		return testSuite;
	}

}