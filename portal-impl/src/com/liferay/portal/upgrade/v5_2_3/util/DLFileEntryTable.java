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

package com.liferay.portal.upgrade.v5_2_3.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class DLFileEntryTable {

	public static final String TABLE_NAME = "DLFileEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", new Integer(Types.VARCHAR)},
		{"fileEntryId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
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

	public static final String TABLE_SQL_CREATE = "create table DLFileEntry (uuid_ VARCHAR(75) null,fileEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,versionUserId LONG,versionUserName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,folderId LONG,name VARCHAR(255) null,title VARCHAR(255) null,description STRING null,version DOUBLE,size_ INTEGER,readCount INTEGER,extraSettings TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table DLFileEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_4CB1B2B4 on DLFileEntry (companyId)",
		"create index IX_24A846D1 on DLFileEntry (folderId)",
		"create unique index IX_8F6C75D0 on DLFileEntry (folderId, name)",
		"create index IX_A9951F17 on DLFileEntry (folderId, title)",
		"create index IX_F4AF5636 on DLFileEntry (groupId)",
		"create index IX_43261870 on DLFileEntry (groupId, userId)",
		"create index IX_64F0FE40 on DLFileEntry (uuid_)",
		"create unique index IX_BC2E7E6A on DLFileEntry (uuid_, groupId)"
	};

}