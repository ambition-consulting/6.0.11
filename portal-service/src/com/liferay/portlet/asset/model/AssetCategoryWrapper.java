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
 * This class is a wrapper for {@link AssetCategory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetCategory
 * @generated
 */
public class AssetCategoryWrapper implements AssetCategory {
	public AssetCategoryWrapper(AssetCategory assetCategory) {
		_assetCategory = assetCategory;
	}

	/**
	* Gets the primary key of this asset category.
	*
	* @return the primary key of this asset category
	*/
	public long getPrimaryKey() {
		return _assetCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this asset category
	*
	* @param pk the primary key of this asset category
	*/
	public void setPrimaryKey(long pk) {
		_assetCategory.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this asset category.
	*
	* @return the uuid of this asset category
	*/
	public java.lang.String getUuid() {
		return _assetCategory.getUuid();
	}

	/**
	* Sets the uuid of this asset category.
	*
	* @param uuid the uuid of this asset category
	*/
	public void setUuid(java.lang.String uuid) {
		_assetCategory.setUuid(uuid);
	}

	/**
	* Gets the category id of this asset category.
	*
	* @return the category id of this asset category
	*/
	public long getCategoryId() {
		return _assetCategory.getCategoryId();
	}

	/**
	* Sets the category id of this asset category.
	*
	* @param categoryId the category id of this asset category
	*/
	public void setCategoryId(long categoryId) {
		_assetCategory.setCategoryId(categoryId);
	}

	/**
	* Gets the group id of this asset category.
	*
	* @return the group id of this asset category
	*/
	public long getGroupId() {
		return _assetCategory.getGroupId();
	}

	/**
	* Sets the group id of this asset category.
	*
	* @param groupId the group id of this asset category
	*/
	public void setGroupId(long groupId) {
		_assetCategory.setGroupId(groupId);
	}

	/**
	* Gets the company id of this asset category.
	*
	* @return the company id of this asset category
	*/
	public long getCompanyId() {
		return _assetCategory.getCompanyId();
	}

	/**
	* Sets the company id of this asset category.
	*
	* @param companyId the company id of this asset category
	*/
	public void setCompanyId(long companyId) {
		_assetCategory.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this asset category.
	*
	* @return the user id of this asset category
	*/
	public long getUserId() {
		return _assetCategory.getUserId();
	}

	/**
	* Sets the user id of this asset category.
	*
	* @param userId the user id of this asset category
	*/
	public void setUserId(long userId) {
		_assetCategory.setUserId(userId);
	}

	/**
	* Gets the user uuid of this asset category.
	*
	* @return the user uuid of this asset category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this asset category.
	*
	* @param userUuid the user uuid of this asset category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_assetCategory.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this asset category.
	*
	* @return the user name of this asset category
	*/
	public java.lang.String getUserName() {
		return _assetCategory.getUserName();
	}

	/**
	* Sets the user name of this asset category.
	*
	* @param userName the user name of this asset category
	*/
	public void setUserName(java.lang.String userName) {
		_assetCategory.setUserName(userName);
	}

	/**
	* Gets the create date of this asset category.
	*
	* @return the create date of this asset category
	*/
	public java.util.Date getCreateDate() {
		return _assetCategory.getCreateDate();
	}

	/**
	* Sets the create date of this asset category.
	*
	* @param createDate the create date of this asset category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_assetCategory.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this asset category.
	*
	* @return the modified date of this asset category
	*/
	public java.util.Date getModifiedDate() {
		return _assetCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this asset category.
	*
	* @param modifiedDate the modified date of this asset category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assetCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the parent category id of this asset category.
	*
	* @return the parent category id of this asset category
	*/
	public long getParentCategoryId() {
		return _assetCategory.getParentCategoryId();
	}

	/**
	* Sets the parent category id of this asset category.
	*
	* @param parentCategoryId the parent category id of this asset category
	*/
	public void setParentCategoryId(long parentCategoryId) {
		_assetCategory.setParentCategoryId(parentCategoryId);
	}

	/**
	* Gets the left category id of this asset category.
	*
	* @return the left category id of this asset category
	*/
	public long getLeftCategoryId() {
		return _assetCategory.getLeftCategoryId();
	}

	/**
	* Sets the left category id of this asset category.
	*
	* @param leftCategoryId the left category id of this asset category
	*/
	public void setLeftCategoryId(long leftCategoryId) {
		_assetCategory.setLeftCategoryId(leftCategoryId);
	}

	/**
	* Gets the right category id of this asset category.
	*
	* @return the right category id of this asset category
	*/
	public long getRightCategoryId() {
		return _assetCategory.getRightCategoryId();
	}

	/**
	* Sets the right category id of this asset category.
	*
	* @param rightCategoryId the right category id of this asset category
	*/
	public void setRightCategoryId(long rightCategoryId) {
		_assetCategory.setRightCategoryId(rightCategoryId);
	}

	/**
	* Gets the name of this asset category.
	*
	* @return the name of this asset category
	*/
	public java.lang.String getName() {
		return _assetCategory.getName();
	}

	/**
	* Sets the name of this asset category.
	*
	* @param name the name of this asset category
	*/
	public void setName(java.lang.String name) {
		_assetCategory.setName(name);
	}

	/**
	* Gets the title of this asset category.
	*
	* @return the title of this asset category
	*/
	public java.lang.String getTitle() {
		return _assetCategory.getTitle();
	}

	/**
	* Gets the localized title of this asset category. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale to get the localized title for
	* @return the localized title of this asset category
	*/
	public java.lang.String getTitle(java.util.Locale locale) {
		return _assetCategory.getTitle(locale);
	}

	/**
	* Gets the localized title of this asset category, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local to get the localized title for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this asset category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _assetCategory.getTitle(locale, useDefault);
	}

	/**
	* Gets the localized title of this asset category. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized title for
	* @return the localized title of this asset category
	*/
	public java.lang.String getTitle(java.lang.String languageId) {
		return _assetCategory.getTitle(languageId);
	}

	/**
	* Gets the localized title of this asset category, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized title for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this asset category
	*/
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _assetCategory.getTitle(languageId, useDefault);
	}

	/**
	* Gets a map of the locales and localized title of this asset category.
	*
	* @return the locales and localized title
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _assetCategory.getTitleMap();
	}

	/**
	* Sets the title of this asset category.
	*
	* @param title the title of this asset category
	*/
	public void setTitle(java.lang.String title) {
		_assetCategory.setTitle(title);
	}

	/**
	* Sets the localized title of this asset category.
	*
	* @param locale the locale to set the localized title for
	* @param title the localized title of this asset category
	*/
	public void setTitle(java.util.Locale locale, java.lang.String title) {
		_assetCategory.setTitle(locale, title);
	}

	/**
	* Sets the localized titles of this asset category from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this asset category
	*/
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_assetCategory.setTitleMap(titleMap);
	}

	/**
	* Gets the vocabulary id of this asset category.
	*
	* @return the vocabulary id of this asset category
	*/
	public long getVocabularyId() {
		return _assetCategory.getVocabularyId();
	}

	/**
	* Sets the vocabulary id of this asset category.
	*
	* @param vocabularyId the vocabulary id of this asset category
	*/
	public void setVocabularyId(long vocabularyId) {
		_assetCategory.setVocabularyId(vocabularyId);
	}

	public boolean isNew() {
		return _assetCategory.isNew();
	}

	public void setNew(boolean n) {
		_assetCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _assetCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_assetCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _assetCategory.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_assetCategory.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _assetCategory.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetCategory.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AssetCategoryWrapper((AssetCategory)_assetCategory.clone());
	}

	public int compareTo(
		com.liferay.portlet.asset.model.AssetCategory assetCategory) {
		return _assetCategory.compareTo(assetCategory);
	}

	public int hashCode() {
		return _assetCategory.hashCode();
	}

	public com.liferay.portlet.asset.model.AssetCategory toEscapedModel() {
		return new AssetCategoryWrapper(_assetCategory.toEscapedModel());
	}

	public java.lang.String toString() {
		return _assetCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _assetCategory.toXmlString();
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategory.getAncestors();
	}

	public boolean isRootCategory() {
		return _assetCategory.isRootCategory();
	}

	public AssetCategory getWrappedAssetCategory() {
		return _assetCategory;
	}

	private AssetCategory _assetCategory;
}