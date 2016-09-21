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

package com.liferay.portalweb.portlet.imagegallery.lar.importlar;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportLARTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageIGTest.class);
		testSuite.addTestSuite(AddPortletIGTest.class);
		testSuite.addTestSuite(ImportLARTest.class);
		testSuite.addTestSuite(AssertImportLARTest.class);
		testSuite.addTestSuite(TearDownIGFolderTest.class);
		testSuite.addTestSuite(TearDownImageTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}