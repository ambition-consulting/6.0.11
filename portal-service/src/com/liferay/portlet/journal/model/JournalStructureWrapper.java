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
 * This class is a wrapper for {@link JournalStructure}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JournalStructure
 * @generated
 */
public class JournalStructureWrapper implements JournalStructure {
	public JournalStructureWrapper(JournalStructure journalStructure) {
		_journalStructure = journalStructure;
	}

	/**
	* Gets the primary key of this journal structure.
	*
	* @return the primary key of this journal structure
	*/
	public long getPrimaryKey() {
		return _journalStructure.getPrimaryKey();
	}

	/**
	* Sets the primary key of this journal structure
	*
	* @param pk the primary key of this journal structure
	*/
	public void setPrimaryKey(long pk) {
		_journalStructure.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this journal structure.
	*
	* @return the uuid of this journal structure
	*/
	public java.lang.String getUuid() {
		return _journalStructure.getUuid();
	}

	/**
	* Sets the uuid of this journal structure.
	*
	* @param uuid the uuid of this journal structure
	*/
	public void setUuid(java.lang.String uuid) {
		_journalStructure.setUuid(uuid);
	}

	/**
	* Gets the id of this journal structure.
	*
	* @return the id of this journal structure
	*/
	public long getId() {
		return _journalStructure.getId();
	}

	/**
	* Sets the id of this journal structure.
	*
	* @param id the id of this journal structure
	*/
	public void setId(long id) {
		_journalStructure.setId(id);
	}

	/**
	* Gets the group id of this journal structure.
	*
	* @return the group id of this journal structure
	*/
	public long getGroupId() {
		return _journalStructure.getGroupId();
	}

	/**
	* Sets the group id of this journal structure.
	*
	* @param groupId the group id of this journal structure
	*/
	public void setGroupId(long groupId) {
		_journalStructure.setGroupId(groupId);
	}

	/**
	* Gets the company id of this journal structure.
	*
	* @return the company id of this journal structure
	*/
	public long getCompanyId() {
		return _journalStructure.getCompanyId();
	}

	/**
	* Sets the company id of this journal structure.
	*
	* @param companyId the company id of this journal structure
	*/
	public void setCompanyId(long companyId) {
		_journalStructure.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this journal structure.
	*
	* @return the user id of this journal structure
	*/
	public long getUserId() {
		return _journalStructure.getUserId();
	}

	/**
	* Sets the user id of this journal structure.
	*
	* @param userId the user id of this journal structure
	*/
	public void setUserId(long userId) {
		_journalStructure.setUserId(userId);
	}

	/**
	* Gets the user uuid of this journal structure.
	*
	* @return the user uuid of this journal structure
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _journalStructure.getUserUuid();
	}

	/**
	* Sets the user uuid of this journal structure.
	*
	* @param userUuid the user uuid of this journal structure
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_journalStructure.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this journal structure.
	*
	* @return the user name of this journal structure
	*/
	public java.lang.String getUserName() {
		return _journalStructure.getUserName();
	}

	/**
	* Sets the user name of this journal structure.
	*
	* @param userName the user name of this journal structure
	*/
	public void setUserName(java.lang.String userName) {
		_journalStructure.setUserName(userName);
	}

	/**
	* Gets the create date of this journal structure.
	*
	* @return the create date of this journal structure
	*/
	public java.util.Date getCreateDate() {
		return _journalStructure.getCreateDate();
	}

	/**
	* Sets the create date of this journal structure.
	*
	* @param createDate the create date of this journal structure
	*/
	public void setCreateDate(java.util.Date createDate) {
		_journalStructure.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this journal structure.
	*
	* @return the modified date of this journal structure
	*/
	public java.util.Date getModifiedDate() {
		return _journalStructure.getModifiedDate();
	}

	/**
	* Sets the modified date of this journal structure.
	*
	* @param modifiedDate the modified date of this journal structure
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_journalStructure.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the structure id of this journal structure.
	*
	* @return the structure id of this journal structure
	*/
	public java.lang.String getStructureId() {
		return _journalStructure.getStructureId();
	}

	/**
	* Sets the structure id of this journal structure.
	*
	* @param structureId the structure id of this journal structure
	*/
	public void setStructureId(java.lang.String structureId) {
		_journalStructure.setStructureId(structureId);
	}

	/**
	* Gets the parent structure id of this journal structure.
	*
	* @return the parent structure id of this journal structure
	*/
	public java.lang.String getParentStructureId() {
		return _journalStructure.getParentStructureId();
	}

	/**
	* Sets the parent structure id of this journal structure.
	*
	* @param parentStructureId the parent structure id of this journal structure
	*/
	public void setParentStructureId(java.lang.String parentStructureId) {
		_journalStructure.setParentStructureId(parentStructureId);
	}

	/**
	* Gets the name of this journal structure.
	*
	* @return the name of this journal structure
	*/
	public java.lang.String getName() {
		return _journalStructure.getName();
	}

	/**
	* Sets the name of this journal structure.
	*
	* @param name the name of this journal structure
	*/
	public void setName(java.lang.String name) {
		_journalStructure.setName(name);
	}

	/**
	* Gets the description of this journal structure.
	*
	* @return the description of this journal structure
	*/
	public java.lang.String getDescription() {
		return _journalStructure.getDescription();
	}

	/**
	* Sets the description of this journal structure.
	*
	* @param description the description of this journal structure
	*/
	public void setDescription(java.lang.String description) {
		_journalStructure.setDescription(description);
	}

	/**
	* Gets the xsd of this journal structure.
	*
	* @return the xsd of this journal structure
	*/
	public java.lang.String getXsd() {
		return _journalStructure.getXsd();
	}

	/**
	* Sets the xsd of this journal structure.
	*
	* @param xsd the xsd of this journal structure
	*/
	public void setXsd(java.lang.String xsd) {
		_journalStructure.setXsd(xsd);
	}

	public boolean isNew() {
		return _journalStructure.isNew();
	}

	public void setNew(boolean n) {
		_journalStructure.setNew(n);
	}

	public boolean isCachedModel() {
		return _journalStructure.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_journalStructure.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _journalStructure.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_journalStructure.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _journalStructure.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _journalStructure.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_journalStructure.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new JournalStructureWrapper((JournalStructure)_journalStructure.clone());
	}

	public int compareTo(
		com.liferay.portlet.journal.model.JournalStructure journalStructure) {
		return _journalStructure.compareTo(journalStructure);
	}

	public int hashCode() {
		return _journalStructure.hashCode();
	}

	public com.liferay.portlet.journal.model.JournalStructure toEscapedModel() {
		return new JournalStructureWrapper(_journalStructure.toEscapedModel());
	}

	public java.lang.String toString() {
		return _journalStructure.toString();
	}

	public java.lang.String toXmlString() {
		return _journalStructure.toXmlString();
	}

	public java.lang.String getMergedXsd() {
		return _journalStructure.getMergedXsd();
	}

	public JournalStructure getWrappedJournalStructure() {
		return _journalStructure;
	}

	private JournalStructure _journalStructure;
}