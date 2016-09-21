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

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

/**
 * @author Shuyang Zhou
 */
public class EhcachePortalCacheClusterReplicatorFactory
	extends CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties prprts) {
		return _cacheEventListener;
	}

	private static final CacheEventListener _cacheEventListener =
		new EhcachePortalCacheClusterReplicator();

}