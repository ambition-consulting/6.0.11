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

package com.liferay.maven.plugins;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * @author Mika Koivisto
 * @author Thiago Moreira
 * @goal   deploy
 */
public class PluginDeployerMojo extends AbstractMojo {

	public void execute() throws MojoExecutionException {
		try {
			doExecute();
		}
		catch (Exception e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}
	}

	protected void doExecute() throws Exception {
		if (warFile.exists()) {
			getLog().info(
				"Deploying " + warFileName + " to " +
					autoDeployDir.getAbsolutePath());

			FileUtils.copyFile(warFile, new File(autoDeployDir, warFileName));
		}
		else {
			getLog().warn(warFileName + " does not exist");
		}
	}

	/**
	 * @parameter
	 * @required
	 */
	private File autoDeployDir;

	/**
	 * @parameter expression=
	 *			  "${project.build.directory}/${project.build.finalName}.war"
	 * @required
	 */
	private File warFile;

	/**
	 * @parameter expression="${project.build.finalName}.war"
	 * @required
	 */
	private String warFileName;

}