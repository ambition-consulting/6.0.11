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
public class PermissionTable {

	public static String TABLE_NAME = "Permission_";

	public static Object[][] TABLE_COLUMNS = {
		{"permissionId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"actionId", new Integer(Types.VARCHAR)},
		{"resourceId", new Integer(Types.BIGINT)}
	};

	public static String TABLE_SQL_CREATE = "create table Permission_ (permissionId LONG not null primary key,companyId LONG,actionId VARCHAR(75) null,resourceId LONG)";

	public static String TABLE_SQL_DROP = "drop table Permission_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_4D19C2B8 on Permission_ (actionId, resourceId)",
		"create index IX_F090C113 on Permission_ (resourceId)"
	};

}