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

package com.liferay.portal.dao.db;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.Index;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PropsValues;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Chow
 * @author Sandeep Soni
 * @author Ganesh Ram
 */
public class MySQLDB extends BaseDB {

	public static DB getInstance() {
		return _instance;
	}

	public String buildSQL(String template) throws IOException {
		template = convertTimestamp(template);
		template = replaceTemplate(template, getTemplate());

		template = reword(template);
		template = StringUtil.replace(template, "\\'", "''");

		return template;
	}

	public List<Index> getIndexes() throws SQLException {
		List<Index> indexes = new ArrayList<Index>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			StringBundler sb = new StringBundler(4);

			sb.append("select distinct(index_name), table_name, non_unique ");
			sb.append("from information_schema.statistics where ");
			sb.append("index_schema = database() and (index_name like ");
			sb.append("'LIFERAY_%' or index_name like 'IX_%')");

			String sql = sb.toString();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				String indexName = rs.getString("index_name");
				String tableName = rs.getString("table_name");
				boolean unique = !rs.getBoolean("non_unique");

				indexes.add(new Index(indexName, tableName, unique));
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return indexes;
	}

	public boolean isSupportsDateMilliseconds() {
		return _SUPPORTS_DATE_MILLISECONDS;
	}

	public boolean isSupportsUpdateWithInnerJoin() {
		return _SUPPORTS_UPDATE_WITH_INNER_JOIN;
	}

	protected MySQLDB() {
		super(TYPE_MYSQL);
	}

	protected String buildCreateFileContent(
			String sqlDir, String databaseName, int population)
		throws IOException {

		String suffix = getSuffix(population);

		StringBundler sb = new StringBundler(14);

		sb.append("drop database if exists ");
		sb.append(databaseName);
		sb.append(";\n");
		sb.append("create database ");
		sb.append(databaseName);
		sb.append(" character set utf8;\n");
		sb.append("use ");
		sb.append(databaseName);
		sb.append(";\n\n");
		sb.append(
			readFile(
				sqlDir + "/portal" + suffix + "/portal" + suffix +
					"-mysql.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/indexes/indexes-mysql.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/sequences/sequences-mysql.sql"));

		return sb.toString();
	}

	protected String getServerName() {
		return "mysql";
	}

	protected String[] getTemplate() {
		return _MYSQL;
	}

	protected String reword(String data) throws IOException {
		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new UnsyncStringReader(data));

		boolean createTable = false;

		StringBundler sb = new StringBundler();

		String line = null;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			if (StringUtil.startsWith(line, "create table")) {
				createTable = true;
			}
			else if (line.startsWith(ALTER_COLUMN_NAME)) {
				String[] template = buildColumnNameTokens(line);

				line = StringUtil.replace(
					"alter table @table@ change column @old-column@ " +
						"@new-column@ @type@;",
					REWORD_TEMPLATE, template);
			}
			else if (line.startsWith(ALTER_COLUMN_TYPE)) {
				String[] template = buildColumnTypeTokens(line);

				line = StringUtil.replace(
					"alter table @table@ modify @old-column@ @type@;",
					REWORD_TEMPLATE, template);
			}

			int pos = line.indexOf(";");

			if (createTable && (pos != -1)) {
				createTable = false;

				line =
					line.substring(0, pos) + " engine " +
						PropsValues.DATABASE_MYSQL_ENGINE + line.substring(pos);
			}

			sb.append(line);
			sb.append("\n");
		}

		unsyncBufferedReader.close();

		return sb.toString();
	}

	private static String[] _MYSQL = {
		"##", "1", "0",
		"'1970-01-01'", "now()",
		" blob", " tinyint", " datetime",
		" double", " integer", " bigint",
		" longtext", " longtext", " varchar",
		"  auto_increment", "commit"
	};

	private static final boolean _SUPPORTS_DATE_MILLISECONDS = false;

	private static final boolean _SUPPORTS_UPDATE_WITH_INNER_JOIN = true;

	private static MySQLDB _instance = new MySQLDB();

}