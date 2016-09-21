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
public class MBStatsUserTable {

	public static String TABLE_NAME = "MBStatsUser";

	public static Object[][] TABLE_COLUMNS = {
		{"statsUserId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"messageCount", new Integer(Types.INTEGER)},
		{"lastPostDate", new Integer(Types.TIMESTAMP)}
	};

	public static String TABLE_SQL_CREATE = "create table MBStatsUser (statsUserId LONG not null primary key,groupId LONG,userId LONG,messageCount INTEGER,lastPostDate DATE null)";

	public static String TABLE_SQL_DROP = "drop table MBStatsUser";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_A00A898F on MBStatsUser (groupId)",
		"create index IX_FAB5A88B on MBStatsUser (groupId, messageCount)",
		"create index IX_9168E2C9 on MBStatsUser (groupId, userId)",
		"create index IX_847F92B5 on MBStatsUser (userId)"
	};

}