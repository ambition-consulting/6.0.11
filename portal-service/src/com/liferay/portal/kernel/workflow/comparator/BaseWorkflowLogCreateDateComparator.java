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
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public abstract class BaseWorkflowLogCreateDateComparator
	extends OrderByComparator {

	public BaseWorkflowLogCreateDateComparator() {
		this(false);
	}

	public BaseWorkflowLogCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		WorkflowLog workflowLog1 = (WorkflowLog)obj1;
		WorkflowLog workflowLog2 = (WorkflowLog)obj2;

		Date createDate1 = workflowLog1.getCreateDate();
		Date createDate2 = workflowLog2.getCreateDate();

		int value = createDate1.compareTo(createDate2);

		if (value != 0) {
			Long workflowLogId1 = workflowLog1.getWorkflowLogId();
			Long workflowLogId2 = workflowLog2.getWorkflowLogId();

			value = workflowLogId1.compareTo(workflowLogId2);
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