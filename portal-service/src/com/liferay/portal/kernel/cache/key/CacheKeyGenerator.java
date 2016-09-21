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

package com.liferay.portal.kernel.cache.key;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public interface CacheKeyGenerator extends Cloneable {

	public CacheKeyGenerator append(String key);

	public CacheKeyGenerator append(String[] keys);

	public CacheKeyGenerator append(StringBundler sb);

	public CacheKeyGenerator clone();

	public String finish();

	public String getCacheKey(String key);

	public String getCacheKey(String[] keys);

	public String getCacheKey(StringBundler sb);

}