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

package com.liferay.portalweb.portal.controlpanel.organizations.organization;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganizationTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganizationmultiple.AddOrganizationMultipleTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganizationnameduplicate.AddOrganizationNameDuplicateTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganizationnamenull.AddOrganizationNameNullTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.advancedsearchorganization.AdvancedSearchOrganizationTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganization.AssignMembersOrganizationTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.deleteorganization.DeleteOrganizationTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.deleteorganizationassignmembers.DeleteOrganizationAssignMembersTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.removemembersorganization.RemoveMembersOrganizationTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.searchorganization.SearchOrganizationTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddOrganizationTests.suite());
		testSuite.addTest(AddOrganizationMultipleTests.suite());
		testSuite.addTest(AddOrganizationNameDuplicateTests.suite());
		testSuite.addTest(AddOrganizationNameNullTests.suite());
		testSuite.addTest(AdvancedSearchOrganizationTests.suite());
		testSuite.addTest(AssignMembersOrganizationTests.suite());
		testSuite.addTest(DeleteOrganizationTests.suite());
		testSuite.addTest(DeleteOrganizationAssignMembersTests.suite());
		testSuite.addTest(RemoveMembersOrganizationTests.suite());
		testSuite.addTest(SearchOrganizationTests.suite());

		return testSuite;
	}

}