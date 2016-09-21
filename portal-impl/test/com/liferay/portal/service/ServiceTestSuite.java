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

package com.liferay.portal.service;

import com.liferay.counter.service.CounterLocalServiceTest;
import com.liferay.portlet.bookmarks.service.BookmarksEntryServiceTest;
import com.liferay.portlet.bookmarks.service.BookmarksFolderServiceTest;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceTest;
import com.liferay.portlet.imagegallery.service.IGImageServiceTest;
import com.liferay.portlet.messageboards.service.MBMessageServiceTest;
import com.liferay.portlet.social.service.SocialRelationLocalServiceTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ServiceTestSuite extends TestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(CounterLocalServiceTest.class);

		testSuite.addTestSuite(ResourceLocalServiceTest.class);
		testSuite.addTestSuite(UserServiceTest.class);

		testSuite.addTestSuite(BookmarksFolderServiceTest.class);
		testSuite.addTestSuite(BookmarksEntryServiceTest.class);

		testSuite.addTestSuite(DLFileEntryServiceTest.class);

		testSuite.addTestSuite(IGImageServiceTest.class);

		testSuite.addTestSuite(MBMessageServiceTest.class);

		testSuite.addTestSuite(SocialRelationLocalServiceTest.class);

		return new ServiceTestSetup(testSuite);
	}

}