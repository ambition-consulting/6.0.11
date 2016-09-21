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

package com.liferay.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Neil Griffin
 */
public class ResourceBundleUtil {

	public static String getString(
		ResourceBundle resourceBundle, Locale locale, String key,
		Object[] arguments) {

		String value = null;

		if (resourceBundle == null) {
			if (_log.isErrorEnabled()) {
				_log.error("Resource bundle is null");
			}
		}
		else {

			// Get the value associated with the specified key, and substitute
			// any arguuments like {0}, {1}, {2}, etc. with the specified
			// argument values.

			value = resourceBundle.getString(key);

			if (value == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No value found for key " + key);
				}
			}
			else {
				if ((arguments != null) && (arguments.length > 0)) {
					MessageFormat messageFormat = new MessageFormat(
						value, locale);

					value = messageFormat.format(arguments);
				}
			}
		}

		if (value == null) {
			value = key;
		}

		return value;
	}

	private static Log _log = LogFactoryUtil.getLog(ResourceBundleUtil.class);

}