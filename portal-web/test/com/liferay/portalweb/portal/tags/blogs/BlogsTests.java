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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(SetupTest.class);
		testSuite.addTestSuite(AssertNoTagsInTagsAdminTest.class);
		testSuite.addTestSuite(AssertNoTagsInSelectTagsTest.class);
		testSuite.addTestSuite(AddTagTest.class);
		testSuite.addTestSuite(AddAmpersandTagTest.class);
		testSuite.addTestSuite(AddApostropheTagTest.class);
		testSuite.addTestSuite(AddAsteriskTagTest.class);
		testSuite.addTestSuite(AddAtTagTest.class);
		testSuite.addTestSuite(AddBackSlashTagTest.class);
		testSuite.addTestSuite(AddBracketTagTest.class);
		testSuite.addTestSuite(AddCompareCharacterTagTest.class);
		testSuite.addTestSuite(AddCurlyBraceTagTest.class);
		testSuite.addTestSuite(AddColonTagTest.class);
		testSuite.addTestSuite(AddDuplicateTagTest.class);
		testSuite.addTestSuite(AddEqualSignTagTest.class);
		testSuite.addTestSuite(AddForwardSlashTagTest.class);
		testSuite.addTestSuite(AddNullTagTest.class);
		testSuite.addTestSuite(AddPercentTagTest.class);
		testSuite.addTestSuite(AddPlusTagTest.class);
		testSuite.addTestSuite(AddPoundTagTest.class);
		testSuite.addTestSuite(AddQuestionTagTest.class);
		testSuite.addTestSuite(AddQuoteTagTest.class);
		testSuite.addTestSuite(AddSemiColonTagTest.class);
		testSuite.addTestSuite(AddTildeTagTest.class);
		testSuite.addTestSuite(AddTagThroughJavaScriptTest.class);
		testSuite.addTestSuite(AddMultipleTagsTest.class);
		testSuite.addTestSuite(AssertTagsInTagsAdminTest.class);
		testSuite.addTestSuite(AssertTagsInSelectTagsTest.class);
		testSuite.addTestSuite(SelectTagsTest.class);
		testSuite.addTestSuite(RemoveTagThroughSelectTagTest.class);
		testSuite.addTestSuite(AssertAutoSuggestionDropDownTest.class);
		testSuite.addTestSuite(SelectTagThroughAutoSuggestionTest.class);
		testSuite.addTestSuite(SearchTagsTest.class);
		testSuite.addTestSuite(RemoveTagThroughJavaScriptTest.class);
		testSuite.addTestSuite(SearchRemovedTagTest.class);
		testSuite.addTestSuite(DeleteTagTest.class);
		testSuite.addTestSuite(AssertDeletedTagDoesNotPersistTest.class);
		testSuite.addTestSuite(SuggestionTagTest.class);
		testSuite.addTestSuite(AddUTFTagTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryCPTest.class);
		testSuite.addTestSuite(TearDownTagTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}