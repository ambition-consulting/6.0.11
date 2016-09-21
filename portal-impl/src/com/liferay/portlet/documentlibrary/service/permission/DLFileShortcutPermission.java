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

package com.liferay.portlet.documentlibrary.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileShortcutPermission {

	public static void check(
			PermissionChecker permissionChecker, DLFileShortcut fileShortcut,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, fileShortcut, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long fileShortcutId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, fileShortcutId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, DLFileShortcut fileShortcut,
		String actionId) {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, fileShortcut.getGroupId(),
			DLFileShortcut.class.getName(), fileShortcut.getFileShortcutId(),
			PortletKeys.DOCUMENT_LIBRARY, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (permissionChecker.hasOwnerPermission(
				fileShortcut.getCompanyId(), DLFileShortcut.class.getName(),
				fileShortcut.getFileShortcutId(), fileShortcut.getUserId(),
				actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			fileShortcut.getGroupId(), DLFileShortcut.class.getName(),
			fileShortcut.getFileShortcutId(), actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long fileShortcutId,
			String actionId)
		throws PortalException, SystemException {

		DLFileShortcut fileShortcut =
			DLFileShortcutLocalServiceUtil.getFileShortcut(fileShortcutId);

		return contains(permissionChecker, fileShortcut, actionId);
	}

}