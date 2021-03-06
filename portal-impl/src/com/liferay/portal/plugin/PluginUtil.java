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

package com.liferay.portal.plugin;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Plugin;
import com.liferay.portal.model.PluginSetting;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PluginSettingLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PluginUtil {

	public static List<? extends Plugin> restrictPlugins(
			List<? extends Plugin> plugins, long companyId, long userId)
		throws SystemException {

		List<Plugin> visiblePlugins = new ArrayList<Plugin>(plugins.size());

		for (Plugin plugin : plugins) {
			PluginSetting pluginSetting =
				PluginSettingLocalServiceUtil.getPluginSetting(
					companyId, plugin.getPluginId(), plugin.getPluginType());

			if (pluginSetting.isActive() &&
				pluginSetting.hasPermission(userId)) {

				visiblePlugins.add(plugin);
			}
		}

		return visiblePlugins;
	}

	public static List<? extends Plugin> restrictPlugins(
			List<? extends Plugin> plugins, User user)
		throws SystemException {

		return restrictPlugins(plugins, user.getCompanyId(), user.getUserId());
	}

}