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

package com.liferay.portal.liveusers.messaging;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.liveusers.LiveUsers;

/**
 * @author Brian Wing Shun Chan
 */
public class LiveUsersMessageListener extends BaseMessageListener {

	protected void doCommandSignIn(JSONObject jsonObject) throws Exception {
		long companyId = jsonObject.getLong("companyId");
		long userId = jsonObject.getLong("userId");
		String sessionId = jsonObject.getString("sessionId");
		String remoteAddr = jsonObject.getString("remoteAddr");
		String remoteHost = jsonObject.getString("remoteHost");
		String userAgent = jsonObject.getString("userAgent");

		LiveUsers.signIn(
			companyId, userId, sessionId, remoteAddr, remoteHost, userAgent);
	}

	protected void doCommandSignOut(JSONObject jsonObject) throws Exception {
		long companyId = jsonObject.getLong("companyId");
		long userId = jsonObject.getLong("userId");
		String sessionId = jsonObject.getString("sessionId");

		LiveUsers.signOut(companyId, userId, sessionId);
	}

	protected void doReceive(Message message) throws Exception {
		String payload = (String)message.getPayload();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);

		String command = jsonObject.getString("command");

		if (command.equals("signIn")) {
			doCommandSignIn(jsonObject);
		}
		else if (command.equals("signOut")) {
			doCommandSignOut(jsonObject);
		}
	}

}