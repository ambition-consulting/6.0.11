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
public class MBBanTable {

	public static String TABLE_NAME = "MBBan";

	public static Object[][] TABLE_COLUMNS = {
		{"banId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"banUserId", new Integer(Types.BIGINT)}
	};

	public static String TABLE_SQL_CREATE = "create table MBBan (banId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,banUserId LONG)";

	public static String TABLE_SQL_DROP = "drop table MBBan";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_69951A25 on MBBan (banUserId)",
		"create index IX_5C3FF12A on MBBan (groupId)",
		"create index IX_8ABC4E3B on MBBan (groupId, banUserId)",
		"create index IX_48814BBA on MBBan (userId)"
	};

}