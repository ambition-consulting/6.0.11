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
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.Address6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.Announcements6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.AnnouncementsDelivery6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.calendar.Calendar6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.DocumentLibrary6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.expando.Expando6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.Groups6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.organizations.Organizations6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.portletpermissions.PortletPermissions6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.Shopping6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.social.Social6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.StagingCommunity6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingorganization.StagingOrganization6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.Tags6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.webcontent.WebContent6010LatestTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.wiki.Wiki6010LatestTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSampleData6010LatestTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Address6010LatestTests.suite());
		testSuite.addTest(Announcements6010LatestTests.suite());
		testSuite.addTest(AnnouncementsDelivery6010LatestTests.suite());
		testSuite.addTest(Calendar6010LatestTests.suite());
		testSuite.addTest(DocumentLibrary6010LatestTests.suite());
		testSuite.addTest(Expando6010LatestTests.suite());
		testSuite.addTest(Groups6010LatestTests.suite());
		testSuite.addTest(Organizations6010LatestTests.suite());
		testSuite.addTest(PortletPermissions6010LatestTests.suite());
		testSuite.addTest(Shopping6010LatestTests.suite());
		testSuite.addTest(Social6010LatestTests.suite());
		testSuite.addTest(StagingCommunity6010LatestTests.suite());
		testSuite.addTest(StagingOrganization6010LatestTests.suite());
		testSuite.addTest(Tags6010LatestTests.suite());
		testSuite.addTest(WebContent6010LatestTests.suite());
		testSuite.addTest(Wiki6010LatestTests.suite());

		return testSuite;
	}

}