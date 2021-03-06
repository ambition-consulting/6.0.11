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

package com.liferay.portlet.social.model;

/**
 * <p>
 * This class is a wrapper for {@link SocialEquityHistory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialEquityHistory
 * @generated
 */
public class SocialEquityHistoryWrapper implements SocialEquityHistory {
	public SocialEquityHistoryWrapper(SocialEquityHistory socialEquityHistory) {
		_socialEquityHistory = socialEquityHistory;
	}

	/**
	* Gets the primary key of this social equity history.
	*
	* @return the primary key of this social equity history
	*/
	public long getPrimaryKey() {
		return _socialEquityHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social equity history
	*
	* @param pk the primary key of this social equity history
	*/
	public void setPrimaryKey(long pk) {
		_socialEquityHistory.setPrimaryKey(pk);
	}

	/**
	* Gets the equity history id of this social equity history.
	*
	* @return the equity history id of this social equity history
	*/
	public long getEquityHistoryId() {
		return _socialEquityHistory.getEquityHistoryId();
	}

	/**
	* Sets the equity history id of this social equity history.
	*
	* @param equityHistoryId the equity history id of this social equity history
	*/
	public void setEquityHistoryId(long equityHistoryId) {
		_socialEquityHistory.setEquityHistoryId(equityHistoryId);
	}

	/**
	* Gets the group id of this social equity history.
	*
	* @return the group id of this social equity history
	*/
	public long getGroupId() {
		return _socialEquityHistory.getGroupId();
	}

	/**
	* Sets the group id of this social equity history.
	*
	* @param groupId the group id of this social equity history
	*/
	public void setGroupId(long groupId) {
		_socialEquityHistory.setGroupId(groupId);
	}

	/**
	* Gets the company id of this social equity history.
	*
	* @return the company id of this social equity history
	*/
	public long getCompanyId() {
		return _socialEquityHistory.getCompanyId();
	}

	/**
	* Sets the company id of this social equity history.
	*
	* @param companyId the company id of this social equity history
	*/
	public void setCompanyId(long companyId) {
		_socialEquityHistory.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this social equity history.
	*
	* @return the user id of this social equity history
	*/
	public long getUserId() {
		return _socialEquityHistory.getUserId();
	}

	/**
	* Sets the user id of this social equity history.
	*
	* @param userId the user id of this social equity history
	*/
	public void setUserId(long userId) {
		_socialEquityHistory.setUserId(userId);
	}

	/**
	* Gets the user uuid of this social equity history.
	*
	* @return the user uuid of this social equity history
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialEquityHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this social equity history.
	*
	* @param userUuid the user uuid of this social equity history
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_socialEquityHistory.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this social equity history.
	*
	* @return the create date of this social equity history
	*/
	public java.util.Date getCreateDate() {
		return _socialEquityHistory.getCreateDate();
	}

	/**
	* Sets the create date of this social equity history.
	*
	* @param createDate the create date of this social equity history
	*/
	public void setCreateDate(java.util.Date createDate) {
		_socialEquityHistory.setCreateDate(createDate);
	}

	/**
	* Gets the personal equity of this social equity history.
	*
	* @return the personal equity of this social equity history
	*/
	public int getPersonalEquity() {
		return _socialEquityHistory.getPersonalEquity();
	}

	/**
	* Sets the personal equity of this social equity history.
	*
	* @param personalEquity the personal equity of this social equity history
	*/
	public void setPersonalEquity(int personalEquity) {
		_socialEquityHistory.setPersonalEquity(personalEquity);
	}

	public boolean isNew() {
		return _socialEquityHistory.isNew();
	}

	public void setNew(boolean n) {
		_socialEquityHistory.setNew(n);
	}

	public boolean isCachedModel() {
		return _socialEquityHistory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_socialEquityHistory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _socialEquityHistory.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_socialEquityHistory.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _socialEquityHistory.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialEquityHistory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialEquityHistory.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SocialEquityHistoryWrapper((SocialEquityHistory)_socialEquityHistory.clone());
	}

	public int compareTo(
		com.liferay.portlet.social.model.SocialEquityHistory socialEquityHistory) {
		return _socialEquityHistory.compareTo(socialEquityHistory);
	}

	public int hashCode() {
		return _socialEquityHistory.hashCode();
	}

	public com.liferay.portlet.social.model.SocialEquityHistory toEscapedModel() {
		return new SocialEquityHistoryWrapper(_socialEquityHistory.toEscapedModel());
	}

	public java.lang.String toString() {
		return _socialEquityHistory.toString();
	}

	public java.lang.String toXmlString() {
		return _socialEquityHistory.toXmlString();
	}

	public SocialEquityHistory getWrappedSocialEquityHistory() {
		return _socialEquityHistory;
	}

	private SocialEquityHistory _socialEquityHistory;
}