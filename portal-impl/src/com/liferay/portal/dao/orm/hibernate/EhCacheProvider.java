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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ReflectionUtil;

import java.lang.reflect.Field;

import java.util.Properties;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.util.FailSafeTimer;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.CacheProvider;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
@SuppressWarnings("deprecation")
public class EhCacheProvider extends CacheProviderWrapper {

	public static CacheManager getCacheManager() throws SystemException {
		try {
			Class<?> clazz = Class.forName(
				"net.sf.ehcache.hibernate.AbstractEhcacheProvider");

			Field field = clazz.getDeclaredField("manager");

			field.setAccessible(true);

			CacheManager cacheManager = (CacheManager)field.get(
				_cacheProvider);

			if (cacheManager == null) {
				throw new SystemException("CacheManager has been initialized");
			}

			return cacheManager;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public EhCacheProvider() {
		super("net.sf.ehcache.hibernate.EhCacheProvider");

		_cacheProvider = cacheProvider;
	}

	public void start(Properties properties) throws CacheException {
		super.start(properties);

		try {
			CacheManager cacheManager = getCacheManager();

			FailSafeTimer failSafeTimer = cacheManager.getTimer();

			failSafeTimer.cancel();

			Field cacheManagerTimerField = ReflectionUtil.getDeclaredField(
				CacheManager.class, "cacheManagerTimer");

			cacheManagerTimerField.set(cacheManager, null);
		}
		catch (Exception e) {
			throw new CacheException(e);
		}
	}

	private static CacheProvider _cacheProvider;

}