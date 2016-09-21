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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class TeamPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long teamId, String actionId)
		throws PortalException, SystemException {

		getTeamPermission().check(permissionChecker, teamId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, Team team, String actionId)
		throws PortalException, SystemException {

		getTeamPermission().check(permissionChecker, team, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long teamId, String actionId)
		throws PortalException, SystemException {

		return getTeamPermission().contains(
			permissionChecker, teamId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Team team, String actionId)
		throws PortalException, SystemException {

		return getTeamPermission().contains(permissionChecker, team, actionId);
	}

	public static TeamPermission getTeamPermission() {
		return _userGroupPermission;
	}

	public void setTeamPermission(
		TeamPermission userGroupPermission) {

		_userGroupPermission = userGroupPermission;
	}

	private static TeamPermission _userGroupPermission;

}