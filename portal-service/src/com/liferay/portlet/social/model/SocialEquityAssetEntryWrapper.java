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
 * This class is a wrapper for {@link SocialEquityAssetEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialEquityAssetEntry
 * @generated
 */
public class SocialEquityAssetEntryWrapper implements SocialEquityAssetEntry {
	public SocialEquityAssetEntryWrapper(
		SocialEquityAssetEntry socialEquityAssetEntry) {
		_socialEquityAssetEntry = socialEquityAssetEntry;
	}

	/**
	* Gets the primary key of this social equity asset entry.
	*
	* @return the primary key of this social equity asset entry
	*/
	public long getPrimaryKey() {
		return _socialEquityAssetEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social equity asset entry
	*
	* @param pk the primary key of this social equity asset entry
	*/
	public void setPrimaryKey(long pk) {
		_socialEquityAssetEntry.setPrimaryKey(pk);
	}

	/**
	* Gets the equity asset entry id of this social equity asset entry.
	*
	* @return the equity asset entry id of this social equity asset entry
	*/
	public long getEquityAssetEntryId() {
		return _socialEquityAssetEntry.getEquityAssetEntryId();
	}

	/**
	* Sets the equity asset entry id of this social equity asset entry.
	*
	* @param equityAssetEntryId the equity asset entry id of this social equity asset entry
	*/
	public void setEquityAssetEntryId(long equityAssetEntryId) {
		_socialEquityAssetEntry.setEquityAssetEntryId(equityAssetEntryId);
	}

	/**
	* Gets the group id of this social equity asset entry.
	*
	* @return the group id of this social equity asset entry
	*/
	public long getGroupId() {
		return _socialEquityAssetEntry.getGroupId();
	}

	/**
	* Sets the group id of this social equity asset entry.
	*
	* @param groupId the group id of this social equity asset entry
	*/
	public void setGroupId(long groupId) {
		_socialEquityAssetEntry.setGroupId(groupId);
	}

	/**
	* Gets the company id of this social equity asset entry.
	*
	* @return the company id of this social equity asset entry
	*/
	public long getCompanyId() {
		return _socialEquityAssetEntry.getCompanyId();
	}

	/**
	* Sets the company id of this social equity asset entry.
	*
	* @param companyId the company id of this social equity asset entry
	*/
	public void setCompanyId(long companyId) {
		_socialEquityAssetEntry.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this social equity asset entry.
	*
	* @return the user id of this social equity asset entry
	*/
	public long getUserId() {
		return _socialEquityAssetEntry.getUserId();
	}

	/**
	* Sets the user id of this social equity asset entry.
	*
	* @param userId the user id of this social equity asset entry
	*/
	public void setUserId(long userId) {
		_socialEquityAssetEntry.setUserId(userId);
	}

	/**
	* Gets the user uuid of this social equity asset entry.
	*
	* @return the user uuid of this social equity asset entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialEquityAssetEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this social equity asset entry.
	*
	* @param userUuid the user uuid of this social equity asset entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_socialEquityAssetEntry.setUserUuid(userUuid);
	}

	/**
	* Gets the asset entry id of this social equity asset entry.
	*
	* @return the asset entry id of this social equity asset entry
	*/
	public long getAssetEntryId() {
		return _socialEquityAssetEntry.getAssetEntryId();
	}

	/**
	* Sets the asset entry id of this social equity asset entry.
	*
	* @param assetEntryId the asset entry id of this social equity asset entry
	*/
	public void setAssetEntryId(long assetEntryId) {
		_socialEquityAssetEntry.setAssetEntryId(assetEntryId);
	}

	/**
	* Gets the information k of this social equity asset entry.
	*
	* @return the information k of this social equity asset entry
	*/
	public double getInformationK() {
		return _socialEquityAssetEntry.getInformationK();
	}

	/**
	* Sets the information k of this social equity asset entry.
	*
	* @param informationK the information k of this social equity asset entry
	*/
	public void setInformationK(double informationK) {
		_socialEquityAssetEntry.setInformationK(informationK);
	}

	/**
	* Gets the information b of this social equity asset entry.
	*
	* @return the information b of this social equity asset entry
	*/
	public double getInformationB() {
		return _socialEquityAssetEntry.getInformationB();
	}

	/**
	* Sets the information b of this social equity asset entry.
	*
	* @param informationB the information b of this social equity asset entry
	*/
	public void setInformationB(double informationB) {
		_socialEquityAssetEntry.setInformationB(informationB);
	}

	public boolean isNew() {
		return _socialEquityAssetEntry.isNew();
	}

	public void setNew(boolean n) {
		_socialEquityAssetEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _socialEquityAssetEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_socialEquityAssetEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _socialEquityAssetEntry.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_socialEquityAssetEntry.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _socialEquityAssetEntry.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialEquityAssetEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialEquityAssetEntry.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SocialEquityAssetEntryWrapper((SocialEquityAssetEntry)_socialEquityAssetEntry.clone());
	}

	public int compareTo(
		com.liferay.portlet.social.model.SocialEquityAssetEntry socialEquityAssetEntry) {
		return _socialEquityAssetEntry.compareTo(socialEquityAssetEntry);
	}

	public int hashCode() {
		return _socialEquityAssetEntry.hashCode();
	}

	public com.liferay.portlet.social.model.SocialEquityAssetEntry toEscapedModel() {
		return new SocialEquityAssetEntryWrapper(_socialEquityAssetEntry.toEscapedModel());
	}

	public java.lang.String toString() {
		return _socialEquityAssetEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _socialEquityAssetEntry.toXmlString();
	}

	public SocialEquityAssetEntry getWrappedSocialEquityAssetEntry() {
		return _socialEquityAssetEntry;
	}

	private SocialEquityAssetEntry _socialEquityAssetEntry;
}