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

package com.liferay.portlet.imagegallery.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.permission.IGImagePermission;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

/**
 * @author Julio Camarero
 * @author Juan Fernández
 */
public class IGImageAssetRenderer extends BaseAssetRenderer {

	public IGImageAssetRenderer(IGImage image) {
		_image = image;
	}

	public long getClassPK() {
		return _image.getImageId();
	}

	public long getGroupId() {
		return _image.getGroupId();
	}

	public String getSummary() {
		return HtmlUtil.stripHtml(_image.getDescription());
	}

	public String getTitle() {
		return _image.getName();
	}

	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		PortletURL editPortletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.IMAGE_GALLERY);

		editPortletURL.setParameter(
			"struts_action", "/image_gallery/edit_image");
		editPortletURL.setParameter(
			"folderId", String.valueOf(_image.getFolderId()));
		editPortletURL.setParameter(
			"imageId", String.valueOf(_image.getImageId()));

		return editPortletURL;
	}

	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect)
		throws Exception {

		PortletURL viewPortletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.IMAGE_GALLERY);

		viewPortletURL.setWindowState(WindowState.MAXIMIZED);

		viewPortletURL.setParameter("struts_action", "/image_gallery/view");
		viewPortletURL.setParameter(
			"groupId", String.valueOf(_image.getGroupId()));
		viewPortletURL.setParameter(
			"folderId", String.valueOf(_image.getFolderId()));

		return viewPortletURL.toString();
	}

	public long getUserId() {
		return _image.getUserId();
	}

	public String getUuid() {
		return _image.getUuid();
	}

	public String getViewInContextMessage() {
		return "view-album";
	}

	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		return IGImagePermission.contains(
			permissionChecker, _image, ActionKeys.UPDATE);
	}

	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		return IGImagePermission.contains(
			permissionChecker, _image, ActionKeys.VIEW);
	}

	public boolean isPrintable() {
		return true;
	}

	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse,
		String template) {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(WebKeys.IMAGE_GALLERY_IMAGE, _image);

			return "/html/portlet/image_gallery/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/file_system/small/bmp.png";
	}

	private IGImage _image;

}