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
 * This class is a wrapper for {@link ExpandoRow}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExpandoRow
 * @generated
 */
public class ExpandoRowWrapper implements ExpandoRow {
	public ExpandoRowWrapper(ExpandoRow expandoRow) {
		_expandoRow = expandoRow;
	}

	/**
	* Gets the primary key of this expando row.
	*
	* @return the primary key of this expando row
	*/
	public long getPrimaryKey() {
		return _expandoRow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expando row
	*
	* @param pk the primary key of this expando row
	*/
	public void setPrimaryKey(long pk) {
		_expandoRow.setPrimaryKey(pk);
	}

	/**
	* Gets the row id of this expando row.
	*
	* @return the row id of this expando row
	*/
	public long getRowId() {
		return _expandoRow.getRowId();
	}

	/**
	* Sets the row id of this expando row.
	*
	* @param rowId the row id of this expando row
	*/
	public void setRowId(long rowId) {
		_expandoRow.setRowId(rowId);
	}

	/**
	* Gets the company id of this expando row.
	*
	* @return the company id of this expando row
	*/
	public long getCompanyId() {
		return _expandoRow.getCompanyId();
	}

	/**
	* Sets the company id of this expando row.
	*
	* @param companyId the company id of this expando row
	*/
	public void setCompanyId(long companyId) {
		_expandoRow.setCompanyId(companyId);
	}

	/**
	* Gets the table id of this expando row.
	*
	* @return the table id of this expando row
	*/
	public long getTableId() {
		return _expandoRow.getTableId();
	}

	/**
	* Sets the table id of this expando row.
	*
	* @param tableId the table id of this expando row
	*/
	public void setTableId(long tableId) {
		_expandoRow.setTableId(tableId);
	}

	/**
	* Gets the class p k of this expando row.
	*
	* @return the class p k of this expando row
	*/
	public long getClassPK() {
		return _expandoRow.getClassPK();
	}

	/**
	* Sets the class p k of this expando row.
	*
	* @param classPK the class p k of this expando row
	*/
	public void setClassPK(long classPK) {
		_expandoRow.setClassPK(classPK);
	}

	public boolean isNew() {
		return _expandoRow.isNew();
	}

	public void setNew(boolean n) {
		_expandoRow.setNew(n);
	}

	public boolean isCachedModel() {
		return _expandoRow.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_expandoRow.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _expandoRow.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_expandoRow.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _expandoRow.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expandoRow.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expandoRow.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ExpandoRowWrapper((ExpandoRow)_expandoRow.clone());
	}

	public int compareTo(
		com.liferay.portlet.expando.model.ExpandoRow expandoRow) {
		return _expandoRow.compareTo(expandoRow);
	}

	public int hashCode() {
		return _expandoRow.hashCode();
	}

	public com.liferay.portlet.expando.model.ExpandoRow toEscapedModel() {
		return new ExpandoRowWrapper(_expandoRow.toEscapedModel());
	}

	public java.lang.String toString() {
		return _expandoRow.toString();
	}

	public java.lang.String toXmlString() {
		return _expandoRow.toXmlString();
	}

	public ExpandoRow getWrappedExpandoRow() {
		return _expandoRow;
	}

	private ExpandoRow _expandoRow;
}