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

package com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentrydynamicassettypebookmarksentry;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBookmarksEntryDynamicAssetTypeBookmarksEntryTests
	extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageBookmarksTest.class);
		testSuite.addTestSuite(AddPortletBookmarksTest.class);
		testSuite.addTestSuite(AddFolderTest.class);
		testSuite.addTestSuite(AddBookmarksEntryTest.class);
		testSuite.addTestSuite(
			ConfigurePortletDynamicAvailableBookmarksEntryTest.class);
		testSuite.addTestSuite(ViewBookmarksEntryAvailableTest.class);
		testSuite.addTestSuite(
			ConfigurePortletDynamicCurrentBookmarksEntryTest.class);
		testSuite.addTestSuite(ViewBookmarksEntryCurrentTest.class);
		testSuite.addTestSuite(TearDownBookmarksFolderTest.class);
		testSuite.addTestSuite(TearDownBookmarksEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}