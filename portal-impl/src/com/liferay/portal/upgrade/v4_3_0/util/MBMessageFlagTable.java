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
public class MBMessageFlagTable {

	public static String TABLE_NAME = "MBMessageFlag";

	public static Object[][] TABLE_COLUMNS = {
		{"messageFlagId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"messageId", new Integer(Types.BIGINT)},
		{"flag", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table MBMessageFlag (messageFlagId LONG not null primary key,userId LONG,messageId LONG,flag INTEGER)";

	public static String TABLE_SQL_DROP = "drop table MBMessageFlag";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_D180D4AE on MBMessageFlag (messageId)",
		"create index IX_7B2917BE on MBMessageFlag (userId)",
		"create index IX_94A83834 on MBMessageFlag (userId, messageId)"
	};

}