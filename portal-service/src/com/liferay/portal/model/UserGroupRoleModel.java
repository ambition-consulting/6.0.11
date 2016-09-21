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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.persistence.UserGroupRolePK;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserGroupRole service. Represents a row in the &quot;UserGroupRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserGroupRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserGroupRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRole
 * @see com.liferay.portal.model.impl.UserGroupRoleImpl
 * @see com.liferay.portal.model.impl.UserGroupRoleModelImpl
 * @generated
 */
public interface UserGroupRoleModel extends BaseModel<UserGroupRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user group role model instance should use the {@link UserGroupRole} interface instead.
	 */

	/**
	 * Gets the primary key of this user group role.
	 *
	 * @return the primary key of this user group role
	 */
	public UserGroupRolePK getPrimaryKey();

	/**
	 * Sets the primary key of this user group role
	 *
	 * @param pk the primary key of this user group role
	 */
	public void setPrimaryKey(UserGroupRolePK pk);

	/**
	 * Gets the user id of this user group role.
	 *
	 * @return the user id of this user group role
	 */
	public long getUserId();

	/**
	 * Sets the user id of this user group role.
	 *
	 * @param userId the user id of this user group role
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this user group role.
	 *
	 * @return the user uuid of this user group role
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user group role.
	 *
	 * @param userUuid the user uuid of this user group role
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the group id of this user group role.
	 *
	 * @return the group id of this user group role
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this user group role.
	 *
	 * @param groupId the group id of this user group role
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the role id of this user group role.
	 *
	 * @return the role id of this user group role
	 */
	public long getRoleId();

	/**
	 * Sets the role id of this user group role.
	 *
	 * @param roleId the role id of this user group role
	 */
	public void setRoleId(long roleId);

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

	public int compareTo(UserGroupRole userGroupRole);

	public int hashCode();

	public UserGroupRole toEscapedModel();

	public String toString();

	public String toXmlString();
}