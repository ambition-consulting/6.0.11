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

import java.io.File;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class LayoutTemplateAutoDeployListener extends BaseAutoDeployListener {

	public LayoutTemplateAutoDeployListener() {
		_deployer = new LayoutTemplateAutoDeployer();
	}

	public void deploy(File file) throws AutoDeployException {
		if (_log.isDebugEnabled()) {
			_log.debug("Invoking deploy for " + file.getPath());
		}

		if (!isMatchingFile(file, "WEB-INF/liferay-layout-templates.xml")) {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Copying layout templates for " + file.getPath());
		}

		_deployer.autoDeploy(file.getName());

		if (_log.isInfoEnabled()) {
			_log.info(
				"Layout templates for " + file.getPath() +
					" copied successfully. Deployment will start in a few " +
						"seconds.");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LayoutTemplateAutoDeployListener.class);

	private AutoDeployer _deployer;

}