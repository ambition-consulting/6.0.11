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

import java.util.List;

/**
 * @author Bruno Farache
 * @author Marcellus Tavares
 */
public interface WorkflowHandlerRegistry {

	public WorkflowHandler getWorkflowHandler(String className);

	public List<WorkflowHandler> getWorkflowHandlers();

	public void register(WorkflowHandler workflowHandler);

	public void unregister(WorkflowHandler workflowHandler);

}