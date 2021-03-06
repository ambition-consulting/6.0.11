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

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.CookieKeys;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class RememberMeAutoLogin implements AutoLogin {

	public String[] login(
			HttpServletRequest request, HttpServletResponse response)
		throws AutoLoginException {

		try {
			String[] credentials = null;

			String autoUserId = CookieKeys.getCookie(request, CookieKeys.ID);
			String autoPassword = CookieKeys.getCookie(
				request, CookieKeys.PASSWORD);
			String rememberMe = CookieKeys.getCookie(
				request, CookieKeys.REMEMBER_ME);

			// LEP-5188

			String proxyPath = PortalUtil.getPathProxy();
			String contextPath = PortalUtil.getPathContext();

			if (proxyPath.equals(contextPath)) {
				if (Validator.isNotNull(request.getContextPath())) {
					rememberMe = Boolean.TRUE.toString();
				}
			}
			else {
				if (!contextPath.equals(request.getContextPath())) {
					rememberMe = Boolean.TRUE.toString();
				}
			}

			if (Validator.isNotNull(autoUserId) &&
				Validator.isNotNull(autoPassword) &&
				Validator.isNotNull(rememberMe)) {

				Company company = PortalUtil.getCompany(request);

				KeyValuePair kvp = null;

				if (company.isAutoLogin()) {
					kvp = UserLocalServiceUtil.decryptUserId(
						company.getCompanyId(), autoUserId, autoPassword);

					credentials = new String[3];

					credentials[0] = kvp.getKey();
					credentials[1] = kvp.getValue();
					credentials[2] = Boolean.FALSE.toString();
				}
			}

			// LPS-11218

			if (credentials != null) {
				Company company = PortalUtil.getCompany(request);

				User defaultUser = UserLocalServiceUtil.getDefaultUser(
					company.getCompanyId());

				long userId = GetterUtil.getLong(credentials[0]);

				if (defaultUser.getUserId() == userId) {
					credentials = null;

					removeCookies(request, response);
				}
			}

			return credentials;
		}
		catch (Exception e) {
			_log.warn(e, e);

			removeCookies(request, response);

			throw new AutoLoginException(e);
		}
	}

	protected void removeCookies(
		HttpServletRequest request, HttpServletResponse response) {

		Cookie cookie = new Cookie(CookieKeys.ID, StringPool.BLANK);

		cookie.setMaxAge(0);
		cookie.setPath(StringPool.SLASH);

		CookieKeys.addCookie(request, response, cookie);

		cookie = new Cookie(CookieKeys.PASSWORD, StringPool.BLANK);

		cookie.setMaxAge(0);
		cookie.setPath(StringPool.SLASH);

		CookieKeys.addCookie(request, response, cookie);
	}

	private static Log _log = LogFactoryUtil.getLog(RememberMeAutoLogin.class);

}