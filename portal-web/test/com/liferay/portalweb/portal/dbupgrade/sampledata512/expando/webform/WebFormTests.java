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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.expando.webform;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebFormTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddCommunityExpandoWebFormTest.class);
		testSuite.addTestSuite(AddPageWFTest.class);
		testSuite.addTestSuite(AddPortletWFTest.class);
		testSuite.addTestSuite(AddFormFieldRadioTest.class);
		testSuite.addTestSuite(AddFormFieldParagraphTest.class);
		testSuite.addTestSuite(AddFormFieldCheckboxTest.class);
		testSuite.addTestSuite(SendForm1Test.class);
		testSuite.addTestSuite(SendForm2Test.class);
		testSuite.addTestSuite(SendForm3Test.class);
		testSuite.addTestSuite(ViewWebFormTest.class);

		return testSuite;
	}

}