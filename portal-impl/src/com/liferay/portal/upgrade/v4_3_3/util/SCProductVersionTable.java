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
public class SCProductVersionTable {

	public static String TABLE_NAME = "SCProductVersion";

	public static Object[][] TABLE_COLUMNS = {
		{"productVersionId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"productEntryId", new Integer(Types.BIGINT)},
		{"version", new Integer(Types.VARCHAR)},
		{"changeLog", new Integer(Types.VARCHAR)},
		{"downloadPageURL", new Integer(Types.VARCHAR)},
		{"directDownloadURL", new Integer(Types.VARCHAR)},
		{"repoStoreArtifact", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table SCProductVersion (productVersionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,productEntryId LONG,version VARCHAR(75) null,changeLog STRING null,downloadPageURL STRING null,directDownloadURL STRING null,repoStoreArtifact BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table SCProductVersion";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_8377A211 on SCProductVersion (productEntryId)"
	};

}