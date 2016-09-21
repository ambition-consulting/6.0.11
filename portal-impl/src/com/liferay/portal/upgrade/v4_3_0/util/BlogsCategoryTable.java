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
public class BlogsCategoryTable {

	public static String TABLE_NAME = "BlogsCategory";

	public static Object[][] TABLE_COLUMNS = {
		{"categoryId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"parentCategoryId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table BlogsCategory (categoryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentCategoryId LONG,name VARCHAR(75) null,description STRING null)";

	public static String TABLE_SQL_DROP = "drop table BlogsCategory";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C49DD10C on BlogsCategory (parentCategoryId)"
	};

}