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

import java.io.Serializable;

import java.lang.reflect.Method;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class MethodKey implements Serializable {

	public MethodKey(Method method) {
		this(
			method.getDeclaringClass().getName(), method.getName(),
			method.getParameterTypes());
	}

	public MethodKey(
		String className, String methodName, Class<?>... parameterTypes) {

		_className = className;
		_methodName = methodName;
		_parameterTypes = parameterTypes;
	}

	public MethodKey(
			String className, String methodName, String[] parameterTypeNames)
		throws ClassNotFoundException {

		_className = className;
		_methodName = methodName;

		_parameterTypes = new Class[parameterTypeNames.length];

		ClassLoader classLoader = null;

		if (parameterTypeNames.length > 0) {
			Thread currentThread = Thread.currentThread();

			classLoader = currentThread.getContextClassLoader();
		}

		for (int i = 0; i < parameterTypeNames.length; i++) {
			String parameterTypeName = parameterTypeNames[i];

			_parameterTypes[i] = Class.forName(
				parameterTypeName, true, classLoader);
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MethodKey methodKey = (MethodKey)obj;

		if (toString().equals(methodKey.toString())) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getClassName() {
		return _className;
	}

	public String getMethodName() {
		return _methodName;
	}

	public Class<?>[] getParameterTypes() {
		return _parameterTypes;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public String toString() {
		return _toString();
	}

	private String _toString() {
		if (_toString == null) {
			StringBundler sb = new StringBundler();

			sb.append(_className);
			sb.append(_methodName);

			if ((_parameterTypes != null) && (_parameterTypes.length > 0)) {
				sb.append(StringPool.DASH);

				for (Class<?> parameterType : _parameterTypes) {
					sb.append(parameterType.getName());
				}
			}

			_toString = sb.toString();
		}

		return _toString;
	}

	private String _className;
	private String _methodName;
	private Class<?>[] _parameterTypes;
	private String _toString;

}