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
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.Plugin;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.base.LayoutSetServiceBaseImpl;
import com.liferay.portal.service.permission.GroupPermissionUtil;

import java.io.File;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutSetServiceImpl extends LayoutSetServiceBaseImpl {

	public void updateLogo(
			long groupId, boolean privateLayout, boolean logo, File file)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.MANAGE_LAYOUTS);

		layoutSetLocalService.updateLogo(groupId, privateLayout, logo, file);
	}

	public LayoutSet updateLookAndFeel(
			long groupId, boolean privateLayout, String themeId,
			String colorSchemeId, String css, boolean wapTheme)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.MANAGE_LAYOUTS);

		pluginSettingLocalService.checkPermission(
			getUserId(), themeId, Plugin.TYPE_THEME);

		return layoutSetLocalService.updateLookAndFeel(
			groupId, privateLayout, themeId, colorSchemeId, css, wapTheme);
	}

	public LayoutSet updateSettings(
			long groupId, boolean privateLayout, String settings)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.MANAGE_LAYOUTS);

		return layoutSetLocalService.updateSettings(
			groupId, privateLayout, settings);
	}

	public LayoutSet updateVirtualHost(
			long groupId, boolean privateLayout, String virtualHost)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.UPDATE);

		return layoutSetLocalService.updateVirtualHost(
			groupId, privateLayout, virtualHost);
	}

}