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

package com.liferay.portal.kernel.workflow.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowTask;

/**
 * @author Shuyang Zhou
 */
public abstract class BaseWorkflowTaskUserIdComparator
	extends OrderByComparator {

	public BaseWorkflowTaskUserIdComparator() {
		this(false);
	}

	public BaseWorkflowTaskUserIdComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		WorkflowTask workflowTask1 = (WorkflowTask)obj1;
		WorkflowTask workflowTask2 = (WorkflowTask)obj2;

		Long assigneeUserId1 = workflowTask1.getAssigneeUserId();
		Long assigneeUserId2 = workflowTask2.getAssigneeUserId();

		int value = assigneeUserId1.compareTo(assigneeUserId2);

		if (value == 0) {
			Long workflowTaskId1 = workflowTask1.getWorkflowTaskId();
			Long workflowTaskId2 = workflowTask2.getWorkflowTaskId();

			value = workflowTaskId1.compareTo(workflowTaskId2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}