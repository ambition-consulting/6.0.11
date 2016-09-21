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

package com.liferay.portal.cache;

import com.liferay.portal.kernel.cache.Lifecycle;
import com.liferay.portal.kernel.cache.ThreadLocalCachable;
import com.liferay.portal.kernel.cache.ThreadLocalCache;
import com.liferay.portal.kernel.cache.ThreadLocalCacheManager;
import com.liferay.portal.kernel.util.MethodTargetClassKey;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.aop.AnnotationChainableMethodAdvice;

import java.lang.annotation.Annotation;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class ThreadLocalCacheAdvice
	extends AnnotationChainableMethodAdvice<ThreadLocalCachable> {

	public void afterReturning(
			MethodInvocation methodInvocation, Object result)
		throws Throwable {

		MethodTargetClassKey methodTargetClassKey = buildMethodTargetClassKey(
			methodInvocation);

		ThreadLocalCachable threadLocalCachable = findAnnotation(
			methodTargetClassKey);

		if (threadLocalCachable == _nullThreadLocalCacheable) {
			return;
		}

		ThreadLocalCache<Object> threadLocalCache =
			ThreadLocalCacheManager.getThreadLocalCache(
				threadLocalCachable.scope(), methodTargetClassKey.toString());

		String cacheKey = _buildCacheKey(methodInvocation.getArguments());

		if (result == null) {
			threadLocalCache.put(cacheKey, nullResult);
		}
		else {
			threadLocalCache.put(cacheKey, result);
		}
	}

	public Object before(MethodInvocation methodInvocation) throws Throwable {
		MethodTargetClassKey methodTargetClassKey = buildMethodTargetClassKey(
			methodInvocation);

		ThreadLocalCachable threadLocalCachable = findAnnotation(
			methodTargetClassKey);

		if (threadLocalCachable == _nullThreadLocalCacheable) {
			return null;
		}

		ThreadLocalCache<?> threadLocalCache =
			ThreadLocalCacheManager.getThreadLocalCache(
				threadLocalCachable.scope(), methodTargetClassKey.toString());

		String cacheKey = _buildCacheKey(methodInvocation.getArguments());

		Object value = threadLocalCache.get(cacheKey);

		if (value == nullResult) {
			return null;
		}

		return value;
	}

	public ThreadLocalCachable getNullAnnotation() {
		return _nullThreadLocalCacheable;
	}

	private String _buildCacheKey(Object[] arguments) {
		StringBundler sb = new StringBundler(arguments.length * 2 - 1);

		for (int i = 0; i < arguments.length; i++) {
			sb.append(StringUtil.toHexString(arguments[i]));

			if ((i + 1) < arguments.length) {
				sb.append(StringPool.POUND);
			}
		}

		return sb.toString();
	}

	private static ThreadLocalCachable _nullThreadLocalCacheable =
		new ThreadLocalCachable() {

			public Class<? extends Annotation> annotationType() {
				return ThreadLocalCachable.class;
			}

			public Lifecycle scope() {
				return null;
			}

		};

}