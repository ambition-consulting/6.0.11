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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link PluginSettingService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PluginSettingService
 * @generated
 */
public class PluginSettingServiceWrapper implements PluginSettingService {
	public PluginSettingServiceWrapper(
		PluginSettingService pluginSettingService) {
		_pluginSettingService = pluginSettingService;
	}

	public com.liferay.portal.model.PluginSetting updatePluginSetting(
		long companyId, java.lang.String pluginId, java.lang.String pluginType,
		java.lang.String roles, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pluginSettingService.updatePluginSetting(companyId, pluginId,
			pluginType, roles, active);
	}

	public PluginSettingService getWrappedPluginSettingService() {
		return _pluginSettingService;
	}

	public void setWrappedPluginSettingService(
		PluginSettingService pluginSettingService) {
		_pluginSettingService = pluginSettingService;
	}

	private PluginSettingService _pluginSettingService;
}