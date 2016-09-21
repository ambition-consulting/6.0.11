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

package com.liferay.portalweb.portlet.assetpublisher.wikipage;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewcountwikipage.ViewCountWikiPageTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewwikipageabstracts.ViewWikiPageAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewwikipagedynamicassettypewikipage.ViewWikiPageDynamicAssetTypeWikiPageTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewwikipagefullcontent.ViewWikiPageFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewwikipagetable.ViewWikiPageTableTests;
import com.liferay.portalweb.portlet.assetpublisher.wikipage.viewwikipagetitlelist.ViewWikiPageTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewCountWikiPageTests.suite());
		testSuite.addTest(ViewWikiPageAbstractsTests.suite());
		testSuite.addTest(ViewWikiPageDynamicAssetTypeWikiPageTests.suite());
		testSuite.addTest(ViewWikiPageFullContentTests.suite());
		testSuite.addTest(ViewWikiPageTableTests.suite());
		testSuite.addTest(ViewWikiPageTitleListTests.suite());

		return testSuite;
	}

}