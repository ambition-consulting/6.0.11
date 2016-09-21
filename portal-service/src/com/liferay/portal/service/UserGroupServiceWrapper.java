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
 * This class is a wrapper for {@link UserGroupService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserGroupService
 * @generated
 */
public class UserGroupServiceWrapper implements UserGroupService {
	public UserGroupServiceWrapper(UserGroupService userGroupService) {
		_userGroupService = userGroupService;
	}

	public void addGroupUserGroups(long groupId, long[] userGroupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupService.addGroupUserGroups(groupId, userGroupIds);
	}

	public com.liferay.portal.model.UserGroup addUserGroup(
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupService.addUserGroup(name, description);
	}

	public void deleteUserGroup(long userGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupService.deleteUserGroup(userGroupId);
	}

	public com.liferay.portal.model.UserGroup getUserGroup(long userGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupService.getUserGroup(userGroupId);
	}

	public com.liferay.portal.model.UserGroup getUserGroup(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupService.getUserGroup(name);
	}

	public java.util.List<com.liferay.portal.model.UserGroup> getUserUserGroups(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupService.getUserUserGroups(userId);
	}

	public void unsetGroupUserGroups(long groupId, long[] userGroupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupService.unsetGroupUserGroups(groupId, userGroupIds);
	}

	public com.liferay.portal.model.UserGroup updateUserGroup(
		long userGroupId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupService.updateUserGroup(userGroupId, name, description);
	}

	public UserGroupService getWrappedUserGroupService() {
		return _userGroupService;
	}

	public void setWrappedUserGroupService(UserGroupService userGroupService) {
		_userGroupService = userGroupService;
	}

	private UserGroupService _userGroupService;
}