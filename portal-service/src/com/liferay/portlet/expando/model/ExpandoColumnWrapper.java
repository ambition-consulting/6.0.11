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

package com.liferay.portlet.expando.model;

/**
 * <p>
 * This class is a wrapper for {@link ExpandoColumn}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExpandoColumn
 * @generated
 */
public class ExpandoColumnWrapper implements ExpandoColumn {
	public ExpandoColumnWrapper(ExpandoColumn expandoColumn) {
		_expandoColumn = expandoColumn;
	}

	/**
	* Gets the primary key of this expando column.
	*
	* @return the primary key of this expando column
	*/
	public long getPrimaryKey() {
		return _expandoColumn.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expando column
	*
	* @param pk the primary key of this expando column
	*/
	public void setPrimaryKey(long pk) {
		_expandoColumn.setPrimaryKey(pk);
	}

	/**
	* Gets the column id of this expando column.
	*
	* @return the column id of this expando column
	*/
	public long getColumnId() {
		return _expandoColumn.getColumnId();
	}

	/**
	* Sets the column id of this expando column.
	*
	* @param columnId the column id of this expando column
	*/
	public void setColumnId(long columnId) {
		_expandoColumn.setColumnId(columnId);
	}

	/**
	* Gets the company id of this expando column.
	*
	* @return the company id of this expando column
	*/
	public long getCompanyId() {
		return _expandoColumn.getCompanyId();
	}

	/**
	* Sets the company id of this expando column.
	*
	* @param companyId the company id of this expando column
	*/
	public void setCompanyId(long companyId) {
		_expandoColumn.setCompanyId(companyId);
	}

	/**
	* Gets the table id of this expando column.
	*
	* @return the table id of this expando column
	*/
	public long getTableId() {
		return _expandoColumn.getTableId();
	}

	/**
	* Sets the table id of this expando column.
	*
	* @param tableId the table id of this expando column
	*/
	public void setTableId(long tableId) {
		_expandoColumn.setTableId(tableId);
	}

	/**
	* Gets the name of this expando column.
	*
	* @return the name of this expando column
	*/
	public java.lang.String getName() {
		return _expandoColumn.getName();
	}

	/**
	* Sets the name of this expando column.
	*
	* @param name the name of this expando column
	*/
	public void setName(java.lang.String name) {
		_expandoColumn.setName(name);
	}

	/**
	* Gets the type of this expando column.
	*
	* @return the type of this expando column
	*/
	public int getType() {
		return _expandoColumn.getType();
	}

	/**
	* Sets the type of this expando column.
	*
	* @param type the type of this expando column
	*/
	public void setType(int type) {
		_expandoColumn.setType(type);
	}

	/**
	* Gets the default data of this expando column.
	*
	* @return the default data of this expando column
	*/
	public java.lang.String getDefaultData() {
		return _expandoColumn.getDefaultData();
	}

	/**
	* Sets the default data of this expando column.
	*
	* @param defaultData the default data of this expando column
	*/
	public void setDefaultData(java.lang.String defaultData) {
		_expandoColumn.setDefaultData(defaultData);
	}

	/**
	* Gets the type settings of this expando column.
	*
	* @return the type settings of this expando column
	*/
	public java.lang.String getTypeSettings() {
		return _expandoColumn.getTypeSettings();
	}

	/**
	* Sets the type settings of this expando column.
	*
	* @param typeSettings the type settings of this expando column
	*/
	public void setTypeSettings(java.lang.String typeSettings) {
		_expandoColumn.setTypeSettings(typeSettings);
	}

	public boolean isNew() {
		return _expandoColumn.isNew();
	}

	public void setNew(boolean n) {
		_expandoColumn.setNew(n);
	}

	public boolean isCachedModel() {
		return _expandoColumn.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_expandoColumn.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _expandoColumn.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_expandoColumn.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _expandoColumn.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expandoColumn.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expandoColumn.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ExpandoColumnWrapper((ExpandoColumn)_expandoColumn.clone());
	}

	public int compareTo(
		com.liferay.portlet.expando.model.ExpandoColumn expandoColumn) {
		return _expandoColumn.compareTo(expandoColumn);
	}

	public int hashCode() {
		return _expandoColumn.hashCode();
	}

	public com.liferay.portlet.expando.model.ExpandoColumn toEscapedModel() {
		return new ExpandoColumnWrapper(_expandoColumn.toEscapedModel());
	}

	public java.lang.String toString() {
		return _expandoColumn.toString();
	}

	public java.lang.String toXmlString() {
		return _expandoColumn.toXmlString();
	}

	public java.io.Serializable getDefaultValue() {
		return _expandoColumn.getDefaultValue();
	}

	public java.lang.String getDisplayName(java.util.Locale locale) {
		return _expandoColumn.getDisplayName(locale);
	}

	public com.liferay.portal.kernel.util.UnicodeProperties getTypeSettingsProperties() {
		return _expandoColumn.getTypeSettingsProperties();
	}

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties) {
		_expandoColumn.setTypeSettingsProperties(typeSettingsProperties);
	}

	public ExpandoColumn getWrappedExpandoColumn() {
		return _expandoColumn;
	}

	private ExpandoColumn _expandoColumn;
}