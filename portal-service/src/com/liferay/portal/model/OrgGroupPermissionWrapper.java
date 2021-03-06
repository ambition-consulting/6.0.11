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
 * This class is a wrapper for {@link OrgGroupPermission}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OrgGroupPermission
 * @generated
 */
public class OrgGroupPermissionWrapper implements OrgGroupPermission {
	public OrgGroupPermissionWrapper(OrgGroupPermission orgGroupPermission) {
		_orgGroupPermission = orgGroupPermission;
	}

	/**
	* Gets the primary key of this org group permission.
	*
	* @return the primary key of this org group permission
	*/
	public com.liferay.portal.service.persistence.OrgGroupPermissionPK getPrimaryKey() {
		return _orgGroupPermission.getPrimaryKey();
	}

	/**
	* Sets the primary key of this org group permission
	*
	* @param pk the primary key of this org group permission
	*/
	public void setPrimaryKey(
		com.liferay.portal.service.persistence.OrgGroupPermissionPK pk) {
		_orgGroupPermission.setPrimaryKey(pk);
	}

	/**
	* Gets the organization id of this org group permission.
	*
	* @return the organization id of this org group permission
	*/
	public long getOrganizationId() {
		return _orgGroupPermission.getOrganizationId();
	}

	/**
	* Sets the organization id of this org group permission.
	*
	* @param organizationId the organization id of this org group permission
	*/
	public void setOrganizationId(long organizationId) {
		_orgGroupPermission.setOrganizationId(organizationId);
	}

	/**
	* Gets the group id of this org group permission.
	*
	* @return the group id of this org group permission
	*/
	public long getGroupId() {
		return _orgGroupPermission.getGroupId();
	}

	/**
	* Sets the group id of this org group permission.
	*
	* @param groupId the group id of this org group permission
	*/
	public void setGroupId(long groupId) {
		_orgGroupPermission.setGroupId(groupId);
	}

	/**
	* Gets the permission id of this org group permission.
	*
	* @return the permission id of this org group permission
	*/
	public long getPermissionId() {
		return _orgGroupPermission.getPermissionId();
	}

	/**
	* Sets the permission id of this org group permission.
	*
	* @param permissionId the permission id of this org group permission
	*/
	public void setPermissionId(long permissionId) {
		_orgGroupPermission.setPermissionId(permissionId);
	}

	public boolean isNew() {
		return _orgGroupPermission.isNew();
	}

	public void setNew(boolean n) {
		_orgGroupPermission.setNew(n);
	}

	public boolean isCachedModel() {
		return _orgGroupPermission.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_orgGroupPermission.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _orgGroupPermission.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_orgGroupPermission.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _orgGroupPermission.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orgGroupPermission.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orgGroupPermission.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new OrgGroupPermissionWrapper((OrgGroupPermission)_orgGroupPermission.clone());
	}

	public int compareTo(
		com.liferay.portal.model.OrgGroupPermission orgGroupPermission) {
		return _orgGroupPermission.compareTo(orgGroupPermission);
	}

	public int hashCode() {
		return _orgGroupPermission.hashCode();
	}

	public com.liferay.portal.model.OrgGroupPermission toEscapedModel() {
		return new OrgGroupPermissionWrapper(_orgGroupPermission.toEscapedModel());
	}

	public java.lang.String toString() {
		return _orgGroupPermission.toString();
	}

	public java.lang.String toXmlString() {
		return _orgGroupPermission.toXmlString();
	}

	public boolean containsGroup(
		java.util.List<com.liferay.portal.model.Group> groups) {
		return _orgGroupPermission.containsGroup(groups);
	}

	public boolean containsOrganization(
		java.util.List<com.liferay.portal.model.Organization> organizations) {
		return _orgGroupPermission.containsOrganization(organizations);
	}

	public OrgGroupPermission getWrappedOrgGroupPermission() {
		return _orgGroupPermission;
	}

	private OrgGroupPermission _orgGroupPermission;
}