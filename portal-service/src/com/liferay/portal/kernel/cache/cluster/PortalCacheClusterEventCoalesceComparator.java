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

import java.util.Comparator;

/**
 * @author Shuyang Zhou
 */
public class PortalCacheClusterEventCoalesceComparator
	implements Comparator<PortalCacheClusterEvent> {

	public int compare(
		PortalCacheClusterEvent portalCacheClusterEvent1,
		PortalCacheClusterEvent portalCacheClusterEvent2) {

		if ((portalCacheClusterEvent1 == null) ||
			(portalCacheClusterEvent2 == null)) {

			return 1;
		}

		if (portalCacheClusterEvent1.getCacheName().equals(
				portalCacheClusterEvent2.getCacheName()) &&
			portalCacheClusterEvent1.getElementKey().equals(
				portalCacheClusterEvent2.getElementKey())) {

			return 0;
		}
		else {
			return -1;
		}
	}

}