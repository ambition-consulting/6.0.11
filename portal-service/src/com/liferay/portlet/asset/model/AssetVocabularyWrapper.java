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
 * This class is a wrapper for {@link AssetVocabulary}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetVocabulary
 * @generated
 */
public class AssetVocabularyWrapper implements AssetVocabulary {
	public AssetVocabularyWrapper(AssetVocabulary assetVocabulary) {
		_assetVocabulary = assetVocabulary;
	}

	/**
	* Gets the primary key of this asset vocabulary.
	*
	* @return the primary key of this asset vocabulary
	*/
	public long getPrimaryKey() {
		return _assetVocabulary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this asset vocabulary
	*
	* @param pk the primary key of this asset vocabulary
	*/
	public void setPrimaryKey(long pk) {
		_assetVocabulary.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this asset vocabulary.
	*
	* @return the uuid of this asset vocabulary
	*/
	public java.lang.String getUuid() {
		return _assetVocabulary.getUuid();
	}

	/**
	* Sets the uuid of this asset vocabulary.
	*
	* @param uuid the uuid of this asset vocabulary
	*/
	public void setUuid(java.lang.String uuid) {
		_assetVocabulary.setUuid(uuid);
	}

	/**
	* Gets the vocabulary id of this asset vocabulary.
	*
	* @return the vocabulary id of this asset vocabulary
	*/
	public long getVocabularyId() {
		return _assetVocabulary.getVocabularyId();
	}

	/**
	* Sets the vocabulary id of this asset vocabulary.
	*
	* @param vocabularyId the vocabulary id of this asset vocabulary
	*/
	public void setVocabularyId(long vocabularyId) {
		_assetVocabulary.setVocabularyId(vocabularyId);
	}

	/**
	* Gets the group id of this asset vocabulary.
	*
	* @return the group id of this asset vocabulary
	*/
	public long getGroupId() {
		return _assetVocabulary.getGroupId();
	}

	/**
	* Sets the group id of this asset vocabulary.
	*
	* @param groupId the group id of this asset vocabulary
	*/
	public void setGroupId(long groupId) {
		_assetVocabulary.setGroupId(groupId);
	}

	/**
	* Gets the company id of this asset vocabulary.
	*
	* @return the company id of this asset vocabulary
	*/
	public long getCompanyId() {
		return _assetVocabulary.getCompanyId();
	}

	/**
	* Sets the company id of this asset vocabulary.
	*
	* @param companyId the company id of this asset vocabulary
	*/
	public void setCompanyId(long companyId) {
		_assetVocabulary.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this asset vocabulary.
	*
	* @return the user id of this asset vocabulary
	*/
	public long getUserId() {
		return _assetVocabulary.getUserId();
	}

	/**
	* Sets the user id of this asset vocabulary.
	*
	* @param userId the user id of this asset vocabulary
	*/
	public void setUserId(long userId) {
		_assetVocabulary.setUserId(userId);
	}

	/**
	* Gets the user uuid of this asset vocabulary.
	*
	* @return the user uuid of this asset vocabulary
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabulary.getUserUuid();
	}

	/**
	* Sets the user uuid of this asset vocabulary.
	*
	* @param userUuid the user uuid of this asset vocabulary
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_assetVocabulary.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this asset vocabulary.
	*
	* @return the user name of this asset vocabulary
	*/
	public java.lang.String getUserName() {
		return _assetVocabulary.getUserName();
	}

	/**
	* Sets the user name of this asset vocabulary.
	*
	* @param userName the user name of this asset vocabulary
	*/
	public void setUserName(java.lang.String userName) {
		_assetVocabulary.setUserName(userName);
	}

	/**
	* Gets the create date of this asset vocabulary.
	*
	* @return the create date of this asset vocabulary
	*/
	public java.util.Date getCreateDate() {
		return _assetVocabulary.getCreateDate();
	}

	/**
	* Sets the create date of this asset vocabulary.
	*
	* @param createDate the create date of this asset vocabulary
	*/
	public void setCreateDate(java.util.Date createDate) {
		_assetVocabulary.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this asset vocabulary.
	*
	* @return the modified date of this asset vocabulary
	*/
	public java.util.Date getModifiedDate() {
		return _assetVocabulary.getModifiedDate();
	}

	/**
	* Sets the modified date of this asset vocabulary.
	*
	* @param modifiedDate the modified date of this asset vocabulary
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assetVocabulary.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the name of this asset vocabulary.
	*
	* @return the name of this asset vocabulary
	*/
	public java.lang.String getName() {
		return _assetVocabulary.getName();
	}

	/**
	* Sets the name of this asset vocabulary.
	*
	* @param name the name of this asset vocabulary
	*/
	public void setName(java.lang.String name) {
		_assetVocabulary.setName(name);
	}

	/**
	* Gets the title of this asset vocabulary.
	*
	* @return the title of this asset vocabulary
	*/
	public java.lang.String getTitle() {
		return _assetVocabulary.getTitle();
	}

	/**
	* Gets the localized title of this asset vocabulary. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale to get the localized title for
	* @return the localized title of this asset vocabulary
	*/
	public java.lang.String getTitle(java.util.Locale locale) {
		return _assetVocabulary.getTitle(locale);
	}

	/**
	* Gets the localized title of this asset vocabulary, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local to get the localized title for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this asset vocabulary. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _assetVocabulary.getTitle(locale, useDefault);
	}

	/**
	* Gets the localized title of this asset vocabulary. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized title for
	* @return the localized title of this asset vocabulary
	*/
	public java.lang.String getTitle(java.lang.String languageId) {
		return _assetVocabulary.getTitle(languageId);
	}

	/**
	* Gets the localized title of this asset vocabulary, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized title for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this asset vocabulary
	*/
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _assetVocabulary.getTitle(languageId, useDefault);
	}

	/**
	* Gets a map of the locales and localized title of this asset vocabulary.
	*
	* @return the locales and localized title
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _assetVocabulary.getTitleMap();
	}

	/**
	* Sets the title of this asset vocabulary.
	*
	* @param title the title of this asset vocabulary
	*/
	public void setTitle(java.lang.String title) {
		_assetVocabulary.setTitle(title);
	}

	/**
	* Sets the localized title of this asset vocabulary.
	*
	* @param locale the locale to set the localized title for
	* @param title the localized title of this asset vocabulary
	*/
	public void setTitle(java.util.Locale locale, java.lang.String title) {
		_assetVocabulary.setTitle(locale, title);
	}

	/**
	* Sets the localized titles of this asset vocabulary from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this asset vocabulary
	*/
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_assetVocabulary.setTitleMap(titleMap);
	}

	/**
	* Gets the description of this asset vocabulary.
	*
	* @return the description of this asset vocabulary
	*/
	public java.lang.String getDescription() {
		return _assetVocabulary.getDescription();
	}

	/**
	* Gets the localized description of this asset vocabulary. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale to get the localized description for
	* @return the localized description of this asset vocabulary
	*/
	public java.lang.String getDescription(java.util.Locale locale) {
		return _assetVocabulary.getDescription(locale);
	}

	/**
	* Gets the localized description of this asset vocabulary, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local to get the localized description for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this asset vocabulary. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _assetVocabulary.getDescription(locale, useDefault);
	}

	/**
	* Gets the localized description of this asset vocabulary. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized description for
	* @return the localized description of this asset vocabulary
	*/
	public java.lang.String getDescription(java.lang.String languageId) {
		return _assetVocabulary.getDescription(languageId);
	}

	/**
	* Gets the localized description of this asset vocabulary, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized description for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this asset vocabulary
	*/
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _assetVocabulary.getDescription(languageId, useDefault);
	}

	/**
	* Gets a map of the locales and localized description of this asset vocabulary.
	*
	* @return the locales and localized description
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _assetVocabulary.getDescriptionMap();
	}

	/**
	* Sets the description of this asset vocabulary.
	*
	* @param description the description of this asset vocabulary
	*/
	public void setDescription(java.lang.String description) {
		_assetVocabulary.setDescription(description);
	}

	/**
	* Sets the localized description of this asset vocabulary.
	*
	* @param locale the locale to set the localized description for
	* @param description the localized description of this asset vocabulary
	*/
	public void setDescription(java.util.Locale locale,
		java.lang.String description) {
		_assetVocabulary.setDescription(locale, description);
	}

	/**
	* Sets the localized descriptions of this asset vocabulary from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this asset vocabulary
	*/
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_assetVocabulary.setDescriptionMap(descriptionMap);
	}

