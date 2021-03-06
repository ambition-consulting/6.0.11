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
 * This class is a wrapper for {@link AssetTag}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetTag
 * @generated
 */
public class AssetTagWrapper implements AssetTag {
	public AssetTagWrapper(AssetTag assetTag) {
		_assetTag = assetTag;
	}

	/**
	* Gets the primary key of this asset tag.
	*
	* @return the primary key of this asset tag
	*/
	public long getPrimaryKey() {
		return _assetTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this asset tag
	*
	* @param pk the primary key of this asset tag
	*/
	public void setPrimaryKey(long pk) {
		_assetTag.setPrimaryKey(pk);
	}

	/**
	* Gets the tag id of this asset tag.
	*
	* @return the tag id of this asset tag
	*/
	public long getTagId() {
		return _assetTag.getTagId();
	}

	/**
	* Sets the tag id of this asset tag.
	*
	* @param tagId the tag id of this asset tag
	*/
	public void setTagId(long tagId) {
		_assetTag.setTagId(tagId);
	}

	/**
	* Gets the group id of this asset tag.
	*
	* @return the group id of this asset tag
	*/
	public long getGroupId() {
		return _assetTag.getGroupId();
	}

	/**
	* Sets the group id of this asset tag.
	*
	* @param groupId the group id of this asset tag
	*/
	public void setGroupId(long groupId) {
		_assetTag.setGroupId(groupId);
	}

	/**
	* Gets the company id of this asset tag.
	*
	* @return the company id of this asset tag
	*/
	public long getCompanyId() {
		return _assetTag.getCompanyId();
	}

	/**
	* Sets the company id of this asset tag.
	*
	* @param companyId the company id of this asset tag
	*/
	public void setCompanyId(long companyId) {
		_assetTag.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this asset tag.
	*
	* @return the user id of this asset tag
	*/
	public long getUserId() {
		return _assetTag.getUserId();
	}

	/**
	* Sets the user id of this asset tag.
	*
	* @param userId the user id of this asset tag
	*/
	public void setUserId(long userId) {
		_assetTag.setUserId(userId);
	}

	/**
	* Gets the user uuid of this asset tag.
	*
	* @return the user uuid of this asset tag
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetTag.getUserUuid();
	}

	/**
	* Sets the user uuid of this asset tag.
	*
	* @param userUuid the user uuid of this asset tag
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_assetTag.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this asset tag.
	*
	* @return the user name of this asset tag
	*/
	public java.lang.String getUserName() {
		return _assetTag.getUserName();
	}

	/**
	* Sets the user name of this asset tag.
	*
	* @param userName the user name of this asset tag
	*/
	public void setUserName(java.lang.String userName) {
		_assetTag.setUserName(userName);
	}

	/**
	* Gets the create date of this asset tag.
	*
	* @return the create date of this asset tag
	*/
	public java.util.Date getCreateDate() {
		return _assetTag.getCreateDate();
	}

	/**
	* Sets the create date of this asset tag.
	*
	* @param createDate the create date of this asset tag
	*/
	public void setCreateDate(java.util.Date createDate) {
		_assetTag.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this asset tag.
	*
	* @return the modified date of this asset tag
	*/
	public java.util.Date getModifiedDate() {
		return _assetTag.getModifiedDate();
	}

	/**
	* Sets the modified date of this asset tag.
	*
	* @param modifiedDate the modified date of this asset tag
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assetTag.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the name of this asset tag.
	*
	* @return the name of this asset tag
	*/
	public java.lang.String getName() {
		return _assetTag.getName();
	}

	/**
	* Sets the name of this asset tag.
	*
	* @param name the name of this asset tag
	*/
	public void setName(java.lang.String name) {
		_assetTag.setName(name);
	}

	/**
	* Gets the asset count of this asset tag.
	*
	* @return the asset count of this asset tag
	*/
	public int getAssetCount() {
		return _assetTag.getAssetCount();
	}

	/**
	* Sets the asset count of this asset tag.
	*
	* @param assetCount the asset count of this asset tag
	*/
	public void setAssetCount(int assetCount) {
		_assetTag.setAssetCount(assetCount);
	}

	public boolean isNew() {
		return _assetTag.isNew();
	}

	public void setNew(boolean n) {
		_assetTag.setNew(n);
	}

	public boolean isCachedModel() {
		return _assetTag.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_assetTag.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _assetTag.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_assetTag.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _assetTag.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetTag.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetTag.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AssetTagWrapper((AssetTag)_assetTag.clone());
	}

	public int compareTo(com.liferay.portlet.asset.model.AssetTag assetTag) {
		return _assetTag.compareTo(assetTag);
	}

	public int hashCode() {
		return _assetTag.hashCode();
	}

	public com.liferay.portlet.asset.model.AssetTag toEscapedModel() {
		return new AssetTagWrapper(_assetTag.toEscapedModel());
	}

	public java.lang.String toString() {
		return _assetTag.toString();
	}

	public java.lang.String toXmlString() {
		return _assetTag.toXmlString();
	}

	public AssetTag getWrappedAssetTag() {
		return _assetTag;
	}

	private AssetTag _assetTag;
}