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
public class SCProductEntryTable {

	public static String TABLE_NAME = "SCProductEntry";

	public static Object[][] TABLE_COLUMNS = {
		{"productEntryId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"name", new Integer(Types.VARCHAR)},
		{"type_", new Integer(Types.VARCHAR)},
		{"tags", new Integer(Types.VARCHAR)},
		{"shortDescription", new Integer(Types.VARCHAR)},
		{"longDescription", new Integer(Types.VARCHAR)},
		{"pageURL", new Integer(Types.VARCHAR)},
		{"author", new Integer(Types.VARCHAR)},
		{"repoGroupId", new Integer(Types.VARCHAR)},
		{"repoArtifactId", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table SCProductEntry (productEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,type_ VARCHAR(75) null,tags VARCHAR(300) null,shortDescription STRING null,longDescription STRING null,pageURL STRING null,author VARCHAR(75) null,repoGroupId VARCHAR(75) null,repoArtifactId VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table SCProductEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_5D25244F on SCProductEntry (companyId)",
		"create index IX_72F87291 on SCProductEntry (groupId)",
		"create index IX_98E6A9CB on SCProductEntry (groupId, userId)"
	};

}