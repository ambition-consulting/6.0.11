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
public class WebsiteTable {

	public static String TABLE_NAME = "Website";

	public static Object[][] TABLE_COLUMNS = {
		{"websiteId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"url", new Integer(Types.VARCHAR)},
		{"typeId", new Integer(Types.INTEGER)},
		{"primary_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Website (websiteId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,url VARCHAR(75) null,typeId INTEGER,primary_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Website";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_96F07007 on Website (companyId)",
		"create index IX_4F0F0CA7 on Website (companyId, classNameId)",
		"create index IX_F960131C on Website (companyId, classNameId, classPK)",
		"create index IX_1AA07A6D on Website (companyId, classNameId, classPK, primary_)",
		"create index IX_F75690BB on Website (userId)"
	};

}