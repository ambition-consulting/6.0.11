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

package com.liferay.portlet.shopping.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.shopping.model.ShoppingOrder;
import com.liferay.portlet.shopping.service.ShoppingOrderLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderPermission {

	public static void check(
			PermissionChecker permissionChecker, long groupId, long orderId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, orderId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId,
			ShoppingOrder order, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, order, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long orderId,
			String actionId)
		throws PortalException, SystemException {

		ShoppingOrder order =
			ShoppingOrderLocalServiceUtil.getOrder(orderId);

		return contains(permissionChecker, groupId, order, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, ShoppingOrder order,
		String actionId) {

		if (ShoppingPermission.contains(
				permissionChecker, groupId, ActionKeys.MANAGE_ORDERS)) {

			return true;
		}
		else {
			if (permissionChecker.hasOwnerPermission(
					order.getCompanyId(), ShoppingOrder.class.getName(),
					order.getOrderId(), order.getUserId(), actionId)) {

				return true;
			}

			return permissionChecker.hasPermission(
				order.getGroupId(), ShoppingOrder.class.getName(),
				order.getOrderId(), actionId);
		}
	}

}