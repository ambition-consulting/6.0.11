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

package com.liferay.portal.facebook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnect;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Wilson Man
 */
public class FacebookConnectImpl implements FacebookConnect {

	public String getAccessTokenURL(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_OAUTH_TOKEN_URL,
			PropsValues.FACEBOOK_CONNECT_OAUTH_TOKEN_URL);
	}

	public String getAppId(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_APP_ID,
			PropsValues.FACEBOOK_CONNECT_APP_ID);
	}

	public String getAppSecret(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_APP_SECRET,
			PropsValues.FACEBOOK_CONNECT_APP_SECRET);
	}

	public String getAuthURL(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_OAUTH_AUTH_URL,
			PropsValues.FACEBOOK_CONNECT_OAUTH_AUTH_URL);
	}

	public JSONObject getGraphResources(
		long companyId, String path, String accessToken, String fields) {

		try {
			String url = HttpUtil.addParameter(
				getGraphURL(companyId) + path, "access_token", accessToken);

			if (Validator.isNotNull(fields)) {
				url = HttpUtil.addParameter(url, "fields", fields);
			}

			Http.Options options = new Http.Options();

			options.setLocation(url);

			String json = HttpUtil.URLtoString(options);

			return JSONFactoryUtil.createJSONObject(json);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		return null;
	}

	public String getGraphURL(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_GRAPH_URL,
			PropsValues.FACEBOOK_CONNECT_GRAPH_URL);
	}

	public String getProfileImageURL(PortletRequest portletRequest) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		request = PortalUtil.getOriginalServletRequest(request);

		HttpSession session = request.getSession();

		String facebookId = (String)session.getAttribute(
			WebKeys.FACEBOOK_USER_ID);

		if (Validator.isNull(facebookId)) {
			return null;
		}

		long companyId = PortalUtil.getCompanyId(request);

		String token = (String)session.getAttribute(
			WebKeys.FACEBOOK_ACCESS_TOKEN);

		JSONObject jsonObject = getGraphResources(
			companyId, "/me", token, "id,picture");

		return jsonObject.getString("picture");
	}

	public String getRedirectURL(long companyId) throws SystemException {
		return PrefsPropsUtil.getString(
			companyId, PropsKeys.FACEBOOK_CONNECT_OAUTH_REDIRECT_URL,
			PropsValues.FACEBOOK_CONNECT_OAUTH_REDIRECT_URL);
	}

	public boolean isEnabled(long companyId) throws SystemException {
		return PrefsPropsUtil.getBoolean(
			companyId, PropsKeys.FACEBOOK_CONNECT_AUTH_ENABLED,
			PropsValues.FACEBOOK_CONNECT_AUTH_ENABLED);
	}

	private static Log _log = LogFactoryUtil.getLog(FacebookConnectImpl.class);

}