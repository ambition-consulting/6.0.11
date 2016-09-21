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
 * This class is a wrapper for {@link ResourcePermissionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourcePermissionService
 * @generated
 */
public class ResourcePermissionServiceWrapper
	implements ResourcePermissionService {
	public ResourcePermissionServiceWrapper(
		ResourcePermissionService resourcePermissionService) {
		_resourcePermissionService = resourcePermissionService;
	}

	public void addResourcePermission(long groupId, long companyId,
		java.lang.String name, int scope, java.lang.String primKey,
		long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourcePermissionService.addResourcePermission(groupId, companyId,
			name, scope, primKey, roleId, actionId);
	}

	public void setIndividualResourcePermissions(long groupId, long companyId,
		java.lang.String name, java.lang.String primKey, long roleId,
		java.lang.String[] actionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourcePermissionService.setIndividualResourcePermissions(groupId,
			companyId, name, primKey, roleId, actionIds);
	}

	public void removeResourcePermission(long groupId, long companyId,
		java.lang.String name, int scope, java.lang.String primKey,
		long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourcePermissionService.removeResourcePermission(groupId, companyId,
			name, scope, primKey, roleId, actionId);
	}

	public void removeResourcePermissions(long groupId, long companyId,
		java.lang.String name, int scope, long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourcePermissionService.removeResourcePermissions(groupId,
			companyId, name, scope, roleId, actionId);
	}

	public ResourcePermissionService getWrappedResourcePermissionService() {
		return _resourcePermissionService;
	}

	public void setWrappedResourcePermissionService(
		ResourcePermissionService resourcePermissionService) {
		_resourcePermissionService = resourcePermissionService;
	}

	private ResourcePermissionService _resourcePermissionService;
}