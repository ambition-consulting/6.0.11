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

package com.liferay.portlet;

import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.model.PortletInfo;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
public class PortletResourceBundle extends ResourceBundle {

	public PortletResourceBundle(PortletInfo portletInfo) {
		this(null, portletInfo);
	}

	public PortletResourceBundle(
		ResourceBundle parentResourceBundle, PortletInfo portletInfo) {

		_parentResourceBundle = parentResourceBundle;
		_portletInfo = portletInfo;
	}

	public Enumeration<String> getKeys() {
		return _parentResourceBundle.getKeys();
	}

	public Locale getLocale() {
		return _parentResourceBundle.getLocale();
	}

	protected Object handleGetObject(String key) {
		try {
			if (_parentResourceBundle == null) {
				return _getJavaxPortletString(key);
			}
			else {
				return _parentResourceBundle.getObject(key);
			}
		}
		catch (MissingResourceException mre) {
			String value = _getJavaxPortletString(key);

			if (value != null) {
				return value;
			}
			else {
				throw mre;
			}
		}
	}
	private String _getJavaxPortletString(String key) {
		if (key == null) {
			return null;
		}
		else if (key.equals(JavaConstants.JAVAX_PORTLET_TITLE)) {
			return _portletInfo.getTitle();
		}
		else if (key.equals(JavaConstants.JAVAX_PORTLET_SHORT_TITLE)) {
			return _portletInfo.getShortTitle();
		}
		else if (key.equals(JavaConstants.JAVAX_PORTLET_KEYWORDS)) {
			return _portletInfo.getKeywords();
		}
		else if (key.equals(JavaConstants.JAVAX_PORTLET_DESCRIPTION)) {
			return _portletInfo.getDescription();
		}

		return null;
	}

	private ResourceBundle _parentResourceBundle;
	private PortletInfo _portletInfo;

}