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

package com.liferay.portalweb.portlet.assetpublisher;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.archivedsetup.ArchivedSetupTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentry.BlogsEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.blogsentrycomment.BlogsEntryCommentTests;
import com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.BookmarksEntryTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.DLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocumentcomment.DLDocumentCommentTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.IGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.lar.LARTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.MBMessageTests;
import com.liferay.portalweb.portlet.assetpublisher.portlet.PortletTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.WebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontentcomment.WebContentCommentTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.WikiPageTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipagecomment.WikiPageCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetPublisherTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ArchivedSetupTests.suite());
		testSuite.addTest(BlogsEntryTests.suite());
		testSuite.addTest(BlogsEntryCommentTests.suite());
		testSuite.addTest(BookmarksEntryTests.suite());
		testSuite.addTest(DLDocumentTests.suite());
		testSuite.addTest(DLDocumentCommentTests.suite());
		testSuite.addTest(IGImageTests.suite());
		testSuite.addTest(LARTests.suite());
		testSuite.addTest(MBMessageTests.suite());
		testSuite.addTest(PortletTests.suite());
		testSuite.addTest(WebContentTests.suite());
		testSuite.addTest(WebContentCommentTests.suite());
		testSuite.addTest(WikiPageTests.suite());
		testSuite.addTest(WikiPageCommentTests.suite());

		return testSuite;
	}

}