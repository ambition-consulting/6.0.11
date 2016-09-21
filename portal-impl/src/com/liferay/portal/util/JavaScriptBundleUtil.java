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

package com.liferay.portal.util;

import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.util.UniqueList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduardo Lundgren
 */
public class JavaScriptBundleUtil {

	public static final String CACHE_NAME =
		JavaScriptBundleUtil.class.getName();

	public static void clearCache() {
		SingleVMPoolUtil.clear(CACHE_NAME);
	}

	public static String[] getFileNames(String bundleId) {
		String[] fileNames = (String[])SingleVMPoolUtil.get(
			CACHE_NAME, bundleId);

		if (fileNames == null) {
			List<String> fileNamesList = new ArrayList<String>();

			List<String> dependencies = _getDependencies(
				bundleId, new UniqueList<String>());

			for (String dependency : dependencies) {
				String[] dependencyFileNames = PropsUtil.getArray(dependency);

				for (String dependencyFileName : dependencyFileNames) {
					fileNamesList.add(dependencyFileName);
				}
			}

			fileNames = fileNamesList.toArray(
				new String[fileNamesList.size()]);

			SingleVMPoolUtil.put(CACHE_NAME, bundleId, fileNames);
		}

		return fileNames;
	}

	private static List<String> _getDependencies(
		String bundleId, List<String> dependencies) {

		if (!ArrayUtil.contains(PropsValues.JAVASCRIPT_BUNDLE_IDS, bundleId)) {
			return dependencies;
		}

		String[] bundleDependencies = PropsUtil.getArray(
			PropsKeys.JAVASCRIPT_BUNDLE_DEPENDENCIES, new Filter(bundleId));

		for (String bundleDependency : bundleDependencies) {
			String[] bundleDependencyDependencies = PropsUtil.getArray(
				PropsKeys.JAVASCRIPT_BUNDLE_DEPENDENCIES,
				new Filter(bundleDependency));

			if (!ArrayUtil.contains(bundleDependencyDependencies, bundleId)) {
				_getDependencies(bundleDependency, dependencies);
			}

			dependencies.add(bundleDependency);
		}

		dependencies.add(bundleId);

		return dependencies;
	}

}