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
public class CalEventTable {

	public static String TABLE_NAME = "CalEvent";

	public static Object[][] TABLE_COLUMNS = {
		{"eventId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"startDate", new Integer(Types.TIMESTAMP)},
		{"endDate", new Integer(Types.TIMESTAMP)},
		{"durationHour", new Integer(Types.INTEGER)},
		{"durationMinute", new Integer(Types.INTEGER)},
		{"allDay", new Integer(Types.BOOLEAN)},
		{"timeZoneSensitive", new Integer(Types.BOOLEAN)},
		{"type_", new Integer(Types.VARCHAR)},
		{"repeating", new Integer(Types.BOOLEAN)},
		{"recurrence", new Integer(Types.CLOB)},
		{"remindBy", new Integer(Types.VARCHAR)},
		{"firstReminder", new Integer(Types.INTEGER)},
		{"secondReminder", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table CalEvent (eventId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,description STRING null,startDate DATE null,endDate DATE null,durationHour INTEGER,durationMinute INTEGER,allDay BOOLEAN,timeZoneSensitive BOOLEAN,type_ VARCHAR(75) null,repeating BOOLEAN,recurrence TEXT null,remindBy VARCHAR(75) null,firstReminder INTEGER,secondReminder INTEGER)";

	public static String TABLE_SQL_DROP = "drop table CalEvent";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_12EE4898 on CalEvent (groupId)",
		"create index IX_4FDDD2BF on CalEvent (groupId, repeating)",
		"create index IX_FCD7C63D on CalEvent (groupId, type_)"
	};

}