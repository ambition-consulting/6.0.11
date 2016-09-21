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

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;

import java.util.Collections;
import java.util.List;

/**
 * @author Shuyang Zhou
 */
public class ClusterLinkUtil {

	public static Address getAddress(Message message) {
		return (Address)message.get(_ADDRESS);
	}

	public static ClusterLink getClusterLink() {
		if ((_clusterLink == null) || !_clusterLink.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterLinkUtil has not been initialized");
			}

			return null;
		}

		return _clusterLink;
	}

	public static List<Address> getLocalTransportAddresses() {
		if ((_clusterLink == null) || !_clusterLink.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterLinkUtil has not been initialized");
			}

			return Collections.EMPTY_LIST;
		}

		return _clusterLink.getLocalTransportAddresses();
	}

	public static List<Address> getTransportAddresses(Priority priority) {
		if ((_clusterLink == null) || !_clusterLink.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterLinkUtil has not been initialized");
			}

			return Collections.EMPTY_LIST;
		}

		return _clusterLink.getTransportAddresses(priority);
	}

	public static boolean isForwardMessage(Message message) {
		return message.getBoolean(_CLUSTER_FORWARD_MESSAGE);
	}

	public static void sendMulticastMessage(
		Message message, Priority priority) {

		if ((_clusterLink == null) || !_clusterLink.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterLinkUtil has not been initialized");
			}

			return;
		}

		_clusterLink.sendMulticastMessage(message, priority);
	}

	public static void sendMulticastMessage(
		Object payload, Priority priority) {

		Message message = new Message();

		message.setPayload(payload);

		sendMulticastMessage(message, priority);
	}

	public static void sendUnicastMessage(
		Address address, Message message, Priority priority) {

		if ((_clusterLink == null) || !_clusterLink.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterLinkUtil has not been initialized");
			}

			return;
		}

		_clusterLink.sendUnicastMessage(address, message, priority);
	}

	public static Message setAddress(Message message, Address address) {
		message.put(_ADDRESS, address);

		return message;
	}

	public static void setForwardMessage(Message message) {
		message.put(_CLUSTER_FORWARD_MESSAGE, true);
	}

	public void setClusterLink(ClusterLink clusterLink) {
		_clusterLink = clusterLink;
	}

	private static final String _ADDRESS = "CLUSTER_ADDRESS";

	private static final String _CLUSTER_FORWARD_MESSAGE =
		"CLUSTER_FORWARD_MESSAGE";

	private static Log _log = LogFactoryUtil.getLog(ClusterLinkUtil.class);

	private static ClusterLink _clusterLink;

}