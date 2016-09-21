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

package com.liferay.portal.kernel.scheduler.messaging;

import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.JobState;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

/**
 * @author Shuyang Zhou
 */
public class SchedulerEventMessageListenerWrapper implements MessageListener {

	public void afterPropertiesSet() {
		String jobName = _className;

		if (_className.length() > SchedulerEngine.JOB_NAME_MAX_LENGTH) {
			jobName = _className.substring(
				0, SchedulerEngine.JOB_NAME_MAX_LENGTH);
		}

		String groupName = _className;

		if (_className.length() > SchedulerEngine.GROUP_NAME_MAX_LENGTH) {
			groupName = _className.substring(
				0, SchedulerEngine.GROUP_NAME_MAX_LENGTH);
		}

		_key = jobName.concat(StringPool.PERIOD).concat(groupName);

		if (_messageListenerUUID == null) {
			_messageListenerUUID = PortalUUIDUtil.generate();
		}
	}

	public String getMessageListenerUUID() {
		return _messageListenerUUID;
	}

	public void receive(Message message) throws MessageListenerException {
		String destinationName = GetterUtil.getString(
			message.getString(SchedulerEngine.DESTINATION_NAME));

		if (destinationName.equals(DestinationNames.SCHEDULER_DISPATCH)) {
			String receiverKey = GetterUtil.getString(
				message.getString(SchedulerEngine.RECEIVER_KEY));

			if (!receiverKey.equals(_key)) {
				return;
			}
		}

		try{
			_messageListener.receive(message);
		}
		catch (Exception e) {
			handleException(message, e);

			if (e instanceof MessageListenerException) {
				throw (MessageListenerException)e;
			}
			else {
				throw new MessageListenerException(e);
			}
		}
		finally {
			if (message.getBoolean(SchedulerEngine.DISABLE) &&
				destinationName.equals(DestinationNames.SCHEDULER_DISPATCH)) {

				MessageBusUtil.unregisterMessageListener(
					destinationName, this);
			}
		}
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setMessageListener(MessageListener messageListener) {
		_messageListener = messageListener;
	}

	public void setMessageListenerUUID(String messageListenerUUID) {
		_messageListenerUUID = messageListenerUUID;
	}

	protected void handleException(Message message, Exception exception) {
		JobState jobState = (JobState)message.get(SchedulerEngine.JOB_STATE);

		if (jobState != null) {
			jobState.addException(exception);
		}
	}

	private String _className;
	private String _key;
	private MessageListener _messageListener;
	private String _messageListenerUUID;

}