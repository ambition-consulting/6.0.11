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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long plid, String actionId)
		throws PortalException, SystemException {

		getLayoutPermission().check(permissionChecker, plid, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId,
			boolean privateLayout, long layoutId, String actionId)
		throws PortalException, SystemException {

		getLayoutPermission().check(
			permissionChecker, groupId, privateLayout, layoutId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, Layout layout, String actionId)
		throws PortalException, SystemException {

		getLayoutPermission().check(permissionChecker, layout, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long plid, String actionId)
		throws PortalException, SystemException {

		return getLayoutPermission().contains(
			permissionChecker, plid, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId,
			boolean privateLayout, long layoutId, String actionId)
		throws PortalException, SystemException {

		return getLayoutPermission().contains(
			permissionChecker, groupId, privateLayout, layoutId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Layout layout, String actionId)
		throws PortalException, SystemException {

		return getLayoutPermission().contains(
			permissionChecker, layout, actionId);
	}

	public static LayoutPermission getLayoutPermission() {
		return _layoutPermission;
	}

	public void setLayoutPermission(LayoutPermission layoutPermission) {
		_layoutPermission = layoutPermission;
	}

	private static LayoutPermission _layoutPermission;

}