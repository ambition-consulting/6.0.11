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
 * This class is a wrapper for {@link UserGroup}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserGroup
 * @generated
 */
public class UserGroupWrapper implements UserGroup {
	public UserGroupWrapper(UserGroup userGroup) {
		_userGroup = userGroup;
	}

	/**
	* Gets the primary key of this user group.
	*
	* @return the primary key of this user group
	*/
	public long getPrimaryKey() {
		return _userGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user group
	*
	* @param pk the primary key of this user group
	*/
	public void setPrimaryKey(long pk) {
		_userGroup.setPrimaryKey(pk);
	}

	/**
	* Gets the user group id of this user group.
	*
	* @return the user group id of this user group
	*/
	public long getUserGroupId() {
		return _userGroup.getUserGroupId();
	}

	/**
	* Sets the user group id of this user group.
	*
	* @param userGroupId the user group id of this user group
	*/
	public void setUserGroupId(long userGroupId) {
		_userGroup.setUserGroupId(userGroupId);
	}

	/**
	* Gets the company id of this user group.
	*
	* @return the company id of this user group
	*/
	public long getCompanyId() {
		return _userGroup.getCompanyId();
	}

	/**
	* Sets the company id of this user group.
	*
	* @param companyId the company id of this user group
	*/
	public void setCompanyId(long companyId) {
		_userGroup.setCompanyId(companyId);
	}

	/**
	* Gets the parent user group id of this user group.
	*
	* @return the parent user group id of this user group
	*/
	public long getParentUserGroupId() {
		return _userGroup.getParentUserGroupId();
	}

	/**
	* Sets the parent user group id of this user group.
	*
	* @param parentUserGroupId the parent user group id of this user group
	*/
	public void setParentUserGroupId(long parentUserGroupId) {
		_userGroup.setParentUserGroupId(parentUserGroupId);
	}

	/**
	* Gets the name of this user group.
	*
	* @return the name of this user group
	*/
	public java.lang.String getName() {
		return _userGroup.getName();
	}

	/**
	* Sets the name of this user group.
	*
	* @param name the name of this user group
	*/
	public void setName(java.lang.String name) {
		_userGroup.setName(name);
	}

	/**
	* Gets the description of this user group.
	*
	* @return the description of this user group
	*/
	public java.lang.String getDescription() {
		return _userGroup.getDescription();
	}

	/**
	* Sets the description of this user group.
	*
	* @param description the description of this user group
	*/
	public void setDescription(java.lang.String description) {
		_userGroup.setDescription(description);
	}

	public boolean isNew() {
		return _userGroup.isNew();
	}

	public void setNew(boolean n) {
		_userGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _userGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userGroup.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_userGroup.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userGroup.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userGroup.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new UserGroupWrapper((UserGroup)_userGroup.clone());
	}

	public int compareTo(com.liferay.portal.model.UserGroup userGroup) {
		return _userGroup.compareTo(userGroup);
	}

	public int hashCode() {
		return _userGroup.hashCode();
	}

	public com.liferay.portal.model.UserGroup toEscapedModel() {
		return new UserGroupWrapper(_userGroup.toEscapedModel());
	}

	public java.lang.String toString() {
		return _userGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _userGroup.toXmlString();
	}

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroup.getGroup();
	}

	public int getPrivateLayoutsPageCount()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroup.getPrivateLayoutsPageCount();
	}

	public boolean hasPrivateLayouts()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroup.hasPrivateLayouts();
	}

	public int getPublicLayoutsPageCount()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroup.getPublicLayoutsPageCount();
	}

	public boolean hasPublicLayouts()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroup.hasPublicLayouts();
	}

	public UserGroup getWrappedUserGroup() {
		return _userGroup;
	}

	private UserGroup _userGroup;
}