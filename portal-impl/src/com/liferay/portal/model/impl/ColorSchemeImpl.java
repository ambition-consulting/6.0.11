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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.SafeProperties;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ColorScheme;
import com.liferay.portal.util.PropsValues;

import java.io.IOException;

import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class ColorSchemeImpl implements ColorScheme {

	public static String getDefaultRegularColorSchemeId() {
		return PropsValues.DEFAULT_REGULAR_COLOR_SCHEME_ID;
	}

	public static String getDefaultWapColorSchemeId() {
		return PropsValues.DEFAULT_WAP_COLOR_SCHEME_ID;
	}

	public static ColorScheme getNullColorScheme() {
		return new ColorSchemeImpl(
			getDefaultRegularColorSchemeId(), StringPool.BLANK,
			StringPool.BLANK);
	}

	public ColorSchemeImpl() {
	}

	public ColorSchemeImpl(String colorSchemeId) {
		_colorSchemeId = colorSchemeId;
	}

	public ColorSchemeImpl(String colorSchemeId, String name, String cssClass) {
		_colorSchemeId = colorSchemeId;
		_name = name;
		_cssClass = cssClass;
	}

	public String getColorSchemeId() {
		return _colorSchemeId;
	}

	public String getName() {
		if (Validator.isNull(_name)) {
			return _colorSchemeId;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getDefaultCs() {
		return _defaultCs;
	}

	public boolean isDefaultCs() {
		return _defaultCs;
	}

	public void setDefaultCs(boolean defaultCs) {
		_defaultCs = defaultCs;
	}

	public String getCssClass() {
		return _cssClass;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public String getColorSchemeImagesPath() {
		return _colorSchemeImagesPath;
	}

	public String getColorSchemeThumbnailPath() {

		// LEP-5270

		if (Validator.isNotNull(_cssClass) &&
			Validator.isNotNull(_colorSchemeImagesPath)) {

			int pos = _cssClass.indexOf(CharPool.SPACE);

			if (pos > 0) {
				if (_colorSchemeImagesPath.endsWith(
						_cssClass.substring(0, pos))) {

					String subclassPath = StringUtil.replace(
						_cssClass, CharPool.SPACE, CharPool.SLASH);

					return _colorSchemeImagesPath + subclassPath.substring(pos);
				}
			}
		}

		return _colorSchemeImagesPath;
	}

	public void setColorSchemeImagesPath(String colorSchemeImagesPath) {
		_colorSchemeImagesPath = colorSchemeImagesPath;
	}

	public String getSettings() {
		return PropertiesUtil.toString(_settingsProperties);
	}

	public void setSettings(String settings) {
		_settingsProperties.clear();

		try {
			PropertiesUtil.load(_settingsProperties, settings);
			PropertiesUtil.trimKeys(_settingsProperties);
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}
	}

	public Properties getSettingsProperties() {
		return _settingsProperties;
	}

	public void setSettingsProperties(Properties settingsProperties) {
		_settingsProperties = settingsProperties;
	}

	public String getSetting(String key) {
		//return _settingsProperties.getProperty(key);

		// FIX ME

		if (key.endsWith("-bg")) {
			return "#FFFFFF";
		}
		else {
			return "#000000";
		}
	}

	public int compareTo(ColorScheme colorScheme) {
		return getName().compareTo(colorScheme.getName());
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ColorScheme colorScheme = null;

		try {
			colorScheme = (ColorScheme)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String colorSchemeId = colorScheme.getColorSchemeId();

		if (getColorSchemeId().equals(colorSchemeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return _colorSchemeId.hashCode();
	}

	private static Log _log = LogFactoryUtil.getLog(ColorScheme.class);

	private String _colorSchemeId;
	private String _name;
	private String _cssClass;
	private String _colorSchemeImagesPath =
		"${images-path}/color_schemes/${css-class}";
	private boolean _defaultCs;
	private Properties _settingsProperties = new SafeProperties();

}