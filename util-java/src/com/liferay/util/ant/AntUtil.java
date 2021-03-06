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

package com.liferay.util.ant;

import org.apache.tools.ant.Project;

/**
 * @author Brian Wing Shun Chan
 */
public class AntUtil {

	public static Project getProject() {
		Project project = new Project();

		SystemLogger logger = new SystemLogger();

		logger.setMessageOutputLevel(Project.MSG_INFO);
		logger.setOutputPrintStream(System.out);
		logger.setErrorPrintStream(System.err);

		project.addBuildListener(logger);

		return project;
	}

}