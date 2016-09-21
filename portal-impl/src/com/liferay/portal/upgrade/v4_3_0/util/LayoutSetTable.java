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
public class LayoutSetTable {

	public static String TABLE_NAME = "LayoutSet";

	public static Object[][] TABLE_COLUMNS = {
		{"layoutSetId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"privateLayout", new Integer(Types.BOOLEAN)},
		{"logo", new Integer(Types.BOOLEAN)},
		{"logoId", new Integer(Types.BIGINT)},
		{"themeId", new Integer(Types.VARCHAR)},
		{"colorSchemeId", new Integer(Types.VARCHAR)},
		{"wapThemeId", new Integer(Types.VARCHAR)},
		{"wapColorSchemeId", new Integer(Types.VARCHAR)},
		{"css", new Integer(Types.VARCHAR)},
		{"pageCount", new Integer(Types.INTEGER)},
		{"virtualHost", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table LayoutSet (layoutSetId LONG not null primary key,groupId LONG,companyId LONG,privateLayout BOOLEAN,logo BOOLEAN,logoId LONG,themeId VARCHAR(75) null,colorSchemeId VARCHAR(75) null,wapThemeId VARCHAR(75) null,wapColorSchemeId VARCHAR(75) null,css VARCHAR(75) null,pageCount INTEGER,virtualHost VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table LayoutSet";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_A40B8BEC on LayoutSet (groupId)",
		"create index IX_48550691 on LayoutSet (groupId, privateLayout)",
		"create index IX_5ABC2905 on LayoutSet (virtualHost)"
	};

}