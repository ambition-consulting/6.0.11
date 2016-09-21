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
public class ShoppingItemFieldTable {

	public static String TABLE_NAME = "ShoppingItemField";

	public static Object[][] TABLE_COLUMNS = {
		{"itemFieldId", new Integer(Types.BIGINT)},
		{"itemId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"values_", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table ShoppingItemField (itemFieldId LONG not null primary key,itemId LONG,name VARCHAR(75) null,values_ STRING null,description STRING null)";

	public static String TABLE_SQL_DROP = "drop table ShoppingItemField";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_6D5F9B87 on ShoppingItemField (itemId)"
	};

}