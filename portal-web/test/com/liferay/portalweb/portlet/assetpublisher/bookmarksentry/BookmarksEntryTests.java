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

package com.liferay.portalweb.portlet.assetpublisher.bookmarksentry;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.addbookmarksentry.AddBookmarksEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.removebookmarksentry.RemoveBookmarksEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.selectbookmarksentry.SelectBookmarksEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentryabstracts.ViewBookmarksEntryAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentrydynamicassettypebookmarksentry.ViewBookmarksEntryDynamicAssetTypeBookmarksEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentryfullcontent.ViewBookmarksEntryFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentrytable.ViewBookmarksEntryTableTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentrytitlelist.ViewBookmarksEntryTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksEntryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBookmarksEntryTests.suite());
		testSuite.addTest(RemoveBookmarksEntryTests.suite());
		testSuite.addTest(SelectBookmarksEntryTests.suite());
		testSuite.addTest(ViewBookmarksEntryAbstractsTests.suite());
		testSuite.addTest(
			ViewBookmarksEntryDynamicAssetTypeBookmarksEntryTests.suite());
		testSuite.addTest(ViewBookmarksEntryFullContentTests.suite());
		testSuite.addTest(ViewBookmarksEntryTableTests.suite());
		testSuite.addTest(ViewBookmarksEntryTitleListTests.suite());

		return testSuite;
	}

}