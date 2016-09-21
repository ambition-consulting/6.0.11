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

package com.liferay.portalweb.plugins.kaleo;

import com.liferay.portalweb.plugins.kaleo.assetpublisher.AssetPublisherTests;
import com.liferay.portalweb.plugins.kaleo.mysubmissions.MySubmissionsTests;
import com.liferay.portalweb.plugins.kaleo.myworkflowtasks.MyWorkflowTasksTests;
import com.liferay.portalweb.plugins.kaleo.scope.ScopeTests;
import com.liferay.portalweb.plugins.kaleo.webcontent.WebContentTests;
import com.liferay.portalweb.plugins.kaleo.webcontentdisplay.WebContentDisplayTests;
import com.liferay.portalweb.plugins.kaleo.workflow.WorkflowTests;
import com.liferay.portalweb.plugins.kaleo.workflowconfiguration.WorkflowConfigurationTests;
import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AssetPublisherTests.suite());
		testSuite.addTest(MySubmissionsTests.suite());
		testSuite.addTest(MyWorkflowTasksTests.suite());
		testSuite.addTest(ScopeTests.suite());
		testSuite.addTest(WebContentTests.suite());
		testSuite.addTest(WebContentDisplayTests.suite());
		testSuite.addTest(WorkflowTests.suite());
		testSuite.addTest(WorkflowConfigurationTests.suite());

		return testSuite;
	}

}