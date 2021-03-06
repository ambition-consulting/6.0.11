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

package com.liferay.portalweb.portlet.assetpublisher.portlet.configureportletdynamicpaginationtypesimple;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletDynamicPaginationTypeSimpleTests
	extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddCategoryTest.class);
		testSuite.addTestSuite(AddMBMessage1Test.class);
		testSuite.addTestSuite(AddMBMessage2Test.class);
		testSuite.addTestSuite(AddMBMessage3Test.class);
		testSuite.addTestSuite(AddMBMessage4Test.class);
		testSuite.addTestSuite(AddMBMessage5Test.class);
		testSuite.addTestSuite(AddMBMessage6Test.class);
		testSuite.addTestSuite(
			ConfigurePortletDynamicMaxItemToDisplay2Test.class);
		testSuite.addTestSuite(
			ConfigurePortletDynamicPaginationTypeSimpleTest.class);
		testSuite.addTestSuite(NextButtonTest.class);
		testSuite.addTestSuite(PreviousButtonTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownMBMessageTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}