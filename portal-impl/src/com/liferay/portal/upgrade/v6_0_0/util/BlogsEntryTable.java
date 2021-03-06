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

package com.liferay.portal.upgrade.v6_0_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class BlogsEntryTable {

	public static final String TABLE_NAME = "BlogsEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", new Integer(Types.VARCHAR)},
		{"entryId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"title", new Integer(Types.VARCHAR)},
		{"urlTitle", new Integer(Types.VARCHAR)},
		{"content", new Integer(Types.CLOB)},
		{"displayDate", new Integer(Types.TIMESTAMP)},
		{"allowPingbacks", new Integer(Types.BOOLEAN)},
		{"allowTrackbacks", new Integer(Types.BOOLEAN)},
		{"trackbacks", new Integer(Types.CLOB)},
		{"status", new Integer(Types.INTEGER)},
		{"statusByUserId", new Integer(Types.BIGINT)},
		{"statusByUserName", new Integer(Types.VARCHAR)},
		{"statusDate", new Integer(Types.TIMESTAMP)}
	};

	public static final String TABLE_SQL_CREATE = "create table BlogsEntry (uuid_ VARCHAR(75) null,entryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(150) null,urlTitle VARCHAR(150) null,content TEXT null,displayDate DATE null,allowPingbacks BOOLEAN,allowTrackbacks BOOLEAN,trackbacks TEXT null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table BlogsEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_72EF6041 on BlogsEntry (companyId)",
		"create index IX_430D791F on BlogsEntry (companyId, displayDate)",
		"create index IX_BB0C2905 on BlogsEntry (companyId, displayDate, status)",
		"create index IX_EB2DCE27 on BlogsEntry (companyId, status)",
		"create index IX_8CACE77B on BlogsEntry (companyId, userId)",
		"create index IX_A5F57B61 on BlogsEntry (companyId, userId, status)",
		"create index IX_81A50303 on BlogsEntry (groupId)",
		"create index IX_621E19D on BlogsEntry (groupId, displayDate)",
		"create index IX_F0E73383 on BlogsEntry (groupId, displayDate, status)",
		"create index IX_1EFD8EE9 on BlogsEntry (groupId, status)",
		"create unique index IX_DB780A20 on BlogsEntry (groupId, urlTitle)",
		"create index IX_FBDE0AA3 on BlogsEntry (groupId, userId, displayDate)",
		"create index IX_DA04F689 on BlogsEntry (groupId, userId, displayDate, status)",
		"create index IX_49E15A23 on BlogsEntry (groupId, userId, status)",
		"create index IX_69157A4D on BlogsEntry (uuid_)",
		"create unique index IX_1B1040FD on BlogsEntry (uuid_, groupId)"
	};

}