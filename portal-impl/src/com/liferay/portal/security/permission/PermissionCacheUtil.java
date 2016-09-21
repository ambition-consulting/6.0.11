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

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.cache.key.CacheKeyGeneratorUtil;
import com.liferay.portal.kernel.util.AutoResetThreadLocal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PropsValues;

import java.util.Map;

import org.apache.commons.collections.map.LRUMap;

/**
 * @author Charles May
 * @author Michael Young
 */
public class PermissionCacheUtil {

	public static final String PERMISSION_CACHE_NAME =
		PermissionCacheUtil.class.getName() + "_PERMISSION";

	public static final String PERMISSION_CHECKER_BAG_CACHE_NAME =
		PermissionCacheUtil.class.getName() + "_PERMISSION_CHECKER_BAG";

	public static void clearCache() {
		clearLocalCache();

		_permissionCheckerBagPortalCache.removeAll();
		_permissionPortalCache.removeAll();
	}

	public static void clearLocalCache() {
		if (_localCacheAvailable) {
			Map<String, Object> localCache = _localCache.get();

			localCache.clear();
		}
	}

	public static PermissionCheckerBag getBag(long userId, long groupId) {
		PermissionCheckerBag bag = null;

		String key = _encodeKey(userId, groupId);

		if (_localCacheAvailable) {
			Map<String, Object> localCache = _localCache.get();

			bag = (PermissionCheckerBag)localCache.get(key);
		}

		if (bag == null) {
			bag = (PermissionCheckerBag)_permissionCheckerBagPortalCache.get(
				key);
		}

		return bag;
	}

	public static Boolean getPermission(
		long userId, long groupId, String name, String primKey,
		String actionId) {

		Boolean value = null;

		String key = _encodeKey(userId, groupId, name, primKey, actionId);

		if (_localCacheAvailable) {
			Map<String, Object> localCache = _localCache.get();

			value = (Boolean)localCache.get(key);
		}

		if (value == null) {
			value = (Boolean)_permissionPortalCache.get(key);
		}

		return value;
	}

	public static PermissionCheckerBag putBag(
		long userId, long groupId, PermissionCheckerBag bag) {

		if (bag != null) {
			String key = _encodeKey(userId, groupId);

			if (_localCacheAvailable) {
				Map<String, Object> localCache = _localCache.get();

				localCache.put(key, bag);
			}

			_permissionCheckerBagPortalCache.put(key, bag);
		}

		return bag;
	}

	public static Boolean putPermission(
		long userId, long groupId, String name, String primKey, String actionId,
		Boolean value) {

		if (value != null) {
			String key = _encodeKey(userId, groupId, name, primKey, actionId);

			if (_localCacheAvailable) {
				Map<String, Object> localCache = _localCache.get();

				localCache.put(key, value);
			}

			_permissionPortalCache.put(key, value);
		}

		return value;
	}

	private static String _encodeKey(long userId, long groupId) {
		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(
				PERMISSION_CHECKER_BAG_CACHE_NAME);

		cacheKeyGenerator.append(StringUtil.toHexString(userId));
		cacheKeyGenerator.append(StringUtil.toHexString(groupId));

		return cacheKeyGenerator.finish();
	}

	private static String _encodeKey(
		long userId, long groupId, String name, String primKey,
		String actionId) {

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(
				PERMISSION_CHECKER_BAG_CACHE_NAME);

		cacheKeyGenerator.append(StringUtil.toHexString(userId));
		cacheKeyGenerator.append(StringUtil.toHexString(groupId));
		cacheKeyGenerator.append(name);
		cacheKeyGenerator.append(primKey);
		cacheKeyGenerator.append(actionId);

		return cacheKeyGenerator.finish();
	}

	private static ThreadLocal<LRUMap> _localCache;
	private static boolean _localCacheAvailable;
	private static PortalCache _permissionCheckerBagPortalCache =
		MultiVMPoolUtil.getCache(
			PERMISSION_CHECKER_BAG_CACHE_NAME,
			PropsValues.PERMISSIONS_OBJECT_BLOCKING_CACHE);
	private static PortalCache _permissionPortalCache =
		MultiVMPoolUtil.getCache(
			PERMISSION_CACHE_NAME,
			PropsValues.PERMISSIONS_OBJECT_BLOCKING_CACHE);

	static {
		if (PropsValues.PERMISSIONS_THREAD_LOCAL_CACHE_MAX_SIZE > 0) {
			_localCache = new AutoResetThreadLocal<LRUMap>(
				PermissionCacheUtil.class + "._localCache",
				new LRUMap(
					PropsValues.PERMISSIONS_THREAD_LOCAL_CACHE_MAX_SIZE));
			_localCacheAvailable = true;
		}
	}

}