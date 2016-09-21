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

package com.liferay.portalweb.portlet.assetpublisher.blogsentry;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.addblogsentry.AddBlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.rateblogsentry.RateBlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.removeblogsentry.RemoveBlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.selectblogsentry.SelectBlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewblogsentryabstracts.ViewBlogsEntryAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewblogsentrydynamicassettypeblogsentry.ViewBlogsEntryDynamicAssetTypeBlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewblogsentryfullcontent.ViewBlogsEntryFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewblogsentrytable.ViewBlogsEntryTableTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewblogsentrytitlelist.ViewBlogsEntryTitleListTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.viewcountblogsentry.ViewCountBlogsEntryTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBlogsEntryTests.suite());
		testSuite.addTest(RateBlogsEntryTests.suite());
		testSuite.addTest(RemoveBlogsEntryTests.suite());
		testSuite.addTest(SelectBlogsEntryTests.suite());
		testSuite.addTest(ViewBlogsEntryAbstractsTests.suite());
		testSuite.addTest(
			ViewBlogsEntryDynamicAssetTypeBlogsEntryTests.suite());
		testSuite.addTest(ViewBlogsEntryFullContentTests.suite());
		testSuite.addTest(ViewBlogsEntryTableTests.suite());
		testSuite.addTest(ViewBlogsEntryTitleListTests.suite());
		testSuite.addTest(ViewCountBlogsEntryTests.suite());

		return testSuite;
	}

}