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
public class DLFolderTable {

	public static String TABLE_NAME = "DLFolder";

	public static Object[][] TABLE_COLUMNS = {
		{"folderId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"parentFolderId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"lastPostDate", new Integer(Types.TIMESTAMP)}
	};

	public static String TABLE_SQL_CREATE = "create table DLFolder (folderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentFolderId LONG,name VARCHAR(100) null,description STRING null,lastPostDate DATE null)";

	public static String TABLE_SQL_DROP = "drop table DLFolder";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_A74DB14C on DLFolder (companyId)",
		"create index IX_F2EA1ACE on DLFolder (groupId)",
		"create index IX_49C37475 on DLFolder (groupId, parentFolderId)",
		"create index IX_51556082 on DLFolder (parentFolderId, name)"
	};

}