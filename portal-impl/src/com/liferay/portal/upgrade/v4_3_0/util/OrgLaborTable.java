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
public class OrgLaborTable {

	public static String TABLE_NAME = "OrgLabor";

	public static Object[][] TABLE_COLUMNS = {
		{"orgLaborId", new Integer(Types.BIGINT)},
		{"organizationId", new Integer(Types.BIGINT)},
		{"typeId", new Integer(Types.INTEGER)},
		{"sunOpen", new Integer(Types.INTEGER)},
		{"sunClose", new Integer(Types.INTEGER)},
		{"monOpen", new Integer(Types.INTEGER)},
		{"monClose", new Integer(Types.INTEGER)},
		{"tueOpen", new Integer(Types.INTEGER)},
		{"tueClose", new Integer(Types.INTEGER)},
		{"wedOpen", new Integer(Types.INTEGER)},
		{"wedClose", new Integer(Types.INTEGER)},
		{"thuOpen", new Integer(Types.INTEGER)},
		{"thuClose", new Integer(Types.INTEGER)},
		{"friOpen", new Integer(Types.INTEGER)},
		{"friClose", new Integer(Types.INTEGER)},
		{"satOpen", new Integer(Types.INTEGER)},
		{"satClose", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table OrgLabor (orgLaborId LONG not null primary key,organizationId LONG,typeId INTEGER,sunOpen INTEGER,sunClose INTEGER,monOpen INTEGER,monClose INTEGER,tueOpen INTEGER,tueClose INTEGER,wedOpen INTEGER,wedClose INTEGER,thuOpen INTEGER,thuClose INTEGER,friOpen INTEGER,friClose INTEGER,satOpen INTEGER,satClose INTEGER)";

	public static String TABLE_SQL_DROP = "drop table OrgLabor";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_6AF0D434 on OrgLabor (organizationId)"
	};

}