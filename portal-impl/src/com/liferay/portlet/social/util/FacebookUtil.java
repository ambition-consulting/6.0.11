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

package com.liferay.portlet.social.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.Portal;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jorge Ferrer
 */
public class FacebookUtil {

	public static final String FACEBOOK_APPS_URL = "http://apps.facebook.com/";

	public static final String FACEBOOK_SERVLET_PATH = "/facebook/";

	public static String[] getFacebookData(HttpServletRequest request) {
		String path = GetterUtil.getString(request.getPathInfo());

		if (Validator.isNull(path)) {
			return null;
		}

		int pos = path.indexOf(StringPool.SLASH, 1);

		if (pos == -1) {
			return null;
		}

		String facebookCanvasPageURL = path.substring(1, pos);

		if (_log.isDebugEnabled()) {
			_log.debug("Facebook canvas page URL " + facebookCanvasPageURL);
		}

		if (Validator.isNull(facebookCanvasPageURL)) {
			return null;
		}

		String redirect = path.substring(pos);

		if (_log.isDebugEnabled()) {
			_log.debug("Redirect " + redirect);
		}

		if (Validator.isNull(redirect)) {
			return null;
		}

		pos = path.indexOf(Portal.FRIENDLY_URL_SEPARATOR);

		String appPath = StringPool.BLANK;

		if (pos != -1) {
			pos = path.indexOf(CharPool.SLASH, pos + 3);

			if (pos != -1) {
				appPath = path.substring(pos);
			}
		}

		return new String[] {facebookCanvasPageURL, redirect, appPath};
	}

	public static boolean isFacebook(String currentURL) {
		String path = currentURL;

		if (currentURL.startsWith(Http.HTTP)) {
			int pos = currentURL.indexOf(
				CharPool.SLASH, Http.HTTPS_WITH_SLASH.length());

			path = currentURL.substring(pos);
		}

		if (path.startsWith(FACEBOOK_SERVLET_PATH)) {
			return true;
		}
		else {
			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FacebookUtil.class);

}