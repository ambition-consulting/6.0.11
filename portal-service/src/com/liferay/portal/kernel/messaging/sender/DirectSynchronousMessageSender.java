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

package com.liferay.portal.kernel.messaging.sender;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.messaging.SynchronousDestination;

import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class DirectSynchronousMessageSender
	implements SynchronousMessageSender {

	public Object send(String destinationName, Message message) {
		Destination destination = _messageBus.getDestination(destinationName);

		if (destination == null) {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Destination " + destinationName + " is not configured");
			}

			return null;
		}

		if (destination.getMessageListenerCount() == 0) {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Destination " + destinationName +
						" does not have any message listeners");
			}

			return null;
		}

		if (destination instanceof SynchronousDestination) {
			destination.send(message);
		}
		else {
			Set<MessageListener> messageListeners =
				destination.getMessageListeners();

			for (MessageListener messageListener : messageListeners) {
				try {
					messageListener.receive(message);
				}
				catch (MessageListenerException mle) {
					_log.error("Unable to process message " + message, mle);
				}
			}
		}

		return message.getResponse();
	}

	public Object send(String destinationName, Message message, long timeout) {
		if (_log.isWarnEnabled()) {
			_log.warn(
				DirectSynchronousMessageSender.class.getName() +
					" does not support timeout");
		}

		return send(destinationName, message);
	}

	public void setMessageBus(MessageBus messageBus) {
		_messageBus = messageBus;
	}

	private static Log _log = LogFactoryUtil.getLog(
		DirectSynchronousMessageSender.class);

	private MessageBus _messageBus;

}