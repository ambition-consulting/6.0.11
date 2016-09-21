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

package com.liferay.portalweb.portal.controlpanel.webcontent.templates.addtemplateassociated;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTemplateAssociatedTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddStructureTest.class);
		testSuite.addTestSuite(AddTemplateTest.class);
		testSuite.addTestSuite(AddTemplateAssociatedTest.class);
		testSuite.addTestSuite(AssertTemplateAssociatedTest.class);
		testSuite.addTestSuite(TearDownWebContentTest.class);
		testSuite.addTestSuite(TearDownTemplateTest.class);
		testSuite.addTestSuite(TearDownStructureTest.class);

		return testSuite;
	}

}