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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Brian Wing Shun Chan
 */
public class WebAppPool {

	public static Object get(String webAppId, String key) {
		return _instance._get(webAppId, key);
	}

	public static void put(String webAppId, String key, Object obj) {
		_instance._put(webAppId, key, obj);
	}

	public static Object remove(String webAppId, String key) {
		return _instance._remove(webAppId, key);
	}

	private WebAppPool() {
		_webAppPool = new ConcurrentHashMap<String, Map<String, Object>>();
	}

	private Object _get(String webAppId, String key) {
		Map<String, Object> map = _webAppPool.get(webAppId);

		if (map == null) {
			return null;
		}
		else {
			return map.get(key);
		}
	}

	private void _put(String webAppId, String key, Object obj) {
		Map<String, Object> map = _webAppPool.get(webAppId);

		if (map == null) {
			map = new ConcurrentHashMap<String, Object>();

			_webAppPool.put(webAppId, map);
		}

		map.put(key, obj);
	}

	private Object _remove(String webAppId, String key) {
		Map<String, Object> map = _webAppPool.get(webAppId);

		if (map == null) {
			return null;
		}
		else {
			return map.remove(key);
		}
	}

	private static WebAppPool _instance = new WebAppPool();

	private Map<String, Map<String, Object>> _webAppPool;

}