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

package com.liferay.portal.kernel.deploy.hot;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class HotDeployEvent {

	public HotDeployEvent(
		ServletContext servletContext, ClassLoader contextClassLoader) {

		_servletContext = servletContext;
		_contextClassLoader = contextClassLoader;

		try {
			initDependentServletContextNames();
		}
		catch (IOException ioe) {
			_log.error(ioe, ioe);
		}
	}

	public ClassLoader getContextClassLoader() {
		return _contextClassLoader;
	}

	public Set<String> getDependentServletContextNames() {
		return _dependentServletContextNames;
	}

	public PluginPackage getPluginPackage() {
		return _pluginPackage;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	public String getServletContextName() {
		return _servletContext.getServletContextName();
	}

	public void setPluginPackage(PluginPackage pluginPackage) {
		_pluginPackage = pluginPackage;
	}

	protected void initDependentServletContextNames() throws IOException {
		InputStream is = _servletContext.getResourceAsStream(
			"/WEB-INF/liferay-plugin-package.properties");

		_dependentServletContextNames = new HashSet<String>();

		if (is != null) {
			String propertiesString = StringUtil.read(is);

			is.close();

			Properties properties = PropertiesUtil.load(propertiesString);

			String[] requiredDeploymentContexts = StringUtil.split(
				properties.getProperty("required-deployment-contexts"));

			if ((requiredDeploymentContexts.length > 0) &&
				(_log.isInfoEnabled())) {

				_log.info(
					"Plugin " + _servletContext.getServletContextName() +
						" requires " +
						StringUtil.merge(requiredDeploymentContexts, ", "));
			}

			for (String requiredDeploymentContext :
					requiredDeploymentContexts) {

				_dependentServletContextNames.add(
					requiredDeploymentContext.trim());
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(HotDeployEvent.class);

	private ClassLoader _contextClassLoader;
	private Set<String> _dependentServletContextNames;
	private PluginPackage _pluginPackage;
	private ServletContext _servletContext;

}