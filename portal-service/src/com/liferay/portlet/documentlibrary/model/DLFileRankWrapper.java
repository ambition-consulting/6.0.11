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

package com.liferay.portlet.documentlibrary.model;

/**
 * <p>
 * This class is a wrapper for {@link DLFileRank}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DLFileRank
 * @generated
 */
public class DLFileRankWrapper implements DLFileRank {
	public DLFileRankWrapper(DLFileRank dlFileRank) {
		_dlFileRank = dlFileRank;
	}

	/**
	* Gets the primary key of this d l file rank.
	*
	* @return the primary key of this d l file rank
	*/
	public long getPrimaryKey() {
		return _dlFileRank.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d l file rank
	*
	* @param pk the primary key of this d l file rank
	*/
	public void setPrimaryKey(long pk) {
		_dlFileRank.setPrimaryKey(pk);
	}

	/**
	* Gets the file rank id of this d l file rank.
	*
	* @return the file rank id of this d l file rank
	*/
	public long getFileRankId() {
		return _dlFileRank.getFileRankId();
	}

	/**
	* Sets the file rank id of this d l file rank.
	*
	* @param fileRankId the file rank id of this d l file rank
	*/
	public void setFileRankId(long fileRankId) {
		_dlFileRank.setFileRankId(fileRankId);
	}

	/**
	* Gets the group id of this d l file rank.
	*
	* @return the group id of this d l file rank
	*/
	public long getGroupId() {
		return _dlFileRank.getGroupId();
	}

	/**
	* Sets the group id of this d l file rank.
	*
	* @param groupId the group id of this d l file rank
	*/
	public void setGroupId(long groupId) {
		_dlFileRank.setGroupId(groupId);
	}

	/**
	* Gets the company id of this d l file rank.
	*
	* @return the company id of this d l file rank
	*/
	public long getCompanyId() {
		return _dlFileRank.getCompanyId();
	}

	/**
	* Sets the company id of this d l file rank.
	*
	* @param companyId the company id of this d l file rank
	*/
	public void setCompanyId(long companyId) {
		_dlFileRank.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this d l file rank.
	*
	* @return the user id of this d l file rank
	*/
	public long getUserId() {
		return _dlFileRank.getUserId();
	}

	/**
	* Sets the user id of this d l file rank.
	*
	* @param userId the user id of this d l file rank
	*/
	public void setUserId(long userId) {
		_dlFileRank.setUserId(userId);
	}

	/**
	* Gets the user uuid of this d l file rank.
	*
	* @return the user uuid of this d l file rank
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlFileRank.getUserUuid();
	}

	/**
	* Sets the user uuid of this d l file rank.
	*
	* @param userUuid the user uuid of this d l file rank
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dlFileRank.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this d l file rank.
	*
	* @return the create date of this d l file rank
	*/
	public java.util.Date getCreateDate() {
		return _dlFileRank.getCreateDate();
	}

	/**
	* Sets the create date of this d l file rank.
	*
	* @param createDate the create date of this d l file rank
	*/
	public void setCreateDate(java.util.Date createDate) {
		_dlFileRank.setCreateDate(createDate);
	}

	/**
	* Gets the file entry id of this d l file rank.
	*
	* @return the file entry id of this d l file rank
	*/
	public long getFileEntryId() {
		return _dlFileRank.getFileEntryId();
	}

	/**
	* Sets the file entry id of this d l file rank.
	*
	* @param fileEntryId the file entry id of this d l file rank
	*/
	public void setFileEntryId(long fileEntryId) {
		_dlFileRank.setFileEntryId(fileEntryId);
	}

	public boolean isNew() {
		return _dlFileRank.isNew();
	}

	public void setNew(boolean n) {
		_dlFileRank.setNew(n);
	}

	public boolean isCachedModel() {
		return _dlFileRank.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dlFileRank.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dlFileRank.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_dlFileRank.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dlFileRank.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dlFileRank.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dlFileRank.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new DLFileRankWrapper((DLFileRank)_dlFileRank.clone());
	}

	public int compareTo(
		com.liferay.portlet.documentlibrary.model.DLFileRank dlFileRank) {
		return _dlFileRank.compareTo(dlFileRank);
	}

	public int hashCode() {
		return _dlFileRank.hashCode();
	}

	public com.liferay.portlet.documentlibrary.model.DLFileRank toEscapedModel() {
		return new DLFileRankWrapper(_dlFileRank.toEscapedModel());
	}

	public java.lang.String toString() {
		return _dlFileRank.toString();
	}

	public java.lang.String toXmlString() {
		return _dlFileRank.toXmlString();
	}

	public com.liferay.portlet.documentlibrary.model.DLFileEntry getFileEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileRank.getFileEntry();
	}

	/**
	* @deprecated {@link #getFileEntry()}
	*/
	public long getFolderId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileRank.getFolderId();
	}

	/**
	* @deprecated {@link #getFileEntry()}
	*/
	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileRank.getName();
	}

	public DLFileRank getWrappedDLFileRank() {
		return _dlFileRank;
	}

	private DLFileRank _dlFileRank;
}