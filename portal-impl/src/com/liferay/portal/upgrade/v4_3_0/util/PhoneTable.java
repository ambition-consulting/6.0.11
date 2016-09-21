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
public class PhoneTable {

	public static String TABLE_NAME = "Phone";

	public static Object[][] TABLE_COLUMNS = {
		{"phoneId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"number_", new Integer(Types.VARCHAR)},
		{"extension", new Integer(Types.VARCHAR)},
		{"typeId", new Integer(Types.INTEGER)},
		{"primary_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Phone (phoneId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,number_ VARCHAR(75) null,extension VARCHAR(75) null,typeId INTEGER,primary_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Phone";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_9F704A14 on Phone (companyId)",
		"create index IX_A2E4AFBA on Phone (companyId, classNameId)",
		"create index IX_9A53569 on Phone (companyId, classNameId, classPK)",
		"create index IX_812CE07A on Phone (companyId, classNameId, classPK, primary_)",
		"create index IX_F202B9CE on Phone (userId)"
	};

}