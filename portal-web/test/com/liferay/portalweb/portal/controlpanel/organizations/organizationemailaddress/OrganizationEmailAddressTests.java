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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationemailaddress;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationemailaddress.addorganizationemailaddress.AddOrganizationEmailAddressTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationemailaddress.addorganizationemailaddressinvalid.AddOrganizationEmailAddressInvalidTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationemailaddress.addorganizationemailaddressmultiple.AddOrganizationEmailAddressMultipleTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationEmailAddressTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddOrganizationEmailAddressTests.suite());
		testSuite.addTest(AddOrganizationEmailAddressInvalidTests.suite());
		testSuite.addTest(AddOrganizationEmailAddressMultipleTests.suite());

		return testSuite;
	}

}