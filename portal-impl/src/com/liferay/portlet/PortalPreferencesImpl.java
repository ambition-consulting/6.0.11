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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalPreferencesImpl implements PortalPreferences {

	public PortalPreferencesImpl(
		PortletPreferencesImpl preferences, boolean signedIn) {

		_preferences = preferences;
		_signedIn = signedIn;
	}

	public String getValue(String namespace, String key) {
		return getValue(namespace, key, null);
	}

	public String getValue(String namespace, String key, String defaultValue) {
		key = _encodeKey(namespace, key);

		return _preferences.getValue(key, defaultValue);
	}

	public String[] getValues(String namespace, String key) {
		return getValues(namespace, key, null);
	}

	public String[] getValues(
		String namespace, String key, String[] defaultValue) {

		key = _encodeKey(namespace, key);

		return _preferences.getValues(key, defaultValue);
	}

	public void setValue(String namespace, String key, String value) {
		if (Validator.isNull(key) || (key.equals(_RANDOM_KEY))) {
			return;
		}

		key = _encodeKey(namespace, key);

		try {
			if (value != null) {
				_preferences.setValue(key, value);
			}
			else {
				_preferences.reset(key);
			}

			if (_signedIn) {
				_preferences.store();
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public void setValues(String namespace, String key, String[] values) {
		if (Validator.isNull(key) || (key.equals(_RANDOM_KEY))) {
			return;
		}

		key = _encodeKey(namespace, key);

		try {
			if (values != null) {
				_preferences.setValues(key, values);
			}
			else {
				_preferences.reset(key);
			}

			if (_signedIn) {
				_preferences.store();
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private String _encodeKey(String namespace, String key) {
		return namespace + StringPool.POUND + key;
	}

	private static final String _RANDOM_KEY = "r";

	private static Log _log = LogFactoryUtil.getLog(PortalPreferences.class);

	private PortletPreferencesImpl _preferences;
	private boolean _signedIn;

}