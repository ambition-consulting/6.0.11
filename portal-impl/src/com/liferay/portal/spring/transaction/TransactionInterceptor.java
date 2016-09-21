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

package com.liferay.portal.spring.transaction;

import com.liferay.portal.cache.transactional.TransactionalPortalCacheHelper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

/**
 * @author Shuyang Zhou
 */
public class TransactionInterceptor
	extends TransactionAspectSupport implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Method method = methodInvocation.getMethod();

		Class<?> targetClass = null;

		Object thisObject = methodInvocation.getThis();

		if (thisObject != null) {
			targetClass = thisObject.getClass();
		}

		TransactionAttributeSource transactionAttributeSource =
			getTransactionAttributeSource();

		TransactionAttribute transactionAttribute =
			transactionAttributeSource.getTransactionAttribute(
				method, targetClass);

		if (transactionAttribute == null) {
			return methodInvocation.proceed();
		}

		Class<?> declaringClass = method.getDeclaringClass();

		String joinPointIdentification = StringPool.BLANK;

		if (_log.isDebugEnabled()) {
			joinPointIdentification =
				declaringClass.getName().concat(StringPool.PERIOD).concat(
					method.getName());
		}

		TransactionInfo transactionInfo = createTransactionIfNecessary(
			getTransactionManager(), transactionAttribute,
			joinPointIdentification);

		TransactionStatus transactionStatus =
			transactionInfo.getTransactionStatus();

		boolean newTransaction = transactionStatus.isNewTransaction();

		if (newTransaction) {
			TransactionalPortalCacheHelper.begin();
		}

		Object returnValue = null;

		try {
			returnValue = methodInvocation.proceed();
		}
		catch (Throwable throwable) {
			if (newTransaction) {
				TransactionalPortalCacheHelper.rollback();
			}

			completeTransactionAfterThrowing(transactionInfo, throwable);

			throw throwable;
		}
		finally {
			cleanupTransactionInfo(transactionInfo);
		}

		commitTransactionAfterReturning(transactionInfo);

		if (newTransaction) {
			TransactionalPortalCacheHelper.commit();
		}

		return returnValue;
	}

	private static Log _log = LogFactoryUtil.getLog(
		TransactionInterceptor.class);

}