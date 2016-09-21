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

package com.liferay.portalweb.portal.controlpanel.blogs;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddEntryTest.class);
		testSuite.addTestSuite(AddEntryCommentTest.class);
		testSuite.addTestSuite(AssertViewCountTest.class);
		testSuite.addTestSuite(AddRatingTest.class);
		testSuite.addTestSuite(AddSecondEntryTest.class);
		testSuite.addTestSuite(AddSecondEntryCommentTest.class);
		testSuite.addTestSuite(EditSecondEntryTest.class);
		testSuite.addTestSuite(EditSecondCommentTest.class);
		testSuite.addTestSuite(SearchBlogsTest.class);
		testSuite.addTestSuite(DeleteSecondCommentTest.class);
		testSuite.addTestSuite(DeleteSecondEntryTest.class);
		testSuite.addTestSuite(AddNullEntryTest.class);
		testSuite.addTestSuite(AddNullTitleTest.class);
		testSuite.addTestSuite(AddEscapeCharacterEntryTest.class);
		testSuite.addTestSuite(DeleteEscapeCharacterEntryTest.class);
		testSuite.addTestSuite(DeleteEntryTest.class);
		testSuite.addTestSuite(AddDraftEntryTest.class);
		testSuite.addTestSuite(PublishDraftEntryTest.class);
		testSuite.addTestSuite(ImportLARTest.class);
		testSuite.addTestSuite(AssertImportLARTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryCPTest.class);

		return testSuite;
	}

}