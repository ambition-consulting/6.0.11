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

package com.liferay.portlet.asset.model;

/**
 * <p>
 * This class is a wrapper for {@link AssetLink}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetLink
 * @generated
 */
public class AssetLinkWrapper implements AssetLink {
	public AssetLinkWrapper(AssetLink assetLink) {
		_assetLink = assetLink;
	}

	/**
	* Gets the primary key of this asset link.
	*
	* @return the primary key of this asset link
	*/
	public long getPrimaryKey() {
		return _assetLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this asset link
	*
	* @param pk the primary key of this asset link
	*/
	public void setPrimaryKey(long pk) {
		_assetLink.setPrimaryKey(pk);
	}

	/**
	* Gets the link id of this asset link.
	*
	* @return the link id of this asset link
	*/
	public long getLinkId() {
		return _assetLink.getLinkId();
	}

	/**
	* Sets the link id of this asset link.
	*
	* @param linkId the link id of this asset link
	*/
	public void setLinkId(long linkId) {
		_assetLink.setLinkId(linkId);
	}

	/**
	* Gets the company id of this asset link.
	*
	* @return the company id of this asset link
	*/
	public long getCompanyId() {
		return _assetLink.getCompanyId();
	}

	/**
	* Sets the company id of this asset link.
	*
	* @param companyId the company id of this asset link
	*/
	public void setCompanyId(long companyId) {
		_assetLink.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this asset link.
	*
	* @return the user id of this asset link
	*/
	public long getUserId() {
		return _assetLink.getUserId();
	}

	/**
	* Sets the user id of this asset link.
	*
	* @param userId the user id of this asset link
	*/
	public void setUserId(long userId) {
		_assetLink.setUserId(userId);
	}

	/**
	* Gets the user uuid of this asset link.
	*
	* @return the user uuid of this asset link
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetLink.getUserUuid();
	}

	/**
	* Sets the user uuid of this asset link.
	*
	* @param userUuid the user uuid of this asset link
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_assetLink.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this asset link.
	*
	* @return the user name of this asset link
	*/
	public java.lang.String getUserName() {
		return _assetLink.getUserName();
	}

	/**
	* Sets the user name of this asset link.
	*
	* @param userName the user name of this asset link
	*/
	public void setUserName(java.lang.String userName) {
		_assetLink.setUserName(userName);
	}

	/**
	* Gets the create date of this asset link.
	*
	* @return the create date of this asset link
	*/
	public java.util.Date getCreateDate() {
		return _assetLink.getCreateDate();
	}

	/**
	* Sets the create date of this asset link.
	*
	* @param createDate the create date of this asset link
	*/
	public void setCreateDate(java.util.Date createDate) {
		_assetLink.setCreateDate(createDate);
	}

	/**
	* Gets the entry id1 of this asset link.
	*
	* @return the entry id1 of this asset link
	*/
	public long getEntryId1() {
		return _assetLink.getEntryId1();
	}

	/**
	* Sets the entry id1 of this asset link.
	*
	* @param entryId1 the entry id1 of this asset link
	*/
	public void setEntryId1(long entryId1) {
		_assetLink.setEntryId1(entryId1);
	}

	/**
	* Gets the entry id2 of this asset link.
	*
	* @return the entry id2 of this asset link
	*/
	public long getEntryId2() {
		return _assetLink.getEntryId2();
	}

	/**
	* Sets the entry id2 of this asset link.
	*
	* @param entryId2 the entry id2 of this asset link
	*/
	public void setEntryId2(long entryId2) {
		_assetLink.setEntryId2(entryId2);
	}

	/**
	* Gets the type of this asset link.
	*
	* @return the type of this asset link
	*/
	public int getType() {
		return _assetLink.getType();
	}

	/**
	* Sets the type of this asset link.
	*
	* @param type the type of this asset link
	*/
	public void setType(int type) {
		_assetLink.setType(type);
	}

	/**
	* Gets the weight of this asset link.
	*
	* @return the weight of this asset link
	*/
	public int getWeight() {
		return _assetLink.getWeight();
	}

	/**
	* Sets the weight of this asset link.
	*
	* @param weight the weight of this asset link
	*/
	public void setWeight(int weight) {
		_assetLink.setWeight(weight);
	}

	public boolean isNew() {
		return _assetLink.isNew();
	}

	public void setNew(boolean n) {
		_assetLink.setNew(n);
	}

	public boolean isCachedModel() {
		return _assetLink.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_assetLink.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _assetLink.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_assetLink.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _assetLink.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetLink.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetLink.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AssetLinkWrapper((AssetLink)_assetLink.clone());
	}

	public int compareTo(com.liferay.portlet.asset.model.AssetLink assetLink) {
		return _assetLink.compareTo(assetLink);
	}

	public int hashCode() {
		return _assetLink.hashCode();
	}

	public com.liferay.portlet.asset.model.AssetLink toEscapedModel() {
		return new AssetLinkWrapper(_assetLink.toEscapedModel());
	}

	public java.lang.String toString() {
		return _assetLink.toString();
	}

	public java.lang.String toXmlString() {
		return _assetLink.toXmlString();
	}

	public AssetLink getWrappedAssetLink() {
		return _assetLink;
	}

	private AssetLink _assetLink;
}