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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkflowDefinitionLink service. Represents a row in the &quot;WorkflowDefinitionLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.WorkflowDefinitionLinkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.WorkflowDefinitionLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowDefinitionLink
 * @see com.liferay.portal.model.impl.WorkflowDefinitionLinkImpl
 * @see com.liferay.portal.model.impl.WorkflowDefinitionLinkModelImpl
 * @generated
 */
public interface WorkflowDefinitionLinkModel extends BaseModel<WorkflowDefinitionLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workflow definition link model instance should use the {@link WorkflowDefinitionLink} interface instead.
	 */

	/**
	 * Gets the primary key of this workflow definition link.
	 *
	 * @return the primary key of this workflow definition link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workflow definition link
	 *
	 * @param pk the primary key of this workflow definition link
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the workflow definition link id of this workflow definition link.
	 *
	 * @return the workflow definition link id of this workflow definition link
	 */
	public long getWorkflowDefinitionLinkId();

	/**
	 * Sets the workflow definition link id of this workflow definition link.
	 *
	 * @param workflowDefinitionLinkId the workflow definition link id of this workflow definition link
	 */
	public void setWorkflowDefinitionLinkId(long workflowDefinitionLinkId);

	/**
	 * Gets the group id of this workflow definition link.
	 *
	 * @return the group id of this workflow definition link
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this workflow definition link.
	 *
	 * @param groupId the group id of this workflow definition link
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this workflow definition link.
	 *
	 * @return the company id of this workflow definition link
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this workflow definition link.
	 *
	 * @param companyId the company id of this workflow definition link
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this workflow definition link.
	 *
	 * @return the user id of this workflow definition link
	 */
	public long getUserId();

	/**
	 * Sets the user id of this workflow definition link.
	 *
	 * @param userId the user id of this workflow definition link
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this workflow definition link.
	 *
	 * @return the user uuid of this workflow definition link
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this workflow definition link.
	 *
	 * @param userUuid the user uuid of this workflow definition link
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this workflow definition link.
	 *
	 * @return the user name of this workflow definition link
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this workflow definition link.
	 *
	 * @param userName the user name of this workflow definition link
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this workflow definition link.
	 *
	 * @return the create date of this workflow definition link
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this workflow definition link.
	 *
	 * @param createDate the create date of this workflow definition link
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this workflow definition link.
	 *
	 * @return the modified date of this workflow definition link
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workflow definition link.
	 *
	 * @param modifiedDate the modified date of this workflow definition link
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the class name of the model instance this workflow definition link is polymorphically associated with.
	 *
	 * @return the class name of the model instance this workflow definition link is polymorphically associated with
	 */
	public String getClassName();

	/**
	 * Gets the class name id of this workflow definition link.
	 *
	 * @return the class name id of this workflow definition link
	 */
	public long getClassNameId();

	/**
	 * Sets the class name id of this workflow definition link.
	 *
	 * @param classNameId the class name id of this workflow definition link
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Gets the workflow definition name of this workflow definition link.
	 *
	 * @return the workflow definition name of this workflow definition link
	 */
	@AutoEscape
	public String getWorkflowDefinitionName();

	/**
	 * Sets the workflow definition name of this workflow definition link.
	 *
	 * @param workflowDefinitionName the workflow definition name of this workflow definition link
	 */
	public void setWorkflowDefinitionName(String workflowDefinitionName);

	/**
	 * Gets the workflow definition version of this workflow definition link.
	 *
	 * @return the workflow definition version of this workflow definition link
	 */
	public int getWorkflowDefinitionVersion();

	/**
	 * Sets the workflow definition version of this workflow definition link.
	 *
	 * @param workflowDefinitionVersion the workflow definition version of this workflow definition link
	 */
	public void setWorkflowDefinitionVersion(int workflowDefinitionVersion);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(WorkflowDefinitionLink workflowDefinitionLink);

	public int hashCode();

	public WorkflowDefinitionLink toEscapedModel();

	public String toString();

	public String toXmlString();
}