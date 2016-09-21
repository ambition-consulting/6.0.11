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

package com.liferay.portlet.imagegallery.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGFolderConstants;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class IGFolderPermission {

	public static void check(
			PermissionChecker permissionChecker, IGFolder folder,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, folder, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, folderId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, IGFolder folder,
			String actionId)
		throws PortalException, SystemException {

		if (actionId.equals(ActionKeys.ADD_FOLDER)) {
			actionId = ActionKeys.ADD_SUBFOLDER;
		}

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, folder.getGroupId(), IGFolder.class.getName(),
			folder.getFolderId(), PortletKeys.IMAGE_GALLERY, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		long folderId = folder.getFolderId();

		if (actionId.equals(ActionKeys.VIEW)) {
			while (folderId != IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
				folder = IGFolderLocalServiceUtil.getFolder(folderId);

				folderId = folder.getParentFolderId();

				if (!permissionChecker.hasOwnerPermission(
						folder.getCompanyId(), IGFolder.class.getName(),
						folder.getFolderId(), folder.getUserId(), actionId) &&
					!permissionChecker.hasPermission(
						folder.getGroupId(), IGFolder.class.getName(),
						folder.getFolderId(), actionId)) {

					return false;
				}

				if (!PropsValues.PERMISSIONS_VIEW_DYNAMIC_INHERITANCE) {
					break;
				}
			}

			return true;
		}
		else {
			while (folderId != IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
				if (permissionChecker.hasOwnerPermission(
						folder.getCompanyId(), IGFolder.class.getName(),
						folder.getFolderId(), folder.getUserId(), actionId)) {

					return true;
				}

				if (permissionChecker.hasPermission(
						folder.getGroupId(), IGFolder.class.getName(),
						folder.getFolderId(), actionId)) {

					return true;
				}

				if (actionId.equals(ActionKeys.VIEW)) {
					break;
				}

				folder = IGFolderLocalServiceUtil.getFolder(folderId);

				folderId = folder.getParentFolderId();
			}

			return false;
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException, SystemException {

		if (folderId == IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return IGPermission.contains(permissionChecker, groupId, actionId);
		}
		else {
			IGFolder folder = IGFolderLocalServiceUtil.getFolder(folderId);

			return contains(permissionChecker, folder, actionId);
		}
	}

}