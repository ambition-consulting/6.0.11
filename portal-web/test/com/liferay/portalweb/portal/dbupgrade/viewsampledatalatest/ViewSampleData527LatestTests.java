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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.Address527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.Announcements527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.AnnouncementsDelivery527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.calendar.Calendar527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.DocumentLibrary527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.expando.Expando527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.Groups527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.organizations.Organizations527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.portletpermissions.PortletPermissions527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.Shopping527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.social.Social527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.StagingCommunity527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingorganization.StagingOrganization527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.Tags527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.webcontent.WebContent527LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.wiki.Wiki527LatestTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSampleData527LatestTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Address527LatestTests.suite());
		testSuite.addTest(Announcements527LatestTests.suite());
		testSuite.addTest(AnnouncementsDelivery527LatestTests.suite());
		testSuite.addTest(Calendar527LatestTests.suite());
		testSuite.addTest(DocumentLibrary527LatestTests.suite());
		testSuite.addTest(Expando527LatestTests.suite());
		testSuite.addTest(Groups527LatestTests.suite());
		testSuite.addTest(Organizations527LatestTests.suite());
		testSuite.addTest(PortletPermissions527LatestTests.suite());
		testSuite.addTest(Shopping527LatestTests.suite());
		testSuite.addTest(Social527LatestTests.suite());
		testSuite.addTest(StagingCommunity527LatestTests.suite());
		testSuite.addTest(StagingOrganization527LatestTests.suite());
		testSuite.addTest(Tags527LatestTests.suite());
		testSuite.addTest(WebContent527LatestTests.suite());
		testSuite.addTest(Wiki527LatestTests.suite());

		return testSuite;
	}

}