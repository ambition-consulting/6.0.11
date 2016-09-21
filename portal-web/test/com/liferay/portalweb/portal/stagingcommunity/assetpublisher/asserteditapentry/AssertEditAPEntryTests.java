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

package com.liferay.portalweb.portal.stagingcommunity.assetpublisher.asserteditapentry;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertEditAPEntryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddCommunitiesTest.class);
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(AddBlogsEntryTest.class);
		testSuite.addTestSuite(AssertEditAPEntryTest.class);
		testSuite.addTestSuite(ActivateStagingTest.class);
		testSuite.addTestSuite(AssertCannotEditAPEntryTest.class);
		testSuite.addTestSuite(DeactivateStagingTest.class);
		testSuite.addTestSuite(AssertEditAPEntryTest.class);
		testSuite.addTestSuite(TearDownCommunityTest.class);

		return testSuite;
	}

}