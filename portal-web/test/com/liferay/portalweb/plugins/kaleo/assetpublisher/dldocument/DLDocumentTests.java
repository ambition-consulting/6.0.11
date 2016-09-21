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

package com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument;

import com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentassignedtome.ViewDocumentAssignedToMeTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentassignedtomyroles.ViewDocumentAssignedToMyRolesTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentcompleted.ViewDocumentCompletedTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentrejected.ViewDocumentRejectedTests;
import com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentresubmitted.ViewDocumentResubmittedTests;
import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DLDocumentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewDocumentAssignedToMeTests.suite());
		testSuite.addTest(ViewDocumentAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewDocumentCompletedTests.suite());
		testSuite.addTest(ViewDocumentRejectedTests.suite());
		testSuite.addTest(ViewDocumentResubmittedTests.suite());

		return testSuite;
	}

}