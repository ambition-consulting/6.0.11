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

package com.liferay.portal.kernel.cache;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 */
public interface SingleVMPool {

	public void clear();

	public void clear(String name);

	public Object get(String name, String key);

	/**
	 * @deprecated
	 */
	public Object get(PortalCache portalCache, String key);

	public PortalCache getCache(String name);

	public PortalCache getCache(String name, boolean blocking);

	public void put(String name, String key, Object obj);

	/**
	 * @deprecated
	 */
	public void put(PortalCache portalCache, String key, Object obj);

	/**
	 * @deprecated
	 */
	public void put(
		PortalCache portalCache, String key, Object obj, int timeToLive);

	public void put(String name, String key, Serializable obj);

	/**
	 * @deprecated
	 */
	public void put(PortalCache portalCache, String key, Serializable obj);

	/**
	 * @deprecated
	 */
	public void put(
		PortalCache portalCache, String key, Serializable obj, int timeToLive);

	public void remove(String name, String key);

	/**
	 * @deprecated
	 */
	public void remove(PortalCache portalCache, String key);

	public void removeCache(String name);

}