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

package com.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleFinderUtil {
	public static int countByR_U(long roleId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByR_U(roleId, userId);
	}

	public static int countByU_G_R(long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByU_G_R(userId, groupId, roleId);
	}

	public static int countByC_N_D_T(long companyId, java.lang.String name,
		java.lang.String description, java.lang.Integer[] types,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_N_D_T(companyId, name, description, types, params,
			andOperator);
	}

	public static int countByC_N_D_T(long companyId, java.lang.String[] names,
		java.lang.String[] descriptions, java.lang.Integer[] types,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_N_D_T(companyId, names, descriptions, types,
			params, andOperator);
	}

	public static int countByKeywords(long companyId,
		java.lang.String keywords, java.lang.Integer[] types)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeywords(companyId, keywords, types);
	}

	public static java.util.List<com.liferay.portal.model.Role> findBySystem(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBySystem(companyId);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByUserGroupGroupRole(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByUserGroupGroupRole(userId, groupId);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByUserGroupRole(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByUserGroupRole(userId, groupId);
	}

	public static com.liferay.portal.model.Role findByC_N(long companyId,
		java.lang.String name)
		throws com.liferay.portal.NoSuchRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByC_N(companyId, name);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByU_G(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByU_G(userId, groupId);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByU_G(
		long userId, long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByU_G(userId, groupIds);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByU_G(
		long userId, java.util.List<com.liferay.portal.model.Group> groups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByU_G(userId, groups);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByC_N_D_T(
		long companyId, java.lang.String name, java.lang.String description,
		java.lang.Integer[] types,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_N_D_T(companyId, name, description, types, params,
			andOperator, start, end, obc);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByC_N_D_T(
		long companyId, java.lang.String[] names,
		java.lang.String[] descriptions, java.lang.Integer[] types,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_N_D_T(companyId, names, descriptions, types,
			params, andOperator, start, end, obc);
	}

	public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> findByC_N_S_P(
		long companyId, java.lang.String name, int scope,
		java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByC_N_S_P(companyId, name, scope, primKey);
	}

	public static java.util.List<com.liferay.portal.model.Role> findByKeywords(
		long companyId, java.lang.String keywords, java.lang.Integer[] types,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeywords(companyId, keywords, types, start, end, obc);
	}

	public static RoleFinder getFinder() {
		if (_finder == null) {
			_finder = (RoleFinder)PortalBeanLocatorUtil.locate(RoleFinder.class.getName());

			ReferenceRegistry.registerReference(RoleFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(RoleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(RoleFinderUtil.class, "_finder");
	}

	private static RoleFinder _finder;
}