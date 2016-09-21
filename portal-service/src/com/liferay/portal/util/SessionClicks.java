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

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			preferences.setValue(CLASS_NAME, key, value);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SessionClicks.class);

}