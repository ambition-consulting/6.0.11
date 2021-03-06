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
public class ListTypeTable {

	public static String TABLE_NAME = "ListType";

	public static Object[][] TABLE_COLUMNS = {
		{"listTypeId", new Integer(Types.INTEGER)},
		{"name", new Integer(Types.VARCHAR)},
		{"type_", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table ListType (listTypeId INTEGER not null primary key,name VARCHAR(75) null,type_ VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table ListType";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_2932DD37 on ListType (type_)"
	};

}