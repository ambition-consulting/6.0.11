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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PropsValues;

/**
 * @author Charles May
 * @author Jorge Ferrer
 */
public class UserPermissionImpl implements UserPermission {

	/**
	 * @deprecated
	 */
	public void check(
			PermissionChecker permissionChecker, long userId,
			long organizationId, long locationId, String actionId)
		throws PrincipalException {

		check(
			permissionChecker, userId, new long[] {organizationId, locationId},
			actionId);
	}

	public void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException {

		if (!contains(
				permissionChecker, userId, organizationIds, actionId)) {

			throw new PrincipalException();
		}
	}

	public void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException {

		if (!contains(permissionChecker, userId, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * @deprecated
	 */
	public boolean contains(
		PermissionChecker permissionChecker, long userId, long organizationId,
		long locationId, String actionId) {

		return contains(
			permissionChecker, userId, new long[] {organizationId, locationId},
			actionId);
	}

	public boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId) {

		if (((PropsValues.PERMISSIONS_USER_CHECK_ALGORITHM == 5 ||
			  PropsValues.PERMISSIONS_USER_CHECK_ALGORITHM == 6) &&
			 (permissionChecker.hasOwnerPermission(
				permissionChecker.getCompanyId(), User.class.getName(), userId,
				userId, actionId))) ||
			(permissionChecker.getUserId() == userId)) {

			return true;
		}
		else if (permissionChecker.hasPermission(
					0, User.class.getName(), userId, actionId)) {

			return true;
		}
		else if (userId != ResourceConstants.PRIMKEY_DNE) {
			try {
				if (organizationIds == null) {
					User user = UserLocalServiceUtil.getUserById(userId);

					organizationIds = user.getOrganizationIds();
				}

				for (int i = 0; i < organizationIds.length; i++) {
					long organizationId = organizationIds[i];

					if (OrganizationPermissionUtil.contains(
							permissionChecker, organizationId,
							ActionKeys.MANAGE_USERS)) {

						return true;
					}
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}

		return false;
	}

	public boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId) {

		return contains(permissionChecker, userId, null, actionId);
	}

	private static Log _log = LogFactoryUtil.getLog(UserPermissionImpl.class);

}