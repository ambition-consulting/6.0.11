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

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Properties;

import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.CacheProvider;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated
 */
public class CacheProviderWrapper implements CacheProvider {

	public CacheProviderWrapper(CacheProvider cacheProvider) {
		this.cacheProvider = cacheProvider;
	}

	public CacheProviderWrapper(String cacheProviderClassName) {
		try {
			cacheProvider = (CacheProvider)Class.forName(
				cacheProviderClassName).newInstance();
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public Cache buildCache(String regionName, Properties properties)
		throws CacheException {

		return new CacheWrapper(
			cacheProvider.buildCache(regionName, properties));
	}

	public boolean isMinimalPutsEnabledByDefault() {
		return cacheProvider.isMinimalPutsEnabledByDefault();
	}

	public long nextTimestamp() {
		return cacheProvider.nextTimestamp();
	}

	public void start(Properties properties) throws CacheException {
		cacheProvider.start(properties);
	}

	public void stop() {
		cacheProvider.stop();
	}

	protected CacheProvider cacheProvider;

	private static Log _log = LogFactoryUtil.getLog(CacheProviderWrapper.class);

}