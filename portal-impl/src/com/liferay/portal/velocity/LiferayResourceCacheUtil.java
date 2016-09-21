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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;

import org.apache.velocity.runtime.resource.Resource;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayResourceCacheUtil {

	public static final String CACHE_NAME =
		LiferayResourceCacheUtil.class.getName();

	public static void clear() {
		_multiVMPortalCache.removeAll();
		_singleVMPortalCache.removeAll();
	}

	public static Resource get(String key) {
		Object obj = _singleVMPortalCache.get(key);

		if ((obj != null) && (obj instanceof Resource)) {
			Resource resource = (Resource)obj;

			Long lastModified = (Long)_multiVMPortalCache.get(key);

			if ((lastModified != null) &&
				lastModified.equals(resource.getLastModified())) {

				return resource;
			}

			_singleVMPortalCache.remove(key);
		}

		return null;
	}

	public static void put(String key, Resource resource) {
		_multiVMPortalCache.put(key, resource.getLastModified());
		_singleVMPortalCache.put(key, resource);
	}

	public static void remove(String key) {
		_multiVMPortalCache.remove(key);
		_singleVMPortalCache.remove(key);
	}

	private static PortalCache _multiVMPortalCache = MultiVMPoolUtil.getCache(
		CACHE_NAME);
	private static PortalCache _singleVMPortalCache = SingleVMPoolUtil.getCache(
		CACHE_NAME);

}