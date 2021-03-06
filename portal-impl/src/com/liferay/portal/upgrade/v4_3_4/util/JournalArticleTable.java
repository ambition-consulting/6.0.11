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

package com.liferay.portal.upgrade.v4_3_4.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class JournalArticleTable {

	public static String TABLE_NAME = "JournalArticle";

	public static Object[][] TABLE_COLUMNS = {
		{"id_", new Integer(Types.BIGINT)},
		{"resourcePrimKey", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"articleId", new Integer(Types.VARCHAR)},
		{"version", new Integer(Types.DOUBLE)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"content", new Integer(Types.CLOB)},
		{"type_", new Integer(Types.VARCHAR)},
		{"structureId", new Integer(Types.VARCHAR)},
		{"templateId", new Integer(Types.VARCHAR)},
		{"displayDate", new Integer(Types.TIMESTAMP)},
		{"approved", new Integer(Types.BOOLEAN)},
		{"approvedByUserId", new Integer(Types.BIGINT)},
		{"approvedByUserName", new Integer(Types.VARCHAR)},
		{"approvedDate", new Integer(Types.TIMESTAMP)},
		{"expired", new Integer(Types.BOOLEAN)},
		{"expirationDate", new Integer(Types.TIMESTAMP)},
		{"reviewDate", new Integer(Types.TIMESTAMP)},
		{"indexable", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table JournalArticle (id_ LONG not null primary key,resourcePrimKey LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,articleId VARCHAR(75) null,version DOUBLE,title VARCHAR(100) null,description STRING null,content TEXT null,type_ VARCHAR(75) null,structureId VARCHAR(75) null,templateId VARCHAR(75) null,displayDate DATE null,approved BOOLEAN,approvedByUserId LONG,approvedByUserName VARCHAR(75) null,approvedDate DATE null,expired BOOLEAN,expirationDate DATE null,reviewDate DATE null,indexable BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table JournalArticle";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_DFF98523 on JournalArticle (companyId)",
		"create index IX_9356F865 on JournalArticle (groupId)",
		"create index IX_68C0F69C on JournalArticle (groupId, articleId)",
		"create index IX_8DBF1387 on JournalArticle (groupId, articleId, approved)",
		"create index IX_85C52EEC on JournalArticle (groupId, articleId, version)",
		"create index IX_2E207659 on JournalArticle (groupId, structureId)",
		"create index IX_8DEAE14E on JournalArticle (groupId, templateId)"
	};

}