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

package com.liferay.portlet.softwarecatalog.model;

/**
 * <p>
 * This class is a wrapper for {@link SCFrameworkVersion}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SCFrameworkVersion
 * @generated
 */
public class SCFrameworkVersionWrapper implements SCFrameworkVersion {
	public SCFrameworkVersionWrapper(SCFrameworkVersion scFrameworkVersion) {
		_scFrameworkVersion = scFrameworkVersion;
	}

	/**
	* Gets the primary key of this s c framework version.
	*
	* @return the primary key of this s c framework version
	*/
	public long getPrimaryKey() {
		return _scFrameworkVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s c framework version
	*
	* @param pk the primary key of this s c framework version
	*/
	public void setPrimaryKey(long pk) {
		_scFrameworkVersion.setPrimaryKey(pk);
	}

	/**
	* Gets the framework version id of this s c framework version.
	*
	* @return the framework version id of this s c framework version
	*/
	public long getFrameworkVersionId() {
		return _scFrameworkVersion.getFrameworkVersionId();
	}

	/**
	* Sets the framework version id of this s c framework version.
	*
	* @param frameworkVersionId the framework version id of this s c framework version
	*/
	public void setFrameworkVersionId(long frameworkVersionId) {
		_scFrameworkVersion.setFrameworkVersionId(frameworkVersionId);
	}

	/**
	* Gets the group id of this s c framework version.
	*
	* @return the group id of this s c framework version
	*/
	public long getGroupId() {
		return _scFrameworkVersion.getGroupId();
	}

	/**
	* Sets the group id of this s c framework version.
	*
	* @param groupId the group id of this s c framework version
	*/
	public void setGroupId(long groupId) {
		_scFrameworkVersion.setGroupId(groupId);
	}

	/**
	* Gets the company id of this s c framework version.
	*
	* @return the company id of this s c framework version
	*/
	public long getCompanyId() {
		return _scFrameworkVersion.getCompanyId();
	}

	/**
	* Sets the company id of this s c framework version.
	*
	* @param companyId the company id of this s c framework version
	*/
	public void setCompanyId(long companyId) {
		_scFrameworkVersion.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this s c framework version.
	*
	* @return the user id of this s c framework version
	*/
	public long getUserId() {
		return _scFrameworkVersion.getUserId();
	}

	/**
	* Sets the user id of this s c framework version.
	*
	* @param userId the user id of this s c framework version
	*/
	public void setUserId(long userId) {
		_scFrameworkVersion.setUserId(userId);
	}

	/**
	* Gets the user uuid of this s c framework version.
	*
	* @return the user uuid of this s c framework version
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersion.getUserUuid();
	}

	/**
	* Sets the user uuid of this s c framework version.
	*
	* @param userUuid the user uuid of this s c framework version
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_scFrameworkVersion.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this s c framework version.
	*
	* @return the user name of this s c framework version
	*/
	public java.lang.String getUserName() {
		return _scFrameworkVersion.getUserName();
	}

	/**
	* Sets the user name of this s c framework version.
	*
	* @param userName the user name of this s c framework version
	*/
	public void setUserName(java.lang.String userName) {
		_scFrameworkVersion.setUserName(userName);
	}

	/**
	* Gets the create date of this s c framework version.
	*
	* @return the create date of this s c framework version
	*/
	public java.util.Date getCreateDate() {
		return _scFrameworkVersion.getCreateDate();
	}

	/**
	* Sets the create date of this s c framework version.
	*
	* @param createDate the create date of this s c framework version
	*/
	public void setCreateDate(java.util.Date createDate) {
		_scFrameworkVersion.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this s c framework version.
	*
	* @return the modified date of this s c framework version
	*/
	public java.util.Date getModifiedDate() {
		return _scFrameworkVersion.getModifiedDate();
	}

	/**
	* Sets the modified date of this s c framework version.
	*
	* @param modifiedDate the modified date of this s c framework version
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_scFrameworkVersion.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the name of this s c framework version.
	*
	* @return the name of this s c framework version
	*/
	public java.lang.String getName() {
		return _scFrameworkVersion.getName();
	}

	/**
	* Sets the name of this s c framework version.
	*
	* @param name the name of this s c framework version
	*/
	public void setName(java.lang.String name) {
		_scFrameworkVersion.setName(name);
	}

	/**
	* Gets the url of this s c framework version.
	*
	* @return the url of this s c framework version
	*/
	public java.lang.String getUrl() {
		return _scFrameworkVersion.getUrl();
	}

	/**
	* Sets the url of this s c framework version.
	*
	* @param url the url of this s c framework version
	*/
	public void setUrl(java.lang.String url) {
		_scFrameworkVersion.setUrl(url);
	}

	/**
	* Gets the active of this s c framework version.
	*
	* @return the active of this s c framework version
	*/
	public boolean getActive() {
		return _scFrameworkVersion.getActive();
	}

	/**
	* Determines if this s c framework version is active.
	*
	* @return <code>true</code> if this s c framework version is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _scFrameworkVersion.isActive();
	}

	/**
	* Sets whether this s c framework version is active.
	*
	* @param active the active of this s c framework version
	*/
	public void setActive(boolean active) {
		_scFrameworkVersion.setActive(active);
	}

	/**
	* Gets the priority of this s c framework version.
	*
	* @return the priority of this s c framework version
	*/
	public int getPriority() {
		return _scFrameworkVersion.getPriority();
	}

	/**
	* Sets the priority of this s c framework version.
	*
	* @param priority the priority of this s c framework version
	*/
	public void setPriority(int priority) {
		_scFrameworkVersion.setPriority(priority);
	}

	public boolean isNew() {
		return _scFrameworkVersion.isNew();
	}

	public void setNew(boolean n) {
		_scFrameworkVersion.setNew(n);
	}

	public boolean isCachedModel() {
		return _scFrameworkVersion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_scFrameworkVersion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _scFrameworkVersion.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_scFrameworkVersion.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _scFrameworkVersion.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scFrameworkVersion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scFrameworkVersion.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SCFrameworkVersionWrapper((SCFrameworkVersion)_scFrameworkVersion.clone());
	}

	public int compareTo(
		com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion scFrameworkVersion) {
		return _scFrameworkVersion.compareTo(scFrameworkVersion);
	}

	public int hashCode() {
		return _scFrameworkVersion.hashCode();
	}

	public com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion toEscapedModel() {
		return new SCFrameworkVersionWrapper(_scFrameworkVersion.toEscapedModel());
	}

	public java.lang.String toString() {
		return _scFrameworkVersion.toString();
	}

	public java.lang.String toXmlString() {
		return _scFrameworkVersion.toXmlString();
	}

	public SCFrameworkVersion getWrappedSCFrameworkVersion() {
		return _scFrameworkVersion;
	}

	private SCFrameworkVersion _scFrameworkVersion;
}