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
public class CountryTable {

	public static String TABLE_NAME = "Country";

	public static Object[][] TABLE_COLUMNS = {
		{"countryId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"a2", new Integer(Types.VARCHAR)},
		{"a3", new Integer(Types.VARCHAR)},
		{"number_", new Integer(Types.VARCHAR)},
		{"idd_", new Integer(Types.VARCHAR)},
		{"active_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Country (countryId LONG not null primary key,name VARCHAR(75) null,a2 VARCHAR(75) null,a3 VARCHAR(75) null,number_ VARCHAR(75) null,idd_ VARCHAR(75) null,active_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Country";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_25D734CD on Country (active_)"
	};

}