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
 * This class is a wrapper for {@link AssetTagProperty}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetTagProperty
 * @generated
 */
public class AssetTagPropertyWrapper implements AssetTagProperty {
	public AssetTagPropertyWrapper(AssetTagProperty assetTagProperty) {
		_assetTagProperty = assetTagProperty;
	}

	/**
	* Gets the primary key of this asset tag property.
	*
	* @return the primary key of this asset tag property
	*/
	public long getPrimaryKey() {
		return _assetTagProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this asset tag property
	*
	* @param pk the primary key of this asset tag property
	*/
	public void setPrimaryKey(long pk) {
		_assetTagProperty.setPrimaryKey(pk);
	}

	/**
	* Gets the tag property id of this asset tag property.
	*
	* @return the tag property id of this asset tag property
	*/
	public long getTagPropertyId() {
		return _assetTagProperty.getTagPropertyId();
	}

	/**
	* Sets the tag property id of this asset tag property.
	*
	* @param tagPropertyId the tag property id of this asset tag property
	*/
	public void setTagPropertyId(long tagPropertyId) {
		_assetTagProperty.setTagPropertyId(tagPropertyId);
	}

	/**
	* Gets the company id of this asset tag property.
	*
	* @return the company id of this asset tag property
	*/
	public long getCompanyId() {
		return _assetTagProperty.getCompanyId();
	}

	/**
	* Sets the company id of this asset tag property.
	*
	* @param companyId the company id of this asset tag property
	*/
	public void setCompanyId(long companyId) {
		_assetTagProperty.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this asset tag property.
	*
	* @return the user id of this asset tag property
	*/
	public long getUserId() {
		return _assetTagProperty.getUserId();
	}

	/**
	* Sets the user id of this asset tag property.
	*
	* @param userId the user id of this asset tag property
	*/
	public void setUserId(long userId) {
		_assetTagProperty.setUserId(userId);
	}

	/**
	* Gets the user uuid of this asset tag property.
	*
	* @return the user uuid of this asset tag property
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetTagProperty.getUserUuid();
	}

	/**
	* Sets the user uuid of this asset tag property.
	*
	* @param userUuid the user uuid of this asset tag property
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_assetTagProperty.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this asset tag property.
	*
	* @return the user name of this asset tag property
	*/
	public java.lang.String getUserName() {
		return _assetTagProperty.getUserName();
	}

	/**
	* Sets the user name of this asset tag property.
	*
	* @param userName the user name of this asset tag property
	*/
	public void setUserName(java.lang.String userName) {
		_assetTagProperty.setUserName(userName);
	}

	/**
	* Gets the create date of this asset tag property.
	*
	* @return the create date of this asset tag property
	*/
	public java.util.Date getCreateDate() {
		return _assetTagProperty.getCreateDate();
	}

	/**
	* Sets the create date of this asset tag property.
	*
	* @param createDate the create date of this asset tag property
	*/
	public void setCreateDate(java.util.Date createDate) {
		_assetTagProperty.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this asset tag property.
	*
	* @return the modified date of this asset tag property
	*/
	public java.util.Date getModifiedDate() {
		return _assetTagProperty.getModifiedDate();
	}

	/**
	* Sets the modified date of this asset tag property.
	*
	* @param modifiedDate the modified date of this asset tag property
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assetTagProperty.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the tag id of this asset tag property.
	*
	* @return the tag id of this asset tag property
	*/
	public long getTagId() {
		return _assetTagProperty.getTagId();
	}

	/**
	* Sets the tag id of this asset tag property.
	*
	* @param tagId the tag id of this asset tag property
	*/
	public void setTagId(long tagId) {
		_assetTagProperty.setTagId(tagId);
	}

	/**
	* Gets the key of this asset tag property.
	*
	* @return the key of this asset tag property
	*/
	public java.lang.String getKey() {
		return _assetTagProperty.getKey();
	}

	/**
	* Sets the key of this asset tag property.
	*
	* @param key the key of this asset tag property
	*/
	public void setKey(java.lang.String key) {
		_assetTagProperty.setKey(key);
	}

	/**
	* Gets the value of this asset tag property.
	*
	* @return the value of this asset tag property
	*/
	public java.lang.String getValue() {
		return _assetTagProperty.getValue();
	}

	/**
	* Sets the value of this asset tag property.
	*
	* @param value the value of this asset tag property
	*/
	public void setValue(java.lang.String value) {
		_assetTagProperty.setValue(value);
	}

	public boolean isNew() {
		return _assetTagProperty.isNew();
	}

	public void setNew(boolean n) {
		_assetTagProperty.setNew(n);
	}

	public boolean isCachedModel() {
		return _assetTagProperty.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_assetTagProperty.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _assetTagProperty.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_assetTagProperty.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _assetTagProperty.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetTagProperty.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetTagProperty.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AssetTagPropertyWrapper((AssetTagProperty)_assetTagProperty.clone());
	}

	public int compareTo(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty) {
		return _assetTagProperty.compareTo(assetTagProperty);
	}

	public int hashCode() {
		return _assetTagProperty.hashCode();
	}

	public com.liferay.portlet.asset.model.AssetTagProperty toEscapedModel() {
		return new AssetTagPropertyWrapper(_assetTagProperty.toEscapedModel());
	}

	public java.lang.String toString() {
		return _assetTagProperty.toString();
	}

	public java.lang.String toXmlString() {
		return _assetTagProperty.toXmlString();
	}

	public AssetTagProperty getWrappedAssetTagProperty() {
		return _assetTagProperty;
	}

	private AssetTagProperty _assetTagProperty;
}