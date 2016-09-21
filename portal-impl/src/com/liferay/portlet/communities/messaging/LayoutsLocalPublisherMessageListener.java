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

package com.liferay.portlet.communities.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageStatusMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageStatus;
import com.liferay.portal.kernel.messaging.sender.MessageSender;
import com.liferay.portal.kernel.messaging.sender.SingleDestinationMessageSender;
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.Map;

/**
 * @author Bruno Farache
 */
public class LayoutsLocalPublisherMessageListener
	extends BaseMessageStatusMessageListener {

	public LayoutsLocalPublisherMessageListener() {
	}

	/**
	 * @deprecated
	 */
	public LayoutsLocalPublisherMessageListener(
		SingleDestinationMessageSender statusSender,
		MessageSender responseSender) {

		super(statusSender, responseSender);
	}

	protected void doReceive(Message message, MessageStatus messageStatus)
		throws Exception {

		LayoutsLocalPublisherRequest publisherRequest =
			(LayoutsLocalPublisherRequest)message.getPayload();

		messageStatus.setPayload(publisherRequest);

		String command = publisherRequest.getCommand();
		long userId = publisherRequest.getUserId();
		long sourceGroupId = publisherRequest.getSourceGroupId();
		long targetGroupId = publisherRequest.getTargetGroupId();
		boolean privateLayout = publisherRequest.isPrivateLayout();
		Map<Long, Boolean> layoutIdMap = publisherRequest.getLayoutIdMap();
		Map<String, String[]> parameterMap = publisherRequest.getParameterMap();
		Date startDate = publisherRequest.getStartDate();
		Date endDate = publisherRequest.getEndDate();

		String range = MapUtil.getString(parameterMap, "range");

		if (range.equals("last")) {
			int last = MapUtil.getInteger(parameterMap, "last");

			if (last > 0) {
				Date scheduledFireTime =
					publisherRequest.getScheduledFireTime();

				startDate = new Date(
					scheduledFireTime.getTime() - (last * Time.HOUR));

				endDate = scheduledFireTime;
			}
		}

		PrincipalThreadLocal.setName(userId);

		User user = UserLocalServiceUtil.getUserById(userId);

		PermissionChecker permissionChecker =
			PermissionCheckerFactoryUtil.create(user, false);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		try {
			if (command.equals(
					LayoutsLocalPublisherRequest.COMMAND_ALL_PAGES)) {

				StagingUtil.publishLayouts(
					sourceGroupId, targetGroupId, privateLayout, parameterMap,
					startDate, endDate);
			}
			else if (command.equals(
				LayoutsLocalPublisherRequest.COMMAND_SELECTED_PAGES)) {

				StagingUtil.publishLayouts(
					sourceGroupId, targetGroupId, privateLayout, layoutIdMap,
					parameterMap, startDate, endDate);
			}
		}
		finally {
			PrincipalThreadLocal.setName(null);
			PermissionThreadLocal.setPermissionChecker(null);
		}
	}

}