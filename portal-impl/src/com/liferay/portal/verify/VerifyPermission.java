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

package com.liferay.portal.verify;

import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.util.PropsValues;

import java.util.List;

/**
 * @author Tobias Kaefer
 */
public class VerifyPermission extends VerifyProcess {

	protected void doVerify() throws Exception {
		if (PropsValues.PERMISSIONS_USER_CHECK_ALGORITHM != 6) {
			return;
		}

		List<String> modelNames = ResourceActionsUtil.getModelNames();

		for (String modelName : modelNames) {
			List<String> actionIds =
				ResourceActionsUtil.getModelResourceActions(modelName);

			ResourceActionLocalServiceUtil.checkResourceActions(
				modelName, actionIds);
		}
	}

}