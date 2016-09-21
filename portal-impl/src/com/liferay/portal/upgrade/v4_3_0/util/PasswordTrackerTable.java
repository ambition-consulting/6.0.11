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
public class PasswordTrackerTable {

	public static String TABLE_NAME = "PasswordTracker";

	public static Object[][] TABLE_COLUMNS = {
		{"passwordTrackerId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"password_", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table PasswordTracker (passwordTrackerId LONG not null primary key,userId LONG,createDate DATE null,password_ VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table PasswordTracker";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_326F75BD on PasswordTracker (userId)"
	};

}