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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
public class StrutsResourceBundle extends ResourceBundle {

	public StrutsResourceBundle(String portletName, Locale locale) {
		_portletName = portletName;
		_locale = locale;
	}

	public Enumeration<String> getKeys() {
		return null;
	}

	public Locale getLocale() {
		return _locale;
	}

	protected Object handleGetObject(String key) {
		if ((key != null) &&
			(key.equals(JavaConstants.JAVAX_PORTLET_TITLE) ||
			 key.equals(JavaConstants.JAVAX_PORTLET_SHORT_TITLE) ||
			 key.equals(JavaConstants.JAVAX_PORTLET_KEYWORDS) ||
			 key.equals(JavaConstants.JAVAX_PORTLET_DESCRIPTION))) {

			key = key.concat(StringPool.PERIOD).concat(_portletName);
		}

		return LanguageUtil.get(_locale, key);
	}

	private String _portletName;
	private Locale _locale;

}