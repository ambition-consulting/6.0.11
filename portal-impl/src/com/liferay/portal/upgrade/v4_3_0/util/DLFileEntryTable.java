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

package com.liferay.portal.upgrade.v4_3_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class DLFileEntryTable {

	public static String TABLE_NAME = "DLFileEntry";

	public static Object[][] TABLE_COLUMNS = {
		{"fileEntryId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"versionUserId", new Integer(Types.BIGINT)},
		{"versionUserName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"folderId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"version", new Integer(Types.DOUBLE)},
		{"size_", new Integer(Types.INTEGER)},
		{"readCount", new Integer(Types.INTEGER)},
		{"extraSettings", new Integer(Types.CLOB)}
	};

	public static String TABLE_SQL_CREATE = "create table DLFileEntry (fileEntryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,versionUserId LONG,versionUserName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,folderId LONG,name VARCHAR(300) null,title VARCHAR(300) null,description STRING null,version DOUBLE,size_ INTEGER,readCount INTEGER,extraSettings TEXT null)";

	public static String TABLE_SQL_DROP = "drop table DLFileEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_24A846D1 on DLFileEntry (folderId)",
		"create index IX_8F6C75D0 on DLFileEntry (folderId, name)"
	};

}