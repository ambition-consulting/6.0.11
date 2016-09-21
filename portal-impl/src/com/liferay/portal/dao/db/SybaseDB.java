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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Alexander Chow
 * @author Bruno Farache
 * @author Sandeep Soni
 * @author Ganesh Ram
 */
public class SybaseDB extends BaseDB {

	public static DB getInstance() {
		return _instance;
	}

	public String buildSQL(String template) throws IOException {
		template = convertTimestamp(template);
		template = replaceTemplate(template, getTemplate());

		template = reword(template);
		template = StringUtil.replace(template, ");\n", ")\ngo\n");
		template = StringUtil.replace(template, "\ngo;\n", "\ngo\n");
		template = StringUtil.replace(
			template,
			new String[] {"\\\\", "\\'", "\\\"", "\\n", "\\r"},
			new String[] {"\\", "''", "\"", "\n", "\r"});

		return template;
	}

	public boolean isSupportsInlineDistinct() {
		return _SUPPORTS_INLINE_DISTINCT;
	}

	protected SybaseDB() {
		super(TYPE_SYBASE);
	}

	protected String buildCreateFileContent(
			String sqlDir, String databaseName, int population)
		throws IOException {

		String suffix = getSuffix(population);

		StringBundler sb = new StringBundler(19);

		sb.append("use master\n");
		sb.append("exec sp_dboption '");
		sb.append(databaseName);
		sb.append("', ");
		sb.append("'allow nulls by default' , true\n");
		sb.append("go\n\n");
		sb.append("exec sp_dboption '");
		sb.append(databaseName);
		sb.append("', ");
		sb.append("'select into/bulkcopy/pllsort' , true\n");
		sb.append("go\n\n");

		sb.append("use ");
		sb.append(databaseName);
		sb.append("\n\n");
		sb.append(
			readFile(
				sqlDir + "/portal" + suffix + "/portal" + suffix +
					"-sybase.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/indexes/indexes-sybase.sql"));
		sb.append("\n\n");
		sb.append(readFile(sqlDir + "/sequences/sequences-sybase.sql"));

		return sb.toString();
	}

	protected String getServerName() {
		return "sybase";
	}

	protected String[] getTemplate() {
		return _SYBASE;
	}

	protected String reword(String data) throws IOException {
		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new UnsyncStringReader(data));

		StringBundler sb = new StringBundler();

		String line = null;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			if (line.indexOf(DROP_COLUMN) != -1) {
				line = StringUtil.replace(line, " drop column ", " drop ");
			}

			if (line.startsWith(ALTER_COLUMN_NAME)) {
				String[] template = buildColumnNameTokens(line);

				line = StringUtil.replace(
					"exec sp_rename '@table@.@old-column@', '@new-column@', " +
						"'column';",
					REWORD_TEMPLATE, template);
			}
			else if (line.startsWith(ALTER_COLUMN_TYPE)) {
				String[] template = buildColumnTypeTokens(line);

				line = StringUtil.replace(
					"alter table @table@ alter column @old-column@ @type@;",
					REWORD_TEMPLATE, template);
			}
			else if (line.indexOf(DROP_INDEX) != -1) {
				String[] tokens = StringUtil.split(line, " ");

				String tableName = tokens[4];

				if (tableName.endsWith(StringPool.SEMICOLON)) {
					tableName = tableName.substring(0, tableName.length() - 1);
				}

				line = StringUtil.replace(
					"drop index @table@.@index@;", "@table@", tableName);
				line = StringUtil.replace(line, "@index@", tokens[2]);
			}

			sb.append(line);
			sb.append("\n");
		}

		unsyncBufferedReader.close();

		return sb.toString();
	}

	protected static String DROP_COLUMN = "drop column";

	private static final boolean _SUPPORTS_INLINE_DISTINCT = false;

	private static String[] _SYBASE = {
		"--", "1", "0",
		"'19700101'", "getdate()",
		" image", " int", " datetime",
		" float", " int", " decimal(20,0)",
		" varchar(1000)", " text", " varchar",
		"  identity(1,1)", "go"
	};

	private static SybaseDB _instance = new SybaseDB();

}