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
 * This class is a wrapper for {@link LayoutTemplateLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutTemplateLocalService
 * @generated
 */
public class LayoutTemplateLocalServiceWrapper
	implements LayoutTemplateLocalService {
	public LayoutTemplateLocalServiceWrapper(
		LayoutTemplateLocalService layoutTemplateLocalService) {
		_layoutTemplateLocalService = layoutTemplateLocalService;
	}

	public java.lang.String getContent(java.lang.String layoutTemplateId,
		boolean standard, java.lang.String themeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutTemplateLocalService.getContent(layoutTemplateId,
			standard, themeId);
	}

	public com.liferay.portal.model.LayoutTemplate getLayoutTemplate(
		java.lang.String layoutTemplateId, boolean standard,
		java.lang.String themeId) {
		return _layoutTemplateLocalService.getLayoutTemplate(layoutTemplateId,
			standard, themeId);
	}

	public java.util.List<com.liferay.portal.model.LayoutTemplate> getLayoutTemplates() {
		return _layoutTemplateLocalService.getLayoutTemplates();
	}

	public java.util.List<com.liferay.portal.model.LayoutTemplate> getLayoutTemplates(
		java.lang.String themeId) {
		return _layoutTemplateLocalService.getLayoutTemplates(themeId);
	}

	public java.lang.String getWapContent(java.lang.String layoutTemplateId,
		boolean standard, java.lang.String themeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutTemplateLocalService.getWapContent(layoutTemplateId,
			standard, themeId);
	}

	public java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.lang.Boolean>> init(
		javax.servlet.ServletContext servletContext, java.lang.String[] xmls,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {
		return _layoutTemplateLocalService.init(servletContext, xmls,
			pluginPackage);
	}

	public java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.lang.Boolean>> init(
		java.lang.String servletContextName,
		javax.servlet.ServletContext servletContext, java.lang.String[] xmls,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {
		return _layoutTemplateLocalService.init(servletContextName,
			servletContext, xmls, pluginPackage);
	}

	public void readLayoutTemplate(java.lang.String servletContextName,
		javax.servlet.ServletContext servletContext,
		java.util.Set<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.lang.Boolean>> layoutTemplateIds,
		com.liferay.portal.kernel.xml.Element el, boolean standard,
		java.lang.String themeId,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {
		_layoutTemplateLocalService.readLayoutTemplate(servletContextName,
			servletContext, layoutTemplateIds, el, standard, themeId,
			pluginPackage);
	}

	public void uninstallLayoutTemplate(java.lang.String layoutTemplateId,
		boolean standard) {
		_layoutTemplateLocalService.uninstallLayoutTemplate(layoutTemplateId,
			standard);
	}

	public void uninstallLayoutTemplates(java.lang.String themeId) {
		_layoutTemplateLocalService.uninstallLayoutTemplates(themeId);
	}

	public LayoutTemplateLocalService getWrappedLayoutTemplateLocalService() {
		return _layoutTemplateLocalService;
	}

	public void setWrappedLayoutTemplateLocalService(
		LayoutTemplateLocalService layoutTemplateLocalService) {
		_layoutTemplateLocalService = layoutTemplateLocalService;
	}

	private LayoutTemplateLocalService _layoutTemplateLocalService;
}