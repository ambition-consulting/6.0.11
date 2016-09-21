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

package com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry;

import com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentryassignedtome.ViewBlogsEntryAssignedToMeTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentryassignedtomyroles.ViewBlogsEntryAssignedToMyRolesTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentrycompleted.ViewBlogsEntryCompletedTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentryrejected.ViewBlogsEntryRejectedTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.blogsentry.viewblogsentryresubmitted.ViewBlogsEntryResubmittedTests;
import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewBlogsEntryAssignedToMeTests.suite());
		testSuite.addTest(ViewBlogsEntryAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewBlogsEntryCompletedTests.suite());
		testSuite.addTest(ViewBlogsEntryRejectedTests.suite());
		testSuite.addTest(ViewBlogsEntryResubmittedTests.suite());

		return testSuite;
	}

}