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
 * This class is a wrapper for {@link PermissionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PermissionService
 * @generated
 */
public class PermissionServiceWrapper implements PermissionService {
	public PermissionServiceWrapper(PermissionService permissionService) {
		_permissionService = permissionService;
	}

	public void checkPermission(long groupId, long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.checkPermission(groupId, resourceId);
	}

	public void checkPermission(long groupId, java.lang.String name,
		long primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.checkPermission(groupId, name, primKey);
	}

	public void checkPermission(long groupId, java.lang.String name,
		java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.checkPermission(groupId, name, primKey);
	}

	public boolean hasGroupPermission(long groupId, java.lang.String actionId,
		long resourceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permissionService.hasGroupPermission(groupId, actionId,
			resourceId);
	}

	public boolean hasUserPermission(long userId, java.lang.String actionId,
		long resourceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permissionService.hasUserPermission(userId, actionId, resourceId);
	}

	public boolean hasUserPermissions(long userId, long groupId,
		java.util.List<com.liferay.portal.model.Resource> resources,
		java.lang.String actionId,
		com.liferay.portal.security.permission.PermissionCheckerBag permissionCheckerBag)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permissionService.hasUserPermissions(userId, groupId,
			resources, actionId, permissionCheckerBag);
	}

	public void setGroupPermissions(long groupId, java.lang.String[] actionIds,
		long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setGroupPermissions(groupId, actionIds, resourceId);
	}

	public void setGroupPermissions(java.lang.String className,
		java.lang.String classPK, long groupId, java.lang.String[] actionIds,
		long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setGroupPermissions(className, classPK, groupId,
			actionIds, resourceId);
	}

	public void setOrgGroupPermissions(long organizationId, long groupId,
		java.lang.String[] actionIds, long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setOrgGroupPermissions(organizationId, groupId,
			actionIds, resourceId);
	}

	public void setRolePermission(long roleId, long groupId,
		java.lang.String name, int scope, java.lang.String primKey,
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setRolePermission(roleId, groupId, name, scope,
			primKey, actionId);
	}

	public void setRolePermissions(long roleId, long groupId,
		java.lang.String[] actionIds, long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setRolePermissions(roleId, groupId, actionIds,
			resourceId);
	}

	public void setUserPermissions(long userId, long groupId,
		java.lang.String[] actionIds, long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.setUserPermissions(userId, groupId, actionIds,
			resourceId);
	}

	public void unsetRolePermission(long roleId, long groupId, long permissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.unsetRolePermission(roleId, groupId, permissionId);
	}

	public void unsetRolePermission(long roleId, long groupId,
		java.lang.String name, int scope, java.lang.String primKey,
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.unsetRolePermission(roleId, groupId, name, scope,
			primKey, actionId);
	}

	public void unsetRolePermissions(long roleId, long groupId,
		java.lang.String name, int scope, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.unsetRolePermissions(roleId, groupId, name, scope,
			actionId);
	}

	public void unsetUserPermissions(long userId, long groupId,
		java.lang.String[] actionIds, long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_permissionService.unsetUserPermissions(userId, groupId, actionIds,
			resourceId);
	}

	public PermissionService getWrappedPermissionService() {
		return _permissionService;
	}

	public void setWrappedPermissionService(PermissionService permissionService) {
		_permissionService = permissionService;
	}

	private PermissionService _permissionService;
}