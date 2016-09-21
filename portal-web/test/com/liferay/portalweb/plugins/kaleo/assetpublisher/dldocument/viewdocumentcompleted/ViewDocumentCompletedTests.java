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

package com.liferay.portalweb.plugins.kaleo.assetpublisher.dldocument.viewdocumentcompleted;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDocumentCompletedTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(ConfigureDocumentSingleApproverTest.class);
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddAPDocumentTest.class);
		testSuite.addTestSuite(AssignToMeDocumentActionsTest.class);
		testSuite.addTestSuite(ApproveDocumentActionsTest.class);
		testSuite.addTestSuite(ViewDocumentCompletedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(ViewDocumentCompletedGuestTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownDocumentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);

		return testSuite;
	}

}