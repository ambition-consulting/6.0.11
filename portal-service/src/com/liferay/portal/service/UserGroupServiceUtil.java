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
 * The utility for the user group remote service. This utility wraps {@link com.liferay.portal.service.impl.UserGroupServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupService
 * @see com.liferay.portal.service.base.UserGroupServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserGroupServiceImpl
 * @generated
 */
public class UserGroupServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserGroupServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addGroupUserGroups(long groupId, long[] userGroupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addGroupUserGroups(groupId, userGroupIds);
	}

	public static com.liferay.portal.model.UserGroup addUserGroup(
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserGroup(name, description);
	}

	public static void deleteUserGroup(long userGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroup(userGroupId);
	}

	public static com.liferay.portal.model.UserGroup getUserGroup(
		long userGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroup(userGroupId);
	}

	public static com.liferay.portal.model.UserGroup getUserGroup(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroup(name);
	}

	public static java.util.List<com.liferay.portal.model.UserGroup> getUserUserGroups(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserUserGroups(userId);
	}

	public static void unsetGroupUserGroups(long groupId, long[] userGroupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unsetGroupUserGroups(groupId, userGroupIds);
	}

	public static com.liferay.portal.model.UserGroup updateUserGroup(
		long userGroupId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroup(userGroupId, name, description);
	}

	public static UserGroupService getService() {
		if (_service == null) {
			_service = (UserGroupService)PortalBeanLocatorUtil.locate(UserGroupService.class.getName());

			ReferenceRegistry.registerReference(UserGroupServiceUtil.class,
				"_service");
			MethodCache.remove(UserGroupService.class);
		}

		return _service;
	}

	public void setService(UserGroupService service) {
		MethodCache.remove(UserGroupService.class);

		_service = service;

		ReferenceRegistry.registerReference(UserGroupServiceUtil.class,
			"_service");
		MethodCache.remove(UserGroupService.class);
	}

	private static UserGroupService _service;
}