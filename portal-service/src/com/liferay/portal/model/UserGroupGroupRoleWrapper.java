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

/**
 * <p>
 * This class is a wrapper for {@link UserGroupGroupRole}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserGroupGroupRole
 * @generated
 */
public class UserGroupGroupRoleWrapper implements UserGroupGroupRole {
	public UserGroupGroupRoleWrapper(UserGroupGroupRole userGroupGroupRole) {
		_userGroupGroupRole = userGroupGroupRole;
	}

	/**
	* Gets the primary key of this user group group role.
	*
	* @return the primary key of this user group group role
	*/
	public com.liferay.portal.service.persistence.UserGroupGroupRolePK getPrimaryKey() {
		return _userGroupGroupRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user group group role
	*
	* @param pk the primary key of this user group group role
	*/
	public void setPrimaryKey(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK pk) {
		_userGroupGroupRole.setPrimaryKey(pk);
	}

	/**
	* Gets the user group id of this user group group role.
	*
	* @return the user group id of this user group group role
	*/
	public long getUserGroupId() {
		return _userGroupGroupRole.getUserGroupId();
	}

	/**
	* Sets the user group id of this user group group role.
	*
	* @param userGroupId the user group id of this user group group role
	*/
	public void setUserGroupId(long userGroupId) {
		_userGroupGroupRole.setUserGroupId(userGroupId);
	}

	/**
	* Gets the group id of this user group group role.
	*
	* @return the group id of this user group group role
	*/
	public long getGroupId() {
		return _userGroupGroupRole.getGroupId();
	}

	/**
	* Sets the group id of this user group group role.
	*
	* @param groupId the group id of this user group group role
	*/
	public void setGroupId(long groupId) {
		_userGroupGroupRole.setGroupId(groupId);
	}

	/**
	* Gets the role id of this user group group role.
	*
	* @return the role id of this user group group role
	*/
	public long getRoleId() {
		return _userGroupGroupRole.getRoleId();
	}

	/**
	* Sets the role id of this user group group role.
	*
	* @param roleId the role id of this user group group role
	*/
	public void setRoleId(long roleId) {
		_userGroupGroupRole.setRoleId(roleId);
	}

	public boolean isNew() {
		return _userGroupGroupRole.isNew();
	}

	public void setNew(boolean n) {
		_userGroupGroupRole.setNew(n);
	}

	public boolean isCachedModel() {
		return _userGroupGroupRole.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userGroupGroupRole.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userGroupGroupRole.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_userGroupGroupRole.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userGroupGroupRole.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userGroupGroupRole.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userGroupGroupRole.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new UserGroupGroupRoleWrapper((UserGroupGroupRole)_userGroupGroupRole.clone());
	}

	public int compareTo(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole) {
		return _userGroupGroupRole.compareTo(userGroupGroupRole);
	}

	public int hashCode() {
		return _userGroupGroupRole.hashCode();
	}

	public com.liferay.portal.model.UserGroupGroupRole toEscapedModel() {
		return new UserGroupGroupRoleWrapper(_userGroupGroupRole.toEscapedModel());
	}

	public java.lang.String toString() {
		return _userGroupGroupRole.toString();
	}

	public java.lang.String toXmlString() {
		return _userGroupGroupRole.toXmlString();
	}

	public UserGroupGroupRole getWrappedUserGroupGroupRole() {
		return _userGroupGroupRole;
	}

	private UserGroupGroupRole _userGroupGroupRole;
}