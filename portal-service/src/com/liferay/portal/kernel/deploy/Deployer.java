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

package com.liferay.portal.kernel.deploy;

import com.liferay.portal.kernel.plugin.PluginPackage;

import java.io.File;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public interface Deployer {

	public void copyDependencyXml(String fileName, String targetDir)
		throws Exception;

	public void copyDependencyXml(
			String fileName, String targetDir, Map<String, String> filterMap)
		throws Exception;

	public void copyDependencyXml(
			String fileName, String targetDir, Map<String, String> filterMap,
			boolean overwrite)
		throws Exception;

	public void copyJars(File srcFile, PluginPackage pluginPackage)
		throws Exception;

	public void copyProperties(File srcFile, PluginPackage pluginPackage)
		throws Exception;

	public void copyTlds(File srcFile, PluginPackage pluginPackage)
		throws Exception;

	public void copyXmls(
			File srcFile, String displayName, PluginPackage pluginPackage)
		throws Exception;

	public void processPluginPackageProperties(
			File srcFile, String displayName, PluginPackage pluginPackage)
		throws Exception;

	public PluginPackage readPluginPackage(File file);

	public void updateWebXml(
			File webXml, File srcFile, String displayName,
			PluginPackage pluginPackage)
		throws Exception;

}