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

package com.liferay.portlet.journal.model;

/**
 * <p>
 * This class is a wrapper for {@link JournalContentSearch}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JournalContentSearch
 * @generated
 */
public class JournalContentSearchWrapper implements JournalContentSearch {
	public JournalContentSearchWrapper(
		JournalContentSearch journalContentSearch) {
		_journalContentSearch = journalContentSearch;
	}

	/**
	* Gets the primary key of this journal content search.
	*
	* @return the primary key of this journal content search
	*/
	public long getPrimaryKey() {
		return _journalContentSearch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this journal content search
	*
	* @param pk the primary key of this journal content search
	*/
	public void setPrimaryKey(long pk) {
		_journalContentSearch.setPrimaryKey(pk);
	}

	/**
	* Gets the content search id of this journal content search.
	*
	* @return the content search id of this journal content search
	*/
	public long getContentSearchId() {
		return _journalContentSearch.getContentSearchId();
	}

	/**
	* Sets the content search id of this journal content search.
	*
	* @param contentSearchId the content search id of this journal content search
	*/
	public void setContentSearchId(long contentSearchId) {
		_journalContentSearch.setContentSearchId(contentSearchId);
	}

	/**
	* Gets the group id of this journal content search.
	*
	* @return the group id of this journal content search
	*/
	public long getGroupId() {
		return _journalContentSearch.getGroupId();
	}

	/**
	* Sets the group id of this journal content search.
	*
	* @param groupId the group id of this journal content search
	*/
	public void setGroupId(long groupId) {
		_journalContentSearch.setGroupId(groupId);
	}

	/**
	* Gets the company id of this journal content search.
	*
	* @return the company id of this journal content search
	*/
	public long getCompanyId() {
		return _journalContentSearch.getCompanyId();
	}

	/**
	* Sets the company id of this journal content search.
	*
	* @param companyId the company id of this journal content search
	*/
	public void setCompanyId(long companyId) {
		_journalContentSearch.setCompanyId(companyId);
	}

	/**
	* Gets the private layout of this journal content search.
	*
	* @return the private layout of this journal content search
	*/
	public boolean getPrivateLayout() {
		return _journalContentSearch.getPrivateLayout();
	}

	/**
	* Determines if this journal content search is private layout.
	*
	* @return <code>true</code> if this journal content search is private layout; <code>false</code> otherwise
	*/
	public boolean isPrivateLayout() {
		return _journalContentSearch.isPrivateLayout();
	}

	/**
	* Sets whether this journal content search is private layout.
	*
	* @param privateLayout the private layout of this journal content search
	*/
	public void setPrivateLayout(boolean privateLayout) {
		_journalContentSearch.setPrivateLayout(privateLayout);
	}

	/**
	* Gets the layout id of this journal content search.
	*
	* @return the layout id of this journal content search
	*/
	public long getLayoutId() {
		return _journalContentSearch.getLayoutId();
	}

	/**
	* Sets the layout id of this journal content search.
	*
	* @param layoutId the layout id of this journal content search
	*/
	public void setLayoutId(long layoutId) {
		_journalContentSearch.setLayoutId(layoutId);
	}

	/**
	* Gets the portlet id of this journal content search.
	*
	* @return the portlet id of this journal content search
	*/
	public java.lang.String getPortletId() {
		return _journalContentSearch.getPortletId();
	}

	/**
	* Sets the portlet id of this journal content search.
	*
	* @param portletId the portlet id of this journal content search
	*/
	public void setPortletId(java.lang.String portletId) {
		_journalContentSearch.setPortletId(portletId);
	}

	/**
	* Gets the article id of this journal content search.
	*
	* @return the article id of this journal content search
	*/
	public java.lang.String getArticleId() {
		return _journalContentSearch.getArticleId();
	}

	/**
	* Sets the article id of this journal content search.
	*
	* @param articleId the article id of this journal content search
	*/
	public void setArticleId(java.lang.String articleId) {
		_journalContentSearch.setArticleId(articleId);
	}

	public boolean isNew() {
		return _journalContentSearch.isNew();
	}

	public void setNew(boolean n) {
		_journalContentSearch.setNew(n);
	}

	public boolean isCachedModel() {
		return _journalContentSearch.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_journalContentSearch.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _journalContentSearch.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_journalContentSearch.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _journalContentSearch.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _journalContentSearch.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_journalContentSearch.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new JournalContentSearchWrapper((JournalContentSearch)_journalContentSearch.clone());
	}

	public int compareTo(
		com.liferay.portlet.journal.model.JournalContentSearch journalContentSearch) {
		return _journalContentSearch.compareTo(journalContentSearch);
	}

	public int hashCode() {
		return _journalContentSearch.hashCode();
	}

	public com.liferay.portlet.journal.model.JournalContentSearch toEscapedModel() {
		return new JournalContentSearchWrapper(_journalContentSearch.toEscapedModel());
	}

	public java.lang.String toString() {
		return _journalContentSearch.toString();
	}

	public java.lang.String toXmlString() {
		return _journalContentSearch.toXmlString();
	}

	public JournalContentSearch getWrappedJournalContentSearch() {
		return _journalContentSearch;
	}

	private JournalContentSearch _journalContentSearch;
}