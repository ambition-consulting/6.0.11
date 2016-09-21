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
 * The model interface for the LayoutSet service. Represents a row in the &quot;LayoutSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.LayoutSetImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetModel
 * @see com.liferay.portal.model.impl.LayoutSetImpl
 * @see com.liferay.portal.model.impl.LayoutSetModelImpl
 * @generated
 */
public interface LayoutSet extends LayoutSetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a layout set model instance should use the {@link LayoutSet} interface instead.
	 */
	public com.liferay.portal.model.Theme getTheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ColorScheme getColorScheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getSettingsProperties();

	public java.lang.String getSettingsProperty(java.lang.String key);

	public com.liferay.portal.model.Theme getWapTheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ColorScheme getWapColorScheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setSettings(java.lang.String settings);

	public void setSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties settingsProperties);
}