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

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.servlet.ImageServletToken;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.servlet.filters.cache.CacheUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageServletTokenImpl implements ImageServletToken {

	public static final String CACHE_NAME = ImageServletToken.class.getName();

	public void afterPropertiesSet() {
		_portalCache = _multiVMPool.getCache(CACHE_NAME);
	}

	public String getToken(long imageId) {
		String key = _encodeKey(imageId);

		String token = (String)_portalCache.get(key);

		if (token == null) {
			token = _createToken(imageId);

			_portalCache.put(key, token);
		}

		return token;
	}

	public void resetToken(long imageId) {
		String key = _encodeKey(imageId);

		_portalCache.remove(key);

		// Journal content

		JournalContentUtil.clearCache();

		// Layout cache

		CacheUtil.clearCache();
	}

	public void setMultiVMPool(MultiVMPool multiVMPool) {
		_multiVMPool = multiVMPool;
	}

	private String _createToken(long imageId) {
		return String.valueOf(System.currentTimeMillis());
	}

	private String _encodeKey(long imageId) {
		return CACHE_NAME.concat(StringPool.POUND).concat(
			StringUtil.toHexString(imageId));
	}

	private MultiVMPool _multiVMPool;
	private PortalCache _portalCache;

}