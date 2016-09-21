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
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.base.ImageServiceBaseImpl;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.permission.IGImagePermission;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class ImageServiceImpl extends ImageServiceBaseImpl {

	public Image getImage(long imageId)
		throws PortalException, SystemException {

		IGImage igImage = igImageFinder.fetchByAnyImageId(imageId);

		if (igImage != null) {
			IGImagePermission.check(
				getPermissionChecker(), igImage, ActionKeys.VIEW);
		}

		return imageLocalService.getImage(imageId);
	}

}