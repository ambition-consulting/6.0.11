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

package com.liferay.portalweb.portlet.assetpublisher.blogsentrycomment;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentrycomment.addblogsentrycomment.AddBlogsEntryCommentTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentrycomment.rateblogsentrycomment.RateBlogsEntryCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryCommentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBlogsEntryCommentTests.suite());
		testSuite.addTest(RateBlogsEntryCommentTests.suite());

		return testSuite;
	}

}