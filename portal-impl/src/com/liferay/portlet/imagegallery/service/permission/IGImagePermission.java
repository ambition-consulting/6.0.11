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
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class IGImagePermission {

	public static void check(
			PermissionChecker permissionChecker, IGImage image, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, image, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long imageId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, imageId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, IGImage image, String actionId)
		throws PortalException, SystemException {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, image.getGroupId(), IGImage.class.getName(),
			image.getImageId(), PortletKeys.IMAGE_GALLERY, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (PropsValues.PERMISSIONS_VIEW_DYNAMIC_INHERITANCE) {
			if (image.getFolderId() !=
					IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

				IGFolder folder = image.getFolder();

				if (!IGFolderPermission.contains(
						permissionChecker, folder, ActionKeys.ACCESS) &&
					!IGFolderPermission.contains(
						permissionChecker, folder, ActionKeys.VIEW)) {

					return false;
				}
			}
		}

		if (permissionChecker.hasOwnerPermission(
				image.getCompanyId(), IGImage.class.getName(),
				image.getImageId(), image.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			image.getGroupId(), IGImage.class.getName(), image.getImageId(),
			actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long imageId, String actionId)
		throws PortalException, SystemException {

		IGImage image = IGImageLocalServiceUtil.getImage(imageId);

		return contains(permissionChecker, image, actionId);
	}

}