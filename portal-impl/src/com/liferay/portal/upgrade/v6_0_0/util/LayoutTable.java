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

package com.liferay.portal.upgrade.v6_0_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class LayoutTable {

	public static final String TABLE_NAME = "Layout";

	public static final Object[][] TABLE_COLUMNS = {
		{"plid", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"privateLayout", new Integer(Types.BOOLEAN)},
		{"layoutId", new Integer(Types.BIGINT)},
		{"parentLayoutId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"type_", new Integer(Types.VARCHAR)},
		{"typeSettings", new Integer(Types.CLOB)},
		{"hidden_", new Integer(Types.BOOLEAN)},
		{"friendlyURL", new Integer(Types.VARCHAR)},
		{"iconImage", new Integer(Types.BOOLEAN)},
		{"iconImageId", new Integer(Types.BIGINT)},
		{"themeId", new Integer(Types.VARCHAR)},
		{"colorSchemeId", new Integer(Types.VARCHAR)},
		{"wapThemeId", new Integer(Types.VARCHAR)},
		{"wapColorSchemeId", new Integer(Types.VARCHAR)},
		{"css", new Integer(Types.VARCHAR)},
		{"priority", new Integer(Types.INTEGER)},
		{"layoutPrototypeId", new Integer(Types.BIGINT)},
		{"dlFolderId", new Integer(Types.BIGINT)}
	};

	public static final String TABLE_SQL_CREATE = "create table Layout (plid LONG not null primary key,groupId LONG,companyId LONG,privateLayout BOOLEAN,layoutId LONG,parentLayoutId LONG,name STRING null,title STRING null,description STRING null,type_ VARCHAR(75) null,typeSettings TEXT null,hidden_ BOOLEAN,friendlyURL VARCHAR(255) null,iconImage BOOLEAN,iconImageId LONG,themeId VARCHAR(75) null,colorSchemeId VARCHAR(75) null,wapThemeId VARCHAR(75) null,wapColorSchemeId VARCHAR(75) null,css STRING null,priority INTEGER,layoutPrototypeId LONG,dlFolderId LONG)";

	public static final String TABLE_SQL_DROP = "drop table Layout";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C7FBC998 on Layout (companyId)",
		"create index IX_FAD05595 on Layout (dlFolderId)",
		"create index IX_C099D61A on Layout (groupId)",
		"create index IX_705F5AA3 on Layout (groupId, privateLayout)",
		"create unique index IX_BC2C4231 on Layout (groupId, privateLayout, friendlyURL)",
		"create unique index IX_7162C27C on Layout (groupId, privateLayout, layoutId)",
		"create index IX_6DE88B06 on Layout (groupId, privateLayout, parentLayoutId)",
		"create index IX_1A1B61D2 on Layout (groupId, privateLayout, type_)",
		"create index IX_23922F7D on Layout (iconImageId)"
	};

}