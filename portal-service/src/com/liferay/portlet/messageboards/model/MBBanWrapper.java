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
 * This class is a wrapper for {@link MBBan}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBBan
 * @generated
 */
public class MBBanWrapper implements MBBan {
	public MBBanWrapper(MBBan mbBan) {
		_mbBan = mbBan;
	}

	/**
	* Gets the primary key of this message boards ban.
	*
	* @return the primary key of this message boards ban
	*/
	public long getPrimaryKey() {
		return _mbBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message boards ban
	*
	* @param pk the primary key of this message boards ban
	*/
	public void setPrimaryKey(long pk) {
		_mbBan.setPrimaryKey(pk);
	}

	/**
	* Gets the ban id of this message boards ban.
	*
	* @return the ban id of this message boards ban
	*/
	public long getBanId() {
		return _mbBan.getBanId();
	}

	/**
	* Sets the ban id of this message boards ban.
	*
	* @param banId the ban id of this message boards ban
	*/
	public void setBanId(long banId) {
		_mbBan.setBanId(banId);
	}

	/**
	* Gets the group id of this message boards ban.
	*
	* @return the group id of this message boards ban
	*/
	public long getGroupId() {
		return _mbBan.getGroupId();
	}

	/**
	* Sets the group id of this message boards ban.
	*
	* @param groupId the group id of this message boards ban
	*/
	public void setGroupId(long groupId) {
		_mbBan.setGroupId(groupId);
	}

	/**
	* Gets the company id of this message boards ban.
	*
	* @return the company id of this message boards ban
	*/
	public long getCompanyId() {
		return _mbBan.getCompanyId();
	}

	/**
	* Sets the company id of this message boards ban.
	*
	* @param companyId the company id of this message boards ban
	*/
	public void setCompanyId(long companyId) {
		_mbBan.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this message boards ban.
	*
	* @return the user id of this message boards ban
	*/
	public long getUserId() {
		return _mbBan.getUserId();
	}

	/**
	* Sets the user id of this message boards ban.
	*
	* @param userId the user id of this message boards ban
	*/
	public void setUserId(long userId) {
		_mbBan.setUserId(userId);
	}

	/**
	* Gets the user uuid of this message boards ban.
	*
	* @return the user uuid of this message boards ban
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbBan.getUserUuid();
	}

	/**
	* Sets the user uuid of this message boards ban.
	*
	* @param userUuid the user uuid of this message boards ban
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mbBan.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this message boards ban.
	*
	* @return the user name of this message boards ban
	*/
	public java.lang.String getUserName() {
		return _mbBan.getUserName();
	}

	/**
	* Sets the user name of this message boards ban.
	*
	* @param userName the user name of this message boards ban
	*/
	public void setUserName(java.lang.String userName) {
		_mbBan.setUserName(userName);
	}

	/**
	* Gets the create date of this message boards ban.
	*
	* @return the create date of this message boards ban
	*/
	public java.util.Date getCreateDate() {
		return _mbBan.getCreateDate();
	}

	/**
	* Sets the create date of this message boards ban.
	*
	* @param createDate the create date of this message boards ban
	*/
	public void setCreateDate(java.util.Date createDate) {
		_mbBan.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this message boards ban.
	*
	* @return the modified date of this message boards ban
	*/
	public java.util.Date getModifiedDate() {
		return _mbBan.getModifiedDate();
	}

	/**
	* Sets the modified date of this message boards ban.
	*
	* @param modifiedDate the modified date of this message boards ban
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mbBan.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the ban user id of this message boards ban.
	*
	* @return the ban user id of this message boards ban
	*/
	public long getBanUserId() {
		return _mbBan.getBanUserId();
	}

	/**
	* Sets the ban user id of this message boards ban.
	*
	* @param banUserId the ban user id of this message boards ban
	*/
	public void setBanUserId(long banUserId) {
		_mbBan.setBanUserId(banUserId);
	}

	/**
	* Gets the ban user uuid of this message boards ban.
	*
	* @return the ban user uuid of this message boards ban
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getBanUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbBan.getBanUserUuid();
	}

	/**
	* Sets the ban user uuid of this message boards ban.
	*
	* @param banUserUuid the ban user uuid of this message boards ban
	*/
	public void setBanUserUuid(java.lang.String banUserUuid) {
		_mbBan.setBanUserUuid(banUserUuid);
	}

	public boolean isNew() {
		return _mbBan.isNew();
	}

	public void setNew(boolean n) {
		_mbBan.setNew(n);
	}

	public boolean isCachedModel() {
		return _mbBan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mbBan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mbBan.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_mbBan.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mbBan.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mbBan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mbBan.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new MBBanWrapper((MBBan)_mbBan.clone());
	}

	public int compareTo(com.liferay.portlet.messageboards.model.MBBan mbBan) {
		return _mbBan.compareTo(mbBan);
	}

	public int hashCode() {
		return _mbBan.hashCode();
	}

	public com.liferay.portlet.messageboards.model.MBBan toEscapedModel() {
		return new MBBanWrapper(_mbBan.toEscapedModel());
	}

	public java.lang.String toString() {
		return _mbBan.toString();
	}

	public java.lang.String toXmlString() {
		return _mbBan.toXmlString();
	}

	public MBBan getWrappedMBBan() {
		return _mbBan;
	}

	private MBBan _mbBan;
}