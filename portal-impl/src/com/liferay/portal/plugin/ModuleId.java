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

package com.liferay.portal.plugin;

import com.liferay.portal.kernel.plugin.Version;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jorge Ferrer
 */
public class ModuleId implements Serializable {

	public static ModuleId getInstance(String moduleId) {
		ModuleId moduleIdObj = _moduleIds.get(moduleId);

		if (moduleIdObj == null) {
			moduleIdObj =  new ModuleId(moduleId);

			_moduleIds.put(moduleId, moduleIdObj);
		}

		return moduleIdObj;
	}

	public static String toString(
		String groupId, String artifactId, String version, String type) {

		return groupId + StringPool.SLASH + artifactId + StringPool.SLASH +
			version + StringPool.SLASH + type;
	}

	public String getGroupId() {
		return _groupId;
	}

	public String getArtifactId() {
		return _artifactId;
	}

	public String getPackageId() {
		return _groupId + StringPool.SLASH + _artifactId;
	}

	public String getVersion() {
		return _pluginVersion.toString();
	}

	public String getType() {
		return _type;
	}

	public String getArtifactPath() {
		return StringPool.SLASH + _groupId + StringPool.SLASH + _artifactId +
			StringPool.SLASH + _pluginVersion + StringPool.SLASH +
				getArtifactWARName();
	}

	public String getArtifactWARName() {
		return _artifactId + StringPool.DASH + _pluginVersion +
			StringPool.PERIOD + _type;
	}

	public boolean isLaterVersionThan(String version) {
		return _pluginVersion.isLaterVersionThan(version);
	}

	public boolean isPreviousVersionThan(String version) {
		return _pluginVersion.isPreviousVersionThan(version);
	}

	public boolean isSameVersionAs(String version) {
		return _pluginVersion.isSameVersionAs(version);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof ModuleId)) {
			return false;
		}

		ModuleId moduleId = (ModuleId)obj;

		return toString().equals(moduleId.toString());
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public String toString() {
		return toString(
			_groupId, _artifactId, _pluginVersion.toString(), _type);
	}

	protected ModuleId(
		String groupId, String artifactId, Version pluginVersion, String type) {

		_groupId = groupId;
		_artifactId = artifactId;
		_pluginVersion = pluginVersion;
		_type = type;
	}

	protected ModuleId(String moduleId) {
		StringTokenizer st = new StringTokenizer(moduleId, StringPool.SLASH);

		if (st.countTokens() < 4) {
			throw new RuntimeException(
				"The moduleId " + moduleId + " is not correct");
		}

		_groupId = st.nextToken();
		_artifactId = st.nextToken();
		_pluginVersion = Version.getInstance(st.nextToken());
		_type = st.nextToken();
	}

	private static Map<String, ModuleId> _moduleIds =
		new ConcurrentHashMap<String, ModuleId>();

	private String _artifactId;
	private String _groupId;
	private Version _pluginVersion;
	private String _type;

}