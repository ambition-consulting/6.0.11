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

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class WorkflowLogManagerUtil {

	public static int getWorkflowLogCountByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes)
		throws WorkflowException {

		return _workflowLogManager.getWorkflowLogCountByWorkflowInstance(
			companyId, workflowInstanceId, logTypes);
	}

	public static int getWorkflowLogCountByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes)
		throws WorkflowException {

		return _workflowLogManager.getWorkflowLogCountByWorkflowTask(
			companyId, workflowTaskId, logTypes);
	}

	public static WorkflowLogManager getWorkflowLogManager() {
		return _workflowLogManager;
	}

	public static List<WorkflowLog> getWorkflowLogsByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes,
			int start, int end, OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowLogManager.getWorkflowLogsByWorkflowInstance(
			companyId, workflowInstanceId, logTypes,
			start, end, orderByComparator);
	}

	public static List<WorkflowLog> getWorkflowLogsByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes,
			int start, int end, OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowLogManager.getWorkflowLogsByWorkflowTask(
			companyId, workflowTaskId, logTypes,
			start, end, orderByComparator);
	}

	public void setWorkflowLogManager(WorkflowLogManager workflowLogManager) {
		_workflowLogManager = workflowLogManager;
	}

	private static WorkflowLogManager _workflowLogManager;

}