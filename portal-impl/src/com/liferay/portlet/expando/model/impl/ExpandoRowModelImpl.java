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

package com.liferay.portlet.expando.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoRowModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the ExpandoRow service. Represents a row in the &quot;ExpandoRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.expando.model.ExpandoRowModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpandoRowImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoRowImpl
 * @see com.liferay.portlet.expando.model.ExpandoRow
 * @see com.liferay.portlet.expando.model.ExpandoRowModel
 * @generated
 */
public class ExpandoRowModelImpl extends BaseModelImpl<ExpandoRow>
	implements ExpandoRowModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expando row model instance should use the {@link com.liferay.portlet.expando.model.ExpandoRow} interface instead.
	 */
	public static final String TABLE_NAME = "ExpandoRow";
	public static final Object[][] TABLE_COLUMNS = {
			{ "rowId_", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "tableId", new Integer(Types.BIGINT) },
			{ "classPK", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table ExpandoRow (rowId_ LONG not null primary key,companyId LONG,tableId LONG,classPK LONG)";
	public static final String TABLE_SQL_DROP = "drop table ExpandoRow";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.expando.model.ExpandoRow"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.expando.model.ExpandoRow"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.expando.model.ExpandoRow"));

	public ExpandoRowModelImpl() {
	}

	public long getPrimaryKey() {
		return _rowId;
	}

	public void setPrimaryKey(long pk) {
		setRowId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_rowId);
	}

	public long getRowId() {
		return _rowId;
	}

	public void setRowId(long rowId) {
		_rowId = rowId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getTableId() {
		return _tableId;
	}

	public void setTableId(long tableId) {
		_tableId = tableId;

		if (!_setOriginalTableId) {
			_setOriginalTableId = true;

			_originalTableId = tableId;
		}
	}

	public long getOriginalTableId() {
		return _originalTableId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = classPK;
		}
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	public ExpandoRow toEscapedModel() {
		if (isEscapedModel()) {
			return (ExpandoRow)this;
		}
		else {
			return (ExpandoRow)Proxy.newProxyInstance(ExpandoRow.class.getClassLoader(),
				new Class[] { ExpandoRow.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ExpandoRowImpl clone = new ExpandoRowImpl();

		clone.setRowId(getRowId());
		clone.setCompanyId(getCompanyId());
		clone.setTableId(getTableId());
		clone.setClassPK(getClassPK());

		return clone;
	}

	public int compareTo(ExpandoRow expandoRow) {
		long pk = expandoRow.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ExpandoRow expandoRow = null;

		try {
			expandoRow = (ExpandoRow)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = expandoRow.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{rowId=");
		sb.append(getRowId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", tableId=");
		sb.append(getTableId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.expando.model.ExpandoRow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rowId</column-name><column-value><![CDATA[");
		sb.append(getRowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableId</column-name><column-value><![CDATA[");
		sb.append(getTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _rowId;
	private long _companyId;
	private long _tableId;
	private long _originalTableId;
	private boolean _setOriginalTableId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
}