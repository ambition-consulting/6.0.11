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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PropsUtil;

import com.opensymphony.oscache.base.CacheEntry;

import java.util.Properties;

import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.CacheProvider;
import org.hibernate.cache.Timestamper;
import org.hibernate.util.StringHelper;

/**
 * @author	   Mathias Bogaert
 * @author	   Brian Wing Shun Chan
 * @deprecated
 */
public class OSCacheProvider implements CacheProvider {

	public static final String OSCACHE_REFRESH_PERIOD = "refresh.period";

	public static final String OSCACHE_CRON = "cron";

	public Cache buildCache(String region, Properties properties)
		throws CacheException {

		int refreshPeriod = GetterUtil.getInteger(
			PropsUtil.get(StringHelper.qualify(region, OSCACHE_REFRESH_PERIOD)),
			CacheEntry.INDEFINITE_EXPIRY);

		String cron = PropsUtil.get(StringHelper.qualify(region, OSCACHE_CRON));

		return new CacheWrapper(new OSCache(refreshPeriod, cron, region));
	}

	public boolean isMinimalPutsEnabledByDefault() {
		return false;
	}

	public long nextTimestamp() {
		return Timestamper.next();
	}

	public void start(Properties properties) throws CacheException {
	}

	public void stop() {
	}

}