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

package com.liferay.portal.cache.cluster.clusterlink.messaging;

import com.liferay.portal.cache.ehcache.EhcachePortalCacheManager;
import com.liferay.portal.dao.orm.hibernate.EhCacheProvider;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.cache.cluster.PortalCacheClusterEvent;
import com.liferay.portal.kernel.cache.cluster.PortalCacheClusterEventType;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * @author Shuyang Zhou
 */
public class ClusterLinkPortalCacheClusterRemoveListener
	extends BaseMessageListener {

	public ClusterLinkPortalCacheClusterRemoveListener()
		throws SystemException {

		_hibernateCacheManager = EhCacheProvider.getCacheManager();

		EhcachePortalCacheManager ehcachePortalCacheManager =
			(EhcachePortalCacheManager)PortalBeanLocatorUtil.locate(
				_MULTI_VM_PORTAL_CACHE_MANAGER_BEAN_NAME);

		_portalCacheManager = ehcachePortalCacheManager.getEhcacheManager();
	}

	protected void doReceive(Message message) throws Exception {
		PortalCacheClusterEvent portalCacheClusterEvent =
			(PortalCacheClusterEvent)message.getPayload();

		if (portalCacheClusterEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("Payload is null");
			}

			return;
		}

		String cacheName = portalCacheClusterEvent.getCacheName();

		Cache cache = _portalCacheManager.getCache(cacheName);

		if (cache == null) {
			cache = _hibernateCacheManager.getCache(cacheName);
		}

		if (cache != null) {
			PortalCacheClusterEventType portalCacheClusterEventType =
				portalCacheClusterEvent.getEventType();

			if (portalCacheClusterEventType.equals(
					PortalCacheClusterEventType.REMOVEALL)) {

				cache.removeAll(true);
			}
			else {
				cache.remove(portalCacheClusterEvent.getElementKey(), true);
			}
		}
	}

	private static final String _MULTI_VM_PORTAL_CACHE_MANAGER_BEAN_NAME =
		"com.liferay.portal.kernel.cache.MultiVMPortalCacheManager";

	private static Log _log = LogFactoryUtil.getLog(
		ClusterLinkPortalCacheClusterRemoveListener.class);

	private CacheManager _hibernateCacheManager;
	private CacheManager _portalCacheManager;

}