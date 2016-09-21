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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.base.UserGroupServiceBaseImpl;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portal.service.permission.UserGroupPermissionUtil;

import java.util.List;

/**
 * @author Charles May
 */
public class UserGroupServiceImpl extends UserGroupServiceBaseImpl {

	public void addGroupUserGroups(long groupId, long[] userGroupIds)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);

		userGroupLocalService.addGroupUserGroups(groupId, userGroupIds);
	}

	public UserGroup addUserGroup(String name, String description)
		throws PortalException, SystemException {

		PortalPermissionUtil.check(
			getPermissionChecker(), ActionKeys.ADD_USER_GROUP);

		User user = getUser();

		return userGroupLocalService.addUserGroup(
			user.getUserId(), user.getCompanyId(), name, description);
	}

	public void deleteUserGroup(long userGroupId)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.DELETE);

		userGroupLocalService.deleteUserGroup(userGroupId);
	}

	public UserGroup getUserGroup(long userGroupId)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.VIEW);

		return userGroupLocalService.getUserGroup(userGroupId);
	}

	public UserGroup getUserGroup(String name)
		throws PortalException, SystemException {

		User user = getUser();

		UserGroup userGroup = userGroupLocalService.getUserGroup(
			user.getCompanyId(), name);

		long userGroupId = userGroup.getUserGroupId();

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.VIEW);

		return userGroup;
	}

	public List<UserGroup> getUserUserGroups(long userId)
		throws SystemException {

		return userGroupLocalService.getUserUserGroups(userId);
	}

	public void unsetGroupUserGroups(long groupId, long[] userGroupIds)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);

		userGroupLocalService.unsetGroupUserGroups(groupId, userGroupIds);
	}

	public UserGroup updateUserGroup(
			long userGroupId, String name, String description)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.UPDATE);

		User user = getUser();

		return userGroupLocalService.updateUserGroup(
			user.getCompanyId(), userGroupId, name, description);
	}

}