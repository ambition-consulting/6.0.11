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
public class SingleVMPoolUtil {

	public static void clear() {
		getSingleVMPool().clear();
	}

	public static void clear(String name) {
		getSingleVMPool().clear(name);
	}

	public static Object get(String name, String key) {
		return getSingleVMPool().get(name, key);
	}

	/**
	 * @deprecated
	 */
	public static Object get(PortalCache portalCache, String key) {
		return getSingleVMPool().get(portalCache, key);
	}

	public static PortalCache getCache(String name) {
		return getSingleVMPool().getCache(name);
	}

	public static PortalCache getCache(String name, boolean blocking) {
		return getSingleVMPool().getCache(name, blocking);
	}

	public static SingleVMPool getSingleVMPool() {
		return _singleVMPool;
	}

	public static void put(String name, String key, Object obj) {
		getSingleVMPool().put(name, key, obj);
	}

	/**
	 * @deprecated
	 */
	public static void put(PortalCache portalCache, String key, Object obj) {
		getSingleVMPool().put(portalCache, key, obj);
	}

	/**
	 * @deprecated
	 */
	public static void put(
		PortalCache portalCache, String key, Object obj, int timeToLive) {

		getSingleVMPool().put(portalCache, key, obj, timeToLive);
	}

	public static void put(String name, String key, Serializable obj) {
		getSingleVMPool().put(name, key, obj);
	}

	/**
	 * @deprecated
	 */
	public static void put(
		PortalCache portalCache, String key, Serializable obj) {

		getSingleVMPool().put(portalCache, key, obj);
	}

	/**
	 * @deprecated
	 */
	public static void put(
		PortalCache portalCache, String key, Serializable obj, int timeToLive) {

		getSingleVMPool().put(portalCache, key, obj, timeToLive);
	}

	public static void remove(String name, String key) {
		getSingleVMPool().remove(name, key);
	}

	/**
	 * @deprecated
	 */
	public static void remove(PortalCache portalCache, String key) {
		getSingleVMPool().remove(portalCache, key);
	}

	public static void removeCache(String name) {
		getSingleVMPool().removeCache(name);
	}

	public void setSingleVMPool(SingleVMPool singleVMPool) {
		_singleVMPool = singleVMPool;
	}

	private static SingleVMPool _singleVMPool;

}