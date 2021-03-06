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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.portal.login.LoginTests;
import com.liferay.portalweb.portal.permissions.announcements.AnnouncementsTests;
import com.liferay.portalweb.portal.permissions.blogs.BlogsTests;
import com.liferay.portalweb.portal.permissions.controlpanel.ControlPanelTests;
import com.liferay.portalweb.portal.permissions.imagegallery.ImageGalleryTests;
import com.liferay.portalweb.portal.permissions.messageboards.MessageBoardsTests;
import com.liferay.portalweb.portal.permissions.webcontent.WebContentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsTestSuite extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(ControlPanelTests.suite());
		testSuite.addTest(AnnouncementsTests.suite());
		testSuite.addTest(BlogsTests.suite());
		//testSuite.addTest(DocumentLibraryTests.suite());
		testSuite.addTest(ImageGalleryTests.suite());
		testSuite.addTest(MessageBoardsTests.suite());
		testSuite.addTest(WebContentTests.suite());

		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}

}