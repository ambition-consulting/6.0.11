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

package com.liferay.portal.cache.key;

import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class HashCodeCacheKeyGenerator extends BaseCacheKeyGenerator {

	public CacheKeyGenerator clone() {
		return new HashCodeCacheKeyGenerator();
	}

	public String getCacheKey(String key) {
		return StringUtil.toHexString(key.hashCode());
	}

	public String getCacheKey(String[] keys) {
		int hashCode = 0;
		int weight = 1;

		for (int i = keys.length - 1; i >= 0; i--) {
			String s = keys[i];

			hashCode = s.hashCode() * weight + hashCode;

			for (int j = 0; j < s.length(); j++) {
				weight *= 31;
			}
		}

		return StringUtil.toHexString(hashCode);
	}

	public String getCacheKey(StringBundler sb) {
		int hashCode = 0;
		int weight = 1;

		for (int i = sb.index() - 1; i >= 0; i--) {
			String s = sb.stringAt(i);

			hashCode = s.hashCode() * weight + hashCode;

			for (int j = 0; j < s.length(); j++) {
				weight *= 31;
			}
		}

		return StringUtil.toHexString(hashCode);
	}

}