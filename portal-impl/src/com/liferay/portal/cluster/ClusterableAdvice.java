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

package com.liferay.portal.cluster;

import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;
import com.liferay.portal.kernel.cluster.ClusterRequest;
import com.liferay.portal.kernel.cluster.Clusterable;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodTargetClassKey;
import com.liferay.portal.spring.aop.AnnotationChainableMethodAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Shuyang Zhou
 */
public class ClusterableAdvice
	extends AnnotationChainableMethodAdvice<Clusterable> {

	public void afterReturning(MethodInvocation methodInvocation, Object result)
		throws Throwable {

		if (!ClusterInvokeThreadLocal.isEnabled()) {
			return;
		}

		MethodTargetClassKey methodTargetClassKey = buildMethodTargetClassKey(
			methodInvocation);

		Clusterable clusterable = findAnnotation(methodTargetClassKey);

		if (clusterable == _nullClusterable) {
			return;
		}

		Method method = methodTargetClassKey.getMethod();

		Method utilClassMethod = _getUtilClassMethod(method);

		MethodHandler methodHandler = new MethodHandler(
			utilClassMethod, methodInvocation.getArguments());

		ClusterRequest clusterRequest = ClusterRequest.createMulticastRequest(
			methodHandler, true);

		clusterRequest.setServletContextName(_servletContextName);

		ClusterExecutorUtil.execute(clusterRequest);
	}

	public Clusterable getNullAnnotation() {
		return _nullClusterable;
	}

	public void setServletContextName(String servletContextName) {
		_servletContextName = servletContextName;
	}

	private Method _getUtilClassMethod(Method method) throws Exception {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		Class<?> declaringClass = method.getDeclaringClass();

		String utilClassName = declaringClass.getName().concat("Util");

		Class<?> utilClass = contextClassLoader.loadClass(utilClassName);

		return utilClass.getMethod(
			method.getName(), method.getParameterTypes());
	}

	private static Clusterable _nullClusterable =
		new Clusterable() {

			public Class<? extends Annotation> annotationType() {
				return Clusterable.class;
			}

		};

	private String _servletContextName;

}