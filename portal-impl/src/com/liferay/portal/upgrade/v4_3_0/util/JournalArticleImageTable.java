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
public class JournalArticleImageTable {

	public static String TABLE_NAME = "JournalArticleImage";

	public static Object[][] TABLE_COLUMNS = {
		{"articleImageId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"articleId", new Integer(Types.VARCHAR)},
		{"version", new Integer(Types.DOUBLE)},
		{"elName", new Integer(Types.VARCHAR)},
		{"languageId", new Integer(Types.VARCHAR)},
		{"tempImage", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table JournalArticleImage (articleImageId LONG not null primary key,groupId LONG,articleId VARCHAR(75) null,version DOUBLE,elName VARCHAR(75) null,languageId VARCHAR(75) null,tempImage BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table JournalArticleImage";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_158B526F on JournalArticleImage (groupId, articleId, version)",
		"create index IX_D67292FC on JournalArticleImage (groupId, articleId, version, elName, languageId)",
		"create index IX_D4121315 on JournalArticleImage (tempImage)"
	};

}