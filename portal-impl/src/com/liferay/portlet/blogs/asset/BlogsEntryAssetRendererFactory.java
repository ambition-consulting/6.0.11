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

package com.liferay.portlet.blogs.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.blogs.service.BlogsEntryServiceUtil;
import com.liferay.portlet.blogs.service.permission.BlogsEntryPermission;
import com.liferay.portlet.blogs.service.permission.BlogsPermission;

import javax.portlet.PortletURL;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 * @author Raymond Augé
 */
public class BlogsEntryAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = BlogsEntry.class.getName();

	public static final String TYPE = "blog";

	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		BlogsEntry entry = BlogsEntryLocalServiceUtil.getEntry(classPK);

		return new BlogsEntryAssetRenderer(entry);
	}

	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
		throws PortalException, SystemException {

		BlogsEntry entry = BlogsEntryServiceUtil.getEntry(groupId, urlTitle);

		return new BlogsEntryAssetRenderer(entry);
	}

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType() {
		return TYPE;
	}

	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletURL addAssetURL = null;

		if (BlogsPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)) {

			addAssetURL = liferayPortletResponse.createRenderURL(
				PortletKeys.BLOGS);

			addAssetURL.setParameter("struts_action", "/blogs/edit_entry");
		}

		return addAssetURL;
	}

	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return BlogsEntryPermission.contains(
			permissionChecker, classPK, actionId);
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/blogs/blogs.png";
	}

}