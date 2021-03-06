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
public class JournalStructureTable {

	public static String TABLE_NAME = "JournalStructure";

	public static Object[][] TABLE_COLUMNS = {
		{"id_", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"structureId", new Integer(Types.VARCHAR)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"xsd", new Integer(Types.CLOB)}
	};

	public static String TABLE_SQL_CREATE = "create table JournalStructure (id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,structureId VARCHAR(75) null,name VARCHAR(75) null,description STRING null,xsd TEXT null)";

	public static String TABLE_SQL_DROP = "drop table JournalStructure";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_B97F5608 on JournalStructure (groupId)",
		"create index IX_AB6E9996 on JournalStructure (groupId, structureId)",
		"create index IX_8831E4FC on JournalStructure (structureId)"
	};

}