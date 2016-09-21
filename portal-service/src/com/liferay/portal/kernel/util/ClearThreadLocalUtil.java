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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Tina Tian
 */
public class ClearThreadLocalUtil {

	public static void clearThreadLocal() throws Exception {
		if (!_initialized) {
			return;
		}

		Thread[] threads = ThreadUtil.getThreads();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		for (Thread thread : threads) {
			_clearThreadLocal(thread, contextClassLoader);
		}
	}

	private static void _clearThreadLocal(
			Thread thread, ClassLoader classLoader)
		throws Exception {

		if (thread == null) {
			return;
		}

		Object threadLocalMap = _threadLocalsField.get(thread);

		Object inheritableThreadLocalMap = _inheritableThreadLocalsField.get(
			thread);

		_clearThreadLocalMap(threadLocalMap, classLoader);
		_clearThreadLocalMap(inheritableThreadLocalMap, classLoader);
	}

	private static void _clearThreadLocalMap(
			Object threadLocalMap, ClassLoader classLoader)
		throws Exception {

		if (threadLocalMap == null) {
			return;
		}

		Object[] table = (Object[])_tableField.get(threadLocalMap);

		if (table == null) {
			return;
		}

		int staleEntriesCount = 0;

		for (Object tableEntry : table) {
			if (tableEntry == null) {
				continue;
			}

			Object key = ((Reference<?>)tableEntry).get();
			Object value = _valueField.get(tableEntry);

			boolean remove = false;

			if (key != null) {
				Class<?> keyClass = key.getClass();

				ClassLoader keyClassLoader = keyClass.getClassLoader();

				if (keyClassLoader == classLoader) {
					remove = true;
				}
			}

			if (value != null) {
				Class<?> valueClass = value.getClass();

				ClassLoader valueClassLoader = valueClass.getClassLoader();

				if (valueClassLoader == classLoader) {
					remove = true;
				}
			}

			if (remove) {
				if (key != null) {
					if (_log.isDebugEnabled()) {
						Class<?> keyClass = key.getClass();

						_log.debug(
							"Clear a ThreadLocal with key of type " +
								keyClass.getCanonicalName());
					}

					_removeMethod.invoke(threadLocalMap, key);
				}
				else {
					staleEntriesCount++;
				}
			}
		}

		if (staleEntriesCount > 0) {
			_expungeStaleEntriesMethod.invoke(threadLocalMap);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClearThreadLocalUtil.class);

	private static Method _expungeStaleEntriesMethod;
	private static Field _inheritableThreadLocalsField;
	private static boolean _initialized;
	private static Method _removeMethod;
	private static Field _tableField;
	private static Field _threadLocalsField;
	private static Field _valueField;

	static {
		try {
			_inheritableThreadLocalsField = ReflectionUtil.getDeclaredField(
				Thread.class, "inheritableThreadLocals");
			_threadLocalsField = ReflectionUtil.getDeclaredField(
				Thread.class, "threadLocals");

			Class<?> threadLocalMapClass = Class.forName(
				"java.lang.ThreadLocal$ThreadLocalMap");

			_expungeStaleEntriesMethod = ReflectionUtil.getDeclaredMethod(
				threadLocalMapClass, "expungeStaleEntries");
			_removeMethod = ReflectionUtil.getDeclaredMethod(
				threadLocalMapClass, "remove", ThreadLocal.class);
			_tableField = ReflectionUtil.getDeclaredField(
				threadLocalMapClass, "table");

			Class<?> threadLocalMapEntryClass = Class.forName(
				"java.lang.ThreadLocal$ThreadLocalMap$Entry");

			_valueField = ReflectionUtil.getDeclaredField(
				threadLocalMapEntryClass, "value");

			_initialized = true;
		}
		catch (Throwable t) {
			_initialized = false;

			_log.warn("Failed to initialize ClearThreadLocalUtil", t);
		}
	}

}