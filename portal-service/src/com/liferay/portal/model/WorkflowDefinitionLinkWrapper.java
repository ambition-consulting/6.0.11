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

package com.liferay.portal.model;

/**
 * <p>
 * This class is a wrapper for {@link WorkflowDefinitionLink}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WorkflowDefinitionLink
 * @generated
 */
public class WorkflowDefinitionLinkWrapper implements WorkflowDefinitionLink {
	public WorkflowDefinitionLinkWrapper(
		WorkflowDefinitionLink workflowDefinitionLink) {
		_workflowDefinitionLink = workflowDefinitionLink;
	}

	/**
	* Gets the primary key of this workflow definition link.
	*
	* @return the primary key of this workflow definition link
	*/
	public long getPrimaryKey() {
		return _workflowDefinitionLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workflow definition link
	*
	* @param pk the primary key of this workflow definition link
	*/
	public void setPrimaryKey(long pk) {
		_workflowDefinitionLink.setPrimaryKey(pk);
	}

	/**
	* Gets the workflow definition link id of this workflow definition link.
	*
	* @return the workflow definition link id of this workflow definition link
	*/
	public long getWorkflowDefinitionLinkId() {
		return _workflowDefinitionLink.getWorkflowDefinitionLinkId();
	}

	/**
	* Sets the workflow definition link id of this workflow definition link.
	*
	* @param workflowDefinitionLinkId the workflow definition link id of this workflow definition link
	*/
	public void setWorkflowDefinitionLinkId(long workflowDefinitionLinkId) {
		_workflowDefinitionLink.setWorkflowDefinitionLinkId(workflowDefinitionLinkId);
	}

	/**
	* Gets the group id of this workflow definition link.
	*
	* @return the group id of this workflow definition link
	*/
	public long getGroupId() {
		return _workflowDefinitionLink.getGroupId();
	}

	/**
	* Sets the group id of this workflow definition link.
	*
	* @param groupId the group id of this workflow definition link
	*/
	public void setGroupId(long groupId) {
		_workflowDefinitionLink.setGroupId(groupId);
	}

	/**
	* Gets the company id of this workflow definition link.
	*
	* @return the company id of this workflow definition link
	*/
	public long getCompanyId() {
		return _workflowDefinitionLink.getCompanyId();
	}

	/**
	* Sets the company id of this workflow definition link.
	*
	* @param companyId the company id of this workflow definition link
	*/
	public void setCompanyId(long companyId) {
		_workflowDefinitionLink.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this workflow definition link.
	*
	* @return the user id of this workflow definition link
	*/
	public long getUserId() {
		return _workflowDefinitionLink.getUserId();
	}

	/**
	* Sets the user id of this workflow definition link.
	*
	* @param userId the user id of this workflow definition link
	*/
	public void setUserId(long userId) {
		_workflowDefinitionLink.setUserId(userId);
	}

	/**
	* Gets the user uuid of this workflow definition link.
	*
	* @return the user uuid of this workflow definition link
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLink.getUserUuid();
	}

	/**
	* Sets the user uuid of this workflow definition link.
	*
	* @param userUuid the user uuid of this workflow definition link
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_workflowDefinitionLink.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this workflow definition link.
	*
	* @return the user name of this workflow definition link
	*/
	public java.lang.String getUserName() {
		return _workflowDefinitionLink.getUserName();
	}

	/**
	* Sets the user name of this workflow definition link.
	*
	* @param userName the user name of this workflow definition link
	*/
	public void setUserName(java.lang.String userName) {
		_workflowDefinitionLink.setUserName(userName);
	}

	/**
	* Gets the create date of this workflow definition link.
	*
	* @return the create date of this workflow definition link
	*/
	public java.util.Date getCreateDate() {
		return _workflowDefinitionLink.getCreateDate();
	}

	/**
	* Sets the create date of this workflow definition link.
	*
	* @param createDate the create date of this workflow definition link
	*/
	public void setCreateDate(java.util.Date createDate) {
		_workflowDefinitionLink.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this workflow definition link.
	*
	* @return the modified date of this workflow definition link
	*/
	public java.util.Date getModifiedDate() {
		return _workflowDefinitionLink.getModifiedDate();
	}

	/**
	* Sets the modified date of this workflow definition link.
	*
	* @param modifiedDate the modified date of this workflow definition link
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workflowDefinitionLink.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the class name of the model instance this workflow definition link is polymorphically associated with.
	*
	* @return the class name of the model instance this workflow definition link is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _workflowDefinitionLink.getClassName();
	}

	/**
	* Gets the class name id of this workflow definition link.
	*
	* @return the class name id of this workflow definition link
	*/
	public long getClassNameId() {
		return _workflowDefinitionLink.getClassNameId();
	}

	/**
	* Sets the class name id of this workflow definition link.
	*
	* @param classNameId the class name id of this workflow definition link
	*/
	public void setClassNameId(long classNameId) {
		_workflowDefinitionLink.setClassNameId(classNameId);
	}

	/**
	* Gets the workflow definition name of this workflow definition link.
	*
	* @return the workflow definition name of this workflow definition link
	*/
	public java.lang.String getWorkflowDefinitionName() {
		return _workflowDefinitionLink.getWorkflowDefinitionName();
	}

	/**
	* Sets the workflow definition name of this workflow definition link.
	*
	* @param workflowDefinitionName the workflow definition name of this workflow definition link
	*/
	public void setWorkflowDefinitionName(
		java.lang.String workflowDefinitionName) {
		_workflowDefinitionLink.setWorkflowDefinitionName(workflowDefinitionName);
	}

	/**
	* Gets the workflow definition version of this workflow definition link.
	*
	* @return the workflow definition version of this workflow definition link
	*/
	public int getWorkflowDefinitionVersion() {
		return _workflowDefinitionLink.getWorkflowDefinitionVersion();
	}

	/**
	* Sets the workflow definition version of this workflow definition link.
	*
	* @param workflowDefinitionVersion the workflow definition version of this workflow definition link
	*/
	public void setWorkflowDefinitionVersion(int workflowDefinitionVersion) {
		_workflowDefinitionLink.setWorkflowDefinitionVersion(workflowDefinitionVersion);
	}

	public boolean isNew() {
		return _workflowDefinitionLink.isNew();
	}

	public void setNew(boolean n) {
		_workflowDefinitionLink.setNew(n);
	}

	public boolean isCachedModel() {
		return _workflowDefinitionLink.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_workflowDefinitionLink.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _workflowDefinitionLink.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_workflowDefinitionLink.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _workflowDefinitionLink.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workflowDefinitionLink.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workflowDefinitionLink.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new WorkflowDefinitionLinkWrapper((WorkflowDefinitionLink)_workflowDefinitionLink.clone());
	}

	public int compareTo(
		com.liferay.portal.model.WorkflowDefinitionLink workflowDefinitionLink) {
		return _workflowDefinitionLink.compareTo(workflowDefinitionLink);
	}

	public int hashCode() {
		return _workflowDefinitionLink.hashCode();
	}

	public com.liferay.portal.model.WorkflowDefinitionLink toEscapedModel() {
		return new WorkflowDefinitionLinkWrapper(_workflowDefinitionLink.toEscapedModel());
	}

	public java.lang.String toString() {
		return _workflowDefinitionLink.toString();
	}

	public java.lang.String toXmlString() {
		return _workflowDefinitionLink.toXmlString();
	}

	public WorkflowDefinitionLink getWrappedWorkflowDefinitionLink() {
		return _workflowDefinitionLink;
	}

	private WorkflowDefinitionLink _workflowDefinitionLink;
}