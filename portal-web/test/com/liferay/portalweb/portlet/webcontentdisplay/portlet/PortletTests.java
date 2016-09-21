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

package com.liferay.portalweb.portlet.webcontentdisplay.portlet;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletenablecommentratings.ConfigurePortletEnableCommentRatingsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletenablecomments.ConfigurePortletEnableCommentsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletenableratings.ConfigurePortletEnableRatingsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletshowavailablelocales.ConfigurePortletShowAvailableLocalesTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ConfigurePortletEnableCommentRatingsTests.suite());
		testSuite.addTest(ConfigurePortletEnableCommentsTests.suite());
		testSuite.addTest(ConfigurePortletEnableRatingsTests.suite());
		testSuite.addTest(ConfigurePortletShowAvailableLocalesTests.suite());

		return testSuite;
	}

}