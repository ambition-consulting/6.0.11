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

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class MethodCache {

	public static Method get(String className, String methodName)
		throws ClassNotFoundException, NoSuchMethodException {

		return get(null, null, className, methodName);
	}

	public static Method get(
			String className, String methodName, Class<?>[] parameterTypes)
		throws ClassNotFoundException, NoSuchMethodException {

		return get(null, null, className, methodName, parameterTypes);
	}

	public static Method get(
			Map<String, Class<?>> classesMap, Map<MethodKey, Method> methodsMap,
			String className, String methodName)
		throws ClassNotFoundException, NoSuchMethodException {

		return get(className, methodName, new Class[0]);
	}

	public static Method get(
			Map<String, Class<?>> classesMap, Map<MethodKey, Method> methodsMap,
			String className, String methodName, Class<?>[] parameterTypes)
		throws ClassNotFoundException, NoSuchMethodException {

		MethodKey methodKey = new MethodKey(
			className, methodName, parameterTypes);

		return _instance._get(classesMap, methodsMap, methodKey);
	}

	public static Method get(MethodKey methodKey)
		throws ClassNotFoundException, NoSuchMethodException {

		return _instance._get(null, null, methodKey);
	}

	public static Method put(MethodKey methodKey, Method method) {
		return _instance._put(methodKey, method);
	}

	public static void remove(Class<?> classObj) {
		_instance._remove(classObj);
	}

	public static void reset() {
		_instance._reset();
	}

	private MethodCache() {
		_classesMap = new HashMap<String, Class<?>>();
		_methodsMap = new HashMap<MethodKey, Method>();
	}

	private Method _get(
			Map<String, Class<?>> classesMap, Map<MethodKey, Method> methodsMap,
			MethodKey methodKey)
		throws ClassNotFoundException, NoSuchMethodException {

		if (classesMap == null) {
			classesMap = _classesMap;
		}

		if (methodsMap == null) {
			methodsMap = _methodsMap;
		}

		Method method = methodsMap.get(methodKey);

		if (method == null) {
			String className = methodKey.getClassName();
			String methodName = methodKey.getMethodName();
			Class<?>[] parameterTypes = methodKey.getParameterTypes();

			Class<?> classObj = classesMap.get(className);

			if (classObj == null) {
				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader =
					currentThread.getContextClassLoader();

				classObj = contextClassLoader.loadClass(className);

				classesMap.put(className, classObj);
			}

			method = classObj.getMethod(methodName, parameterTypes);

			methodsMap.put(methodKey, method);
		}

		return method;
	}

	private Method _put(MethodKey methodKey, Method method) {
		return _methodsMap.put(methodKey, method);
	}

	private void _remove(Class<?> classObj) {
		_classesMap.remove(classObj.getName());

		for (Method method : classObj.getMethods()) {
			_methodsMap.remove(new MethodKey(method));
		}
	}

	private void _reset() {
		_classesMap.clear();
		_methodsMap.clear();
	}

	private static MethodCache _instance = new MethodCache();

	private Map<String, Class<?>> _classesMap;
	private Map<MethodKey, Method> _methodsMap;

}