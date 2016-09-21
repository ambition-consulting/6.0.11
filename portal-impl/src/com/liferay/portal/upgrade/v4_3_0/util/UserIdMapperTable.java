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
public class UserIdMapperTable {

	public static String TABLE_NAME = "UserIdMapper";

	public static Object[][] TABLE_COLUMNS = {
		{"userIdMapperId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"type_", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"externalUserId", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table UserIdMapper (userIdMapperId LONG not null primary key,userId LONG,type_ VARCHAR(75) null,description VARCHAR(75) null,externalUserId VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table UserIdMapper";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_E60EA987 on UserIdMapper (userId)",
		"create index IX_D1C44A6E on UserIdMapper (userId, type_)"
	};

}