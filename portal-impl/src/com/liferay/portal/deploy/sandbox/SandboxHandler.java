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

package com.liferay.portal.deploy.sandbox;

import com.liferay.portal.kernel.deploy.sandbox.SandboxDeployException;

import java.io.File;

/**
 * @author Igor Spasic
 * @author Brian Wing Shun Chan
 */
public interface SandboxHandler {

	public static final String SANDBOX_MARKER = "-SANDBOX-";

	public void deploy(File dir) throws SandboxDeployException;

	public String getDisplayName(String dirName);

	public void undeploy(File dir) throws SandboxDeployException;

}