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

package com.liferay.portlet.blogs.model;

/**
 * <p>
 * This class is a wrapper for {@link BlogsEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BlogsEntry
 * @generated
 */
public class BlogsEntryWrapper implements BlogsEntry {
	public BlogsEntryWrapper(BlogsEntry blogsEntry) {
		_blogsEntry = blogsEntry;
	}

	/**
	* Gets the primary key of this blogs entry.
	*
	* @return the primary key of this blogs entry
	*/
	public long getPrimaryKey() {
		return _blogsEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this blogs entry
	*
	* @param pk the primary key of this blogs entry
	*/
	public void setPrimaryKey(long pk) {
		_blogsEntry.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this blogs entry.
	*
	* @return the uuid of this blogs entry
	*/
	public java.lang.String getUuid() {
		return _blogsEntry.getUuid();
	}

	/**
	* Sets the uuid of this blogs entry.
	*
	* @param uuid the uuid of this blogs entry
	*/
	public void setUuid(java.lang.String uuid) {
		_blogsEntry.setUuid(uuid);
	}

	/**
	* Gets the entry id of this blogs entry.
	*
	* @return the entry id of this blogs entry
	*/
	public long getEntryId() {
		return _blogsEntry.getEntryId();
	}

	/**
	* Sets the entry id of this blogs entry.
	*
	* @param entryId the entry id of this blogs entry
	*/
	public void setEntryId(long entryId) {
		_blogsEntry.setEntryId(entryId);
	}

	/**
	* Gets the group id of this blogs entry.
	*
	* @return the group id of this blogs entry
	*/
	public long getGroupId() {
		return _blogsEntry.getGroupId();
	}

	/**
	* Sets the group id of this blogs entry.
	*
	* @param groupId the group id of this blogs entry
	*/
	public void setGroupId(long groupId) {
		_blogsEntry.setGroupId(groupId);
	}

	/**
	* Gets the company id of this blogs entry.
	*
	* @return the company id of this blogs entry
	*/
	public long getCompanyId() {
		return _blogsEntry.getCompanyId();
	}

	/**
	* Sets the company id of this blogs entry.
	*
	* @param companyId the company id of this blogs entry
	*/
	public void setCompanyId(long companyId) {
		_blogsEntry.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this blogs entry.
	*
	* @return the user id of this blogs entry
	*/
	public long getUserId() {
		return _blogsEntry.getUserId();
	}

	/**
	* Sets the user id of this blogs entry.
	*
	* @param userId the user id of this blogs entry
	*/
	public void setUserId(long userId) {
		_blogsEntry.setUserId(userId);
	}

	/**
	* Gets the user uuid of this blogs entry.
	*
	* @return the user uuid of this blogs entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _blogsEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this blogs entry.
	*
	* @param userUuid the user uuid of this blogs entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_blogsEntry.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this blogs entry.
	*
	* @return the user name of this blogs entry
	*/
	public java.lang.String getUserName() {
		return _blogsEntry.getUserName();
	}

	/**
	* Sets the user name of this blogs entry.
	*
	* @param userName the user name of this blogs entry
	*/
	public void setUserName(java.lang.String userName) {
		_blogsEntry.setUserName(userName);
	}

	/**
	* Gets the create date of this blogs entry.
	*
	* @return the create date of this blogs entry
	*/
	public java.util.Date getCreateDate() {
		return _blogsEntry.getCreateDate();
	}

	/**
	* Sets the create date of this blogs entry.
	*
	* @param createDate the create date of this blogs entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_blogsEntry.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this blogs entry.
	*
	* @return the modified date of this blogs entry
	*/
	public java.util.Date getModifiedDate() {
		return _blogsEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this blogs entry.
	*
	* @param modifiedDate the modified date of this blogs entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_blogsEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the title of this blogs entry.
	*
	* @return the title of this blogs entry
	*/
	public java.lang.String getTitle() {
		return _blogsEntry.getTitle();
	}

	/**
	* Sets the title of this blogs entry.
	*
	* @param title the title of this blogs entry
	*/
	public void setTitle(java.lang.String title) {
		_blogsEntry.setTitle(title);
	}

	/**
	* Gets the url title of this blogs entry.
	*
	* @return the url title of this blogs entry
	*/
	public java.lang.String getUrlTitle() {
		return _blogsEntry.getUrlTitle();
	}

	/**
	* Sets the url title of this blogs entry.
	*
	* @param urlTitle the url title of this blogs entry
	*/
	public void setUrlTitle(java.lang.String urlTitle) {
		_blogsEntry.setUrlTitle(urlTitle);
	}

	/**
	* Gets the content of this blogs entry.
	*
	* @return the content of this blogs entry
	*/
	public java.lang.String getContent() {
		return _blogsEntry.getContent();
	}

	/**
	* Sets the content of this blogs entry.
	*
	* @param content the content of this blogs entry
	*/
	public void setContent(java.lang.String content) {
		_blogsEntry.setContent(content);
	}

	/**
	* Gets the display date of this blogs entry.
	*
	* @return the display date of this blogs entry
	*/
	public java.util.Date getDisplayDate() {
		return _blogsEntry.getDisplayDate();
	}

	/**
	* Sets the display date of this blogs entry.
	*
	* @param displayDate the display date of this blogs entry
	*/
	public void setDisplayDate(java.util.Date displayDate) {
		_blogsEntry.setDisplayDate(displayDate);
	}

	/**
	* Gets the allow pingbacks of this blogs entry.
	*
	* @return the allow pingbacks of this blogs entry
	*/
	public boolean getAllowPingbacks() {
		return _blogsEntry.getAllowPingbacks();
	}

	/**
	* Determines if this blogs entry is allow pingbacks.
	*
	* @return <code>true</code> if this blogs entry is allow pingbacks; <code>false</code> otherwise
	*/
	public boolean isAllowPingbacks() {
		return _blogsEntry.isAllowPingbacks();
	}

	/**
	* Sets whether this blogs entry is allow pingbacks.
	*
	* @param allowPingbacks the allow pingbacks of this blogs entry
	*/
	public void setAllowPingbacks(boolean allowPingbacks) {
		_blogsEntry.setAllowPingbacks(allowPingbacks);
	}

	/**
	* Gets the allow trackbacks of this blogs entry.
	*
	* @return the allow trackbacks of this blogs entry
	*/
	public boolean getAllowTrackbacks() {
		return _blogsEntry.getAllowTrackbacks();
	}

	/**
	* Determines if this blogs entry is allow trackbacks.
	*
	* @return <code>true</code> if this blogs entry is allow trackbacks; <code>false</code> otherwise
	*/
	public boolean isAllowTrackbacks() {
		return _blogsEntry.isAllowTrackbacks();
	}

	/**
	* Sets whether this blogs entry is allow trackbacks.
	*
	* @param allowTrackbacks the allow trackbacks of this blogs entry
	*/
	public void setAllowTrackbacks(boolean allowTrackbacks) {
		_blogsEntry.setAllowTrackbacks(allowTrackbacks);
	}

	/**
	* Gets the trackbacks of this blogs entry.
	*
	* @return the trackbacks of this blogs entry
	*/
	public java.lang.String getTrackbacks() {
		return _blogsEntry.getTrackbacks();
	}

	/**
	* Sets the trackbacks of this blogs entry.
	*
	* @param trackbacks the trackbacks of this blogs entry
	*/
	public void setTrackbacks(java.lang.String trackbacks) {
		_blogsEntry.setTrackbacks(trackbacks);
	}

	/**
	* Gets the status of this blogs entry.
	*
	* @return the status of this blogs entry
	*/
	public int getStatus() {
		return _blogsEntry.getStatus();
	}

	/**
	* Sets the status of this blogs entry.
	*
	* @param status the status of this blogs entry
	*/
	public void setStatus(int status) {
		_blogsEntry.setStatus(status);
	}

	/**
	* Gets the status by user id of this blogs entry.
	*
	* @return the status by user id of this blogs entry
	*/
	public long getStatusByUserId() {
		return _blogsEntry.getStatusByUserId();
	}

	/**
	* Sets the status by user id of this blogs entry.
	*
	* @param statusByUserId the status by user id of this blogs entry
	*/
	public void setStatusByUserId(long statusByUserId) {
		_blogsEntry.setStatusByUserId(statusByUserId);
	}

	/**
	* Gets the status by user uuid of this blogs entry.
	*
	* @return the status by user uuid of this blogs entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _blogsEntry.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this blogs entry.
	*
	* @param statusByUserUuid the status by user uuid of this blogs entry
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_blogsEntry.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Gets the status by user name of this blogs entry.
	*
	* @return the status by user name of this blogs entry
	*/
	public java.lang.String getStatusByUserName() {
		return _blogsEntry.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this blogs entry.
	*
	* @param statusByUserName the status by user name of this blogs entry
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_blogsEntry.setStatusByUserName(statusByUserName);
	}

	/**
	* Gets the status date of this blogs entry.
	*
	* @return the status date of this blogs entry
	*/
	public java.util.Date getStatusDate() {
		return _blogsEntry.getStatusDate();
	}

	/**
	* Sets the status date of this blogs entry.
	*
	* @param statusDate the status date of this blogs entry
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_blogsEntry.setStatusDate(statusDate);
	}

	/**
	* @deprecated {@link #isApproved}
	*/
	public boolean getApproved() {
		return _blogsEntry.getApproved();
	}

	/**
	* Determines if this blogs entry is approved.
	*
	* @return <code>true</code> if this blogs entry is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _blogsEntry.isApproved();
	}

	/**
	* Determines if this blogs entry is a draft.
	*
	* @return <code>true</code> if this blogs entry is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _blogsEntry.isDraft();
	}

	/**
	* Determines if this blogs entry is expired.
	*
	* @return <code>true</code> if this blogs entry is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _blogsEntry.isExpired();
	}

	/**
	* Determines if this blogs entry is pending.
	*
	* @return <code>true</code> if this blogs entry is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _blogsEntry.isPending();
	}

	public boolean isNew() {
		return _blogsEntry.isNew();
	}

	public void setNew(boolean n) {
		_blogsEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _blogsEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_blogsEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _blogsEntry.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_blogsEntry.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _blogsEntry.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _blogsEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_blogsEntry.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new BlogsEntryWrapper((BlogsEntry)_blogsEntry.clone());
	}

	public int compareTo(com.liferay.portlet.blogs.model.BlogsEntry blogsEntry) {
		return _blogsEntry.compareTo(blogsEntry);
	}

	public int hashCode() {
		return _blogsEntry.hashCode();
	}

	public com.liferay.portlet.blogs.model.BlogsEntry toEscapedModel() {
		return new BlogsEntryWrapper(_blogsEntry.toEscapedModel());
	}

	public java.lang.String toString() {
		return _blogsEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _blogsEntry.toXmlString();
	}

	public BlogsEntry getWrappedBlogsEntry() {
		return _blogsEntry;
	}

	private BlogsEntry _blogsEntry;
}