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

package com.liferay.portalweb.portlet.assetpublisher.webcontent;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.addwebcontent.AddWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.ratewebcontent.RateWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.removewebcontent.RemoveWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.selectwebcontent.SelectWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewcountwebcontent.ViewCountWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewwebcontentabstracts.ViewWebContentAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewwebcontentdynamicassettypewebcontent.ViewWebContentDynamicAssetTypeWebContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewwebcontentfullcontent.ViewWebContentFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewwebcontenttable.ViewWebContentTableTests;
import com.liferay.portalweb.portlet.assetpublisher.webcontent.viewwebcontenttitlelist.ViewWebContentTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWebContentTests.suite());
		testSuite.addTest(RateWebContentTests.suite());
		testSuite.addTest(RemoveWebContentTests.suite());
		testSuite.addTest(SelectWebContentTests.suite());
		testSuite.addTest(ViewCountWebContentTests.suite());
		testSuite.addTest(ViewWebContentAbstractsTests.suite());
		testSuite.addTest(
			ViewWebContentDynamicAssetTypeWebContentTests.suite());
		testSuite.addTest(ViewWebContentFullContentTests.suite());
		testSuite.addTest(ViewWebContentTableTests.suite());
		testSuite.addTest(ViewWebContentTitleListTests.suite());

		return testSuite;
	}

}