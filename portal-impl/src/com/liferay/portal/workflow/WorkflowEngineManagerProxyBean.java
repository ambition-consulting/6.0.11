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

package com.liferay.portal.workflow;

import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;
import com.liferay.portal.kernel.workflow.WorkflowEngineManager;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WorkflowEngineManagerProxyBean
	extends BaseProxyBean implements WorkflowEngineManager {

	public String getKey() {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public Map<String, Object> getOptionalAttributes() {
		throw new UnsupportedOperationException();
	}

	public String getVersion() {
		throw new UnsupportedOperationException();
	}

}