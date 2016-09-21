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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link UserGroupRoleService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserGroupRoleService
 * @generated
 */
public class UserGroupRoleServiceWrapper implements UserGroupRoleService {
	public UserGroupRoleServiceWrapper(
		UserGroupRoleService userGroupRoleService) {
		_userGroupRoleService = userGroupRoleService;
	}

	public void addUserGroupRoles(long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleService.addUserGroupRoles(userId, groupId, roleIds);
	}

	public void addUserGroupRoles(long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleService.addUserGroupRoles(userIds, groupId, roleId);
	}

	public void deleteUserGroupRoles(long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleService.deleteUserGroupRoles(userId, groupId, roleIds);
	}

	public void deleteUserGroupRoles(long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleService.deleteUserGroupRoles(userIds, groupId, roleId);
	}

	public UserGroupRoleService getWrappedUserGroupRoleService() {
		return _userGroupRoleService;
	}

	public void setWrappedUserGroupRoleService(
		UserGroupRoleService userGroupRoleService) {
		_userGroupRoleService = userGroupRoleService;
	}

	private UserGroupRoleService _userGroupRoleService;
}