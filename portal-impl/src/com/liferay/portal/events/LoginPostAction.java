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

package com.liferay.portal.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginPostAction extends Action {

	public void run(HttpServletRequest request, HttpServletResponse response)
		throws ActionException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Running " + request.getRemoteUser());
			}

			HttpSession session = request.getSession();

			long companyId = PortalUtil.getCompanyId(request);
			long userId = PortalUtil.getUserId(request);

			// Language

			session.removeAttribute(Globals.LOCALE_KEY);

			// Live users

			if (PropsValues.LIVE_USERS_ENABLED) {
				String sessionId = session.getId();
				String remoteAddr = request.getRemoteAddr();
				String remoteHost = request.getRemoteHost();
				String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("command", "signIn");
				jsonObject.put("companyId", companyId);
				jsonObject.put("userId", userId);
				jsonObject.put("sessionId", sessionId);
				jsonObject.put("remoteAddr", remoteAddr);
				jsonObject.put("remoteHost", remoteHost);
				jsonObject.put("userAgent", userAgent);

				MessageBusUtil.sendMessage(
					DestinationNames.LIVE_USERS, jsonObject.toString());
			}

			if (PrefsPropsUtil.getBoolean(
					companyId, PropsKeys.ADMIN_SYNC_DEFAULT_ASSOCIATIONS)) {

				UserLocalServiceUtil.addDefaultGroups(userId);
				UserLocalServiceUtil.addDefaultRoles(userId);
				UserLocalServiceUtil.addDefaultUserGroups(userId);
			}
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LoginPostAction.class);

}