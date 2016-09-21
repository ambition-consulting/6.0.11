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

package com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment;

import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.addtaskwebcontentcommentassignedtome.AddTaskWebContentCommentAssignedToMeTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.addtaskwebcontentcommentassignedtomyroles.AddTaskWebContentCommentAssignedToMyRolesTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.addtaskwebcontentcommentcompleted.AddTaskWebContentCommentCompletedTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.assertnoworkflowaddtaskcommentassignedtome.AssertNoWorkflowAddTaskCommentAssignedToMeTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.assertnoworkflowaddtaskcommentassigntomyroles.AssertNoWorkflowAddTaskCommentAssignToMyRolesTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.assertnoworkflowaddtaskcommentcompleted.AssertNoWorkflowAddTaskCommentCompletedTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.viewtaskwebcontentcommentassignedtome.ViewTaskWebContentCommentAssignedToMeTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.viewtaskwebcontentcommentassignedtomyroles.ViewTaskWebContentCommentAssignedToMyRolesTests;
import com.liferay.portalweb.plugins.kaleo.workflow.workflowtaskcomment.viewtaskwebcontentcommentcompleted.ViewTaskWebContentCommentCompletedTests;
import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WorkflowTaskCommentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddTaskWebContentCommentAssignedToMeTests.suite());
		testSuite.addTest(
			AddTaskWebContentCommentAssignedToMyRolesTests.suite());
		testSuite.addTest(AddTaskWebContentCommentCompletedTests.suite());
		testSuite.addTest(
			AssertNoWorkflowAddTaskCommentAssignedToMeTests.suite());
		testSuite.addTest(
			AssertNoWorkflowAddTaskCommentAssignToMyRolesTests.suite());
		testSuite.addTest(AssertNoWorkflowAddTaskCommentCompletedTests.suite());
		testSuite.addTest(ViewTaskWebContentCommentAssignedToMeTests.suite());
		testSuite.addTest(
			ViewTaskWebContentCommentAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewTaskWebContentCommentCompletedTests.suite());

		return testSuite;
	}

}