	/**
	* Gets the settings of this asset vocabulary.
	*
	* @return the settings of this asset vocabulary
	*/
	public java.lang.String getSettings() {
		return _assetVocabulary.getSettings();
	}

	/**
	* Sets the settings of this asset vocabulary.
	*
	* @param settings the settings of this asset vocabulary
	*/
	public void setSettings(java.lang.String settings) {
		_assetVocabulary.setSettings(settings);
	}

	public boolean isNew() {
		return _assetVocabulary.isNew();
	}

	public void setNew(boolean n) {
		_assetVocabulary.setNew(n);
	}

	public boolean isCachedModel() {
		return _assetVocabulary.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_assetVocabulary.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _assetVocabulary.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_assetVocabulary.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _assetVocabulary.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetVocabulary.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetVocabulary.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new AssetVocabularyWrapper((AssetVocabulary)_assetVocabulary.clone());
	}

	public int compareTo(
		com.liferay.portlet.asset.model.AssetVocabulary assetVocabulary) {
		return _assetVocabulary.compareTo(assetVocabulary);
	}

	public int hashCode() {
		return _assetVocabulary.hashCode();
	}

	public com.liferay.portlet.asset.model.AssetVocabulary toEscapedModel() {
		return new AssetVocabularyWrapper(_assetVocabulary.toEscapedModel());
	}

	public java.lang.String toString() {
		return _assetVocabulary.toString();
	}

	public java.lang.String toXmlString() {
		return _assetVocabulary.toXmlString();
	}

	public AssetVocabulary getWrappedAssetVocabulary() {
		return _assetVocabulary;
	}

	private AssetVocabulary _assetVocabulary;
}