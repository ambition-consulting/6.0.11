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
 * This class is a wrapper for {@link ExpandoTable}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExpandoTable
 * @generated
 */
public class ExpandoTableWrapper implements ExpandoTable {
	public ExpandoTableWrapper(ExpandoTable expandoTable) {
		_expandoTable = expandoTable;
	}

	/**
	* Gets the primary key of this expando table.
	*
	* @return the primary key of this expando table
	*/
	public long getPrimaryKey() {
		return _expandoTable.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expando table
	*
	* @param pk the primary key of this expando table
	*/
	public void setPrimaryKey(long pk) {
		_expandoTable.setPrimaryKey(pk);
	}

	/**
	* Gets the table id of this expando table.
	*
	* @return the table id of this expando table
	*/
	public long getTableId() {
		return _expandoTable.getTableId();
	}

	/**
	* Sets the table id of this expando table.
	*
	* @param tableId the table id of this expando table
	*/
	public void setTableId(long tableId) {
		_expandoTable.setTableId(tableId);
	}

	/**
	* Gets the company id of this expando table.
	*
	* @return the company id of this expando table
	*/
	public long getCompanyId() {
		return _expandoTable.getCompanyId();
	}

	/**
	* Sets the company id of this expando table.
	*
	* @param companyId the company id of this expando table
	*/
	public void setCompanyId(long companyId) {
		_expandoTable.setCompanyId(companyId);
	}

	/**
	* Gets the class name of the model instance this expando table is polymorphically associated with.
	*
	* @return the class name of the model instance this expando table is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _expandoTable.getClassName();
	}

	/**
	* Gets the class name id of this expando table.
	*
	* @return the class name id of this expando table
	*/
	public long getClassNameId() {
		return _expandoTable.getClassNameId();
	}

	/**
	* Sets the class name id of this expando table.
	*
	* @param classNameId the class name id of this expando table
	*/
	public void setClassNameId(long classNameId) {
		_expandoTable.setClassNameId(classNameId);
	}

	/**
	* Gets the name of this expando table.
	*
	* @return the name of this expando table
	*/
	public java.lang.String getName() {
		return _expandoTable.getName();
	}

	/**
	* Sets the name of this expando table.
	*
	* @param name the name of this expando table
	*/
	public void setName(java.lang.String name) {
		_expandoTable.setName(name);
	}

	public boolean isNew() {
		return _expandoTable.isNew();
	}

	public void setNew(boolean n) {
		_expandoTable.setNew(n);
	}

	public boolean isCachedModel() {
		return _expandoTable.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_expandoTable.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _expandoTable.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_expandoTable.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _expandoTable.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expandoTable.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expandoTable.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ExpandoTableWrapper((ExpandoTable)_expandoTable.clone());
	}

	public int compareTo(
		com.liferay.portlet.expando.model.ExpandoTable expandoTable) {
		return _expandoTable.compareTo(expandoTable);
	}

	public int hashCode() {
		return _expandoTable.hashCode();
	}

	public com.liferay.portlet.expando.model.ExpandoTable toEscapedModel() {
		return new ExpandoTableWrapper(_expandoTable.toEscapedModel());
	}

	public java.lang.String toString() {
		return _expandoTable.toString();
	}

	public java.lang.String toXmlString() {
		return _expandoTable.toXmlString();
	}

	public boolean isDefaultTable() {
		return _expandoTable.isDefaultTable();
	}

	public ExpandoTable getWrappedExpandoTable() {
		return _expandoTable;
	}

	private ExpandoTable _expandoTable;
}