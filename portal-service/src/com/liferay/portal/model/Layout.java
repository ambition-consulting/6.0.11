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

/**
 * The model interface for the Layout service. Represents a row in the &quot;Layout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.LayoutImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutModel
 * @see com.liferay.portal.model.impl.LayoutImpl
 * @see com.liferay.portal.model.impl.LayoutModelImpl
 * @generated
 */
public interface Layout extends LayoutModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a layout model instance should use the {@link Layout} interface instead.
	 */
	public java.util.List<com.liferay.portal.model.Layout> getAllChildren()
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getAncestorLayoutId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public long getAncestorPlid()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.model.Layout> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.model.Layout> getChildren()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.model.Layout> getChildren(
		com.liferay.portal.security.permission.PermissionChecker permissionChecker)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ColorScheme getColorScheme()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getCssText()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getHTMLTitle(java.util.Locale locale);

	public java.lang.String getHTMLTitle(java.lang.String localeLanguageId);

	public com.liferay.portal.model.LayoutSet getLayoutSet()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.LayoutType getLayoutType();

	public java.lang.String getName(java.util.Locale locale);

	public java.lang.String getName(java.util.Locale locale, boolean useDefault);

	public java.lang.String getName(java.lang.String localeLanguageId);

	public java.lang.String getName(java.lang.String localeLanguageId,
		boolean useDefault);

	public long getParentPlid()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getRegularURL(
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getResetLayoutURL(
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getResetMaxStateURL(
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group getScopeGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getTarget();

	public com.liferay.portal.model.Theme getTheme()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getTitle(java.util.Locale locale);

	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault);

	public java.lang.String getTitle(java.lang.String localeLanguageId);

	public java.lang.String getTitle(java.lang.String localeLanguageId,
		boolean useDefault);

	public java.lang.String getTypeSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getTypeSettingsProperties();

	public com.liferay.portal.model.ColorScheme getWapColorScheme()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Theme getWapTheme()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean hasAncestor(long layoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean hasChildren()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean hasScopeGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean isChildSelected(boolean selectable,
		com.liferay.portal.model.Layout layout)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean isFirstChild();

	public boolean isFirstParent();

	public boolean isInheritLookAndFeel();

	public boolean isInheritWapLookAndFeel();

	public boolean isPublicLayout();

	public boolean isRootLayout();

	public boolean isSelected(boolean selectable,
		com.liferay.portal.model.Layout layout, long ancestorPlid);

	public boolean isTypeArticle();

	public boolean isTypeControlPanel();

	public boolean isTypeEmbedded();

	public boolean isTypeLinkToLayout();

	public boolean isTypePanel();

	public boolean isTypePortlet();

	public boolean isTypeURL();

	public void setName(java.lang.String name, java.util.Locale locale);

	public void setTitle(java.lang.String title, java.util.Locale locale);

	public void setTypeSettings(java.lang.String typeSettings);

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties);
}