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
public class RegionTable {

	public static String TABLE_NAME = "Region";

	public static Object[][] TABLE_COLUMNS = {
		{"regionId", new Integer(Types.BIGINT)},
		{"countryId", new Integer(Types.BIGINT)},
		{"regionCode", new Integer(Types.VARCHAR)},
		{"name", new Integer(Types.VARCHAR)},
		{"active_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Region (regionId LONG not null primary key,countryId LONG,regionCode VARCHAR(75) null,name VARCHAR(75) null,active_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Region";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_2D9A426F on Region (active_)",
		"create index IX_16D87CA7 on Region (countryId)",
		"create index IX_11FB3E42 on Region (countryId, active_)"
	};

}