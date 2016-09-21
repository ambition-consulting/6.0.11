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

import com.liferay.portal.tools.ThumbnailBuilder;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * @author Mika Koivisto
 * @goal   build-thumbnail
 * @phase  process-sources
 */
public class ThumbnailBuilderMojo extends AbstractMojo {

	public void execute() throws MojoExecutionException {
		new ThumbnailBuilder(
			originalFile, thumbnailFile, height, width, overwrite);
	}

	/**
	 * @parameter default-value="120"
	 * @required
	 */
	private int height;

	/**
	 * @parameter expression="${basedir}/src/main/webapp/images/screenshot.png"
	 * @required
	 */
	private File originalFile;

	/**
	 * @parameter default-value="false"
	 * @required
	 */
	private boolean overwrite;

	/**
	 * @parameter expression="${basedir}/src/main/webapp/images/thumbnail.png"
	 * @required
	 */
	private File thumbnailFile;

	/**
	 * @parameter default-value="160"
	 * @required
	 */
	private int width;

}