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

package com.liferay.portal.kernel.dao.orm;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class EntityCacheUtil {

	public static void clearCache() {
		getEntityCache().clearCache();
	}

	public static void clearCache(String className) {
		getEntityCache().clearCache(className);
	}

	public static void clearLocalCache() {
		getEntityCache().clearLocalCache();
	}

	public static EntityCache getEntityCache() {
		return _finderCache;
	}

	public static Object getResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory) {

		return getEntityCache().getResult(
			entityCacheEnabled, classObj, primaryKeyObj, sessionFactory);
	}

	public static void invalidate() {
		getEntityCache().invalidate();
	}

	public static Object loadResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory) {

		return getEntityCache().loadResult(
			entityCacheEnabled, classObj, primaryKeyObj, sessionFactory);
	}

	public static void putResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, Object result) {

		getEntityCache().putResult(
			entityCacheEnabled, classObj, primaryKeyObj, result);
	}

	public static void removeCache(String className) {
		getEntityCache().removeCache(className);
	}

	public static void removeResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj) {

		getEntityCache().removeResult(
			entityCacheEnabled, classObj, primaryKeyObj);
	}

	public void setEntityCache(EntityCache finderCache) {
		_finderCache = finderCache;
	}

	private static EntityCache _finderCache;

}