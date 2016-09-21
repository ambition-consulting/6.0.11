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
public class TagsAssetTable {

	public static String TABLE_NAME = "TagsAsset";

	public static Object[][] TABLE_COLUMNS = {
		{"assetId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"startDate", new Integer(Types.TIMESTAMP)},
		{"endDate", new Integer(Types.TIMESTAMP)},
		{"publishDate", new Integer(Types.TIMESTAMP)},
		{"expirationDate", new Integer(Types.TIMESTAMP)},
		{"mimeType", new Integer(Types.VARCHAR)},
		{"title", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"summary", new Integer(Types.VARCHAR)},
		{"url", new Integer(Types.VARCHAR)},
		{"height", new Integer(Types.INTEGER)},
		{"width", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table TagsAsset (assetId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,startDate DATE null,endDate DATE null,publishDate DATE null,expirationDate DATE null,mimeType VARCHAR(75) null,title VARCHAR(300) null,description STRING null,summary STRING null,url STRING null,height INTEGER,width INTEGER)";

	public static String TABLE_SQL_DROP = "drop table TagsAsset";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_1AB6D6D2 on TagsAsset (classNameId, classPK)",
		"create index IX_AB3D8BCB on TagsAsset (companyId)"
	};

}