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
public class IGImageTable {

	public static String TABLE_NAME = "IGImage";

	public static Object[][] TABLE_COLUMNS = {
		{"imageId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"folderId", new Integer(Types.BIGINT)},
		{"description", new Integer(Types.VARCHAR)},
		{"smallImageId", new Integer(Types.BIGINT)},
		{"largeImageId", new Integer(Types.BIGINT)}
	};

	public static String TABLE_SQL_CREATE = "create table IGImage (imageId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,folderId LONG,description STRING null,smallImageId LONG,largeImageId LONG)";

	public static String TABLE_SQL_DROP = "drop table IGImage";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_4438CA80 on IGImage (folderId)"
	};

}