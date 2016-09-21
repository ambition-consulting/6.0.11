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
public class DLFileShortcutTable {

	public static String TABLE_NAME = "DLFileShortcut";

	public static Object[][] TABLE_COLUMNS = {
		{"fileShortcutId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"folderId", new Integer(Types.BIGINT)},
		{"toFolderId", new Integer(Types.BIGINT)},
		{"toName", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table DLFileShortcut (fileShortcutId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,folderId LONG,toFolderId LONG,toName VARCHAR(300) null)";

	public static String TABLE_SQL_DROP = "drop table DLFileShortcut";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_E56EC6AD on DLFileShortcut (folderId)",
		"create index IX_CA2708A2 on DLFileShortcut (toFolderId, toName)"
	};

}