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

package com.liferay.portal.messaging.async;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.async.Async;
import com.liferay.portal.kernel.util.MethodTargetClassKey;
import com.liferay.portal.spring.aop.AnnotationChainableMethodAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class AsyncAdvice extends AnnotationChainableMethodAdvice<Async> {

	public Object before(final MethodInvocation methodInvocation)
		throws Throwable {

		MethodTargetClassKey methodTargetClassKey = buildMethodTargetClassKey(
			methodInvocation);

		Async async = findAnnotation(methodTargetClassKey);

		if (async == _nullAsync) {
			return null;
		}

		Method method = methodTargetClassKey.getMethod();

		if (method.getReturnType() != void.class) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Async annotation on method " + method.getName() +
						" does not return void");
			}

			return null;
		}

		String destinationName = null;

		if ((_destinationNames != null) && !_destinationNames.isEmpty()) {
			destinationName = _destinationNames.get(
				methodTargetClassKey.getTargetClass());
		}

		if (destinationName == null) {
			destinationName = _defaultDestinationName;
		}

		MessageBusUtil.sendMessage(
			destinationName,
			new Runnable() {

				public void run() {
					try {
						nextMethodInterceptor.invoke(methodInvocation);
					}
					catch (Throwable t) {
						throw new RuntimeException(t);
					}
				}

				public String toString() {
					return methodInvocation.toString();
				}

			});

		return nullResult;
	}

	public String getDefaultDestinationName() {
		return _defaultDestinationName;
	}

	public Async getNullAnnotation() {
		return _nullAsync;
	}

	public void setDefaultDestinationName(String defaultDestinationName) {
		_defaultDestinationName = defaultDestinationName;
	}

	public void setDestinationNames(Map<Class<?>, String> destinationNames) {
		_destinationNames = destinationNames;
	}

	private static Async _nullAsync =
		new Async() {

			public Class<? extends Annotation> annotationType() {
				return Async.class;
			}

		};

	private static Log _log = LogFactoryUtil.getLog(AsyncAdvice.class);

	private String _defaultDestinationName;
	private Map<Class<?>, String> _destinationNames;

}