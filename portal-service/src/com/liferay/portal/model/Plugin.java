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

package com.liferay.portal.model;

import com.liferay.portal.kernel.plugin.PluginPackage;

/**
 * @author Jorge Ferrer
 */
public interface Plugin {

	public static final String TYPE_EXT = "ext";

	public static final String TYPE_HOOK = "hook";

	public static final String TYPE_LAYOUT_TEMPLATE = "layout-template";

	public static final String TYPE_PORTLET = "portlet";

	public static final String TYPE_THEME = "theme";

	public static final String TYPE_WEB = "web";

	public PluginPackage getPluginPackage();

	public void setPluginPackage(PluginPackage pluginPackage);

	public String getPluginId();

	public String getPluginType();

	public PluginSetting getDefaultPluginSetting();

	public PluginSetting getDefaultPluginSetting(long companyId);

	public void setDefaultPluginSetting(PluginSetting pluginSetting);

}