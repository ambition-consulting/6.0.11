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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Douglas Wong
 */
public class VerifySQLServer extends VerifyProcess {

	protected void convertColumnsToUnicode() {
		dropNonunicodeTableIndexes();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			StringBundler sb = new StringBundler(11);

			sb.append("select sysobjects.name as table_name, syscolumns.name ");
			sb.append("AS column_name, systypes.name as data_type, ");
			sb.append("syscolumns.length, syscolumns.isnullable as ");
			sb.append("is_nullable FROM sysobjects inner join syscolumns on ");
			sb.append("sysobjects.id = syscolumns.id inner join systypes on ");
			sb.append("syscolumns.xtype = systypes.xtype where ");
			sb.append("(sysobjects.xtype = 'U') and ");
			sb.append(_FILTER_NONUNICODE_DATA_TYPES);
			sb.append(" and ");
			sb.append(_FILTER_EXCLUDED_TABLES);
			sb.append(" order by sysobjects.name, syscolumns.colid");

			String sql = sb.toString();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				String tableName = rs.getString("table_name");
				String columnName = rs.getString("column_name");
				String dataType = rs.getString("data_type");
				int length = rs.getInt("length");
				boolean nullable = rs.getBoolean("is_nullable");

				if (dataType.equals("varchar")) {
					convertVarcharColumn(
						tableName, columnName, length, nullable);
				}
				else if (dataType.equals("text")) {
					convertTextColumn(
						tableName, columnName, length, nullable);
				}
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void convertTextColumn(
			String tableName, String columnName, int length, boolean nullable)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info(
				"Updating " + tableName + "." + columnName + " to use ntext");
		}

		StringBundler sb = new StringBundler(4);

		sb.append("alter table ");
		sb.append(tableName);
		sb.append(" add temp ntext");

		if (!nullable) {
			sb.append(" not null");
		}

		runSQL(sb.toString());

		runSQL("update " + tableName + " set temp = " + columnName);

		runSQL("alter table " + tableName + " drop column " + columnName);

		runSQL(
			"exec sp_rename \'" + tableName + ".temp\', \'" + columnName +
				"\', \'column\'");
	}

	protected void convertVarcharColumn(
			String tableName, String columnName, int length, boolean nullable)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info(
				"Updating " + tableName + "." + columnName +
					" to use nvarchar");
		}

		StringBundler sb = new StringBundler(8);

		sb.append("alter table ");
		sb.append(tableName);
		sb.append(" alter column ");
		sb.append(columnName);
		sb.append(" nvarchar(");
		sb.append(length);
		sb.append(")");

		if (!nullable) {
			sb.append(" not null");
		}

		runSQL(sb.toString());
	}

	protected void doVerify() throws Exception {
		DB db = DBFactoryUtil.getDB();

		if (!db.getType().equals(DB.TYPE_SQLSERVER)) {
			return;
		}

		convertColumnsToUnicode();
	}

	protected void dropNonunicodeTableIndexes() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			StringBundler sb = new StringBundler(11);

			sb.append("select distinct sysobjects.name as table_name, ");
			sb.append("sysindexes.name as index_name FROM sysobjects inner ");
			sb.append("join sysindexes on sysobjects.id = sysindexes.id ");
			sb.append("inner join syscolumns on sysobjects.id = ");
			sb.append("syscolumns.id inner join sysindexkeys on ");
			sb.append("((sysobjects.id = sysindexkeys.id) and ");
			sb.append("(syscolumns.colid = sysindexkeys.colid) and ");
			sb.append("(sysindexes.indid = sysindexkeys.indid)) inner join ");
			sb.append("systypes on syscolumns.xtype = systypes.xtype where ");
			sb.append("sysobjects.type = 'U' and ");
			sb.append(_FILTER_NONUNICODE_DATA_TYPES);
			sb.append(" and ");
			sb.append(_FILTER_EXCLUDED_TABLES);
			sb.append(" order by sysobjects.name, sysindexes.name");

			String sql = sb.toString();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				String tableName = rs.getString("table_name");
				String indexName = rs.getString("index_name");

				if (_log.isInfoEnabled()) {
					_log.info("Dropping index " + tableName + "." + indexName);
				}

				runSQL("drop index " + indexName + " on " + tableName);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	private static final String _FILTER_EXCLUDED_TABLES =
		"(sysobjects.name not like 'Counter') and (sysobjects.name not like " +
			"'Cyrus%') and (sysobjects.name not like 'QUARTZ%')";

	private static final String _FILTER_NONUNICODE_DATA_TYPES =
		"((systypes.name = 'varchar') OR (systypes.name = 'text'))";

	private static Log _log = LogFactoryUtil.getLog(VerifySQLServer.class);

}