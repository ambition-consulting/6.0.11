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

package com.liferay.portal.kernel.messaging;

import com.liferay.portal.kernel.concurrent.ConcurrentHashSet;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.Set;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public abstract class BaseDestination implements Destination {

	public void addDestinationEventListener(
		DestinationEventListener destinationEventListener) {

		_destinationEventListeners.add(destinationEventListener);
	}

	public void afterPropertiesSet() {
		if (Validator.isNull(name)) {
			throw new IllegalArgumentException("Name is null");
		}

		open();
	}

	public void close() {
		close(false);
	}

	public void close(boolean force) {
	}

	public void copyDestinationEventListeners(Destination destination) {
		for (DestinationEventListener destinationEventListener :
				_destinationEventListeners) {

			destination.addDestinationEventListener(
				destinationEventListener);
		}
	}

	public void copyMessageListeners(Destination destination) {
		for (MessageListener messageListener : messageListeners) {
			InvokerMessageListener invokerMessageListener =
				(InvokerMessageListener)messageListener;

			destination.register(
				invokerMessageListener.getMessageListener(),
				invokerMessageListener.getClassLoader());
		}
	}

	public int getMessageListenerCount() {
		return messageListeners.size();
	}

	public Set<MessageListener> getMessageListeners() {
		return Collections.unmodifiableSet(messageListeners);
	}

	public String getName() {
		return name;
	}

	public boolean isRegistered() {
		if (getMessageListenerCount() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void open() {
	}

	public boolean register(MessageListener messageListener) {
		InvokerMessageListener invokerMessageListener =
			new InvokerMessageListener(messageListener);

		return registerMessageListener(invokerMessageListener);
	}

	public boolean register(
		MessageListener messageListener, ClassLoader classloader) {

		InvokerMessageListener invokerMessageListener =
			new InvokerMessageListener(messageListener, classloader);

		return registerMessageListener(invokerMessageListener);
	}

	public void removeDestinationEventListener(
		DestinationEventListener destinationEventListener) {

		_destinationEventListeners.remove(destinationEventListener);
	}

	public void removeDestinationEventListeners() {
		_destinationEventListeners.clear();
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean unregister(MessageListener messageListener) {
		InvokerMessageListener invokerMessageListener =
			new InvokerMessageListener(messageListener);

		return unregisterMessageListener(invokerMessageListener);
	}

	public boolean unregister(
		MessageListener messageListener, ClassLoader classloader) {

		InvokerMessageListener invokerMessageListener =
			new InvokerMessageListener(messageListener, classloader);

		return unregisterMessageListener(invokerMessageListener);
	}

	public void unregisterMessageListeners() {
		for (MessageListener messageListener : messageListeners) {
			unregisterMessageListener((InvokerMessageListener)messageListener);
		}
	}

	protected void fireMessageListenerRegisteredEvent(
		MessageListener messageListener) {

		for (DestinationEventListener destinationEventListener :
				_destinationEventListeners) {

			destinationEventListener.messageListenerRegistered(
				getName(), messageListener);
		}
	}

	protected void fireMessageListenerUnregisteredEvent(
		MessageListener messageListener) {

		for (DestinationEventListener listener : _destinationEventListeners) {
			listener.messageListenerUnregistered(getName(), messageListener);
		}
	}

	protected boolean registerMessageListener(
		InvokerMessageListener invokerMessageListener) {

		boolean registered = messageListeners.add(invokerMessageListener);

		if (registered) {
			fireMessageListenerRegisteredEvent(
				invokerMessageListener.getMessageListener());
		}

		return registered;
	}

	protected boolean unregisterMessageListener(
		InvokerMessageListener invokerMessageListener) {

		boolean unregistered = messageListeners.remove(invokerMessageListener);

		if (unregistered) {
			fireMessageListenerUnregisteredEvent(
				invokerMessageListener.getMessageListener());
		}

		return unregistered;
	}

	protected Set<MessageListener> messageListeners =
		new ConcurrentHashSet<MessageListener>();
	protected String name = StringPool.BLANK;

	private Set<DestinationEventListener> _destinationEventListeners =
		new ConcurrentHashSet<DestinationEventListener>();

}