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

package com.liferay.portalweb.portal.permissions.blogs;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.permissions.blogs.assertactions.AssertActionsTests;
import com.liferay.portalweb.portal.permissions.blogs.portlet.PortletTests;
import com.liferay.portalweb.portal.permissions.blogs.scope.ScopeTests;
import com.liferay.portalweb.portal.permissions.blogs.setup.SetupTests;
import com.liferay.portalweb.portal.permissions.blogs.teardown.TearDownTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SetupTests.suite());
		testSuite.addTest(AssertActionsTests.suite());
		testSuite.addTest(PortletTests.suite());
		testSuite.addTest(ScopeTests.suite());
		testSuite.addTest(TearDownTests.suite());

		return testSuite;
	}

}