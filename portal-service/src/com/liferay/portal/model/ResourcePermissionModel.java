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
 * The base model interface for the ResourcePermission service. Represents a row in the &quot;ResourcePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ResourcePermissionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ResourcePermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourcePermission
 * @see com.liferay.portal.model.impl.ResourcePermissionImpl
 * @see com.liferay.portal.model.impl.ResourcePermissionModelImpl
 * @generated
 */
public interface ResourcePermissionModel extends BaseModel<ResourcePermission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a resource permission model instance should use the {@link ResourcePermission} interface instead.
	 */

	/**
	 * Gets the primary key of this resource permission.
	 *
	 * @return the primary key of this resource permission
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resource permission
	 *
	 * @param pk the primary key of this resource permission
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the resource permission id of this resource permission.
	 *
	 * @return the resource permission id of this resource permission
	 */
	public long getResourcePermissionId();

	/**
	 * Sets the resource permission id of this resource permission.
	 *
	 * @param resourcePermissionId the resource permission id of this resource permission
	 */
	public void setResourcePermissionId(long resourcePermissionId);

	/**
	 * Gets the company id of this resource permission.
	 *
	 * @return the company id of this resource permission
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this resource permission.
	 *
	 * @param companyId the company id of this resource permission
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the name of this resource permission.
	 *
	 * @return the name of this resource permission
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this resource permission.
	 *
	 * @param name the name of this resource permission
	 */
	public void setName(String name);

	/**
	 * Gets the scope of this resource permission.
	 *
	 * @return the scope of this resource permission
	 */
	public int getScope();

	/**
	 * Sets the scope of this resource permission.
	 *
	 * @param scope the scope of this resource permission
	 */
	public void setScope(int scope);

	/**
	 * Gets the prim key of this resource permission.
	 *
	 * @return the prim key of this resource permission
	 */
	@AutoEscape
	public String getPrimKey();

	/**
	 * Sets the prim key of this resource permission.
	 *
	 * @param primKey the prim key of this resource permission
	 */
	public void setPrimKey(String primKey);

	/**
	 * Gets the role id of this resource permission.
	 *
	 * @return the role id of this resource permission
	 */
	public long getRoleId();

	/**
	 * Sets the role id of this resource permission.
	 *
	 * @param roleId the role id of this resource permission
	 */
	public void setRoleId(long roleId);

	/**
	 * Gets the action ids of this resource permission.
	 *
	 * @return the action ids of this resource permission
	 */
	public long getActionIds();

	/**
	 * Sets the action ids of this resource permission.
	 *
	 * @param actionIds the action ids of this resource permission
	 */
	public void setActionIds(long actionIds);

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

	public int compareTo(ResourcePermission resourcePermission);

	public int hashCode();

	public ResourcePermission toEscapedModel();

	public String toString();

	public String toXmlString();
}