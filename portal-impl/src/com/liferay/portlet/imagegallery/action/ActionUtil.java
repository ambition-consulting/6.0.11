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

package com.liferay.portlet.imagegallery.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGFolderConstants;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGFolderServiceUtil;
import com.liferay.portlet.imagegallery.service.IGImageServiceUtil;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionUtil {

	public static void getFolder(HttpServletRequest request) throws Exception {
		long folderId = ParamUtil.getLong(request, "folderId");

		IGFolder folder = null;

		if ((folderId > 0) &&
			(folderId != IGFolderConstants.DEFAULT_PARENT_FOLDER_ID)) {

			folder = IGFolderServiceUtil.getFolder(folderId);
		}

		request.setAttribute(WebKeys.IMAGE_GALLERY_FOLDER, folder);
	}

	public static void getFolder(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		getFolder(request);
	}

	public static void getImage(HttpServletRequest request) throws Exception {
		long imageId = ParamUtil.getLong(request, "imageId");

		IGImage image = null;

		if (imageId > 0) {
			image = IGImageServiceUtil.getImage(imageId);
		}

		request.setAttribute(WebKeys.IMAGE_GALLERY_IMAGE, image);
	}

	public static void getImage(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		getImage(request);
	}

}