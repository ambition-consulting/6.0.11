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

package com.liferay.portal.model;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class PermissionDisplay
	implements Comparable<PermissionDisplay>, Serializable {

	public PermissionDisplay(
		Permission permission, Resource resource, String portletName,
		String portletLabel, String modelName, String modelLabel,
		String actionId, String actionLabel) {

		_permission = permission;
		_resource = resource;
		_portletName = portletName;
		_portletLabel = portletLabel;
		_modelName = modelName;
		_modelLabel = modelLabel;
		_actionId = actionId;
		_actionLabel = actionLabel;
	}

	public Permission getPermission() {
		return _permission;
	}

	public Resource getResource() {
		return _resource;
	}

	public String getPortletName() {
		return _portletName;
	}

	public String getPortletLabel() {
		return _portletLabel;
	}

	public String getModelName() {
		return _modelName;
	}

	public String getModelLabel() {
		return _modelLabel;
	}

	public String getActionId() {
		return _actionId;
	}

	public String getActionLabel() {
		return _actionLabel;
	}

	public int compareTo(PermissionDisplay permissionDisplay) {
		int value = getPortletLabel().compareTo(
			permissionDisplay.getPortletLabel());

		if (value == 0) {
			value = getModelLabel().compareTo(
				permissionDisplay.getModelLabel());

			if (value == 0) {
				value = getActionLabel().compareTo(
					permissionDisplay.getActionLabel());
			}
		}

		return value;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof PermissionDisplay)) {
			return false;
		}

		PermissionDisplay permissionDisplay = (PermissionDisplay)obj;

		if (_portletName.equals(permissionDisplay.getPortletName()) &&
			_modelName.equals(permissionDisplay.getModelName()) &&
			_actionId.equals(permissionDisplay.getActionId())) {

			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return _portletName.concat(_modelName).concat(_actionId).hashCode();
	}

	private Permission _permission;
	private Resource _resource;
	private String _portletName;
	private String _portletLabel;
	private String _modelName;
	private String _modelLabel;
	private String _actionId;
	private String _actionLabel;

}