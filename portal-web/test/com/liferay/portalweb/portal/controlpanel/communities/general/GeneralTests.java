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

package com.liferay.portalweb.portal.controlpanel.communities.general;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class GeneralTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AddCommunitiesTest.class);
		testSuite.addTestSuite(AddCommunitiesPublicPageTest.class);
		testSuite.addTestSuite(AddCommunitiesPrivatePageTest.class);
		testSuite.addTestSuite(AssertCommunityDropDownTest.class);
		testSuite.addTestSuite(AddAsteriskCommunityNameTest.class);
		testSuite.addTestSuite(AddCommaCommunityNameTest.class);
		testSuite.addTestSuite(AddDuplicateCommunityNameTest.class);
		testSuite.addTestSuite(AddNullCommunityNameTest.class);
		testSuite.addTestSuite(AddNumberCommunityNameTest.class);
		testSuite.addTestSuite(ApplyCommunityTest.class);
		testSuite.addTestSuite(AssertApplyCommunityTest.class);
		testSuite.addTestSuite(RemoveApplyCommunityTest.class);
		testSuite.addTestSuite(AssertRemoveApplyCommunityTest.class);
		testSuite.addTestSuite(SearchCommunityTest.class);
		testSuite.addTestSuite(AddTemporaryCommunityTest.class);
		testSuite.addTestSuite(EditCommunityTest.class);
		testSuite.addTestSuite(DeleteTemporaryCommunityTest.class);
		testSuite.addTestSuite(DeleteInvalidCommunityTest.class);
		testSuite.addTestSuite(AddTemporaryLARCommunityTest.class);
		testSuite.addTestSuite(AssertNoLARCommunityContentTest.class);
//		testSuite.addTestSuite(ImportCommunityLARTest.class);
//		testSuite.addTestSuite(AssertCommunityLARImportTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownCommunityTest.class);

		return testSuite;
	}

}