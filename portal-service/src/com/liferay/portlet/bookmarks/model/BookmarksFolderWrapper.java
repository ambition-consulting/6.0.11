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

package com.liferay.portlet.bookmarks.model;

/**
 * <p>
 * This class is a wrapper for {@link BookmarksFolder}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookmarksFolder
 * @generated
 */
public class BookmarksFolderWrapper implements BookmarksFolder {
	public BookmarksFolderWrapper(BookmarksFolder bookmarksFolder) {
		_bookmarksFolder = bookmarksFolder;
	}

	/**
	* Gets the primary key of this bookmarks folder.
	*
	* @return the primary key of this bookmarks folder
	*/
	public long getPrimaryKey() {
		return _bookmarksFolder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bookmarks folder
	*
	* @param pk the primary key of this bookmarks folder
	*/
	public void setPrimaryKey(long pk) {
		_bookmarksFolder.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this bookmarks folder.
	*
	* @return the uuid of this bookmarks folder
	*/
	public java.lang.String getUuid() {
		return _bookmarksFolder.getUuid();
	}

	/**
	* Sets the uuid of this bookmarks folder.
	*
	* @param uuid the uuid of this bookmarks folder
	*/
	public void setUuid(java.lang.String uuid) {
		_bookmarksFolder.setUuid(uuid);
	}

	/**
	* Gets the folder id of this bookmarks folder.
	*
	* @return the folder id of this bookmarks folder
	*/
	public long getFolderId() {
		return _bookmarksFolder.getFolderId();
	}

	/**
	* Sets the folder id of this bookmarks folder.
	*
	* @param folderId the folder id of this bookmarks folder
	*/
	public void setFolderId(long folderId) {
		_bookmarksFolder.setFolderId(folderId);
	}

	/**
	* Gets the group id of this bookmarks folder.
	*
	* @return the group id of this bookmarks folder
	*/
	public long getGroupId() {
		return _bookmarksFolder.getGroupId();
	}

	/**
	* Sets the group id of this bookmarks folder.
	*
	* @param groupId the group id of this bookmarks folder
	*/
	public void setGroupId(long groupId) {
		_bookmarksFolder.setGroupId(groupId);
	}

	/**
	* Gets the company id of this bookmarks folder.
	*
	* @return the company id of this bookmarks folder
	*/
	public long getCompanyId() {
		return _bookmarksFolder.getCompanyId();
	}

	/**
	* Sets the company id of this bookmarks folder.
	*
	* @param companyId the company id of this bookmarks folder
	*/
	public void setCompanyId(long companyId) {
		_bookmarksFolder.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this bookmarks folder.
	*
	* @return the user id of this bookmarks folder
	*/
	public long getUserId() {
		return _bookmarksFolder.getUserId();
	}

	/**
	* Sets the user id of this bookmarks folder.
	*
	* @param userId the user id of this bookmarks folder
	*/
	public void setUserId(long userId) {
		_bookmarksFolder.setUserId(userId);
	}

	/**
	* Gets the user uuid of this bookmarks folder.
	*
	* @return the user uuid of this bookmarks folder
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolder.getUserUuid();
	}

	/**
	* Sets the user uuid of this bookmarks folder.
	*
	* @param userUuid the user uuid of this bookmarks folder
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_bookmarksFolder.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this bookmarks folder.
	*
	* @return the create date of this bookmarks folder
	*/
	public java.util.Date getCreateDate() {
		return _bookmarksFolder.getCreateDate();
	}

	/**
	* Sets the create date of this bookmarks folder.
	*
	* @param createDate the create date of this bookmarks folder
	*/
	public void setCreateDate(java.util.Date createDate) {
		_bookmarksFolder.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this bookmarks folder.
	*
	* @return the modified date of this bookmarks folder
	*/
	public java.util.Date getModifiedDate() {
		return _bookmarksFolder.getModifiedDate();
	}

	/**
	* Sets the modified date of this bookmarks folder.
	*
	* @param modifiedDate the modified date of this bookmarks folder
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bookmarksFolder.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the parent folder id of this bookmarks folder.
	*
	* @return the parent folder id of this bookmarks folder
	*/
	public long getParentFolderId() {
		return _bookmarksFolder.getParentFolderId();
	}

	/**
	* Sets the parent folder id of this bookmarks folder.
	*
	* @param parentFolderId the parent folder id of this bookmarks folder
	*/
	public void setParentFolderId(long parentFolderId) {
		_bookmarksFolder.setParentFolderId(parentFolderId);
	}

	/**
	* Gets the name of this bookmarks folder.
	*
	* @return the name of this bookmarks folder
	*/
	public java.lang.String getName() {
		return _bookmarksFolder.getName();
	}

	/**
	* Sets the name of this bookmarks folder.
	*
	* @param name the name of this bookmarks folder
	*/
	public void setName(java.lang.String name) {
		_bookmarksFolder.setName(name);
	}

	/**
	* Gets the description of this bookmarks folder.
	*
	* @return the description of this bookmarks folder
	*/
	public java.lang.String getDescription() {
		return _bookmarksFolder.getDescription();
	}

	/**
	* Sets the description of this bookmarks folder.
	*
	* @param description the description of this bookmarks folder
	*/
	public void setDescription(java.lang.String description) {
		_bookmarksFolder.setDescription(description);
	}

	public boolean isNew() {
		return _bookmarksFolder.isNew();
	}

	public void setNew(boolean n) {
		_bookmarksFolder.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookmarksFolder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookmarksFolder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookmarksFolder.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_bookmarksFolder.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookmarksFolder.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookmarksFolder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookmarksFolder.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new BookmarksFolderWrapper((BookmarksFolder)_bookmarksFolder.clone());
	}

	public int compareTo(
		com.liferay.portlet.bookmarks.model.BookmarksFolder bookmarksFolder) {
		return _bookmarksFolder.compareTo(bookmarksFolder);
	}

	public int hashCode() {
		return _bookmarksFolder.hashCode();
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder toEscapedModel() {
		return new BookmarksFolderWrapper(_bookmarksFolder.toEscapedModel());
	}

	public java.lang.String toString() {
		return _bookmarksFolder.toString();
	}

	public java.lang.String toXmlString() {
		return _bookmarksFolder.toXmlString();
	}

	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolder.getAncestors();
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder getParentFolder()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolder.getParentFolder();
	}

	public boolean isRoot() {
		return _bookmarksFolder.isRoot();
	}

	public BookmarksFolder getWrappedBookmarksFolder() {
		return _bookmarksFolder;
	}

	private BookmarksFolder _bookmarksFolder;
}