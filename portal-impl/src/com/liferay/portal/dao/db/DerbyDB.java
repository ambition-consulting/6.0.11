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
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Alexander Chow
 * @author Sandeep Soni
 * @author Ganesh Ram
 */
public class DerbyDB extends BaseDB {

	public static DB getInstance() {
		return _instance;
	}

	public String buildSQL(String template) throws IOException {
		template = convertTimestamp(template);
		template = replaceTemplate(template, getTemplate());

		template = reword(template );
		//template = _removeLongInserts(derby);
		template = removeNull(template);
		template = StringUtil.replace(template , "\\'", "''");

		return template;
	}

	public boolean isSupportsAlterColumnName() {
		return _SUPPORTS_ALTER_COLUMN_NAME;
	}

	public boolean isSupportsAlterColumnType() {
		return _SUPPORTS_ALTER_COLUMN_TYPE;
	}

	protected DerbyDB() {
		super(TYPE_DERBY);
	}

	protected String buildCreateFileContent(
			String sqlDir, String databaseName, int population)
		throws IOException {

		String suffix = getSuffix(population);

		StringBundler sb = new StringBundler(14);

		sb.append("drop database ");
		sb.append(databaseName);
		sb.append(";\n");
		sb.append("create database ");
		sb.append(databaseName);
		sb.append(";\n");
		sb.append("connect to ");
		sb.append(databaseName);
		sb.append(";\n");
		sb.append(
			readFile(
				sqlDir + "/portal" + suffix + "/portal" + suffix +
					"-derby.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/indexes/indexes-derby.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/sequences/sequences-derby.sql"));

		return sb.toString();
	}

	protected String getServerName() {
		return "derby";
	}

	protected String[] getTemplate() {
		return _DERBY;
	}

	protected String reword(String data) throws IOException {
		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new UnsyncStringReader(data));

		StringBundler sb = new StringBundler();

		String line = null;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			if (line.startsWith(ALTER_COLUMN_NAME) ||
				line.startsWith(ALTER_COLUMN_TYPE)) {

				line = "-- " + line;

				if (_log.isWarnEnabled()) {
					_log.warn(
						"This statement is not supported by Derby: " + line);
				}
			}
			else if (line.indexOf(DROP_INDEX) != -1) {
				String[] tokens = StringUtil.split(line, " ");

				line = StringUtil.replace(
					"drop index @index@;", "@index@", tokens[2]);
			}

			sb.append(line);
			sb.append("\n");
		}

		unsyncBufferedReader.close();

		return sb.toString();
	}

	private static String[] _DERBY = {
		"--", "1", "0",
		"'1970-01-01-00.00.00.000000'", "current timestamp",
		" blob", " smallint", " timestamp",
		" double", " integer", " bigint",
		" varchar(4000)", " clob", " varchar",
		" generated always as identity", "commit"
	};

	private static final boolean _SUPPORTS_ALTER_COLUMN_NAME = false;

	private static final boolean _SUPPORTS_ALTER_COLUMN_TYPE = false;

	private static Log _log = LogFactoryUtil.getLog(DerbyDB.class);

	private static DerbyDB _instance = new DerbyDB();

}