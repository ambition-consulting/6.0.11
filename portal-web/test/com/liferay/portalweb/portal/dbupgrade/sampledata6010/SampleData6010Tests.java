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

package com.liferay.portalweb.portal.dbupgrade.sampledata6010;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.address.AddressTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.announcements.AnnouncementsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.announcementsdelivery.AnnouncementsDeliveryTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.calendar.CalendarTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.documentlibrary.DocumentLibraryTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.expando.ExpandoTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.groups.GroupsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.organizations.OrganizationsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.portletpermissions.PortletPermissionsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.ShoppingTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.social.SocialTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.stagingcommunity.StagingCommunityTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.stagingorganization.StagingOrganizationTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.tags.TagsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.webcontent.WebContentTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.wiki.WikiTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleData6010Tests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddressTests.suite());
		testSuite.addTest(AnnouncementsTests.suite());
		testSuite.addTest(AnnouncementsDeliveryTests.suite());
		testSuite.addTest(CalendarTests.suite());
		testSuite.addTest(DocumentLibraryTests.suite());
		testSuite.addTest(ExpandoTests.suite());
		testSuite.addTest(GroupsTests.suite());
		testSuite.addTest(OrganizationsTests.suite());
		testSuite.addTest(PortletPermissionsTests.suite());
		testSuite.addTest(ShoppingTests.suite());
		testSuite.addTest(StagingCommunityTests.suite());
		testSuite.addTest(StagingOrganizationTests.suite());
		testSuite.addTest(TagsTests.suite());
		testSuite.addTest(WebContentTests.suite());
		testSuite.addTest(WikiTests.suite());
		testSuite.addTest(SocialTests.suite());

		return testSuite;
	}

}