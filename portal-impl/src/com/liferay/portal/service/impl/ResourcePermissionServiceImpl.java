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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.base.ResourcePermissionServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourcePermissionServiceImpl
	extends ResourcePermissionServiceBaseImpl {

	public void addResourcePermission(
			long groupId, long companyId, String name, int scope,
			String primKey, long roleId, String actionId)
		throws PortalException, SystemException {

		permissionService.checkPermission(
			groupId, Role.class.getName(), roleId);

		resourcePermissionLocalService.addResourcePermission(
			companyId, name, scope, primKey, roleId, actionId);
	}

	public void setIndividualResourcePermissions(
			long groupId, long companyId, String name, String primKey,
			long roleId, String[] actionIds)
		throws PortalException, SystemException {

		permissionService.checkPermission(groupId, name, primKey);

		resourcePermissionLocalService.setResourcePermissions(
			companyId, name, ResourceConstants.SCOPE_INDIVIDUAL, primKey,
			roleId, actionIds);
	}

	public void removeResourcePermission(
			long groupId, long companyId, String name, int scope,
			String primKey, long roleId, String actionId)
		throws PortalException, SystemException {

		permissionService.checkPermission(
			groupId, Role.class.getName(), roleId);

		resourcePermissionLocalService.removeResourcePermission(
			companyId, name, scope, primKey, roleId, actionId);
	}

	public void removeResourcePermissions(
			long groupId, long companyId, String name, int scope, long roleId,
			String actionId)
		throws PortalException, SystemException {

		permissionService.checkPermission(
			groupId, Role.class.getName(), roleId);

		resourcePermissionLocalService.removeResourcePermissions(
			companyId, name, scope, roleId, actionId);
	}

}