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

package com.liferay.portalweb.portlet.blogs.entrycomment;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.blogs.entrycomment.addentrycomment.AddEntryCommentTests;
import com.liferay.portalweb.portlet.blogs.entrycomment.deleteentrycomment.DeleteEntryCommentTests;
import com.liferay.portalweb.portlet.blogs.entrycomment.editentrycomment.EditEntryCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryCommentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddEntryCommentTests.suite());
		testSuite.addTest(DeleteEntryCommentTests.suite());
		testSuite.addTest(EditEntryCommentTests.suite());

		return testSuite;
	}

}