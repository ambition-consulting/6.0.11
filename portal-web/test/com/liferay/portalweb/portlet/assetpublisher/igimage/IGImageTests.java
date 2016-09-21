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

package com.liferay.portalweb.portlet.assetpublisher.igimage;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.addigimage.AddIGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.removeigimage.RemoveIGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.selectigimage.SelectIGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewcountigimage.ViewCountIGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewigimageabstracts.ViewIGImageAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewigimagedynamicassettypeigimage.ViewIGImageDynamicAssetTypeIGImageTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewigimagefullcontent.ViewIGImageFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewigimagetable.ViewIGImageTableTests;
import com.liferay.portalweb.portlet.assetpublisher.igimage.viewigimagetitlelist.ViewIGImageTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class IGImageTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddIGImageTests.suite());
		testSuite.addTest(RemoveIGImageTests.suite());
		testSuite.addTest(SelectIGImageTests.suite());
		testSuite.addTest(ViewCountIGImageTests.suite());
		testSuite.addTest(ViewIGImageAbstractsTests.suite());
		testSuite.addTest(
			ViewIGImageDynamicAssetTypeIGImageTests.suite());
		testSuite.addTest(ViewIGImageFullContentTests.suite());
		testSuite.addTest(ViewIGImageTableTests.suite());
		testSuite.addTest(ViewIGImageTitleListTests.suite());

		return testSuite;
	}

}