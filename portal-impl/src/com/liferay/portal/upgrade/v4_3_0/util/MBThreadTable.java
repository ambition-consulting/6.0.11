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
public class MBThreadTable {

	public static String TABLE_NAME = "MBThread";

	public static Object[][] TABLE_COLUMNS = {
		{"threadId", new Integer(Types.BIGINT)},
		{"categoryId", new Integer(Types.BIGINT)},
		{"rootMessageId", new Integer(Types.BIGINT)},
		{"messageCount", new Integer(Types.INTEGER)},
		{"viewCount", new Integer(Types.INTEGER)},
		{"lastPostByUserId", new Integer(Types.BIGINT)},
		{"lastPostDate", new Integer(Types.TIMESTAMP)},
		{"priority", new Integer(Types.DOUBLE)}
	};

	public static String TABLE_SQL_CREATE = "create table MBThread (threadId LONG not null primary key,categoryId LONG,rootMessageId LONG,messageCount INTEGER,viewCount INTEGER,lastPostByUserId LONG,lastPostDate DATE null,priority DOUBLE)";

	public static String TABLE_SQL_DROP = "drop table MBThread";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_CB854772 on MBThread (categoryId)"
	};

}