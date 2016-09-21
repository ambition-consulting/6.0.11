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

package com.liferay.portal.deploy.hot;

import com.liferay.portal.kernel.deploy.hot.BaseHotDeployListener;
import com.liferay.portal.kernel.deploy.hot.HotDeployEvent;
import com.liferay.portal.kernel.deploy.hot.HotDeployException;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public class MessagingHotDeployListener extends BaseHotDeployListener {

	public void invokeDeploy(HotDeployEvent event) throws HotDeployException {
		try {
			doInvokeDeploy(event);
		}
		catch (Throwable t) {
			throwHotDeployException(
				event, "Error sending deploy message for ", t);
		}
	}

	public void invokeUndeploy(HotDeployEvent event) throws HotDeployException {
		try {
			doInvokeUndeploy(event);
		}
		catch (Throwable t) {
			throwHotDeployException(
				event, "Error sending undeploy message for ", t);
		}
	}

	protected void doInvokeDeploy(HotDeployEvent event) throws Exception {
		ServletContext servletContext = event.getServletContext();

		String servletContextName = servletContext.getServletContextName();

		Message message = new Message();

		message.put("command", "deploy");
		message.put("servletContextName", servletContextName);

		MessageBusUtil.sendMessage(DestinationNames.HOT_DEPLOY, message);
	}

	protected void doInvokeUndeploy(HotDeployEvent event) throws Exception {
		ServletContext servletContext = event.getServletContext();

		String servletContextName = servletContext.getServletContextName();

		Message message = new Message();

		message.put("command", "undeploy");
		message.put("servletContextName", servletContextName);

		MessageBusUtil.sendMessage(DestinationNames.HOT_DEPLOY, message);
	}

}