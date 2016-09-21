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

package com.liferay.portalweb.portlet.assetpublisher.dldocument;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.adddldocument.AddDLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.ratedldocument.RateDLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.removedldocument.RemoveDLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.selectdldocument.SelectDLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.viewdldocumentabstracts.ViewDLDocumentAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.viewdldocumentdynamicassettypedldocument.ViewDLDocumentDynamicAssetTypeDLDocumentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.viewdldocumentfullcontent.ViewDLDocumentFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.viewdldocumenttable.ViewDLDocumentTableTests;
import com.liferay.portalweb.portlet.assetpublisher.dldocument.viewdldocumenttitlelist.ViewDLDocumentTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DLDocumentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDLDocumentTests.suite());
		testSuite.addTest(RateDLDocumentTests.suite());
		testSuite.addTest(RemoveDLDocumentTests.suite());
		testSuite.addTest(SelectDLDocumentTests.suite());
		testSuite.addTest(ViewDLDocumentAbstractsTests.suite());
		testSuite.addTest(
			ViewDLDocumentDynamicAssetTypeDLDocumentTests.suite());
		testSuite.addTest(ViewDLDocumentFullContentTests.suite());
		testSuite.addTest(ViewDLDocumentTableTests.suite());
		testSuite.addTest(ViewDLDocumentTitleListTests.suite());

		return testSuite;
	}

}