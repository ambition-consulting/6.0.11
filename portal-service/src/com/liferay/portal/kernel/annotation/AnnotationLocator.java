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

package com.liferay.portal.kernel.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shuyang Zhou
 */
public class AnnotationLocator {

	public static <T extends Annotation> T locate(
		Class<?> targetClass, Class<T> annotationClass) {

		Queue<Class<?>> queue = new LinkedList<Class<?>>();

		queue.offer(targetClass);

		return _deepSearchTypes(queue, annotationClass);
	}

	public static <T extends Annotation> T locate(
		Method method, Class<?> targetClass, Class<T> annotationClass) {

		Queue<Class<?>> queue = new LinkedList<Class<?>>();

		if (targetClass == null) {
			queue.offer(method.getDeclaringClass());
		}
		else {
			queue.offer(targetClass);
		}

		return _deepSearchMethods(queue, method, annotationClass);
	}

	private static <T extends Annotation> T _deepSearchMethods(
		Queue<Class<?>> queue, Method method, Class<T> annotationClass) {

		if (queue.isEmpty()) {
			return null;
		}

		T annotation = null;

		Class<?> clazz = queue.poll();

		try {
			Method specificMethod = clazz.getDeclaredMethod(
				method.getName(), method.getParameterTypes());

			annotation = specificMethod.getAnnotation(annotationClass);

			if (annotation != null) {
				return annotation;
			}
		}
		catch (Exception e) {
		}

		annotation = clazz.getAnnotation(annotationClass);

		if (annotation == null) {
			_queueSuperTypes(queue, clazz);

			return _deepSearchMethods(queue, method, annotationClass);
		}
		else {
			return annotation;
		}
	}

	private static <T extends Annotation> T _deepSearchTypes(
		Queue<Class<?>> queue, Class<T> annotationClass) {

		if (queue.isEmpty()) {
			return null;
		}

		Class<?> clazz = queue.poll();

		T annotation = clazz.getAnnotation(annotationClass);

		if (annotation == null) {
			_queueSuperTypes(queue, clazz);

			return _deepSearchTypes(queue, annotationClass);
		}
		else {
			return annotation;
		}
	}

	private static void _queueSuperTypes(
		Queue<Class<?>> queue, Class<?> clazz) {

		Class<?> supperClass = clazz.getSuperclass();

		if ((supperClass != null) && (supperClass != Object.class)) {
			queue.offer(supperClass);
		}

		Class<?>[] interfaceClasses = clazz.getInterfaces();

		for (Class<?> interfaceClass : interfaceClasses) {
			queue.offer(interfaceClass);
		}
	}

}