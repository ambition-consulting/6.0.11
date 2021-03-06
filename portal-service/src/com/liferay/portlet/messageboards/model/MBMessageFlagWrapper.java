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

package com.liferay.portlet.messageboards.model;

/**
 * <p>
 * This class is a wrapper for {@link MBMessageFlag}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMessageFlag
 * @generated
 */
public class MBMessageFlagWrapper implements MBMessageFlag {
	public MBMessageFlagWrapper(MBMessageFlag mbMessageFlag) {
		_mbMessageFlag = mbMessageFlag;
	}

	/**
	* Gets the primary key of this message boards message flag.
	*
	* @return the primary key of this message boards message flag
	*/
	public long getPrimaryKey() {
		return _mbMessageFlag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message boards message flag
	*
	* @param pk the primary key of this message boards message flag
	*/
	public void setPrimaryKey(long pk) {
		_mbMessageFlag.setPrimaryKey(pk);
	}

	/**
	* Gets the message flag id of this message boards message flag.
	*
	* @return the message flag id of this message boards message flag
	*/
	public long getMessageFlagId() {
		return _mbMessageFlag.getMessageFlagId();
	}

	/**
	* Sets the message flag id of this message boards message flag.
	*
	* @param messageFlagId the message flag id of this message boards message flag
	*/
	public void setMessageFlagId(long messageFlagId) {
		_mbMessageFlag.setMessageFlagId(messageFlagId);
	}

	/**
	* Gets the user id of this message boards message flag.
	*
	* @return the user id of this message boards message flag
	*/
	public long getUserId() {
		return _mbMessageFlag.getUserId();
	}

	/**
	* Sets the user id of this message boards message flag.
	*
	* @param userId the user id of this message boards message flag
	*/
	public void setUserId(long userId) {
		_mbMessageFlag.setUserId(userId);
	}

	/**
	* Gets the user uuid of this message boards message flag.
	*
	* @return the user uuid of this message boards message flag
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageFlag.getUserUuid();
	}

	/**
	* Sets the user uuid of this message boards message flag.
	*
	* @param userUuid the user uuid of this message boards message flag
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mbMessageFlag.setUserUuid(userUuid);
	}

	/**
	* Gets the modified date of this message boards message flag.
	*
	* @return the modified date of this message boards message flag
	*/
	public java.util.Date getModifiedDate() {
		return _mbMessageFlag.getModifiedDate();
	}

	/**
	* Sets the modified date of this message boards message flag.
	*
	* @param modifiedDate the modified date of this message boards message flag
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mbMessageFlag.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the thread id of this message boards message flag.
	*
	* @return the thread id of this message boards message flag
	*/
	public long getThreadId() {
		return _mbMessageFlag.getThreadId();
	}

	/**
	* Sets the thread id of this message boards message flag.
	*
	* @param threadId the thread id of this message boards message flag
	*/
	public void setThreadId(long threadId) {
		_mbMessageFlag.setThreadId(threadId);
	}

	/**
	* Gets the message id of this message boards message flag.
	*
	* @return the message id of this message boards message flag
	*/
	public long getMessageId() {
		return _mbMessageFlag.getMessageId();
	}

	/**
	* Sets the message id of this message boards message flag.
	*
	* @param messageId the message id of this message boards message flag
	*/
	public void setMessageId(long messageId) {
		_mbMessageFlag.setMessageId(messageId);
	}

	/**
	* Gets the flag of this message boards message flag.
	*
	* @return the flag of this message boards message flag
	*/
	public int getFlag() {
		return _mbMessageFlag.getFlag();
	}

	/**
	* Sets the flag of this message boards message flag.
	*
	* @param flag the flag of this message boards message flag
	*/
	public void setFlag(int flag) {
		_mbMessageFlag.setFlag(flag);
	}

	public boolean isNew() {
		return _mbMessageFlag.isNew();
	}

	public void setNew(boolean n) {
		_mbMessageFlag.setNew(n);
	}

	public boolean isCachedModel() {
		return _mbMessageFlag.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mbMessageFlag.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mbMessageFlag.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_mbMessageFlag.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mbMessageFlag.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mbMessageFlag.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mbMessageFlag.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new MBMessageFlagWrapper((MBMessageFlag)_mbMessageFlag.clone());
	}

	public int compareTo(
		com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag) {
		return _mbMessageFlag.compareTo(mbMessageFlag);
	}

	public int hashCode() {
		return _mbMessageFlag.hashCode();
	}

	public com.liferay.portlet.messageboards.model.MBMessageFlag toEscapedModel() {
		return new MBMessageFlagWrapper(_mbMessageFlag.toEscapedModel());
	}

	public java.lang.String toString() {
		return _mbMessageFlag.toString();
	}

	public java.lang.String toXmlString() {
		return _mbMessageFlag.toXmlString();
	}

	public MBMessageFlag getWrappedMBMessageFlag() {
		return _mbMessageFlag;
	}

	private MBMessageFlag _mbMessageFlag;
}