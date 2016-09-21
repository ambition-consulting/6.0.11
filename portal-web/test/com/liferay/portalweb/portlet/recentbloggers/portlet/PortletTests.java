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

package com.liferay.portalweb.portlet.recentbloggers.portlet;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.addportlet.AddPortletTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.addportletduplicate.AddPortletDuplicateTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.configureportletdisplaystyleusername.ConfigurePortletDisplayStyleUserNameTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.configureportletdisplaystyleusernameandimage.ConfigurePortletDisplayStyleUserNameAndImageTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.removeportlet.RemovePortletTests;

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
		testSuite.addTest(ConfigurePortletDisplayStyleUserNameTests.suite());
		testSuite.addTest(
			ConfigurePortletDisplayStyleUserNameAndImageTests.suite());
		testSuite.addTest(RemovePortletTests.suite());

		return testSuite;
	}

}