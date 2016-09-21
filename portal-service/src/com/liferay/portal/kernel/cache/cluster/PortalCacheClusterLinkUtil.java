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

package com.liferay.portal.kernel.cache.cluster;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Shuyang Zhou
 */
public class PortalCacheClusterLinkUtil {

	public static PortalCacheClusterLink getPortalCacheClusterLink() {
		if (_portalCacheClusterLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"PortalCacheClusterLinkUtil has not been initialized.");
			}

			return null;
		}

		return _portalCacheClusterLink;
	}

	public static long getSubmittedEventNumber() {
		if (_portalCacheClusterLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"PortalCacheClusterLinkUtil has not been initialized.");
			}

			return -1;
		}

		return _portalCacheClusterLink.getSubmittedEventNumber();
	}

	public static void sendEvent(
		PortalCacheClusterEvent portalCacheClusterEvent) {

		if (_portalCacheClusterLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"PortalCacheClusterLinkUtil has not been initialized.");
			}

			return;
		}

		_portalCacheClusterLink.sendEvent(portalCacheClusterEvent);
	}

	public void setPortalCacheClusterLink(
		PortalCacheClusterLink portalCacheClusterLink) {

		_portalCacheClusterLink = portalCacheClusterLink;
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortalCacheClusterLinkUtil.class);

	private static PortalCacheClusterLink _portalCacheClusterLink;

}