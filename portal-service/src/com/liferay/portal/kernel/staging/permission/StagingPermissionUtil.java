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

package com.liferay.portal.kernel.staging.permission;

import com.liferay.portal.model.Group;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Jorge Ferrer
 */
public class StagingPermissionUtil {

	public static  Boolean hasPermission(
		PermissionChecker permissionChecker, Group group, String className,
		long classPK, String portletId, String actionId) {

		return _stagingPermission.hasPermission(
			permissionChecker, group, className, classPK, portletId, actionId);
	}

	public static Boolean hasPermission(
		PermissionChecker permissionChecker, long groupId, String className,
		long classPK, String portletId, String actionId) {

		return _stagingPermission.hasPermission(
			permissionChecker, groupId, className, classPK, portletId,
			actionId);
	}

	public void setStagingPermission(StagingPermission stagingPermission) {
		_stagingPermission = stagingPermission;
	}

	private static StagingPermission _stagingPermission;

}