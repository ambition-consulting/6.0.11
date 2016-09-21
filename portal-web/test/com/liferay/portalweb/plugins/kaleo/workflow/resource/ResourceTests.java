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

package com.liferay.portalweb.plugins.kaleo.workflow.resource;

import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfigureblogsentrysingleapprover.DefaultConfigureBlogsEntrySingleApproverTests;
import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfigurecommentssingleapprover.DefaultConfigureCommentsSingleApproverTests;
import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfiguredldocumentsingleapprover.DefaultConfigureDLDocumentSingleApproverTests;
import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfigurembmessagesingleapprover.DefaultConfigureMBMessageSingleApproverTests;
import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfigurewebcontentsingleapprover.DefaultConfigureWebContentSingleApproverTests;
import com.liferay.portalweb.plugins.kaleo.workflow.resource.defaultconfigurewikipagesingleapprover.DefaultConfigureWikiPageSingleApproverTests;
import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(
			DefaultConfigureBlogsEntrySingleApproverTests.suite());
		testSuite.addTest(DefaultConfigureCommentsSingleApproverTests.suite());
		testSuite.addTest(
			DefaultConfigureDLDocumentSingleApproverTests.suite());
		testSuite.addTest(DefaultConfigureMBMessageSingleApproverTests.suite());
		testSuite.addTest(
			DefaultConfigureWebContentSingleApproverTests.suite());
		testSuite.addTest(DefaultConfigureWikiPageSingleApproverTests.suite());

		return testSuite;
	}

}