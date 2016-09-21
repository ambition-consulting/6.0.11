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

package com.liferay.portal.upgrade.v6_0_11.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class DLFileVersionTable {

	public static final String TABLE_NAME = "DLFileVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"fileVersionId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"fileEntryId", new Integer(Types.BIGINT)},
		{"extension", new Integer(Types.VARCHAR)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"changeLog", new Integer(Types.VARCHAR)},
		{"extraSettings", new Integer(Types.CLOB)},
		{"version", new Integer(Types.VARCHAR)},
		{"size_", new Integer(Types.BIGINT)},
		{"status", new Integer(Types.INTEGER)},
		{"statusByUserId", new Integer(Types.BIGINT)},
		{"statusByUserName", new Integer(Types.VARCHAR)},
		{"statusDate", new Integer(Types.TIMESTAMP)}
	};

	public static final String TABLE_SQL_CREATE = "create table DLFileVersion (fileVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,fileEntryId LONG,extension VARCHAR(75) null,title VARCHAR(255) null,description STRING null,changeLog VARCHAR(75) null,extraSettings TEXT null,version VARCHAR(75) null,size_ LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table DLFileVersion";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C68DC967 on DLFileVersion (fileEntryId)",
		"create index IX_D47BB14D on DLFileVersion (fileEntryId, status)",
		"create unique index IX_E2815081 on DLFileVersion (fileEntryId, version)"
	};

}