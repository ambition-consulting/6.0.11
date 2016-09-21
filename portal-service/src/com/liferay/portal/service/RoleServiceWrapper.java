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
 * This class is a wrapper for {@link RoleService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RoleService
 * @generated
 */
public class RoleServiceWrapper implements RoleService {
	public RoleServiceWrapper(RoleService roleService) {
		_roleService = roleService;
	}

	public com.liferay.portal.model.Role addRole(java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.lang.String description, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.addRole(name, titleMap, description, type);
	}

	public void addUserRoles(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roleService.addUserRoles(userId, roleIds);
	}

	public void deleteRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roleService.deleteRole(roleId);
	}

	public java.util.List<com.liferay.portal.model.Role> getGroupRoles(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getGroupRoles(groupId);
	}

	public com.liferay.portal.model.Role getRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getRole(roleId);
	}

	public com.liferay.portal.model.Role getRole(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getRole(companyId, name);
	}

	public java.util.List<com.liferay.portal.model.Role> getUserGroupGroupRoles(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getUserGroupGroupRoles(userId, groupId);
	}

	public java.util.List<com.liferay.portal.model.Role> getUserGroupRoles(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getUserGroupRoles(userId, groupId);
	}

	public java.util.List<com.liferay.portal.model.Role> getUserRelatedRoles(
		long userId, java.util.List<com.liferay.portal.model.Group> groups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getUserRelatedRoles(userId, groups);
	}

	public java.util.List<com.liferay.portal.model.Role> getUserRoles(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _roleService.getUserRoles(userId);
	}

	public boolean hasUserRole(long userId, long companyId,
		java.lang.String name, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.hasUserRole(userId, companyId, name, inherited);
	}

	public boolean hasUserRoles(long userId, long companyId,
		java.lang.String[] names, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.hasUserRoles(userId, companyId, names, inherited);
	}

	public void unsetUserRoles(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roleService.unsetUserRoles(userId, roleIds);
	}

	public com.liferay.portal.model.Role updateRole(long roleId,
		java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.lang.String description, java.lang.String subtype)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roleService.updateRole(roleId, name, titleMap, description,
			subtype);
	}

	public RoleService getWrappedRoleService() {
		return _roleService;
	}

	public void setWrappedRoleService(RoleService roleService) {
		_roleService = roleService;
	}

	private RoleService _roleService;
}