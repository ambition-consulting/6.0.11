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

package com.liferay.portal.util;

import com.liferay.portal.cache.CacheRegistryImpl;
import com.liferay.portal.configuration.ConfigurationFactoryImpl;
import com.liferay.portal.dao.db.DBFactoryImpl;
import com.liferay.portal.dao.jdbc.DataSourceFactoryImpl;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaProps;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.log.Log4jLogFactoryImpl;
import com.liferay.portal.spring.util.SpringUtil;
import com.liferay.util.SystemProperties;
import com.liferay.util.log4j.Log4JUtil;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Brian Wing Shun Chan
 */
public class InitUtil {

	public static synchronized void init() {
		if (_initialized) {
			return;
		}

		StopWatch stopWatch = null;

		if (_PRINT_TIME) {
			stopWatch = new StopWatch();

			stopWatch.start();
		}

		// Set the default locale used by Liferay. This locale is no longer set
		// at the VM level. See LEP-2584.

		String userLanguage = SystemProperties.get("user.language");
		String userCountry = SystemProperties.get("user.country");
		String userVariant = SystemProperties.get("user.variant");

		LocaleUtil.setDefault(userLanguage, userCountry, userVariant);

		// Set the default time zone used by Liferay. This time zone is no
		// longer set at the VM level. See LEP-2584.

		String userTimeZone = SystemProperties.get("user.timezone");

		TimeZoneUtil.setDefault(userTimeZone);

		// Shared class loader

		try {
			Thread currentThread = Thread.currentThread();

			PortalClassLoaderUtil.setClassLoader(
				currentThread.getContextClassLoader());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// Log4J

		if (GetterUtil.getBoolean(SystemProperties.get(
				"log4j.configure.on.startup"), true)) {

			ClassLoader classLoader = InitUtil.class.getClassLoader();

			Log4JUtil.configureLog4J(
				classLoader.getResource("META-INF/portal-log4j.xml"));
			Log4JUtil.configureLog4J(
				classLoader.getResource("META-INF/portal-log4j-ext.xml"));
		}

		// Shared log

		try {
			LogFactoryUtil.setLogFactory(new Log4jLogFactoryImpl());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// Cache registry

		CacheRegistryUtil.setCacheRegistry(new CacheRegistryImpl());

		// Configuration factory

		ConfigurationFactoryUtil.setConfigurationFactory(
			new ConfigurationFactoryImpl());

		// Data source factory

		DataSourceFactoryUtil.setDataSourceFactory(new DataSourceFactoryImpl());

		// DB factory

		DBFactoryUtil.setDBFactory(new DBFactoryImpl());

		// Java properties

		JavaProps.isJDK5();

		if (_PRINT_TIME) {
			System.out.println(
				"InitAction takes " + stopWatch.getTime() + " ms");
		}

		_initialized = true;
	}

	public synchronized static void initWithSpring() {
		initWithSpring(false);
	}

	public synchronized static void initWithSpring(boolean force) {
		if (force) {
			_initialized = false;
		}

		if (_initialized) {
			return;
		}

		if (!_neverInitialized) {
			PropsUtil.reload();
		}
		else {
			_neverInitialized = false;
		}

		init();

		SpringUtil.loadContext();

		_initialized = true;
	}

	private static final boolean _PRINT_TIME = false;

	private static boolean _initialized;
	private static boolean _neverInitialized = true;

}