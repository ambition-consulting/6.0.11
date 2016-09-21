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

import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.cache.key.CacheKeyGeneratorUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class FinderPath {

	public FinderPath(
		boolean entityCacheEnabled, boolean finderCacheEnabled,
		String className, String methodName, String[] params) {

		_entityCacheEnabled = entityCacheEnabled;
		_finderCacheEnabled = finderCacheEnabled;
		_className = className;
		_methodName = methodName;
		_params = params;

		_initCacheKeyPrefix();
		_initLocalCacheKeyPrefix();
	}

	public String encodeCacheKey(Object[] args) {
		StringBundler sb = new StringBundler(args.length * 2 + 1);

		sb.append(_cacheKeyPrefix);

		for (Object arg : args) {
			sb.append(StringPool.PERIOD);
			sb.append(StringUtil.toHexString(arg));
		}

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(
				FinderCache.class.getName());

		return cacheKeyGenerator.getCacheKey(sb);
	}

	public String encodeLocalCacheKey(Object[] args) {
		StringBundler sb = new StringBundler(args.length * 2 + 1);

		sb.append(_localCacheKeyPrefix);

		for (Object arg : args) {
			sb.append(StringPool.PERIOD);
			sb.append(StringUtil.toHexString(arg));
		}

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(
				FinderCache.class.getName());

		return cacheKeyGenerator.getCacheKey(sb);
	}

	public String getClassName() {
		return _className;
	}

	public String getMethodName() {
		return _methodName;
	}

	public String[] getParams() {
		return _params;
	}

	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	private void _initCacheKeyPrefix() {
		StringBundler sb = new StringBundler(_params.length * 2 + 3);

		sb.append(_methodName);
		sb.append(_PARAMS_SEPARATOR);

		for (String param : _params) {
			sb.append(StringPool.PERIOD);
			sb.append(param);
		}

		sb.append(_ARGS_SEPARATOR);

		_cacheKeyPrefix = sb.toString();
	}

	private void _initLocalCacheKeyPrefix() {
		_localCacheKeyPrefix = _className.concat(StringPool.PERIOD).concat(
			_cacheKeyPrefix);
	}

	private static final String _ARGS_SEPARATOR = "_A_";

	private static final String _PARAMS_SEPARATOR = "_P_";

	private String _cacheKeyPrefix;
	private String _className;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
	private String _localCacheKeyPrefix;
	private String _methodName;
	private String[] _params;

}