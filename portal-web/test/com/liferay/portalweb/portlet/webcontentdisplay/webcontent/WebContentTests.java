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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.addwcdwebcontent.AddWCDWebContentTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.ratewcdwebcontent.RateWCDWebContentTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.searchwcdwebcontent.SearchWCDWebContentTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.selectwcwebcontent.SelectWCWebContentTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewwcdwebcontentlocalized.ViewWCDWebContentLocalizedTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWCDWebContentTests.suite());
		testSuite.addTest(RateWCDWebContentTests.suite());
		testSuite.addTest(SearchWCDWebContentTests.suite());
		testSuite.addTest(SelectWCWebContentTests.suite());
		testSuite.addTest(ViewWCDWebContentLocalizedTests.suite());

		return testSuite;
	}

}