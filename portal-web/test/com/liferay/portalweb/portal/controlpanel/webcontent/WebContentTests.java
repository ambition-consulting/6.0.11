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

package com.liferay.portalweb.portal.controlpanel.webcontent;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.lar.LARTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.structures.StructuresTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.templates.TemplatesTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.WCWebContentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LARTests.suite());
		testSuite.addTest(StructuresTests.suite());
		testSuite.addTest(TemplatesTests.suite());
		testSuite.addTest(WCWebContentTests.suite());

		return testSuite;
	}

}