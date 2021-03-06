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
 * This class is a wrapper for {@link AnnouncementsDelivery}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AnnouncementsDelivery
 * @generated
 */
public class AnnouncementsDeliveryWrapper implements AnnouncementsDelivery {
	public AnnouncementsDeliveryWrapper(
		AnnouncementsDelivery announcementsDelivery) {
		_announcementsDelivery = announcementsDelivery;
	}

	/**
	* Gets the primary key of this announcements delivery.
	*
	* @return the primary key of this announcements delivery
	*/
	public long getPrimaryKey() {
		return _announcementsDelivery.getPrimaryKey();
	}

	/**
	* Sets the primary key of this announcements delivery
	*
	* @param pk the primary key of this announcements delivery
	*/
	public void setPrimaryKey(long pk) {
		_announcementsDelivery.setPrimaryKey(pk);
	}

	/**
	* Gets the delivery id of this announcements delivery.
	*
	* @return the delivery id of this announcements delivery
	*/
	public long getDeliveryId() {
		return _announcementsDelivery.getDeliveryId();
	}

	/**
	* Sets the delivery id of this announcements delivery.
	*
	* @param deliveryId the delivery id of this announcements delivery
	*/
	public void setDeliveryId(long deliveryId) {
		_announcementsDelivery.setDeliveryId(deliveryId);
	}

	/**
	* Gets the company id of this announcements delivery.
	*
	* @return the company id of this announcements delivery
	*/
	public long getCompanyId() {
		return _announcementsDelivery.getCompanyId();
	}

	/**
	* Sets the company id of this announcements delivery.
	*
	* @param companyId the company id of this announcements delivery
	*/
	public void setCompanyId(long companyId) {
		_announcementsDelivery.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this announcements delivery.
	*
	* @return the user id of this announcements delivery
	*/
	public long getUserId() {
		return _announcementsDelivery.getUserId();
	}

	/**
	* Sets the user id of this announcements delivery.
	*
	* @param userId the user id of this announcements delivery
	*/
	public void setUserId(long userId) {
		_announcementsDelivery.setUserId(userId);
	}

	/**
	* Gets the user uuid of this announcements delivery.
	*
	* @return the user uuid of this announcements delivery
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsDelivery.getUserUuid();
	}

	/**
	* Sets the user uuid of this announcements delivery.
	*
	* @param userUuid the user uuid of this announcements delivery
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_announcementsDelivery.setUserUuid(userUuid);
	}

	/**
	* Gets the type of this announcements delivery.
	*
	* @return the type of this announcements delivery
	*/
	public java.lang.String getType() {
		return _announcementsDelivery.getType();
	}

	/**
	* Sets the type of this announcements delivery.
	*
	* @param type the type of this announcements delivery
	*/
	public void setType(java.lang.String type) {
		_announcementsDelivery.setType(type);
	}

	/**
	* Gets the email of this announcements delivery.
	*
	* @return the email of this announcements delivery
	*/
	public boolean getEmail() {
		return _announcementsDelivery.getEmail();
	}

	/**
	* Determines if this announcements delivery is email.
	*
	* @return <code>true</code> if this announcements delivery is email; <code>false</code> otherwise
	*/
	public boolean isEmail() {
		return _announcementsDelivery.isEmail();
	}

	/**
	* Sets whether this announcements delivery is email.
	*
	* @param email the email of this announcements delivery
	*/
	public void setEmail(boolean email) {
		_announcementsDelivery.setEmail(email);
	}

	/**
	* Gets the sms of this announcements delivery.
	*
	* @return the sms of this announcements delivery
	*/
	public boolean getSms() {
		return _announcementsDelivery.getSms();
	}

	/**
	* Determines if this announcements delivery is sms.
	*
	* @return <code>true</code> if this announcements delivery is sms; <code>false</code> otherwise
	*/
	public boolean isSms() {
		return _announcementsDelivery.isSms();
	}

	/**
	* Sets whether this announcements delivery is sms.
	*
	* @param sms the sms of this announcements delivery
	*/
	public void setSms(boolean sms) {
		_announcementsDelivery.setSms(sms);
	}

	/**
	* Gets the website of this announcements delivery.
	*
	* @return the website of this announcements delivery
	*/
	public boolean getWebsite() {
		return _announcementsDelivery.getWebsite();
	}

	/**
	* Determines if this announcements delivery is website.
	*
	* @return <code>true</code> if this announcements delivery is website; <code>false</code> otherwise
	*/
	public boolean isWebsite() {
		return _announcementsDelivery.isWebsite();
	}

	/**
	* Sets whether this announcements delivery is website.
	*
	* @param website the website of this announcements delivery
	*/
	public void setWebsite(boolean website) {
		_announcementsDelivery.setWebsite(website);
	}

	public boolean isNew() {
		return _announcementsDelivery.isNew();
	}

	public void setNew(boolean n) {
		_announcementsDelivery.setNew(n);
	}

	public boolean isCachedModel() {
		return _announcementsDelivery.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_announcementsDelivery.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _announcementsDelivery.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_announcementsDelivery.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _announcementsDelivery.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _announcementsDelivery.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_announcementsDelivery.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AnnouncementsDeliveryWrapper((AnnouncementsDelivery)_announcementsDelivery.clone());
	}

	public int compareTo(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery) {
		return _announcementsDelivery.compareTo(announcementsDelivery);
	}

	public int hashCode() {
		return _announcementsDelivery.hashCode();
	}

	public com.liferay.portlet.announcements.model.AnnouncementsDelivery toEscapedModel() {
		return new AnnouncementsDeliveryWrapper(_announcementsDelivery.toEscapedModel());
	}

	public java.lang.String toString() {
		return _announcementsDelivery.toString();
	}

	public java.lang.String toXmlString() {
		return _announcementsDelivery.toXmlString();
	}

	public AnnouncementsDelivery getWrappedAnnouncementsDelivery() {
		return _announcementsDelivery;
	}

	private AnnouncementsDelivery _announcementsDelivery;
}