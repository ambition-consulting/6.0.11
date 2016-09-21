/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class SessionClicks {

	public static final String CLASS_NAME = SessionClicks.class.getName();

	public static String get(
		HttpServletRequest request, String key, String defaultValue) {

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			return preferences.getValue(CLASS_NAME, key, defaultValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			return null;
		}
	}

	public static void put(
		HttpServletRequest request, String key, String value) {

		try {
			if ((key.length() > _SESSION_CLICKS_MAX_SIZE_TERMS) ||
				(value.length() > _SESSION_CLICKS_MAX_SIZE_TERMS)) {

				if (_log.isWarnEnabled()) {
					_log.warn(
						"Session clicks has attempted to exceed the maximum " +
							"size allowed for keys or values with {key=" + key +
								", value=" + value + "}");
				}

				return;
			}

			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			int size = preferences.size();

			if (size <= _SESSION_CLICKS_MAX_ALLOWED_VALUES) {
				preferences.setValue(CLASS_NAME, key, value);
			}
			else {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Session clicks has attempted to exceed the maximum " +
							"number of allowed values with {key=" + key +
								", value=" + value + "}");
				}
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final int _SESSION_CLICKS_MAX_ALLOWED_VALUES =
		GetterUtil.getInteger(
			PropsUtil.get("session.clicks.max.allowed.values"), 1024);

	private static final int _SESSION_CLICKS_MAX_SIZE_TERMS =
		GetterUtil.getInteger(
			PropsUtil.get("session.clicks.max.size.terms"), 1024);

	private static Log _log = LogFactoryUtil.getLog(SessionClicks.class);

}