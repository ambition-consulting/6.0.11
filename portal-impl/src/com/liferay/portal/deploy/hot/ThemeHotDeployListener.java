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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.velocity.LiferayResourceCacheUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 * @author Ivica Cardic
 */
public class ThemeHotDeployListener extends BaseHotDeployListener {

	public void invokeDeploy(HotDeployEvent event) throws HotDeployException {
		try {
			doInvokeDeploy(event);
		}
		catch (Throwable t) {
			throwHotDeployException(event, "Error registering themes for ", t);
		}
	}

	public void invokeUndeploy(HotDeployEvent event) throws HotDeployException {
		try {
			doInvokeUndeploy(event);
		}
		catch (Throwable t) {
			throwHotDeployException(
				event, "Error unregistering themes for ", t);
		}
	}

	protected void doInvokeDeploy(HotDeployEvent event) throws Exception {
		ServletContext servletContext = event.getServletContext();

		String servletContextName = servletContext.getServletContextName();

		if (_log.isDebugEnabled()) {
			_log.debug("Invoking deploy for " + servletContextName);
		}

		String[] xmls = new String[] {
			HttpUtil.URLtoString(
				servletContext.getResource(
					"/WEB-INF/liferay-look-and-feel.xml"))
		};

		if (xmls[0] == null) {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Registering themes for " + servletContextName);
		}

		List<String> themeIds = ThemeLocalServiceUtil.init(
			servletContextName, servletContext, null, true, xmls,
			event.getPluginPackage());

		_vars.put(servletContextName, themeIds);

		if (_log.isInfoEnabled()) {
			if (themeIds.size() == 1) {
				_log.info(
					"1 theme for " + servletContextName +
						" is available for use");
			}
			else {
				_log.info(
					themeIds.size() + " themes for " + servletContextName +
						" are available for use");
			}
		}
	}

	protected void doInvokeUndeploy(HotDeployEvent event) throws Exception {
		ServletContext servletContext = event.getServletContext();

		String servletContextName = servletContext.getServletContextName();

		if (_log.isDebugEnabled()) {
			_log.debug("Invoking undeploy for " + servletContextName);
		}

		List<String> themeIds = _vars.remove(servletContextName);

		if (themeIds != null) {
			if (_log.isInfoEnabled()) {
				_log.info("Unregistering themes for " + servletContextName);
			}

			try {
				ThemeLocalServiceUtil.uninstallThemes(themeIds);
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		else {
			return;
		}

		// LEP-2057

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortalClassLoaderUtil.getClassLoader());

			LiferayResourceCacheUtil.clear();
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		if (_log.isInfoEnabled()) {
			if (themeIds.size() == 1) {
				_log.info(
					"1 theme for " + servletContextName + " was unregistered");
			}
			else {
				_log.info(
					themeIds.size() + " themes for " + servletContextName +
						" was unregistered");
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ThemeHotDeployListener.class);

	private static Map<String, List<String>> _vars =
		new HashMap<String, List<String>>();

}