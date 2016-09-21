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

package com.liferay.portal.upgrade.v4_3_4.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class ClassNameTable {

	public static String TABLE_NAME = "ClassName_";

	public static Object[][] TABLE_COLUMNS = {
		{"classNameId", new Integer(Types.BIGINT)},
		{"value", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table ClassName_ (classNameId LONG not null primary key,value VARCHAR(200) null)";

	public static String TABLE_SQL_DROP = "drop table ClassName_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_B27A301F on ClassName_ (value)"
	};

}