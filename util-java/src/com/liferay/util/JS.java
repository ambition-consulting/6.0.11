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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Brian Wing Shun Chan
 */
public class JS {

	public static String getSafeName(String name) {
		String safeName =
			StringUtil.replace(
				name,
				new String[] {
					StringPool.SPACE, StringPool.DASH, StringPool.PERIOD
				},
				new String[] {
					StringPool.BLANK, StringPool.BLANK, StringPool.BLANK
				});

		return safeName;
	}

	/**
	 * @deprecated Use <code>encodeURIComponent</code>.
	 */
	public static String escape(String s) {
		return encodeURIComponent(s);
	}

	/**
	 * @deprecated Use <code>decodeURIComponent</code>.
	 */
	public static String unescape(String s) {
		return decodeURIComponent(s);
	}

	public static String encodeURIComponent(String s) {

		// Encode URL

		try {
			s = URLEncoder.encode(s, StringPool.UTF8);
		}
		catch (Exception e) {
		}

		// Adjust for JavaScript specific annoyances

		s = StringUtil.replace(s, "+", "%20");
		s = StringUtil.replace(s, "%2B", "+");

		return s;
	}

	public static String decodeURIComponent(String s) {

		// Get rid of all unicode

		s = s.replaceAll("%u[0-9a-fA-F]{4}", StringPool.BLANK);

		// Adjust for JavaScript specific annoyances

		s = StringUtil.replace(s, "+", "%2B");
		s = StringUtil.replace(s, "%20", "+");

		// Decode URL

		try {
			s = URLDecoder.decode(s, StringPool.UTF8);
		}
		catch (Exception e) {
		}

		return s;
	}

	public static String toScript(String[] array) {
		StringBundler sb = new StringBundler(array.length * 4 + 2);

		sb.append(StringPool.OPEN_BRACKET);

		for (int i = 0; i < array.length; i++) {
			sb.append(StringPool.APOSTROPHE);
			sb.append(UnicodeFormatter.toString(array[i]));
			sb.append(StringPool.APOSTROPHE);

			if (i + 1 < array.length) {
				sb.append(StringPool.COMMA);
			}
		}

		sb.append(StringPool.CLOSE_BRACKET);

		return sb.toString();
	}

}