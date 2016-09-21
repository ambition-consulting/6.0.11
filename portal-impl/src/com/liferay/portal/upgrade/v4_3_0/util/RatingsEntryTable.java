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
public class RatingsEntryTable {

	public static String TABLE_NAME = "RatingsEntry";

	public static Object[][] TABLE_COLUMNS = {
		{"entryId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"score", new Integer(Types.DOUBLE)}
	};

	public static String TABLE_SQL_CREATE = "create table RatingsEntry (entryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,score DOUBLE)";

	public static String TABLE_SQL_DROP = "drop table RatingsEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_16184D57 on RatingsEntry (classNameId, classPK)",
		"create index IX_B47E3C11 on RatingsEntry (userId, classNameId, classPK)"
	};

}