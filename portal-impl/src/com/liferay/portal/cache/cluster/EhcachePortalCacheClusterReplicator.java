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

package com.liferay.portal.cache.cluster;

import com.liferay.portal.kernel.cache.cluster.PortalCacheClusterEvent;
import com.liferay.portal.kernel.cache.cluster.PortalCacheClusterEventType;
import com.liferay.portal.kernel.cache.cluster.PortalCacheClusterLinkUtil;
import com.liferay.portal.kernel.util.StringPool;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.distribution.CacheReplicator;

/**
 * @author Shuyang Zhou
 */
public class EhcachePortalCacheClusterReplicator implements CacheReplicator {

	public boolean alive() {
		return true;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void dispose() {
	}

	public boolean isReplicateUpdatesViaCopy() {
		return false;
	}

	public boolean notAlive() {
		return false;
	}

	public void notifyElementEvicted(Ehcache ehcache, Element element) {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), element.getKey(),
				PortalCacheClusterEventType.EVICTED));
	}

	public void notifyElementExpired(Ehcache ehcache, Element element) {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), element.getKey(),
				PortalCacheClusterEventType.EXPIRED));
	}

	public void notifyElementPut(Ehcache ehcache, Element element)
		throws CacheException {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), element.getKey(),
				PortalCacheClusterEventType.PUT));
	}

	public void notifyElementRemoved(Ehcache ehcache, Element element)
		throws CacheException {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), element.getKey(),
				PortalCacheClusterEventType.REMOVE));
	}

	public void notifyElementUpdated(Ehcache ehcache, Element element)
		throws CacheException {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), element.getKey(),
				PortalCacheClusterEventType.UPDATE));
	}

	public void notifyRemoveAll(Ehcache ehcache) {
		PortalCacheClusterLinkUtil.sendEvent(
			new PortalCacheClusterEvent(
				ehcache.getName(), StringPool.BLANK,
				PortalCacheClusterEventType.REMOVEALL));
	}

}