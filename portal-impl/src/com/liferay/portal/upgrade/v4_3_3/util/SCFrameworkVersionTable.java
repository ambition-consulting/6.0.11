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

package com.liferay.portal.upgrade.v4_3_3.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class SCFrameworkVersionTable {

	public static String TABLE_NAME = "SCFrameworkVersion";

	public static Object[][] TABLE_COLUMNS = {
		{"frameworkVersionId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"name", new Integer(Types.VARCHAR)},
		{"url", new Integer(Types.VARCHAR)},
		{"active_", new Integer(Types.BOOLEAN)},
		{"priority", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table SCFrameworkVersion (frameworkVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,url STRING null,active_ BOOLEAN,priority INTEGER)";

	public static String TABLE_SQL_DROP = "drop table SCFrameworkVersion";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C98C0D78 on SCFrameworkVersion (companyId)",
		"create index IX_272991FA on SCFrameworkVersion (groupId)",
		"create index IX_6E1764F on SCFrameworkVersion (groupId, active_)"
	};

}