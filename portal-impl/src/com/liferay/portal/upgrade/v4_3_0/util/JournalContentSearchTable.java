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
public class JournalContentSearchTable {

	public static String TABLE_NAME = "JournalContentSearch";

	public static Object[][] TABLE_COLUMNS = {
		{"contentSearchId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"privateLayout", new Integer(Types.BOOLEAN)},
		{"layoutId", new Integer(Types.BIGINT)},
		{"portletId", new Integer(Types.VARCHAR)},
		{"articleId", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table JournalContentSearch (contentSearchId LONG not null primary key,groupId LONG,companyId LONG,privateLayout BOOLEAN,layoutId LONG,portletId VARCHAR(200) null,articleId VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table JournalContentSearch";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_6838E427 on JournalContentSearch (groupId, articleId)",
		"create index IX_20962903 on JournalContentSearch (groupId, privateLayout)",
		"create index IX_7CC7D73E on JournalContentSearch (groupId, privateLayout, articleId)",
		"create index IX_B3B318DC on JournalContentSearch (groupId, privateLayout, layoutId)",
		"create index IX_C3AA93B8 on JournalContentSearch (groupId, privateLayout, layoutId, portletId, articleId)"
	};

}