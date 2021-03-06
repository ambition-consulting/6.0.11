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
 * This class is a wrapper for {@link MBMailingList}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMailingList
 * @generated
 */
public class MBMailingListWrapper implements MBMailingList {
	public MBMailingListWrapper(MBMailingList mbMailingList) {
		_mbMailingList = mbMailingList;
	}

	/**
	* Gets the primary key of this message boards mailing list.
	*
	* @return the primary key of this message boards mailing list
	*/
	public long getPrimaryKey() {
		return _mbMailingList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message boards mailing list
	*
	* @param pk the primary key of this message boards mailing list
	*/
	public void setPrimaryKey(long pk) {
		_mbMailingList.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this message boards mailing list.
	*
	* @return the uuid of this message boards mailing list
	*/
	public java.lang.String getUuid() {
		return _mbMailingList.getUuid();
	}

	/**
	* Sets the uuid of this message boards mailing list.
	*
	* @param uuid the uuid of this message boards mailing list
	*/
	public void setUuid(java.lang.String uuid) {
		_mbMailingList.setUuid(uuid);
	}

	/**
	* Gets the mailing list id of this message boards mailing list.
	*
	* @return the mailing list id of this message boards mailing list
	*/
	public long getMailingListId() {
		return _mbMailingList.getMailingListId();
	}

	/**
	* Sets the mailing list id of this message boards mailing list.
	*
	* @param mailingListId the mailing list id of this message boards mailing list
	*/
	public void setMailingListId(long mailingListId) {
		_mbMailingList.setMailingListId(mailingListId);
	}

	/**
	* Gets the group id of this message boards mailing list.
	*
	* @return the group id of this message boards mailing list
	*/
	public long getGroupId() {
		return _mbMailingList.getGroupId();
	}

	/**
	* Sets the group id of this message boards mailing list.
	*
	* @param groupId the group id of this message boards mailing list
	*/
	public void setGroupId(long groupId) {
		_mbMailingList.setGroupId(groupId);
	}

	/**
	* Gets the company id of this message boards mailing list.
	*
	* @return the company id of this message boards mailing list
	*/
	public long getCompanyId() {
		return _mbMailingList.getCompanyId();
	}

	/**
	* Sets the company id of this message boards mailing list.
	*
	* @param companyId the company id of this message boards mailing list
	*/
	public void setCompanyId(long companyId) {
		_mbMailingList.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this message boards mailing list.
	*
	* @return the user id of this message boards mailing list
	*/
	public long getUserId() {
		return _mbMailingList.getUserId();
	}

	/**
	* Sets the user id of this message boards mailing list.
	*
	* @param userId the user id of this message boards mailing list
	*/
	public void setUserId(long userId) {
		_mbMailingList.setUserId(userId);
	}

	/**
	* Gets the user uuid of this message boards mailing list.
	*
	* @return the user uuid of this message boards mailing list
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingList.getUserUuid();
	}

	/**
	* Sets the user uuid of this message boards mailing list.
	*
	* @param userUuid the user uuid of this message boards mailing list
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mbMailingList.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this message boards mailing list.
	*
	* @return the user name of this message boards mailing list
	*/
	public java.lang.String getUserName() {
		return _mbMailingList.getUserName();
	}

	/**
	* Sets the user name of this message boards mailing list.
	*
	* @param userName the user name of this message boards mailing list
	*/
	public void setUserName(java.lang.String userName) {
		_mbMailingList.setUserName(userName);
	}

	/**
	* Gets the create date of this message boards mailing list.
	*
	* @return the create date of this message boards mailing list
	*/
	public java.util.Date getCreateDate() {
		return _mbMailingList.getCreateDate();
	}

	/**
	* Sets the create date of this message boards mailing list.
	*
	* @param createDate the create date of this message boards mailing list
	*/
	public void setCreateDate(java.util.Date createDate) {
		_mbMailingList.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this message boards mailing list.
	*
	* @return the modified date of this message boards mailing list
	*/
	public java.util.Date getModifiedDate() {
		return _mbMailingList.getModifiedDate();
	}

	/**
	* Sets the modified date of this message boards mailing list.
	*
	* @param modifiedDate the modified date of this message boards mailing list
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mbMailingList.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the category id of this message boards mailing list.
	*
	* @return the category id of this message boards mailing list
	*/
	public long getCategoryId() {
		return _mbMailingList.getCategoryId();
	}

	/**
	* Sets the category id of this message boards mailing list.
	*
	* @param categoryId the category id of this message boards mailing list
	*/
	public void setCategoryId(long categoryId) {
		_mbMailingList.setCategoryId(categoryId);
	}

	/**
	* Gets the email address of this message boards mailing list.
	*
	* @return the email address of this message boards mailing list
	*/
	public java.lang.String getEmailAddress() {
		return _mbMailingList.getEmailAddress();
	}

	/**
	* Sets the email address of this message boards mailing list.
	*
	* @param emailAddress the email address of this message boards mailing list
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_mbMailingList.setEmailAddress(emailAddress);
	}

	/**
	* Gets the in protocol of this message boards mailing list.
	*
	* @return the in protocol of this message boards mailing list
	*/
	public java.lang.String getInProtocol() {
		return _mbMailingList.getInProtocol();
	}

	/**
	* Sets the in protocol of this message boards mailing list.
	*
	* @param inProtocol the in protocol of this message boards mailing list
	*/
	public void setInProtocol(java.lang.String inProtocol) {
		_mbMailingList.setInProtocol(inProtocol);
	}

	/**
	* Gets the in server name of this message boards mailing list.
	*
	* @return the in server name of this message boards mailing list
	*/
	public java.lang.String getInServerName() {
		return _mbMailingList.getInServerName();
	}

	/**
	* Sets the in server name of this message boards mailing list.
	*
	* @param inServerName the in server name of this message boards mailing list
	*/
	public void setInServerName(java.lang.String inServerName) {
		_mbMailingList.setInServerName(inServerName);
	}

	/**
	* Gets the in server port of this message boards mailing list.
	*
	* @return the in server port of this message boards mailing list
	*/
	public int getInServerPort() {
		return _mbMailingList.getInServerPort();
	}

	/**
	* Sets the in server port of this message boards mailing list.
	*
	* @param inServerPort the in server port of this message boards mailing list
	*/
	public void setInServerPort(int inServerPort) {
		_mbMailingList.setInServerPort(inServerPort);
	}

	/**
	* Gets the in use s s l of this message boards mailing list.
	*
	* @return the in use s s l of this message boards mailing list
	*/
	public boolean getInUseSSL() {
		return _mbMailingList.getInUseSSL();
	}

	/**
	* Determines if this message boards mailing list is in use s s l.
	*
	* @return <code>true</code> if this message boards mailing list is in use s s l; <code>false</code> otherwise
	*/
	public boolean isInUseSSL() {
		return _mbMailingList.isInUseSSL();
	}

	/**
	* Sets whether this message boards mailing list is in use s s l.
	*
	* @param inUseSSL the in use s s l of this message boards mailing list
	*/
	public void setInUseSSL(boolean inUseSSL) {
		_mbMailingList.setInUseSSL(inUseSSL);
	}

	/**
	* Gets the in user name of this message boards mailing list.
	*
	* @return the in user name of this message boards mailing list
	*/
	public java.lang.String getInUserName() {
		return _mbMailingList.getInUserName();
	}

	/**
	* Sets the in user name of this message boards mailing list.
	*
	* @param inUserName the in user name of this message boards mailing list
	*/
	public void setInUserName(java.lang.String inUserName) {
		_mbMailingList.setInUserName(inUserName);
	}

	/**
	* Gets the in password of this message boards mailing list.
	*
	* @return the in password of this message boards mailing list
	*/
	public java.lang.String getInPassword() {
		return _mbMailingList.getInPassword();
	}

	/**
	* Sets the in password of this message boards mailing list.
	*
	* @param inPassword the in password of this message boards mailing list
	*/
	public void setInPassword(java.lang.String inPassword) {
		_mbMailingList.setInPassword(inPassword);
	}

	/**
	* Gets the in read interval of this message boards mailing list.
	*
	* @return the in read interval of this message boards mailing list
	*/
	public int getInReadInterval() {
		return _mbMailingList.getInReadInterval();
	}

	/**
	* Sets the in read interval of this message boards mailing list.
	*
	* @param inReadInterval the in read interval of this message boards mailing list
	*/
	public void setInReadInterval(int inReadInterval) {
		_mbMailingList.setInReadInterval(inReadInterval);
	}

	/**
	* Gets the out email address of this message boards mailing list.
	*
	* @return the out email address of this message boards mailing list
	*/
	public java.lang.String getOutEmailAddress() {
		return _mbMailingList.getOutEmailAddress();
	}

	/**
	* Sets the out email address of this message boards mailing list.
	*
	* @param outEmailAddress the out email address of this message boards mailing list
	*/
	public void setOutEmailAddress(java.lang.String outEmailAddress) {
		_mbMailingList.setOutEmailAddress(outEmailAddress);
	}

	/**
	* Gets the out custom of this message boards mailing list.
	*
	* @return the out custom of this message boards mailing list
	*/
	public boolean getOutCustom() {
		return _mbMailingList.getOutCustom();
	}

	/**
	* Determines if this message boards mailing list is out custom.
	*
	* @return <code>true</code> if this message boards mailing list is out custom; <code>false</code> otherwise
	*/
	public boolean isOutCustom() {
		return _mbMailingList.isOutCustom();
	}

	/**
	* Sets whether this message boards mailing list is out custom.
	*
	* @param outCustom the out custom of this message boards mailing list
	*/
	public void setOutCustom(boolean outCustom) {
		_mbMailingList.setOutCustom(outCustom);
	}

	/**
	* Gets the out server name of this message boards mailing list.
	*
	* @return the out server name of this message boards mailing list
	*/
	public java.lang.String getOutServerName() {
		return _mbMailingList.getOutServerName();
	}

	/**
	* Sets the out server name of this message boards mailing list.
	*
	* @param outServerName the out server name of this message boards mailing list
	*/
	public void setOutServerName(java.lang.String outServerName) {
		_mbMailingList.setOutServerName(outServerName);
	}

	/**
	* Gets the out server port of this message boards mailing list.
	*
	* @return the out server port of this message boards mailing list
	*/
	public int getOutServerPort() {
		return _mbMailingList.getOutServerPort();
	}

	/**
	* Sets the out server port of this message boards mailing list.
	*
	* @param outServerPort the out server port of this message boards mailing list
	*/
	public void setOutServerPort(int outServerPort) {
		_mbMailingList.setOutServerPort(outServerPort);
	}

	/**
	* Gets the out use s s l of this message boards mailing list.
	*
	* @return the out use s s l of this message boards mailing list
	*/
	public boolean getOutUseSSL() {
		return _mbMailingList.getOutUseSSL();
	}

	/**
	* Determines if this message boards mailing list is out use s s l.
	*
	* @return <code>true</code> if this message boards mailing list is out use s s l; <code>false</code> otherwise
	*/
	public boolean isOutUseSSL() {
		return _mbMailingList.isOutUseSSL();
	}

	/**
	* Sets whether this message boards mailing list is out use s s l.
	*
	* @param outUseSSL the out use s s l of this message boards mailing list
	*/
	public void setOutUseSSL(boolean outUseSSL) {
		_mbMailingList.setOutUseSSL(outUseSSL);
	}

	/**
	* Gets the out user name of this message boards mailing list.
	*
	* @return the out user name of this message boards mailing list
	*/
	public java.lang.String getOutUserName() {
		return _mbMailingList.getOutUserName();
	}

	/**
	* Sets the out user name of this message boards mailing list.
	*
	* @param outUserName the out user name of this message boards mailing list
	*/
	public void setOutUserName(java.lang.String outUserName) {
		_mbMailingList.setOutUserName(outUserName);
	}

	/**
	* Gets the out password of this message boards mailing list.
	*
	* @return the out password of this message boards mailing list
	*/
	public java.lang.String getOutPassword() {
		return _mbMailingList.getOutPassword();
	}

	/**
	* Sets the out password of this message boards mailing list.
	*
	* @param outPassword the out password of this message boards mailing list
	*/
	public void setOutPassword(java.lang.String outPassword) {
		_mbMailingList.setOutPassword(outPassword);
	}

	/**
	* Gets the active of this message boards mailing list.
	*
	* @return the active of this message boards mailing list
	*/
	public boolean getActive() {
		return _mbMailingList.getActive();
	}

	/**
	* Determines if this message boards mailing list is active.
	*
	* @return <code>true</code> if this message boards mailing list is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _mbMailingList.isActive();
	}

	/**
	* Sets whether this message boards mailing list is active.
	*
	* @param active the active of this message boards mailing list
	*/
	public void setActive(boolean active) {
		_mbMailingList.setActive(active);
	}

	public boolean isNew() {
		return _mbMailingList.isNew();
	}

	public void setNew(boolean n) {
		_mbMailingList.setNew(n);
	}

	public boolean isCachedModel() {
		return _mbMailingList.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mbMailingList.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mbMailingList.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_mbMailingList.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mbMailingList.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mbMailingList.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mbMailingList.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new MBMailingListWrapper((MBMailingList)_mbMailingList.clone());
	}

	public int compareTo(
		com.liferay.portlet.messageboards.model.MBMailingList mbMailingList) {
		return _mbMailingList.compareTo(mbMailingList);
	}

	public int hashCode() {
		return _mbMailingList.hashCode();
	}

	public com.liferay.portlet.messageboards.model.MBMailingList toEscapedModel() {
		return new MBMailingListWrapper(_mbMailingList.toEscapedModel());
	}

	public java.lang.String toString() {
		return _mbMailingList.toString();
	}

	public java.lang.String toXmlString() {
		return _mbMailingList.toXmlString();
	}

	public MBMailingList getWrappedMBMailingList() {
		return _mbMailingList;
	}

	private MBMailingList _mbMailingList;
}