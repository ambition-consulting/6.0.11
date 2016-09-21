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

package com.liferay.portal.events;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.freemarker.FreeMarkerEngineUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.sender.MessageSender;
import com.liferay.portal.kernel.messaging.sender.SynchronousMessageSender;
import com.liferay.portal.kernel.scheduler.SchedulerEngineUtil;
import com.liferay.portal.kernel.servlet.JspFactorySwapper;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.velocity.VelocityEngineUtil;
import com.liferay.portal.security.lang.PortalSecurityManager;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portal.tools.DBUpgrader;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class StartupAction extends SimpleAction {

	public void run(String[] ids) throws ActionException {
		try {
			doRun(ids);
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected void doRun(String[] ids) throws Exception {

		// Print release information

		System.out.println("Starting " + ReleaseInfo.getReleaseInfo());

		// Clear locks

		if (_log.isDebugEnabled()) {
			_log.debug("Clear locks");
		}

		try {
			LockLocalServiceUtil.clear();
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to clear locks because Lock table does not exist");
			}
		}

		// Shutdown hook

		if (_log.isDebugEnabled()) {
			_log.debug("Add shutdown hook");
		}

		Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));

		// Security manager

		if ((System.getSecurityManager() == null) &&
			(PropsValues.PORTAL_SECURITY_MANAGER_ENABLE)) {

			System.setSecurityManager(new PortalSecurityManager());
		}

		// FreeMarker

		if (_log.isDebugEnabled()) {
			_log.debug("Initialize FreeMarker engine");
		}

		FreeMarkerEngineUtil.init();

		// Velocity

		if (_log.isDebugEnabled()) {
			_log.debug("Initialize Velocity engine");
		}

		VelocityEngineUtil.init();

		// Upgrade

		if (_log.isDebugEnabled()) {
			_log.debug("Upgrade database");
		}

		DBUpgrader.upgrade();

		// Messaging

		if (_log.isDebugEnabled()) {
			_log.debug("Initialize message bus");
		}

		MessageBus messageBus = (MessageBus)PortalBeanLocatorUtil.locate(
			MessageBus.class.getName());
		MessageSender messageSender =
			(MessageSender)PortalBeanLocatorUtil.locate(
				MessageSender.class.getName());
		SynchronousMessageSender synchronousMessageSender =
			(SynchronousMessageSender)PortalBeanLocatorUtil.locate(
				SynchronousMessageSender.class.getName());

		MessageBusUtil.init(
			messageBus, messageSender, synchronousMessageSender);

		// Scheduler

		if (_log.isDebugEnabled()) {
			_log.debug("Initialize scheduler engine");
		}

		SchedulerEngineUtil.start();

		// Verify

		if (_log.isDebugEnabled()) {
			_log.debug("Verify database");
		}

		DBUpgrader.verify();

		// Liferay JspFactory

		JspFactorySwapper.swap();

		// Cluster executor

		ClusterExecutorUtil.initialize();
	}

	private static Log _log = LogFactoryUtil.getLog(StartupAction.class);

}