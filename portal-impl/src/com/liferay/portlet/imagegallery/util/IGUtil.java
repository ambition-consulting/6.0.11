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

package com.liferay.portlet.imagegallery.util;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGFolderConstants;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class IGUtil {

	public static void addPortletBreadcrumbEntries(
			IGImage image, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		IGFolder folder = image.getFolder();

		addPortletBreadcrumbEntries(folder, request, renderResponse);

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("struts_action", "/image_gallery/view_image");
		portletURL.setParameter("imageId", String.valueOf(image.getImageId()));

		PortalUtil.addPortletBreadcrumbEntry(
			request, image.getName(), portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
			long folderId, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		if (folderId == IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return;
		}

		IGFolder folder = IGFolderLocalServiceUtil.getFolder(
			folderId);

		addPortletBreadcrumbEntries(folder, request, renderResponse);
	}

	public static void addPortletBreadcrumbEntries(
			IGFolder folder, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		String strutsAction = ParamUtil.getString(request, "struts_action");

		PortletURL portletURL = renderResponse.createRenderURL();

		if (strutsAction.equals("/journal/select_image_gallery") ||
			strutsAction.equals("/image_gallery/select_folder")) {
			ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			portletURL.setWindowState(LiferayWindowState.POP_UP);

			portletURL.setParameter("struts_action", strutsAction);

			if (strutsAction.equals("/journal/select_image_gallery")) {
				portletURL.setParameter(
					"groupId", String.valueOf(folder.getGroupId()));
			}

			PortalUtil.addPortletBreadcrumbEntry(
				request, themeDisplay.translate("images-home"),
				portletURL.toString());
		}
		else {
			portletURL.setParameter("struts_action", "/image_gallery/view");
		}

		List<IGFolder> ancestorFolders = folder.getAncestors();

		Collections.reverse(ancestorFolders);

		for (IGFolder ancestorFolder : ancestorFolders) {
			portletURL.setParameter(
				"folderId", String.valueOf(ancestorFolder.getFolderId()));

			if (strutsAction.equals("/journal/select_image_gallery")) {
				portletURL.setParameter(
					"groupId", String.valueOf(folder.getGroupId()));
			}

			PortalUtil.addPortletBreadcrumbEntry(
				request, ancestorFolder.getName(), portletURL.toString());
		}

		portletURL.setParameter(
			"folderId", String.valueOf(folder.getFolderId()));

		if (strutsAction.equals("/journal/select_image_gallery")) {
			portletURL.setParameter(
				"groupId", String.valueOf(folder.getGroupId()));
		}

		PortalUtil.addPortletBreadcrumbEntry(
			request, folder.getName(), portletURL.toString());
	}

}