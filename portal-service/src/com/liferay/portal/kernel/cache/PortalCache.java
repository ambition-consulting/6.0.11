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

import java.util.Collection;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortalCache {

	public void destroy();

	public Collection<Object> get(Collection<String> keys);

	public Object get(String key);

	public void put(String key, Object obj);

	public void put(String key, Object obj, int timeToLive);

	public void put(String key, Serializable obj);

	public void put(String key, Serializable obj, int timeToLive);

	public void remove(String key);

	public void removeAll();

	public void setDebug(boolean debug);

}