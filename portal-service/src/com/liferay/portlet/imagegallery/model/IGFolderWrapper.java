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

package com.liferay.portlet.imagegallery.model;

/**
 * <p>
 * This class is a wrapper for {@link IGFolder}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       IGFolder
 * @generated
 */
public class IGFolderWrapper implements IGFolder {
	public IGFolderWrapper(IGFolder igFolder) {
		_igFolder = igFolder;
	}

	/**
	* Gets the primary key of this i g folder.
	*
	* @return the primary key of this i g folder
	*/
	public long getPrimaryKey() {
		return _igFolder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i g folder
	*
	* @param pk the primary key of this i g folder
	*/
	public void setPrimaryKey(long pk) {
		_igFolder.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this i g folder.
	*
	* @return the uuid of this i g folder
	*/
	public java.lang.String getUuid() {
		return _igFolder.getUuid();
	}

	/**
	* Sets the uuid of this i g folder.
	*
	* @param uuid the uuid of this i g folder
	*/
	public void setUuid(java.lang.String uuid) {
		_igFolder.setUuid(uuid);
	}

	/**
	* Gets the folder id of this i g folder.
	*
	* @return the folder id of this i g folder
	*/
	public long getFolderId() {
		return _igFolder.getFolderId();
	}

	/**
	* Sets the folder id of this i g folder.
	*
	* @param folderId the folder id of this i g folder
	*/
	public void setFolderId(long folderId) {
		_igFolder.setFolderId(folderId);
	}

	/**
	* Gets the group id of this i g folder.
	*
	* @return the group id of this i g folder
	*/
	public long getGroupId() {
		return _igFolder.getGroupId();
	}

	/**
	* Sets the group id of this i g folder.
	*
	* @param groupId the group id of this i g folder
	*/
	public void setGroupId(long groupId) {
		_igFolder.setGroupId(groupId);
	}

	/**
	* Gets the company id of this i g folder.
	*
	* @return the company id of this i g folder
	*/
	public long getCompanyId() {
		return _igFolder.getCompanyId();
	}

	/**
	* Sets the company id of this i g folder.
	*
	* @param companyId the company id of this i g folder
	*/
	public void setCompanyId(long companyId) {
		_igFolder.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this i g folder.
	*
	* @return the user id of this i g folder
	*/
	public long getUserId() {
		return _igFolder.getUserId();
	}

	/**
	* Sets the user id of this i g folder.
	*
	* @param userId the user id of this i g folder
	*/
	public void setUserId(long userId) {
		_igFolder.setUserId(userId);
	}

	/**
	* Gets the user uuid of this i g folder.
	*
	* @return the user uuid of this i g folder
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igFolder.getUserUuid();
	}

	/**
	* Sets the user uuid of this i g folder.
	*
	* @param userUuid the user uuid of this i g folder
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_igFolder.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this i g folder.
	*
	* @return the create date of this i g folder
	*/
	public java.util.Date getCreateDate() {
		return _igFolder.getCreateDate();
	}

	/**
	* Sets the create date of this i g folder.
	*
	* @param createDate the create date of this i g folder
	*/
	public void setCreateDate(java.util.Date createDate) {
		_igFolder.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this i g folder.
	*
	* @return the modified date of this i g folder
	*/
	public java.util.Date getModifiedDate() {
		return _igFolder.getModifiedDate();
	}

	/**
	* Sets the modified date of this i g folder.
	*
	* @param modifiedDate the modified date of this i g folder
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_igFolder.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the parent folder id of this i g folder.
	*
	* @return the parent folder id of this i g folder
	*/
	public long getParentFolderId() {
		return _igFolder.getParentFolderId();
	}

	/**
	* Sets the parent folder id of this i g folder.
	*
	* @param parentFolderId the parent folder id of this i g folder
	*/
	public void setParentFolderId(long parentFolderId) {
		_igFolder.setParentFolderId(parentFolderId);
	}

	/**
	* Gets the name of this i g folder.
	*
	* @return the name of this i g folder
	*/
	public java.lang.String getName() {
		return _igFolder.getName();
	}

	/**
	* Sets the name of this i g folder.
	*
	* @param name the name of this i g folder
	*/
	public void setName(java.lang.String name) {
		_igFolder.setName(name);
	}

	/**
	* Gets the description of this i g folder.
	*
	* @return the description of this i g folder
	*/
	public java.lang.String getDescription() {
		return _igFolder.getDescription();
	}

	/**
	* Sets the description of this i g folder.
	*
	* @param description the description of this i g folder
	*/
	public void setDescription(java.lang.String description) {
		_igFolder.setDescription(description);
	}

	public boolean isNew() {
		return _igFolder.isNew();
	}

	public void setNew(boolean n) {
		_igFolder.setNew(n);
	}

	public boolean isCachedModel() {
		return _igFolder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_igFolder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _igFolder.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_igFolder.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _igFolder.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _igFolder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_igFolder.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new IGFolderWrapper((IGFolder)_igFolder.clone());
	}

	public int compareTo(
		com.liferay.portlet.imagegallery.model.IGFolder igFolder) {
		return _igFolder.compareTo(igFolder);
	}

	public int hashCode() {
		return _igFolder.hashCode();
	}

	public com.liferay.portlet.imagegallery.model.IGFolder toEscapedModel() {
		return new IGFolderWrapper(_igFolder.toEscapedModel());
	}

	public java.lang.String toString() {
		return _igFolder.toString();
	}

	public java.lang.String toXmlString() {
		return _igFolder.toXmlString();
	}

	public java.util.List<com.liferay.portlet.imagegallery.model.IGFolder> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igFolder.getAncestors();
	}

	public com.liferay.portlet.imagegallery.model.IGFolder getParentFolder()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igFolder.getParentFolder();
	}

	public boolean isRoot() {
		return _igFolder.isRoot();
	}

	public IGFolder getWrappedIGFolder() {
		return _igFolder;
	}

	private IGFolder _igFolder;
}