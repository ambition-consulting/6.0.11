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

package com.liferay.portlet.announcements.model;

/**
 * <p>
 * This class is a wrapper for {@link AnnouncementsFlag}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AnnouncementsFlag
 * @generated
 */
public class AnnouncementsFlagWrapper implements AnnouncementsFlag {
	public AnnouncementsFlagWrapper(AnnouncementsFlag announcementsFlag) {
		_announcementsFlag = announcementsFlag;
	}

	/**
	* Gets the primary key of this announcements flag.
	*
	* @return the primary key of this announcements flag
	*/
	public long getPrimaryKey() {
		return _announcementsFlag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this announcements flag
	*
	* @param pk the primary key of this announcements flag
	*/
	public void setPrimaryKey(long pk) {
		_announcementsFlag.setPrimaryKey(pk);
	}

	/**
	* Gets the flag id of this announcements flag.
	*
	* @return the flag id of this announcements flag
	*/
	public long getFlagId() {
		return _announcementsFlag.getFlagId();
	}

	/**
	* Sets the flag id of this announcements flag.
	*
	* @param flagId the flag id of this announcements flag
	*/
	public void setFlagId(long flagId) {
		_announcementsFlag.setFlagId(flagId);
	}

	/**
	* Gets the user id of this announcements flag.
	*
	* @return the user id of this announcements flag
	*/
	public long getUserId() {
		return _announcementsFlag.getUserId();
	}

	/**
	* Sets the user id of this announcements flag.
	*
	* @param userId the user id of this announcements flag
	*/
	public void setUserId(long userId) {
		_announcementsFlag.setUserId(userId);
	}

	/**
	* Gets the user uuid of this announcements flag.
	*
	* @return the user uuid of this announcements flag
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsFlag.getUserUuid();
	}

	/**
	* Sets the user uuid of this announcements flag.
	*
	* @param userUuid the user uuid of this announcements flag
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_announcementsFlag.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this announcements flag.
	*
	* @return the create date of this announcements flag
	*/
	public java.util.Date getCreateDate() {
		return _announcementsFlag.getCreateDate();
	}

	/**
	* Sets the create date of this announcements flag.
	*
	* @param createDate the create date of this announcements flag
	*/
	public void setCreateDate(java.util.Date createDate) {
		_announcementsFlag.setCreateDate(createDate);
	}

	/**
	* Gets the entry id of this announcements flag.
	*
	* @return the entry id of this announcements flag
	*/
	public long getEntryId() {
		return _announcementsFlag.getEntryId();
	}

	/**
	* Sets the entry id of this announcements flag.
	*
	* @param entryId the entry id of this announcements flag
	*/
	public void setEntryId(long entryId) {
		_announcementsFlag.setEntryId(entryId);
	}

	/**
	* Gets the value of this announcements flag.
	*
	* @return the value of this announcements flag
	*/
	public int getValue() {
		return _announcementsFlag.getValue();
	}

	/**
	* Sets the value of this announcements flag.
	*
	* @param value the value of this announcements flag
	*/
	public void setValue(int value) {
		_announcementsFlag.setValue(value);
	}

	public boolean isNew() {
		return _announcementsFlag.isNew();
	}

	public void setNew(boolean n) {
		_announcementsFlag.setNew(n);
	}

	public boolean isCachedModel() {
		return _announcementsFlag.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_announcementsFlag.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _announcementsFlag.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_announcementsFlag.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _announcementsFlag.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _announcementsFlag.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_announcementsFlag.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AnnouncementsFlagWrapper((AnnouncementsFlag)_announcementsFlag.clone());
	}

	public int compareTo(
		com.liferay.portlet.announcements.model.AnnouncementsFlag announcementsFlag) {
		return _announcementsFlag.compareTo(announcementsFlag);
	}

	public int hashCode() {
		return _announcementsFlag.hashCode();
	}

	public com.liferay.portlet.announcements.model.AnnouncementsFlag toEscapedModel() {
		return new AnnouncementsFlagWrapper(_announcementsFlag.toEscapedModel());
	}

	public java.lang.String toString() {
		return _announcementsFlag.toString();
	}

	public java.lang.String toXmlString() {
		return _announcementsFlag.toXmlString();
	}

	public AnnouncementsFlag getWrappedAnnouncementsFlag() {
		return _announcementsFlag;
	}

	private AnnouncementsFlag _announcementsFlag;
}