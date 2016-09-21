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

package com.liferay.portal.kernel.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Brian Wing Shun Chan
 */
public class TimeZoneUtil {

	public static TimeZone getDefault() {
		return _instance._getDefault();
	}

	public static TimeZone getTimeZone(String timeZoneId) {
		return _instance._getTimeZone(timeZoneId);
	}

	public static void setDefault(String timeZoneId) {
		_instance._setDefault(timeZoneId);
	}

	private TimeZoneUtil() {
		_timeZone = _getTimeZone(StringPool.UTC);
	}

	private TimeZone _getDefault() {
		TimeZone timeZone = TimeZoneThreadLocal.getTimeZone();

		if (timeZone != null) {
			return timeZone;
		}

		return _timeZone;
	}

	private TimeZone _getTimeZone(String timeZoneId) {
		TimeZone timeZone = _timeZones.get(timeZoneId);

		if (timeZone == null) {
			timeZone = TimeZone.getTimeZone(timeZoneId);

			_timeZones.put(timeZoneId, timeZone);
		}

		return timeZone;
	}

	private void _setDefault(String timeZoneId) {
		if (Validator.isNotNull(timeZoneId)) {
			_timeZone = TimeZone.getTimeZone(timeZoneId);
		}
	}

	private static TimeZoneUtil _instance = new TimeZoneUtil();

	private TimeZone _timeZone;
	private Map<String, TimeZone> _timeZones = new HashMap<String, TimeZone>();

}