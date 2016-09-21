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

import com.liferay.portal.kernel.util.GetterUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class CookieUtil {

	public static String get(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}

		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];

			String cookieName = GetterUtil.getString(cookie.getName());

			if (cookieName.equalsIgnoreCase(name)) {
				return cookie.getValue();
			}
		}

		return null;
	}

}