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
public class RoleTable {

	public static String TABLE_NAME = "Role_";

	public static Object[][] TABLE_COLUMNS = {
		{"roleId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"type_", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table Role_ (roleId LONG not null primary key,companyId LONG,classNameId LONG,classPK LONG,name VARCHAR(75) null,description STRING null,type_ INTEGER)";

	public static String TABLE_SQL_DROP = "drop table Role_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_449A10B9 on Role_ (companyId)",
		"create index IX_A88E424E on Role_ (companyId, classNameId, classPK)",
		"create index IX_EBC931B8 on Role_ (companyId, name)"
	};

}