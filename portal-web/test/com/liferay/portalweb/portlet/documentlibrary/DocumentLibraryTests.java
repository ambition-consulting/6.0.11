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

package com.liferay.portalweb.portlet.documentlibrary;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.documentlibrary.comment.CommentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.DocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.FolderTests;
import com.liferay.portalweb.portlet.documentlibrary.lar.LARTests;
import com.liferay.portalweb.portlet.documentlibrary.portlet.PortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentLibraryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(CommentTests.suite());
		testSuite.addTest(DocumentTests.suite());
		testSuite.addTest(FolderTests.suite());
		testSuite.addTest(LARTests.suite());
		testSuite.addTest(PortletTests.suite());

		return testSuite;
	}

}