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
 * This class is a wrapper for {@link ThemeLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ThemeLocalService
 * @generated
 */
public class ThemeLocalServiceWrapper implements ThemeLocalService {
	public ThemeLocalServiceWrapper(ThemeLocalService themeLocalService) {
		_themeLocalService = themeLocalService;
	}

	public com.liferay.portal.model.ColorScheme getColorScheme(long companyId,
		java.lang.String themeId, java.lang.String colorSchemeId,
		boolean wapTheme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeLocalService.getColorScheme(companyId, themeId,
			colorSchemeId, wapTheme);
	}

	public com.liferay.portal.model.Theme getTheme(long companyId,
		java.lang.String themeId, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeLocalService.getTheme(companyId, themeId, wapTheme);
	}

	public java.util.List<com.liferay.portal.model.Theme> getThemes(
		long companyId) {
		return _themeLocalService.getThemes(companyId);
	}

	public java.util.List<com.liferay.portal.model.Theme> getThemes(
		long companyId, long groupId, long userId, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeLocalService.getThemes(companyId, groupId, userId, wapTheme);
	}

	public java.util.List<com.liferay.portal.model.Theme> getWARThemes() {
		return _themeLocalService.getWARThemes();
	}

	public java.util.List<java.lang.String> init(
		javax.servlet.ServletContext servletContext,
		java.lang.String themesPath, boolean loadFromServletContext,
		java.lang.String[] xmls,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {
		return _themeLocalService.init(servletContext, themesPath,
			loadFromServletContext, xmls, pluginPackage);
	}

	public java.util.List<java.lang.String> init(
		java.lang.String servletContextName,
		javax.servlet.ServletContext servletContext,
		java.lang.String themesPath, boolean loadFromServletContext,
		java.lang.String[] xmls,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {
		return _themeLocalService.init(servletContextName, servletContext,
			themesPath, loadFromServletContext, xmls, pluginPackage);
	}

	public void uninstallThemes(java.util.List<java.lang.String> themeIds) {
		_themeLocalService.uninstallThemes(themeIds);
	}

	public ThemeLocalService getWrappedThemeLocalService() {
		return _themeLocalService;
	}

	public void setWrappedThemeLocalService(ThemeLocalService themeLocalService) {
		_themeLocalService = themeLocalService;
	}

	private ThemeLocalService _themeLocalService;
}