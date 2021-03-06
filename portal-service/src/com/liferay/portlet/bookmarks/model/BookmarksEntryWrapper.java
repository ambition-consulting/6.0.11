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
 * This class is a wrapper for {@link BookmarksEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookmarksEntry
 * @generated
 */
public class BookmarksEntryWrapper implements BookmarksEntry {
	public BookmarksEntryWrapper(BookmarksEntry bookmarksEntry) {
		_bookmarksEntry = bookmarksEntry;
	}

	/**
	* Gets the primary key of this bookmarks entry.
	*
	* @return the primary key of this bookmarks entry
	*/
	public long getPrimaryKey() {
		return _bookmarksEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bookmarks entry
	*
	* @param pk the primary key of this bookmarks entry
	*/
	public void setPrimaryKey(long pk) {
		_bookmarksEntry.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this bookmarks entry.
	*
	* @return the uuid of this bookmarks entry
	*/
	public java.lang.String getUuid() {
		return _bookmarksEntry.getUuid();
	}

	/**
	* Sets the uuid of this bookmarks entry.
	*
	* @param uuid the uuid of this bookmarks entry
	*/
	public void setUuid(java.lang.String uuid) {
		_bookmarksEntry.setUuid(uuid);
	}

	/**
	* Gets the entry id of this bookmarks entry.
	*
	* @return the entry id of this bookmarks entry
	*/
	public long getEntryId() {
		return _bookmarksEntry.getEntryId();
	}

	/**
	* Sets the entry id of this bookmarks entry.
	*
	* @param entryId the entry id of this bookmarks entry
	*/
	public void setEntryId(long entryId) {
		_bookmarksEntry.setEntryId(entryId);
	}

	/**
	* Gets the group id of this bookmarks entry.
	*
	* @return the group id of this bookmarks entry
	*/
	public long getGroupId() {
		return _bookmarksEntry.getGroupId();
	}

	/**
	* Sets the group id of this bookmarks entry.
	*
	* @param groupId the group id of this bookmarks entry
	*/
	public void setGroupId(long groupId) {
		_bookmarksEntry.setGroupId(groupId);
	}

	/**
	* Gets the company id of this bookmarks entry.
	*
	* @return the company id of this bookmarks entry
	*/
	public long getCompanyId() {
		return _bookmarksEntry.getCompanyId();
	}

	/**
	* Sets the company id of this bookmarks entry.
	*
	* @param companyId the company id of this bookmarks entry
	*/
	public void setCompanyId(long companyId) {
		_bookmarksEntry.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this bookmarks entry.
	*
	* @return the user id of this bookmarks entry
	*/
	public long getUserId() {
		return _bookmarksEntry.getUserId();
	}

	/**
	* Sets the user id of this bookmarks entry.
	*
	* @param userId the user id of this bookmarks entry
	*/
	public void setUserId(long userId) {
		_bookmarksEntry.setUserId(userId);
	}

	/**
	* Gets the user uuid of this bookmarks entry.
	*
	* @return the user uuid of this bookmarks entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this bookmarks entry.
	*
	* @param userUuid the user uuid of this bookmarks entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_bookmarksEntry.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this bookmarks entry.
	*
	* @return the create date of this bookmarks entry
	*/
	public java.util.Date getCreateDate() {
		return _bookmarksEntry.getCreateDate();
	}

	/**
	* Sets the create date of this bookmarks entry.
	*
	* @param createDate the create date of this bookmarks entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_bookmarksEntry.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this bookmarks entry.
	*
	* @return the modified date of this bookmarks entry
	*/
	public java.util.Date getModifiedDate() {
		return _bookmarksEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this bookmarks entry.
	*
	* @param modifiedDate the modified date of this bookmarks entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bookmarksEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the folder id of this bookmarks entry.
	*
	* @return the folder id of this bookmarks entry
	*/
	public long getFolderId() {
		return _bookmarksEntry.getFolderId();
	}

	/**
	* Sets the folder id of this bookmarks entry.
	*
	* @param folderId the folder id of this bookmarks entry
	*/
	public void setFolderId(long folderId) {
		_bookmarksEntry.setFolderId(folderId);
	}

	/**
	* Gets the name of this bookmarks entry.
	*
	* @return the name of this bookmarks entry
	*/
	public java.lang.String getName() {
		return _bookmarksEntry.getName();
	}

	/**
	* Sets the name of this bookmarks entry.
	*
	* @param name the name of this bookmarks entry
	*/
	public void setName(java.lang.String name) {
		_bookmarksEntry.setName(name);
	}

	/**
	* Gets the url of this bookmarks entry.
	*
	* @return the url of this bookmarks entry
	*/
	public java.lang.String getUrl() {
		return _bookmarksEntry.getUrl();
	}

	/**
	* Sets the url of this bookmarks entry.
	*
	* @param url the url of this bookmarks entry
	*/
	public void setUrl(java.lang.String url) {
		_bookmarksEntry.setUrl(url);
	}

	/**
	* Gets the comments of this bookmarks entry.
	*
	* @return the comments of this bookmarks entry
	*/
	public java.lang.String getComments() {
		return _bookmarksEntry.getComments();
	}

	/**
	* Sets the comments of this bookmarks entry.
	*
	* @param comments the comments of this bookmarks entry
	*/
	public void setComments(java.lang.String comments) {
		_bookmarksEntry.setComments(comments);
	}

	/**
	* Gets the visits of this bookmarks entry.
	*
	* @return the visits of this bookmarks entry
	*/
	public int getVisits() {
		return _bookmarksEntry.getVisits();
	}

	/**
	* Sets the visits of this bookmarks entry.
	*
	* @param visits the visits of this bookmarks entry
	*/
	public void setVisits(int visits) {
		_bookmarksEntry.setVisits(visits);
	}

	/**
	* Gets the priority of this bookmarks entry.
	*
	* @return the priority of this bookmarks entry
	*/
	public int getPriority() {
		return _bookmarksEntry.getPriority();
	}

	/**
	* Sets the priority of this bookmarks entry.
	*
	* @param priority the priority of this bookmarks entry
	*/
	public void setPriority(int priority) {
		_bookmarksEntry.setPriority(priority);
	}

	public boolean isNew() {
		return _bookmarksEntry.isNew();
	}

	public void setNew(boolean n) {
		_bookmarksEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookmarksEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookmarksEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookmarksEntry.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_bookmarksEntry.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookmarksEntry.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookmarksEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookmarksEntry.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new BookmarksEntryWrapper((BookmarksEntry)_bookmarksEntry.clone());
	}

	public int compareTo(
		com.liferay.portlet.bookmarks.model.BookmarksEntry bookmarksEntry) {
		return _bookmarksEntry.compareTo(bookmarksEntry);
	}

	public int hashCode() {
		return _bookmarksEntry.hashCode();
	}

	public com.liferay.portlet.bookmarks.model.BookmarksEntry toEscapedModel() {
		return new BookmarksEntryWrapper(_bookmarksEntry.toEscapedModel());
	}

	public java.lang.String toString() {
		return _bookmarksEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _bookmarksEntry.toXmlString();
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder getFolder() {
		return _bookmarksEntry.getFolder();
	}

	public BookmarksEntry getWrappedBookmarksEntry() {
		return _bookmarksEntry;
	}

	private BookmarksEntry _bookmarksEntry;
}