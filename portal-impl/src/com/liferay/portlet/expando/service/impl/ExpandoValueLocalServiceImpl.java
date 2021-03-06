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

package com.liferay.portlet.expando.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.model.impl.ExpandoValueImpl;
import com.liferay.portlet.expando.service.base.ExpandoValueLocalServiceBaseImpl;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Raymond Augé
 * @author Brian Wing Shun Chan
 */
public class ExpandoValueLocalServiceImpl
	extends ExpandoValueLocalServiceBaseImpl {

	public ExpandoValue addValue(
			long classNameId, long tableId, long columnId, long classPK,
			String data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTablePersistence.findByPrimaryKey(tableId);

		ExpandoRow row = expandoRowPersistence.fetchByT_C(tableId, classPK);

		if (row == null) {
			long rowId = counterLocalService.increment();

			row = expandoRowPersistence.create(rowId);

			row.setCompanyId(table.getCompanyId());
			row.setTableId(tableId);
			row.setClassPK(classPK);

			expandoRowPersistence.update(row, false);
		}

		ExpandoValue value = expandoValuePersistence.fetchByC_R(
			columnId, row.getRowId());

		if (value == null) {
			long valueId = counterLocalService.increment();

			value = expandoValuePersistence.create(valueId);

			value.setCompanyId(table.getCompanyId());
			value.setTableId(tableId);
			value.setColumnId(columnId);
			value.setRowId(row.getRowId());
			value.setClassNameId(classNameId);
			value.setClassPK(classPK);
		}

		value.setData(data);

		expandoValuePersistence.update(value, false);

		return value;
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, boolean data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setBoolean(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, boolean[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setBooleanArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, Date data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setDate(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, Date[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setDateArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, double data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setDouble(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, double[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setDoubleArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, float data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setFloat(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, float[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setFloatArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, int data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setInteger(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, int[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setIntegerArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, long data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setLong(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, long[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setLongArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, Object data)
		throws PortalException, SystemException {

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			companyId, className, tableName, columnName);

		int type = column.getType();

		if (type == ExpandoColumnConstants.BOOLEAN) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Boolean)data).booleanValue());
		}
		else if (type == ExpandoColumnConstants.BOOLEAN_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(boolean[])data);
		}
		else if (type == ExpandoColumnConstants.DATE) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(Date)data);
		}
		else if (type == ExpandoColumnConstants.DATE_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(Date[])data);
		}
		else if (type == ExpandoColumnConstants.DOUBLE) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Double)data).doubleValue());
		}
		else if (type == ExpandoColumnConstants.DOUBLE_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(double[])data);
		}
		else if (type == ExpandoColumnConstants.FLOAT) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Float)data).floatValue());
		}
		else if (type == ExpandoColumnConstants.FLOAT_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(float[])data);
		}
		else if (type == ExpandoColumnConstants.INTEGER) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Integer)data).intValue());
		}
		else if (type == ExpandoColumnConstants.INTEGER_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(int[])data);
		}
		else if (type == ExpandoColumnConstants.LONG) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Long)data).longValue());
		}
		else if (type == ExpandoColumnConstants.LONG_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(long[])data);
		}
		else if (type == ExpandoColumnConstants.SHORT) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				((Short)data).shortValue());
		}
		else if (type == ExpandoColumnConstants.SHORT_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(short[])data);
		}
		else if (type == ExpandoColumnConstants.STRING_ARRAY) {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(String[])data);
		}
		else {
			return addValue(
				companyId, className, tableName, columnName, classPK,
				(String)data);
		}
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, short data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setShort(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, short[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setShortArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, String data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setString(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	public ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, String[] data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, className, tableName);

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			table.getTableId(), columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setCompanyId(table.getCompanyId());
		value.setColumnId(column.getColumnId());
		value.setStringArray(data);

		return addValue(
			table.getClassNameId(), table.getTableId(), column.getColumnId(),
			classPK, value.getData());
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   boolean[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			boolean data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   boolean[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			boolean[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, Date[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			Date data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, Date[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			Date[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   double[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			double data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   double[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			double[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   float[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			float data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   float[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			float[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, int[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			int data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, int[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			int[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, long[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			long data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, long[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			long[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long, Object)}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			Object data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   short[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			short data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   short[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			short[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   String[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			String data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	/**
	 * @deprecated {@link #addValue(long, String, String, String, long,
	 *			   String[])}
	 */
	public ExpandoValue addValue(
			String className, String tableName, String columnName, long classPK,
			String[] data)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	public void addValues(
			long classNameId, long tableId, List<ExpandoColumn> columns,
			long classPK, Map<String, String> data)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTablePersistence.findByPrimaryKey(tableId);

		ExpandoRow row = expandoRowPersistence.fetchByT_C(tableId, classPK);

		if (row == null) {
			long rowId = counterLocalService.increment();

			row = expandoRowPersistence.create(rowId);

			row.setCompanyId(table.getCompanyId());
			row.setTableId(tableId);
			row.setClassPK(classPK);

			expandoRowPersistence.update(row, false);
		}

		for (ExpandoColumn column : columns) {
			String dataString = data.get(column.getName());

			if (dataString != null) {
				ExpandoValue value = expandoValuePersistence.fetchByC_R(
					column.getColumnId(), row.getRowId());

				if (value == null) {
					long valueId = counterLocalService.increment();

					value = expandoValuePersistence.create(valueId);

					value.setCompanyId(table.getCompanyId());
					value.setTableId(tableId);
					value.setColumnId(column.getColumnId());
					value.setRowId(row.getRowId());
					value.setClassNameId(classNameId);
					value.setClassPK(classPK);
				}

				value.setData(dataString);

				expandoValuePersistence.update(value, false);
			}
		}
	}

	public void deleteColumnValues(long columnId) throws SystemException {
		expandoValuePersistence.removeByColumnId(columnId);
	}

	public void deleteRowValues(long rowId) throws SystemException {
		expandoValuePersistence.removeByRowId(rowId);
	}

	public void deleteTableValues(long tableId) throws SystemException {
		expandoValuePersistence.removeByTableId(tableId);
	}

	public void deleteValue(long valueId)
		throws PortalException, SystemException {

		expandoValuePersistence.remove(valueId);
	}

	public void deleteValue(long columnId, long rowId)
		throws PortalException, SystemException {

		expandoValuePersistence.removeByC_R(columnId, rowId);
	}

	public void deleteValue(
			long companyId, long classNameId, String tableName,
			String columnName, long classPK)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return;
		}

		ExpandoValue value = expandoValuePersistence.fetchByT_C_C(
			table.getTableId(), column.getColumnId(), classPK);

		if (value != null) {
			deleteValue(value.getValueId());
		}
	}

	public void deleteValue(
			long companyId, String className, String tableName,
			String columnName, long classPK)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		deleteValue(companyId, classNameId, tableName, columnName, classPK);
	}

	public void deleteValues(long classNameId, long classPK)
		throws SystemException {

		expandoValuePersistence.removeByC_C(classNameId, classPK);
	}

	public void deleteValues(String className, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		deleteValues(classNameId, classPK);
	}

	public List<ExpandoValue> getColumnValues(long columnId, int start, int end)
		throws SystemException {

		return expandoValuePersistence.findByColumnId(columnId, start, end);
	}

	public List<ExpandoValue> getColumnValues(
			long companyId, long classNameId, String tableName,
			String columnName, int start, int end)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return Collections.EMPTY_LIST;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return Collections.EMPTY_LIST;
		}

		return expandoValuePersistence.findByT_C(
			table.getTableId(), column.getColumnId(), start, end);
	}

	public List<ExpandoValue> getColumnValues(
			long companyId, long classNameId, String tableName,
			String columnName, String data, int start, int end)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return Collections.EMPTY_LIST;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return Collections.EMPTY_LIST;
		}

		return expandoValuePersistence.findByT_C_D(
			table.getTableId(), column.getColumnId(), data, start, end);
	}

	public List<ExpandoValue> getColumnValues(
			long companyId, String className, String tableName,
			String columnName, int start, int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getColumnValues(
			companyId, classNameId, tableName, columnName, start, end);
	}

	public List<ExpandoValue> getColumnValues(
			long companyId, String className, String tableName,
			String columnName, String data, int start, int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getColumnValues(
			companyId, classNameId, tableName, columnName, data, start, end);
	}

	/**
	 * @deprecated {@link #getColumnValues(long, String, String, String, String,
	 *			   int, int)}
	 */
	public List<ExpandoValue> getColumnValues(
			String className, String tableName, String columnName, String data,
			int start, int end)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getColumnValues(
			companyId, className, tableName, columnName, data, start, end);
	}

	public int getColumnValuesCount(long columnId) throws SystemException {
		return expandoValuePersistence.countByColumnId(columnId);
	}

	public int getColumnValuesCount(
			long companyId, long classNameId, String tableName,
			String columnName)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return 0;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return 0;
		}

		return expandoValuePersistence.countByT_C(
			table.getTableId(), column.getColumnId());
	}

	public int getColumnValuesCount(
			long companyId, long classNameId, String tableName,
			String columnName, String data)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return 0;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return 0;
		}

		return expandoValuePersistence.countByT_C_D(
			table.getTableId(), column.getColumnId(), data);
	}

	public int getColumnValuesCount(
			long companyId, String className, String tableName,
			String columnName)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getColumnValuesCount(
			companyId, classNameId, tableName, columnName);
	}

	public int getColumnValuesCount(
			long companyId, String className, String tableName,
			String columnName, String data)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getColumnValuesCount(
			companyId, classNameId, tableName, columnName, data);
	}

	/**
	 * @deprecated {@link #getColumnValuesCount(long, String, String, String,
	 *			   String)}
	 */
	public int getColumnValuesCount(
			String className, String tableName, String columnName, String data)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getColumnValuesCount(
			companyId, className, tableName, columnName, data);
	}

	public Serializable getData(
			long companyId, String className, String tableName,
			String columnName, long classPK)
		throws PortalException, SystemException {

		ExpandoColumn column = expandoColumnLocalService.getColumn(
			companyId, className, tableName, columnName);

		ExpandoValue value = new ExpandoValueImpl();

		value.setColumnId(column.getColumnId());
		value.setData(column.getDefaultData());

		int type = column.getType();

		if (type == ExpandoColumnConstants.BOOLEAN) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getBoolean());
		}
		else if (type == ExpandoColumnConstants.BOOLEAN_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getBooleanArray());
		}
		else if (type == ExpandoColumnConstants.DATE) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getDate());
		}
		else if (type == ExpandoColumnConstants.DATE_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getDateArray());
		}
		else if (type == ExpandoColumnConstants.DOUBLE) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getDouble());
		}
		else if (type == ExpandoColumnConstants.DOUBLE_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getDoubleArray());
		}
		else if (type == ExpandoColumnConstants.FLOAT) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getFloat());
		}
		else if (type == ExpandoColumnConstants.FLOAT_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getFloatArray());
		}
		else if (type == ExpandoColumnConstants.INTEGER) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getInteger());
		}
		else if (type == ExpandoColumnConstants.INTEGER_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getIntegerArray());
		}
		else if (type == ExpandoColumnConstants.LONG) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getLong());
		}
		else if (type == ExpandoColumnConstants.LONG_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getLongArray());
		}
		else if (type == ExpandoColumnConstants.SHORT) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getShort());
		}
		else if (type == ExpandoColumnConstants.SHORT_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getShortArray());
		}
		else if (type == ExpandoColumnConstants.STRING_ARRAY) {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getStringArray());
		}
		else {
			return getData(
				companyId, className, tableName, columnName, classPK,
				value.getString());
		}
	}

	public boolean getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, boolean defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getBoolean();
		}
	}

	public boolean[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, boolean[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getBooleanArray();
		}
	}

	public Date getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, Date defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getDate();
		}
	}

	public Date[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, Date[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getDateArray();
		}
	}

	public double getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, double defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getDouble();
		}
	}

	public double[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, double[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getDoubleArray();
		}
	}

	public float getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, float defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getFloat();
		}
	}

	public float[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, float[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getFloatArray();
		}
	}

	public int getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, int defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getInteger();
		}
	}

	public int[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, int[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getIntegerArray();
		}
	}

	public long getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, long defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getLong();
		}
	}

	public long[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, long[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getLongArray();
		}
	}

	public short getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, short defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getShort();
		}
	}

	public short[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, short[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getShortArray();
		}
	}

	public String getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, String defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getString();
		}
	}

	public String[] getData(
			long companyId, String className, String tableName,
			String columnName, long classPK, String[] defaultData)
		throws PortalException, SystemException {

		ExpandoValue value = getValue(
			companyId, className, tableName, columnName, classPK);

		if (value == null) {
			return defaultData;
		}
		else {
			return value.getStringArray();
		}
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long)}
	 */
	public Serializable getData(
			String className, String tableName, String columnName, long classPK)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(companyId, className, tableName, columnName, classPK);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   boolean[])}
	 */
	public boolean getData(
			String className, String tableName, String columnName, long classPK,
			boolean defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   boolean[])}
	 */
	public boolean[] getData(
			String className, String tableName, String columnName, long classPK,
			boolean[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, Date[])}
	 */
	public Date getData(
			String className, String tableName, String columnName, long classPK,
			Date defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, Date[])}
	 */
	public Date[] getData(
			String className, String tableName, String columnName, long classPK,
			Date[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   double[])}
	 */
	public double getData(
			String className, String tableName, String columnName, long classPK,
			double defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   double[])}
	 */
	public double[] getData(
			String className, String tableName, String columnName, long classPK,
			double[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, float[])}
	 */
	public float getData(
			String className, String tableName, String columnName, long classPK,
			float defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, float[])}
	 */
	public float[] getData(
			String className, String tableName, String columnName, long classPK,
			float[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, int[])}
	 */
	public int getData(
			String className, String tableName, String columnName, long classPK,
			int defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, int[])}
	 */
	public int[] getData(
			String className, String tableName, String columnName, long classPK,
			int[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, long[])}
	 */
	public long getData(
			String className, String tableName, String columnName, long classPK,
			long defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, long[])}
	 */
	public long[] getData(
			String className, String tableName, String columnName, long classPK,
			long[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, short[])}
	 */
	public short getData(
			String className, String tableName, String columnName, long classPK,
			short defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long, short[])}
	 */
	public short[] getData(
			String className, String tableName, String columnName, long classPK,
			short[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   String[])}
	 */
	public String getData(
			String className, String tableName, String columnName, long classPK,
			String defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	/**
	 * @deprecated {@link #getData(long, String, String, String, long,
	 *			   String[])}
	 */
	public String[] getData(
			String className, String tableName, String columnName, long classPK,
			String[] defaultData)
		throws PortalException, SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getData(
			companyId, className, tableName, columnName, classPK, defaultData);
	}

	public List<ExpandoValue> getDefaultTableColumnValues(
			long companyId, long classNameId, String columnName, int start,
			int end)
		throws SystemException {

		return getColumnValues(
			companyId, classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME,
			columnName, start, end);
	}

	public List<ExpandoValue> getDefaultTableColumnValues(
			long companyId, String className, String columnName, int start,
			int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getDefaultTableColumnValues(
			companyId, classNameId, columnName, start, end);
	}

	public int getDefaultTableColumnValuesCount(
			long companyId, long classNameId, String columnName)
		throws SystemException {

		return getColumnValuesCount(
			companyId, classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME,
			columnName);
	}

	public int getDefaultTableColumnValuesCount(
			long companyId, String className, String columnName)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getDefaultTableColumnValuesCount(
			companyId, classNameId, columnName);
	}

	public List<ExpandoValue> getRowValues(long rowId) throws SystemException {
		return expandoValuePersistence.findByRowId(rowId);
	}

	public List<ExpandoValue> getRowValues(long rowId, int start, int end)
		throws SystemException {

		return expandoValuePersistence.findByRowId(rowId, start, end);
	}

	public List<ExpandoValue> getRowValues(
			long companyId, long classNameId, String tableName, long classPK,
			int start, int end)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return Collections.EMPTY_LIST;
		}

		return expandoValuePersistence.findByT_CPK(
			table.getTableId(), classPK, start, end);
	}

	public List<ExpandoValue> getRowValues(
			long companyId, String className, String tableName, long classPK,
			int start, int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getRowValues(
			companyId, classNameId, tableName, classPK, start, end);
	}

	public int getRowValuesCount(long rowId) throws SystemException {
		return expandoValuePersistence.countByRowId(rowId);
	}

	public int getRowValuesCount(
			long companyId, long classNameId, String tableName, long classPK)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return 0;
		}

		return expandoValuePersistence.countByT_CPK(
			table.getTableId(), classPK);
	}

	public int getRowValuesCount(
			long companyId, String className, String tableName, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getRowValuesCount(companyId, classNameId, tableName, classPK);
	}

	public ExpandoValue getValue(long valueId)
		throws PortalException, SystemException {

		return expandoValuePersistence.findByPrimaryKey(valueId);
	}

	public ExpandoValue getValue(long columnId, long rowId)
		throws PortalException, SystemException {

		return expandoValuePersistence.findByC_R(columnId, rowId);
	}

	public ExpandoValue getValue(long tableId, long columnId, long classPK)
		throws SystemException {

		return expandoValuePersistence.fetchByT_C_C(
			tableId, columnId, classPK);
	}

	public ExpandoValue getValue(
			long companyId, long classNameId, String tableName,
			String columnName, long classPK)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return null;
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			table.getTableId(), columnName);

		if (column == null) {
			return null;
		}

		return expandoValuePersistence.fetchByT_C_C(
			table.getTableId(), column.getColumnId(), classPK);
	}

	/**
	 * @deprecated {@link getValue(long, long, String, String, long)}
	 */
	public ExpandoValue getValue(
			long classNameId, String tableName, String columnName, long classPK)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getValue(companyId, classNameId, tableName, columnName, classPK);
	}

	public ExpandoValue getValue(
			long companyId, String className, String tableName,
			String columnName, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getValue(companyId, classNameId, tableName, columnName, classPK);
	}

	/**
	 * @deprecated {@link getValue(long, String, String, String, long)}
	 */
	public ExpandoValue getValue(
			String className, String tableName, String columnName, long classPK)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getValue(companyId, className, tableName, columnName, classPK);
	}

}