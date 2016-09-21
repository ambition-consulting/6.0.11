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

package com.liferay.portal.kernel.deploy.auto;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.IOException;

import java.util.zip.ZipFile;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public abstract class BaseAutoDeployListener implements AutoDeployListener {

	public boolean isExtPlugin(File file) {
		if (file.getName().contains("-ext")) {
			return true;
		}

		return false;
	}

	public boolean isHookPlugin(File file) throws AutoDeployException {
		if ((isMatchingFile(
				file, "WEB-INF/liferay-plugin-package.properties")) &&
			(file.getName().contains("-hook")) &&
			(!file.getName().contains("-portlet"))) {

			return true;
		}

		return false;
	}

	public boolean isMatchingFile(File file, String checkXmlFile)
		throws AutoDeployException {

		if (!isMatchingFileExtension(file)) {
			return false;
		}

		ZipFile zipFile = null;

		try {
			zipFile = new ZipFile(file);

			if (zipFile.getEntry(checkXmlFile) == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						file.getPath() + " does not have " + checkXmlFile);
				}

				return false;
			}
			else {
				return true;
			}
		}
		catch (IOException ioe) {
			throw new AutoDeployException(ioe);
		}
		finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				}
				catch (IOException ioe) {
				}
			}
		}
	}

	public boolean isMatchingFileExtension(File file) {
		String fileName = file.getName().toLowerCase();

		if (fileName.endsWith(".war") || fileName.endsWith(".zip")) {
			if (_log.isDebugEnabled()) {
				_log.debug(file.getPath() + " has a matching extension");
			}

			return true;
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug(
					file.getPath() + " does not have a matching extension");
			}

			return false;
		}
	}

	public boolean isThemePlugin(File file) throws AutoDeployException {
		if (isMatchingFile(file, "WEB-INF/liferay-look-and-feel.xml")) {
			return true;
		}

		if ((isMatchingFile(
				file, "WEB-INF/liferay-plugin-package.properties")) &&
			(file.getName().contains("-theme"))) {

			return true;
		}

		return false;
	}

	public boolean isWebPlugin(File file) throws AutoDeployException {
		if ((isMatchingFile(
				file, "WEB-INF/liferay-plugin-package.properties")) &&
			(file.getName().contains("-web"))) {

			return true;
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
		BaseAutoDeployListener.class);

}