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
public interface EntityCache {

	public void clearCache();

	public void clearCache(String className);

	public void clearLocalCache();

	public Object getResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory);

	public void invalidate();

	public Object loadResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory);

	public void putResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, Object result);

	public void removeCache(String className);

	public void removeResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj);

}