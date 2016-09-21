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
public class BlogsEntryTable {

	public static String TABLE_NAME = "BlogsEntry";

	public static Object[][] TABLE_COLUMNS = {
		{"entryId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"categoryId", new Integer(Types.BIGINT)},
		{"title", new Integer(Types.VARCHAR)},
		{"content", new Integer(Types.CLOB)},
		{"displayDate", new Integer(Types.TIMESTAMP)}
	};

	public static String TABLE_SQL_CREATE = "create table BlogsEntry (entryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,title VARCHAR(150) null,content TEXT null,displayDate DATE null)";

	public static String TABLE_SQL_DROP = "drop table BlogsEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_B0608DF4 on BlogsEntry (categoryId)",
		"create index IX_72EF6041 on BlogsEntry (companyId)",
		"create index IX_81A50303 on BlogsEntry (groupId)"
	};

}