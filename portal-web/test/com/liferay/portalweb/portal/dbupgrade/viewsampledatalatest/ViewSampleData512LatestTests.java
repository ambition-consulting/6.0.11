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
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.Address512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.Announcements512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.AnnouncementsDelivery512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.calendar.Calendar512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.DocumentLibrary512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.expando.Expando512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.Groups512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.organizations.Organizations512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.portletpermissions.PortletPermissions512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.Shopping512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.social.Social512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.StagingCommunity512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingorganization.StagingOrganization512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.Tags512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.webcontent.WebContent512LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.wiki.Wiki512LatestTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSampleData512LatestTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Address512LatestTests.suite());
		testSuite.addTest(Announcements512LatestTests.suite());
		testSuite.addTest(AnnouncementsDelivery512LatestTests.suite());
		testSuite.addTest(Calendar512LatestTests.suite());
		testSuite.addTest(DocumentLibrary512LatestTests.suite());
		testSuite.addTest(Expando512LatestTests.suite());
		testSuite.addTest(Groups512LatestTests.suite());
		testSuite.addTest(Organizations512LatestTests.suite());
		testSuite.addTest(PortletPermissions512LatestTests.suite());
		testSuite.addTest(Shopping512LatestTests.suite());
		testSuite.addTest(Social512LatestTests.suite());
		testSuite.addTest(StagingCommunity512LatestTests.suite());
		testSuite.addTest(StagingOrganization512LatestTests.suite());
		testSuite.addTest(Tags512LatestTests.suite());
		testSuite.addTest(WebContent512LatestTests.suite());
		testSuite.addTest(Wiki512LatestTests.suite());

		return testSuite;
	}

}