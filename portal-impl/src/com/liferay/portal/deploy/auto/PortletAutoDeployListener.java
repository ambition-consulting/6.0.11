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

package com.liferay.portal.deploy.auto;

import com.liferay.portal.kernel.deploy.auto.AutoDeployException;
import com.liferay.portal.kernel.deploy.auto.BaseAutoDeployListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.Portal;

import java.io.File;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class PortletAutoDeployListener extends BaseAutoDeployListener {

	public PortletAutoDeployListener() {
		_deployer = new PortletAutoDeployer();
	}

	public void deploy(File file) throws AutoDeployException {
		if (_log.isDebugEnabled()) {
			_log.debug("Invoking deploy for " + file.getPath());
		}

		AutoDeployer deployer = null;

		if (isMatchingFile(
				file, "WEB-INF/" + Portal.PORTLET_XML_FILE_NAME_STANDARD)) {

			deployer = _deployer;
		}
		else if (isMatchingFile(file, "index_mvc.jsp")) {
			deployer = getMvcDeployer();
		}
		else if (isMatchingFile(file, "index.php")) {
			deployer = getPhpDeployer();
		}
		else if (!isExtPlugin(file) && !isHookPlugin(file) &&
				 !isMatchingFile(
					file, "WEB-INF/liferay-layout-templates.xml") &&
				 !isThemePlugin(file) && !isWebPlugin(file) &&
				 file.getName().endsWith(".war")) {

			if (_log.isInfoEnabled()) {
				_log.info("Deploying package as a web application");
			}

			deployer = getWaiDeployer();
		}
		else {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Copying portlets for " + file.getPath());
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Using deployer " + deployer.getClass().getName());
		}

		deployer.autoDeploy(file.getName());

		if (_log.isInfoEnabled()) {
			_log.info(
				"Portlets for " + file.getPath() + " copied successfully. " +
					"Deployment will start in a few seconds.");
		}
	}

	protected AutoDeployer getMvcDeployer() {
		if (_mvcDeployer == null) {
			_mvcDeployer = new MVCPortletAutoDeployer();
		}

		return _mvcDeployer;
	}

	protected AutoDeployer getPhpDeployer() throws AutoDeployException {
		if (_phpDeployer == null) {
			_phpDeployer = new PHPPortletAutoDeployer();
		}

		return _phpDeployer;
	}

	protected AutoDeployer getWaiDeployer() throws AutoDeployException {
		if (_waiDeployer == null) {
			_waiDeployer = new WAIAutoDeployer();
		}

		return _waiDeployer;
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortletAutoDeployListener.class);

	private AutoDeployer _deployer;
	private MVCPortletAutoDeployer _mvcDeployer;
	private PHPPortletAutoDeployer _phpDeployer;
	private WAIAutoDeployer _waiDeployer;

}