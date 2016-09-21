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

package com.liferay.portlet.asset.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Jorge Ferrer
 */
public abstract class BaseAssetRenderer implements AssetRenderer {

	public String[] getAvailableLocales() {
		return _EMPTY_ARRAY;
	}

	public String getDiscussionPath() {
		return null;
	}

	public String getIconPath(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return getIconPath(themeDisplay);
	}

	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		return null;
	}

	public PortletURL getURLExport(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		return null;
	}

	public String getUrlTitle() {
		return null;
	}

	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect)
		throws Exception {

		return null;
	}

	public String getViewInContextMessage() {
		return "view-in-context";
	}

	@SuppressWarnings("unused")
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		return false;
	}

	@SuppressWarnings("unused")
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		return true;
	}

	public boolean isConvertible() {
		return false;
	}

	public boolean isLocalizable() {
		return false;
	}

	public boolean isPrintable() {
		return false;
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/page.png";
	}

	private static final String[] _EMPTY_ARRAY = new String[0];

}