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

package com.liferay.portlet.polls.model;

/**
 * <p>
 * This class is a wrapper for {@link PollsChoice}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PollsChoice
 * @generated
 */
public class PollsChoiceWrapper implements PollsChoice {
	public PollsChoiceWrapper(PollsChoice pollsChoice) {
		_pollsChoice = pollsChoice;
	}

	/**
	* Gets the primary key of this polls choice.
	*
	* @return the primary key of this polls choice
	*/
	public long getPrimaryKey() {
		return _pollsChoice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this polls choice
	*
	* @param pk the primary key of this polls choice
	*/
	public void setPrimaryKey(long pk) {
		_pollsChoice.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this polls choice.
	*
	* @return the uuid of this polls choice
	*/
	public java.lang.String getUuid() {
		return _pollsChoice.getUuid();
	}

	/**
	* Sets the uuid of this polls choice.
	*
	* @param uuid the uuid of this polls choice
	*/
	public void setUuid(java.lang.String uuid) {
		_pollsChoice.setUuid(uuid);
	}

	/**
	* Gets the choice id of this polls choice.
	*
	* @return the choice id of this polls choice
	*/
	public long getChoiceId() {
		return _pollsChoice.getChoiceId();
	}

	/**
	* Sets the choice id of this polls choice.
	*
	* @param choiceId the choice id of this polls choice
	*/
	public void setChoiceId(long choiceId) {
		_pollsChoice.setChoiceId(choiceId);
	}

	/**
	* Gets the question id of this polls choice.
	*
	* @return the question id of this polls choice
	*/
	public long getQuestionId() {
		return _pollsChoice.getQuestionId();
	}

	/**
	* Sets the question id of this polls choice.
	*
	* @param questionId the question id of this polls choice
	*/
	public void setQuestionId(long questionId) {
		_pollsChoice.setQuestionId(questionId);
	}

	/**
	* Gets the name of this polls choice.
	*
	* @return the name of this polls choice
	*/
	public java.lang.String getName() {
		return _pollsChoice.getName();
	}

	/**
	* Sets the name of this polls choice.
	*
	* @param name the name of this polls choice
	*/
	public void setName(java.lang.String name) {
		_pollsChoice.setName(name);
	}

	/**
	* Gets the description of this polls choice.
	*
	* @return the description of this polls choice
	*/
	public java.lang.String getDescription() {
		return _pollsChoice.getDescription();
	}

	/**
	* Gets the localized description of this polls choice. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale to get the localized description for
	* @return the localized description of this polls choice
	*/
	public java.lang.String getDescription(java.util.Locale locale) {
		return _pollsChoice.getDescription(locale);
	}

	/**
	* Gets the localized description of this polls choice, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local to get the localized description for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this polls choice. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _pollsChoice.getDescription(locale, useDefault);
	}

	/**
	* Gets the localized description of this polls choice. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized description for
	* @return the localized description of this polls choice
	*/
	public java.lang.String getDescription(java.lang.String languageId) {
		return _pollsChoice.getDescription(languageId);
	}

	/**
	* Gets the localized description of this polls choice, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the id of the language to get the localized description for
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this polls choice
	*/
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _pollsChoice.getDescription(languageId, useDefault);
	}

	/**
	* Gets a map of the locales and localized description of this polls choice.
	*
	* @return the locales and localized description
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _pollsChoice.getDescriptionMap();
	}

	/**
	* Sets the description of this polls choice.
	*
	* @param description the description of this polls choice
	*/
	public void setDescription(java.lang.String description) {
		_pollsChoice.setDescription(description);
	}

	/**
	* Sets the localized description of this polls choice.
	*
	* @param locale the locale to set the localized description for
	* @param description the localized description of this polls choice
	*/
	public void setDescription(java.util.Locale locale,
		java.lang.String description) {
		_pollsChoice.setDescription(locale, description);
	}

	/**
	* Sets the localized descriptions of this polls choice from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this polls choice
	*/
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_pollsChoice.setDescriptionMap(descriptionMap);
	}

	public boolean isNew() {
		return _pollsChoice.isNew();
	}

	public void setNew(boolean n) {
		_pollsChoice.setNew(n);
	}

	public boolean isCachedModel() {
		return _pollsChoice.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pollsChoice.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pollsChoice.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_pollsChoice.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pollsChoice.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pollsChoice.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pollsChoice.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new PollsChoiceWrapper((PollsChoice)_pollsChoice.clone());
	}

	public int compareTo(
		com.liferay.portlet.polls.model.PollsChoice pollsChoice) {
		return _pollsChoice.compareTo(pollsChoice);
	}

	public int hashCode() {
		return _pollsChoice.hashCode();
	}

	public com.liferay.portlet.polls.model.PollsChoice toEscapedModel() {
		return new PollsChoiceWrapper(_pollsChoice.toEscapedModel());
	}

	public java.lang.String toString() {
		return _pollsChoice.toString();
	}

	public java.lang.String toXmlString() {
		return _pollsChoice.toXmlString();
	}

	public int getVotesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsChoice.getVotesCount();
	}

	public PollsChoice getWrappedPollsChoice() {
		return _pollsChoice;
	}

	private PollsChoice _pollsChoice;
}