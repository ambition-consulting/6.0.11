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

package com.liferay.portal.upgrade.v6_0_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class JournalTemplateTable {

	public static final String TABLE_NAME = "JournalTemplate";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", new Integer(Types.VARCHAR)},
		{"id_", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"templateId", new Integer(Types.VARCHAR)},
		{"structureId", new Integer(Types.VARCHAR)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"xsl", new Integer(Types.CLOB)},
		{"langType", new Integer(Types.VARCHAR)},
		{"cacheable", new Integer(Types.BOOLEAN)},
		{"smallImage", new Integer(Types.BOOLEAN)},
		{"smallImageId", new Integer(Types.BIGINT)},
		{"smallImageURL", new Integer(Types.VARCHAR)}
	};

	public static final String TABLE_SQL_CREATE = "create table JournalTemplate (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,templateId VARCHAR(75) null,structureId VARCHAR(75) null,name VARCHAR(75) null,description STRING null,xsl TEXT null,langType VARCHAR(75) null,cacheable BOOLEAN,smallImage BOOLEAN,smallImageId LONG,smallImageURL STRING null)";

	public static final String TABLE_SQL_DROP = "drop table JournalTemplate";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_77923653 on JournalTemplate (groupId)",
		"create index IX_1701CB2B on JournalTemplate (groupId, structureId)",
		"create unique index IX_E802AA3C on JournalTemplate (groupId, templateId)",
		"create index IX_25FFB6FA on JournalTemplate (smallImageId)",
		"create index IX_1B12CA20 on JournalTemplate (templateId)",
		"create index IX_2857419D on JournalTemplate (uuid_)",
		"create unique index IX_62D1B3AD on JournalTemplate (uuid_, groupId)"
	};

}