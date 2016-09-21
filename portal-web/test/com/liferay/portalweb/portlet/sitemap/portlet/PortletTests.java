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

package com.liferay.portalweb.portlet.sitemap.portlet;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.sitemap.portlet.addportlet.AddPortletTests;
import com.liferay.portalweb.portlet.sitemap.portlet.addportletchildpage.AddPortletChildPageTests;
import com.liferay.portalweb.portlet.sitemap.portlet.addportletmultiple.AddPortletMultipleTests;
import com.liferay.portalweb.portlet.sitemap.portlet.configureportletrootlayout.ConfigurePortletRootLayoutTests;
import com.liferay.portalweb.portlet.sitemap.portlet.removeportlet.RemovePortletTests;
import com.liferay.portalweb.portlet.sitemap.portlet.viewportletsitemap.ViewPortletSiteMapTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletTests.suite());
		testSuite.addTest(AddPortletChildPageTests.suite());
		testSuite.addTest(AddPortletMultipleTests.suite());
		testSuite.addTest(ConfigurePortletRootLayoutTests.suite());
		testSuite.addTest(RemovePortletTests.suite());
		testSuite.addTest(ViewPortletSiteMapTests.suite());

		return testSuite;
	}

}