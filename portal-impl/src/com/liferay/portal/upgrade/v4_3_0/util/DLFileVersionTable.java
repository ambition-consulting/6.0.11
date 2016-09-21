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
public class DLFileVersionTable {

	public static String TABLE_NAME = "DLFileVersion";

	public static Object[][] TABLE_COLUMNS = {
		{"fileVersionId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"folderId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"version", new Integer(Types.DOUBLE)},
		{"size_", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table DLFileVersion (fileVersionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,folderId LONG,name VARCHAR(300) null,version DOUBLE,size_ INTEGER)";

	public static String TABLE_SQL_DROP = "drop table DLFileVersion";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_9CD91DB6 on DLFileVersion (folderId, name)",
		"create index IX_6C5E6512 on DLFileVersion (folderId, name, version)"
	};

}