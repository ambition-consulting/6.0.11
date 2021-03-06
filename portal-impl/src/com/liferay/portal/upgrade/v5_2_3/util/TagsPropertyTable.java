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

package com.liferay.portal.upgrade.v5_2_3.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class TagsPropertyTable {

	public static final String TABLE_NAME = "TagsProperty";

	public static final Object[][] TABLE_COLUMNS = {
		{"propertyId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"entryId", new Integer(Types.BIGINT)},
		{"key_", new Integer(Types.VARCHAR)},
		{"value", new Integer(Types.VARCHAR)}
	};

	public static final String TABLE_SQL_CREATE = "create table TagsProperty (propertyId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,entryId LONG,key_ VARCHAR(75) null,value VARCHAR(255) null)";

	public static final String TABLE_SQL_DROP = "drop table TagsProperty";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C134234 on TagsProperty (companyId)",
		"create index IX_EB974D08 on TagsProperty (companyId, key_)",
		"create index IX_5200A629 on TagsProperty (entryId)",
		"create unique index IX_F505253D on TagsProperty (entryId, key_)"
	};

}