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

package com.liferay.portal.messaging.proxy;

import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;
import com.liferay.portal.kernel.messaging.proxy.ProxyRequest;
import com.liferay.portal.kernel.messaging.proxy.ProxyResponse;
import com.liferay.portal.kernel.messaging.sender.SingleDestinationMessageSender;
import com.liferay.portal.kernel.messaging.sender.SingleDestinationSynchronousMessageSender;
import com.liferay.util.aspectj.AspectJUtil;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class MessagingProxyAdvice {

	public Object invoke(ProceedingJoinPoint proceedingJoinPoint)
		throws Throwable {

		ProxyRequest proxyRequest = createProxyRequest(proceedingJoinPoint);

		BaseProxyBean baseProxyBean =
			(BaseProxyBean)proceedingJoinPoint.getTarget();

		if (proxyRequest.isSynchronous()) {
			return doInvokeSynchronous(proxyRequest, baseProxyBean);
		}
		else {
			doInvokeAsynchronous(proxyRequest, baseProxyBean);

			return null;
		}
	}

	protected ProxyRequest createProxyRequest(
			ProceedingJoinPoint proceedingJoinPoint)
		throws Exception {

		return new ProxyRequest(
			AspectJUtil.getMethod(proceedingJoinPoint),
			proceedingJoinPoint.getArgs());
	}

	protected void doInvokeAsynchronous(
		ProxyRequest proxyRequest, BaseProxyBean baseProxyBean) {

		SingleDestinationMessageSender messageSender =
			baseProxyBean.getSingleDestinationMessageSender();

		if (messageSender == null) {
			throw new IllegalStateException(
				"Asynchronous message sender was not configured properly for " +
					baseProxyBean.getClass().getName());
		}

		messageSender.send(proxyRequest);
	}

	protected Object doInvokeSynchronous(
			ProxyRequest proxyRequest, BaseProxyBean baseProxyBean)
		throws Exception {

		SingleDestinationSynchronousMessageSender messageSender =
			baseProxyBean.getSingleDestinationSynchronousMessageSender();

		if (messageSender == null) {
			throw new IllegalStateException(
				"Synchronous message sender was not configured properly for " +
					baseProxyBean.getClass().getName());
		}

		ProxyResponse proxyResponse = (ProxyResponse)messageSender.send(
			proxyRequest);

		if (proxyResponse == null) {
			return null;
		}
		else if (proxyResponse.hasError()) {
			throw proxyResponse.getException();
		}
		else {
			return proxyResponse.getResult();
		}
	}

}