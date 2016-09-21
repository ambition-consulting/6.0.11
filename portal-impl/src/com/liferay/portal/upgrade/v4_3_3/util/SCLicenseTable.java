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
public class SCLicenseTable {

	public static String TABLE_NAME = "SCLicense";

	public static Object[][] TABLE_COLUMNS = {
		{"licenseId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"url", new Integer(Types.VARCHAR)},
		{"openSource", new Integer(Types.BOOLEAN)},
		{"active_", new Integer(Types.BOOLEAN)},
		{"recommended", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table SCLicense (licenseId LONG not null primary key,name VARCHAR(75) null,url STRING null,openSource BOOLEAN,active_ BOOLEAN,recommended BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table SCLicense";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_1C841592 on SCLicense (active_)",
		"create index IX_5327BB79 on SCLicense (active_, recommended)"
	};

}