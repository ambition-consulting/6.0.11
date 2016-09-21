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

package com.liferay.util.ldap;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.text.DateFormat;

import java.util.Date;
import java.util.Properties;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

/**
 * @author Toma Bedolla
 * @author Michael Young
 * @author Brian Wing Shun Chan
 */
public class LDAPUtil {

	public static String getAttributeValue(
			Attributes attributes, Properties properties, String key)
		throws NamingException {

		String id = properties.getProperty(key);

		return getAttributeValue(attributes, id);
	}

	public static String getAttributeValue(
			Attributes attributes, Properties properties, String key,
			String defaultValue)
		throws NamingException {

		String id = properties.getProperty(key);

		return getAttributeValue(attributes, id, defaultValue);
	}

	public static String getAttributeValue(Attributes attributes, String id)
		throws NamingException {

		return getAttributeValue(attributes, id, StringPool.BLANK);
	}

	public static String getAttributeValue(
			Attributes attributes, String id, String defaultValue)
		throws NamingException {

		try {
			Attribute attribute = attributes.get(id);

			Object obj = attribute.get();

			return obj.toString();
		}
		catch (NullPointerException npe) {
			return defaultValue;
		}
	}

	public static Date parseDate(String date) throws Exception {
		String format = "yyyyMMddHHmmss";

		if (date.endsWith("Z")) {
			if (date.indexOf(CharPool.PERIOD) != -1) {
				format = "yyyyMMddHHmmss.S'Z'";
			}
			else {
				format = "yyyyMMddHHmmss'Z'";
			}
		}
		else if ((date.indexOf(CharPool.DASH) != -1) ||
				 (date.indexOf(CharPool.PLUS) != -1)) {

			if (date.indexOf(CharPool.PERIOD) != -1) {
				format = "yyyyMMddHHmmss.SZ";
			}
			else {
				format = "yyyyMMddHHmmssZ";
			}
		}
		else if (date.indexOf(CharPool.PERIOD) != -1) {
			format = "yyyyMMddHHmmss.S";
		}

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			format);

		return dateFormat.parse(date);
	}

	public static String getFullProviderURL(String baseURL, String baseDN) {
		return baseURL + StringPool.SLASH + baseDN;
	}

}