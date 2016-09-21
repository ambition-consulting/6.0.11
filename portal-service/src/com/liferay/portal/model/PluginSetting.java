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
 * The model interface for the PluginSetting service. Represents a row in the &quot;PluginSetting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.PluginSettingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PluginSettingModel
 * @see com.liferay.portal.model.impl.PluginSettingImpl
 * @see com.liferay.portal.model.impl.PluginSettingModelImpl
 * @generated
 */
public interface PluginSetting extends PluginSettingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a plugin setting model instance should use the {@link PluginSetting} interface instead.
	 */

	/**
	* Adds a role to the list of roles.
	*/
	public void addRole(java.lang.String role);

	/**
	* Sets a string of ordered comma delimited plugin ids.
	*/
	public void setRoles(java.lang.String roles);

	/**
	* Gets an array of required roles of the plugin.
	*
	* @return an array of required roles of the plugin
	*/
	public java.lang.String[] getRolesArray();

	/**
	* Sets an array of required roles of the plugin.
	*/
	public void setRolesArray(java.lang.String[] rolesArray);

	/**
	* Returns <code>true</code> if the plugin has a role with the specified
	* name.
	*
	* @return <code>true</code> if the plugin has a role with the specified
	name
	*/
	public boolean hasRoleWithName(java.lang.String roleName);

	/**
	* Returns <code>true</code> if the user has permission to use this plugin
	*
	* @return <code>true</code> if the user has permission to use this plugin
	*/
	public boolean hasPermission(long userId);
}