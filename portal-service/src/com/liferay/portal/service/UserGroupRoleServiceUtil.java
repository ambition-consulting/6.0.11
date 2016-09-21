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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the user group role remote service. This utility wraps {@link com.liferay.portal.service.impl.UserGroupRoleServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRoleService
 * @see com.liferay.portal.service.base.UserGroupRoleServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserGroupRoleServiceImpl
 * @generated
 */
public class UserGroupRoleServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserGroupRoleServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addUserGroupRoles(long userId, long groupId,
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupRoles(userId, groupId, roleIds);
	}

	public static void addUserGroupRoles(long[] userIds, long groupId,
		long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupRoles(userIds, groupId, roleId);
	}

	public static void deleteUserGroupRoles(long userId, long groupId,
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userId, groupId, roleIds);
	}

	public static void deleteUserGroupRoles(long[] userIds, long groupId,
		long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userIds, groupId, roleId);
	}

	public static UserGroupRoleService getService() {
		if (_service == null) {
			_service = (UserGroupRoleService)PortalBeanLocatorUtil.locate(UserGroupRoleService.class.getName());

			ReferenceRegistry.registerReference(UserGroupRoleServiceUtil.class,
				"_service");
			MethodCache.remove(UserGroupRoleService.class);
		}

		return _service;
	}

	public void setService(UserGroupRoleService service) {
		MethodCache.remove(UserGroupRoleService.class);

		_service = service;

		ReferenceRegistry.registerReference(UserGroupRoleServiceUtil.class,
			"_service");
		MethodCache.remove(UserGroupRoleService.class);
	}

	private static UserGroupRoleService _service;
}