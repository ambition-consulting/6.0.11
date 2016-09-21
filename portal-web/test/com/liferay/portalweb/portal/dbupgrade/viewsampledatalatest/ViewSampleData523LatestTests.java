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
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.Address523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.Announcements523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.AnnouncementsDelivery523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.calendar.Calendar523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.DocumentLibrary523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.expando.Expando523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.Groups523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.organizations.Organizations523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.portletpermissions.PortletPermissions523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.Shopping523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.social.Social523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.StagingCommunity523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingorganization.StagingOrganization523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.Tags523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.webcontent.WebContent523LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.wiki.Wiki523LatestTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSampleData523LatestTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Address523LatestTests.suite());
		testSuite.addTest(Announcements523LatestTests.suite());
		testSuite.addTest(AnnouncementsDelivery523LatestTests.suite());
		testSuite.addTest(Calendar523LatestTests.suite());
		testSuite.addTest(DocumentLibrary523LatestTests.suite());
		testSuite.addTest(Expando523LatestTests.suite());
		testSuite.addTest(Groups523LatestTests.suite());
		testSuite.addTest(Organizations523LatestTests.suite());
		testSuite.addTest(PortletPermissions523LatestTests.suite());
		testSuite.addTest(Shopping523LatestTests.suite());
		testSuite.addTest(Social523LatestTests.suite());
		testSuite.addTest(StagingCommunity523LatestTests.suite());
		testSuite.addTest(StagingOrganization523LatestTests.suite());
		testSuite.addTest(Tags523LatestTests.suite());
		testSuite.addTest(WebContent523LatestTests.suite());
		testSuite.addTest(Wiki523LatestTests.suite());

		return testSuite;
	}

}