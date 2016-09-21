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

import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.persistence.OrgGroupPermissionPK;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the OrgGroupPermission service. Represents a row in the &quot;OrgGroupPermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.OrgGroupPermissionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.OrgGroupPermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupPermission
 * @see com.liferay.portal.model.impl.OrgGroupPermissionImpl
 * @see com.liferay.portal.model.impl.OrgGroupPermissionModelImpl
 * @generated
 */
public interface OrgGroupPermissionModel extends BaseModel<OrgGroupPermission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a org group permission model instance should use the {@link OrgGroupPermission} interface instead.
	 */

	/**
	 * Gets the primary key of this org group permission.
	 *
	 * @return the primary key of this org group permission
	 */
	public OrgGroupPermissionPK getPrimaryKey();

	/**
	 * Sets the primary key of this org group permission
	 *
	 * @param pk the primary key of this org group permission
	 */
	public void setPrimaryKey(OrgGroupPermissionPK pk);

	/**
	 * Gets the organization id of this org group permission.
	 *
	 * @return the organization id of this org group permission
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization id of this org group permission.
	 *
	 * @param organizationId the organization id of this org group permission
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Gets the group id of this org group permission.
	 *
	 * @return the group id of this org group permission
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this org group permission.
	 *
	 * @param groupId the group id of this org group permission
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the permission id of this org group permission.
	 *
	 * @return the permission id of this org group permission
	 */
	public long getPermissionId();

	/**
	 * Sets the permission id of this org group permission.
	 *
	 * @param permissionId the permission id of this org group permission
	 */
	public void setPermissionId(long permissionId);

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

	public int compareTo(OrgGroupPermission orgGroupPermission);

	public int hashCode();

	public OrgGroupPermission toEscapedModel();

	public String toString();

	public String toXmlString();
}