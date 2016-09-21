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

package com.liferay.portalweb.portlet.shopping.portlet;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.shopping.portlet.addportlet.AddPortletTests;
import com.liferay.portalweb.portlet.shopping.portlet.addportletduplicate.AddPortletDuplicateTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletacceptedcreditcard.ConfigurePortletAcceptedCreditCardTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletinsuranceflatrate.ConfigurePortletInsuranceFlatRateTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletinsurancepercentage.ConfigurePortletInsurancePercentageTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletshippingflatrate.ConfigurePortletShippingFlatRateTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletshippingpercentage.ConfigurePortletShippingPercentageTests;
import com.liferay.portalweb.portlet.shopping.portlet.configureportletstatetax.ConfigurePortletStateTaxTests;
import com.liferay.portalweb.portlet.shopping.portlet.removeportlet.RemovePortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletTests.suite());
		testSuite.addTest(AddPortletDuplicateTests.suite());
		testSuite.addTest(ConfigurePortletAcceptedCreditCardTests.suite());
		testSuite.addTest(ConfigurePortletInsuranceFlatRateTests.suite());
		testSuite.addTest(ConfigurePortletInsurancePercentageTests.suite());
		testSuite.addTest(ConfigurePortletShippingFlatRateTests.suite());
		testSuite.addTest(ConfigurePortletShippingPercentageTests.suite());
		testSuite.addTest(ConfigurePortletStateTaxTests.suite());
		testSuite.addTest(RemovePortletTests.suite());

		return testSuite;
	}

}