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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserGroup service. Represents a row in the &quot;UserGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroup
 * @see com.liferay.portal.model.impl.UserGroupImpl
 * @see com.liferay.portal.model.impl.UserGroupModelImpl
 * @generated
 */
public interface UserGroupModel extends BaseModel<UserGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user group model instance should use the {@link UserGroup} interface instead.
	 */

	/**
	 * Gets the primary key of this user group.
	 *
	 * @return the primary key of this user group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user group
	 *
	 * @param pk the primary key of this user group
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the user group id of this user group.
	 *
	 * @return the user group id of this user group
	 */
	public long getUserGroupId();

	/**
	 * Sets the user group id of this user group.
	 *
	 * @param userGroupId the user group id of this user group
	 */
	public void setUserGroupId(long userGroupId);

	/**
	 * Gets the company id of this user group.
	 *
	 * @return the company id of this user group
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this user group.
	 *
	 * @param companyId the company id of this user group
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the parent user group id of this user group.
	 *
	 * @return the parent user group id of this user group
	 */
	public long getParentUserGroupId();

	/**
	 * Sets the parent user group id of this user group.
	 *
	 * @param parentUserGroupId the parent user group id of this user group
	 */
	public void setParentUserGroupId(long parentUserGroupId);

	/**
	 * Gets the name of this user group.
	 *
	 * @return the name of this user group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this user group.
	 *
	 * @param name the name of this user group
	 */
	public void setName(String name);

	/**
	 * Gets the description of this user group.
	 *
	 * @return the description of this user group
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this user group.
	 *
	 * @param description the description of this user group
	 */
	public void setDescription(String description);

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

	public int compareTo(UserGroup userGroup);

	public int hashCode();

	public UserGroup toEscapedModel();

	public String toString();

	public String toXmlString();
}