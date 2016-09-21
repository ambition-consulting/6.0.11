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

package com.liferay.portalweb.portlet.wiki;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.wiki.attachment.AttachmentTests;
import com.liferay.portalweb.portlet.wiki.comment.CommentTests;
import com.liferay.portalweb.portlet.wiki.lar.LARTests;
import com.liferay.portalweb.portlet.wiki.portlet.PortletTests;
import com.liferay.portalweb.portlet.wiki.wikinode.WikiNodeTests;
import com.liferay.portalweb.portlet.wiki.wikipage.WikiPageTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AttachmentTests.suite());
		testSuite.addTest(CommentTests.suite());
		testSuite.addTest(LARTests.suite());
		testSuite.addTest(PortletTests.suite());
		testSuite.addTest(WikiNodeTests.suite());
		testSuite.addTest(WikiPageTests.suite());

		return testSuite;
	}

}