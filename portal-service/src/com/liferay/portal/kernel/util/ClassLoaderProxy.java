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

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassLoaderProxy {

	public ClassLoaderProxy(Object obj, ClassLoader classLoader) {
		this(obj, obj.getClass().getName(), classLoader);
	}

	public ClassLoaderProxy(
		Object obj, String className, ClassLoader classLoader) {

		_obj = obj;
		_className = className;
		_classLoader = classLoader;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	public String getClassName() {
		return _className;
	}

	public Object invoke(MethodHandler methodHandler) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			return _invoke(methodHandler);
		}
		catch (InvocationTargetException ite) {
			throw translateThrowable(ite.getCause(), contextClassLoader);
		}
		catch (Throwable t) {
			_log.error(t, t);

			throw t;
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	/**
	 * @deprecated
	 */
	public Object invoke(String methodName, Object[] args) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			Class<?> classObj = Class.forName(_className, true, _classLoader);

			List<Class<?>> parameterTypes = new ArrayList<Class<?>>();

			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];

				Class<?> argClass = Class.forName(
					arg.getClass().getName(), true, _classLoader);

				if (ClassUtil.isSubclass(argClass, PrimitiveWrapper.class)) {
					MethodKey methodKey = new MethodKey(
						argClass.getName(), "getValue");

					Method method = MethodCache.get(methodKey);

					args[i] = method.invoke(arg, (Object[])null);

					argClass = (Class<?>)argClass.getField("TYPE").get(arg);
				}

				if (ClassUtil.isSubclass(argClass, NullWrapper.class)) {
					NullWrapper nullWrapper = (NullWrapper)arg;

					argClass = Class.forName(
						nullWrapper.getClassName(), true, _classLoader);

					args[i] = null;
				}

				parameterTypes.add(argClass);
			}

			Method method = null;

			try {
				method = classObj.getMethod(
					methodName,
					parameterTypes.toArray(new Class[parameterTypes.size()]));
			}
			catch (NoSuchMethodException nsme) {
				Method[] methods = ((Class<?>)classObj).getMethods();

				for (int i = 0; i < methods.length; i++) {
					Class<?>[] methodParameterTypes =
						methods[i].getParameterTypes();

					if (methods[i].getName().equals(methodName) &&
						methodParameterTypes.length == parameterTypes.size()) {

						boolean correctParams = true;

						for (int j = 0; j < parameterTypes.size(); j++) {
							Class<?> a = parameterTypes.get(j);
							Class<?> b = methodParameterTypes[j];

							if (!ClassUtil.isSubclass(a, b)) {
								correctParams = false;

								break;
							}
						}

						if (correctParams) {
							method = methods[i];

							break;
						}
					}
				}

				if (method == null) {
					throw nsme;
				}
			}

			return method.invoke(_obj, args);
		}
		catch (InvocationTargetException ite) {
			throw translateThrowable(ite.getCause(), contextClassLoader);
		}
		catch (Throwable t) {
			_log.error(t, t);

			throw t;
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	protected Throwable translateThrowable(
		Throwable t1, ClassLoader contextClassLoader) {

		try {
			UnsyncByteArrayOutputStream ubaos =
				new UnsyncByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(ubaos);

			oos.writeObject(t1);

			oos.flush();
			oos.close();

			UnsyncByteArrayInputStream bais = new UnsyncByteArrayInputStream(
				ubaos.unsafeGetByteArray(), 0, ubaos.size());
			ObjectInputStream ois = new ClassLoaderObjectInputStream(
				bais, contextClassLoader);

			t1 = (Throwable)ois.readObject();

			ois.close();

			return t1;
		}
		catch (Throwable t2) {
			_log.error(t2, t2);

			return t2;
		}
	}

	private Object _invoke(MethodHandler methodHandler) throws Exception {
		try {
			return methodHandler.invoke(_obj);
		}
		catch (NoSuchMethodException nsme) {
			String name = methodHandler.getMethodName();
			Class<?>[] parameterTypes = methodHandler.getArgumentsClasses();

			Class<?> classObj = Class.forName(_className, true, _classLoader);

			for (Method method : classObj.getMethods()) {
				String curName = method.getName();
				Class<?>[] curParameterTypes = method.getParameterTypes();

				if (!curName.equals(name) ||
					(curParameterTypes.length != parameterTypes.length)) {

					continue;
				}

				boolean correctParams = true;

				for (int j = 0; j < parameterTypes.length; j++) {
					Class<?> a = parameterTypes[j];
					Class<?> b = curParameterTypes[j];

					if (!ClassUtil.isSubclass(a, b.getName())) {
						correctParams = false;

						break;
					}
				}

				if (correctParams) {
					return method.invoke(_obj, methodHandler.getArguments());
				}
			}

			throw nsme;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClassLoaderProxy.class);

	private Object _obj;
	private ClassLoader _classLoader;
	private String _className;

}