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

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 * @author Marcellus Tavares
 */
public class WorkflowTaskManagerUtil {

	public static WorkflowTask assignWorkflowTaskToRole(
			long companyId, long userId, long workflowTaskId, long roleId,
			String comment, Date dueDate,
			Map<String, Serializable> workflowContext)
		throws WorkflowException {

		return _workflowTaskManager.assignWorkflowTaskToRole(
			companyId, userId, workflowTaskId, roleId, comment, dueDate,
			workflowContext);
	}

	public static WorkflowTask assignWorkflowTaskToUser(
			long companyId, long userId, long workflowTaskId,
			long assigneeUserId, String comment, Date dueDate,
			Map<String, Serializable> workflowContext)
		throws WorkflowException {

		return _workflowTaskManager.assignWorkflowTaskToUser(
			companyId, userId, workflowTaskId, assigneeUserId, comment, dueDate,
			workflowContext);
	}

	public static WorkflowTask completeWorkflowTask(
			long companyId, long userId, long workflowTaskId,
			String transitionName, String comment,
			Map<String, Serializable> workflowContext)
		throws WorkflowException {

		return _workflowTaskManager.completeWorkflowTask(
			companyId, userId, workflowTaskId, transitionName, comment,
			workflowContext);
	}

	public static List<String> getNextTransitionNames(
			long companyId, long userId, long workflowTaskId)
		throws WorkflowException {

		return _workflowTaskManager.getNextTransitionNames(
			companyId, userId, workflowTaskId);
	}

	public static long[] getPooledActorsIds(long companyId, long workflowTaskId)
		throws WorkflowException {

		return _workflowTaskManager.getPooledActorsIds(
			companyId, workflowTaskId);
	}

	public static WorkflowTask getWorkflowTask(
			long companyId, long workflowTaskId)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTask(companyId, workflowTaskId);
	}

	public static int getWorkflowTaskCount(long companyId, Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCount(companyId, completed);
	}

	public static int getWorkflowTaskCountByRole(
			long companyId, long roleId, Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCountByRole(
			companyId, roleId, completed);
	}

	public static int getWorkflowTaskCountBySubmittingUser(
			long companyId, long userId, Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCountBySubmittingUser(
			companyId, userId, completed);
	}

	public static int getWorkflowTaskCountByUser(
			long companyId, long userId, Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCountByUser(
			companyId, userId, completed);
	}

	public static int getWorkflowTaskCountByUserRoles(
			long companyId, long userId, Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCountByUserRoles(
			companyId, userId, completed);
	}

	public static int getWorkflowTaskCountByWorkflowInstance(
			long companyId, Long userId, long workflowInstanceId,
			Boolean completed)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTaskCountByWorkflowInstance(
			companyId, userId, workflowInstanceId, completed);
	}

	public static WorkflowTaskManager getWorkflowTaskManager() {
		return _workflowTaskManager;
	}

	public static List<WorkflowTask> getWorkflowTasks(
			long companyId, Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasks(
			companyId, completed, start, end, orderByComparator);
	}

	public static List<WorkflowTask> getWorkflowTasksByRole(
			long companyId, long roleId, Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasksByRole(
			companyId, roleId, completed, start, end, orderByComparator);
	}

	public static List<WorkflowTask> getWorkflowTasksBySubmittingUser(
			long companyId, long userId, Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasksBySubmittingUser(
			companyId, userId, completed, start, end, orderByComparator);
	}

	public static List<WorkflowTask> getWorkflowTasksByUser(
			long companyId, long userId, Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasksByUser(
			companyId, userId, completed, start, end, orderByComparator);
	}

	public static List<WorkflowTask> getWorkflowTasksByUserRoles(
			long companyId, long userId, Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasksByUserRoles(
			companyId, userId, completed, start, end, orderByComparator);
	}

	public static List<WorkflowTask> getWorkflowTasksByWorkflowInstance(
			long companyId, Long userId, long workflowInstanceId,
			Boolean completed, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.getWorkflowTasksByWorkflowInstance(
			companyId, userId, workflowInstanceId, completed, start, end,
			orderByComparator);
	}

	public static List<WorkflowTask> search(
			long companyId, long userId, String keywords, Boolean completed,
			Boolean searchByUserRoles, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.search(
			companyId, userId, keywords, completed,	searchByUserRoles, start,
			end, orderByComparator);
	}

	public static List<WorkflowTask> search(
			long companyId, long userId, String taskName, String assetType,
			Date dueDateGT, Date dueDateLT, Boolean completed,
			Boolean searchByUserRoles, boolean andOperator, int start, int end,
			OrderByComparator orderByComparator)
		throws WorkflowException {

		return _workflowTaskManager.search(
			companyId, userId, taskName, assetType, dueDateGT, dueDateLT,
			completed, searchByUserRoles, andOperator, start, end,
			orderByComparator);
	}

	public static int searchCount(
			long companyId, long userId, String keywords, Boolean completed,
			Boolean searchByUserRoles)
		throws WorkflowException {

		return _workflowTaskManager.searchCount(
			companyId, userId, keywords, completed,	searchByUserRoles);
	}

	public static int searchCount(
		long companyId, long userId, String taskName, String assetType,
			Date dueDateGT, Date dueDateLT, Boolean completed,
			Boolean searchByUserRoles, boolean andOperator)
		throws WorkflowException {

		return _workflowTaskManager.searchCount(
			companyId, userId, taskName, assetType, dueDateGT, dueDateLT,
			completed, searchByUserRoles, andOperator);
	}

	public static WorkflowTask updateDueDate(
			long companyId, long userId, long workflowTaskId, String comment,
			Date dueDate)
		throws WorkflowException {

		return _workflowTaskManager.updateDueDate(
			companyId, userId, workflowTaskId, comment, dueDate);
	}

	public void setWorkflowTaskManager(
		WorkflowTaskManager workflowTaskManager) {

		_workflowTaskManager = workflowTaskManager;
	}

	private static WorkflowTaskManager _workflowTaskManager;

}