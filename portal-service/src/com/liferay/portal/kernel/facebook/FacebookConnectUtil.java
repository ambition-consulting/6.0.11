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

package com.liferay.portal.kernel.facebook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;

import javax.portlet.PortletRequest;

/**
 * @author Wilson Man
 * @author Brian Wing Shun Chan
 */
public class FacebookConnectUtil {

	public static String getAccessTokenURL(long companyId)
		throws SystemException {

		return getFacebookConnect().getAccessTokenURL(companyId);
	}

	public static String getAppId(long companyId) throws SystemException {
		return getFacebookConnect().getAppId(companyId);
	}

	public static String getAppSecret(long companyId) throws SystemException {
		return getFacebookConnect().getAppSecret(companyId);
	}

	public static String getAuthURL(long companyId) throws SystemException {
		return getFacebookConnect().getAuthURL(companyId);
	}

	public static FacebookConnect getFacebookConnect() {
		return _facebookConnect;
	}

	public static JSONObject getGraphResources(
		long companyId, String path, String accessToken, String fields) {

		return getFacebookConnect().getGraphResources(
			companyId, path, accessToken, fields);
	}

	public static String getGraphURL(long companyId) throws SystemException {
		return getFacebookConnect().getGraphURL(companyId);
	}

	public static String getProfileImageURL(PortletRequest portletRequest) {
		return getFacebookConnect().getProfileImageURL(portletRequest);
	}

	public static String getRedirectURL(long companyId) throws SystemException {
		return getFacebookConnect().getRedirectURL(companyId);
	}

	public static boolean isEnabled(long companyId) throws SystemException {
		return getFacebookConnect().isEnabled(companyId);
	}

	public void setFacebookConnect(FacebookConnect facebookConnect) {
		_facebookConnect = facebookConnect;
	}

	private static FacebookConnect _facebookConnect;

}