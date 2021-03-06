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
 * This class is a wrapper for {@link SocialEquityUser}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialEquityUser
 * @generated
 */
public class SocialEquityUserWrapper implements SocialEquityUser {
	public SocialEquityUserWrapper(SocialEquityUser socialEquityUser) {
		_socialEquityUser = socialEquityUser;
	}

	/**
	* Gets the primary key of this social equity user.
	*
	* @return the primary key of this social equity user
	*/
	public long getPrimaryKey() {
		return _socialEquityUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social equity user
	*
	* @param pk the primary key of this social equity user
	*/
	public void setPrimaryKey(long pk) {
		_socialEquityUser.setPrimaryKey(pk);
	}

	/**
	* Gets the equity user id of this social equity user.
	*
	* @return the equity user id of this social equity user
	*/
	public long getEquityUserId() {
		return _socialEquityUser.getEquityUserId();
	}

	/**
	* Sets the equity user id of this social equity user.
	*
	* @param equityUserId the equity user id of this social equity user
	*/
	public void setEquityUserId(long equityUserId) {
		_socialEquityUser.setEquityUserId(equityUserId);
	}

	/**
	* Gets the equity user uuid of this social equity user.
	*
	* @return the equity user uuid of this social equity user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getEquityUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialEquityUser.getEquityUserUuid();
	}

	/**
	* Sets the equity user uuid of this social equity user.
	*
	* @param equityUserUuid the equity user uuid of this social equity user
	*/
	public void setEquityUserUuid(java.lang.String equityUserUuid) {
		_socialEquityUser.setEquityUserUuid(equityUserUuid);
	}

	/**
	* Gets the group id of this social equity user.
	*
	* @return the group id of this social equity user
	*/
	public long getGroupId() {
		return _socialEquityUser.getGroupId();
	}

	/**
	* Sets the group id of this social equity user.
	*
	* @param groupId the group id of this social equity user
	*/
	public void setGroupId(long groupId) {
		_socialEquityUser.setGroupId(groupId);
	}

	/**
	* Gets the company id of this social equity user.
	*
	* @return the company id of this social equity user
	*/
	public long getCompanyId() {
		return _socialEquityUser.getCompanyId();
	}

	/**
	* Sets the company id of this social equity user.
	*
	* @param companyId the company id of this social equity user
	*/
	public void setCompanyId(long companyId) {
		_socialEquityUser.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this social equity user.
	*
	* @return the user id of this social equity user
	*/
	public long getUserId() {
		return _socialEquityUser.getUserId();
	}

	/**
	* Sets the user id of this social equity user.
	*
	* @param userId the user id of this social equity user
	*/
	public void setUserId(long userId) {
		_socialEquityUser.setUserId(userId);
	}

	/**
	* Gets the user uuid of this social equity user.
	*
	* @return the user uuid of this social equity user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialEquityUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this social equity user.
	*
	* @param userUuid the user uuid of this social equity user
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_socialEquityUser.setUserUuid(userUuid);
	}

	/**
	* Gets the contribution k of this social equity user.
	*
	* @return the contribution k of this social equity user
	*/
	public double getContributionK() {
		return _socialEquityUser.getContributionK();
	}

	/**
	* Sets the contribution k of this social equity user.
	*
	* @param contributionK the contribution k of this social equity user
	*/
	public void setContributionK(double contributionK) {
		_socialEquityUser.setContributionK(contributionK);
	}

	/**
	* Gets the contribution b of this social equity user.
	*
	* @return the contribution b of this social equity user
	*/
	public double getContributionB() {
		return _socialEquityUser.getContributionB();
	}

	/**
	* Sets the contribution b of this social equity user.
	*
	* @param contributionB the contribution b of this social equity user
	*/
	public void setContributionB(double contributionB) {
		_socialEquityUser.setContributionB(contributionB);
	}

	/**
	* Gets the participation k of this social equity user.
	*
	* @return the participation k of this social equity user
	*/
	public double getParticipationK() {
		return _socialEquityUser.getParticipationK();
	}

	/**
	* Sets the participation k of this social equity user.
	*
	* @param participationK the participation k of this social equity user
	*/
	public void setParticipationK(double participationK) {
		_socialEquityUser.setParticipationK(participationK);
	}

	/**
	* Gets the participation b of this social equity user.
	*
	* @return the participation b of this social equity user
	*/
	public double getParticipationB() {
		return _socialEquityUser.getParticipationB();
	}

	/**
	* Sets the participation b of this social equity user.
	*
	* @param participationB the participation b of this social equity user
	*/
	public void setParticipationB(double participationB) {
		_socialEquityUser.setParticipationB(participationB);
	}

	/**
	* Gets the rank of this social equity user.
	*
	* @return the rank of this social equity user
	*/
	public int getRank() {
		return _socialEquityUser.getRank();
	}

	/**
	* Sets the rank of this social equity user.
	*
	* @param rank the rank of this social equity user
	*/
	public void setRank(int rank) {
		_socialEquityUser.setRank(rank);
	}

	public boolean isNew() {
		return _socialEquityUser.isNew();
	}

	public void setNew(boolean n) {
		_socialEquityUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _socialEquityUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_socialEquityUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _socialEquityUser.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_socialEquityUser.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _socialEquityUser.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialEquityUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialEquityUser.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SocialEquityUserWrapper((SocialEquityUser)_socialEquityUser.clone());
	}

	public int compareTo(
		com.liferay.portlet.social.model.SocialEquityUser socialEquityUser) {
		return _socialEquityUser.compareTo(socialEquityUser);
	}

	public int hashCode() {
		return _socialEquityUser.hashCode();
	}

	public com.liferay.portlet.social.model.SocialEquityUser toEscapedModel() {
		return new SocialEquityUserWrapper(_socialEquityUser.toEscapedModel());
	}

	public java.lang.String toString() {
		return _socialEquityUser.toString();
	}

	public java.lang.String toXmlString() {
		return _socialEquityUser.toXmlString();
	}

	public double getContributionEquity() {
		return _socialEquityUser.getContributionEquity();
	}

	public double getParticipationEquity() {
		return _socialEquityUser.getParticipationEquity();
	}

	public SocialEquityUser getWrappedSocialEquityUser() {
		return _socialEquityUser;
	}

	private SocialEquityUser _socialEquityUser;
}