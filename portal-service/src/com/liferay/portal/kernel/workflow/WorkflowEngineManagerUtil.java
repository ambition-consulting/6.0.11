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

import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WorkflowEngineManagerUtil {

	public static String getKey() {
		return _workflowEngineManager.getKey();
	}

	public static String getName() {
		return _workflowEngineManager.getName();
	}

	public static Map<String, Object> getOptionalAttributes() {
		return _workflowEngineManager.getOptionalAttributes();
	}

	public static String getVersion() {
		return _workflowEngineManager.getVersion();
	}

	public static WorkflowEngineManager getWorkflowEngineManager() {
		return _workflowEngineManager;
	}

	public static boolean isDeployed() {
		if (MessageBusUtil.hasMessageListener(
				DestinationNames.WORKFLOW_ENGINE)) {

			return true;
		}
		else {
			return false;
		}
	}

	public void setWorkflowEngineManager(
		WorkflowEngineManager workflowEngineManager) {

		_workflowEngineManager = workflowEngineManager;
	}

	private static WorkflowEngineManager _workflowEngineManager;

}