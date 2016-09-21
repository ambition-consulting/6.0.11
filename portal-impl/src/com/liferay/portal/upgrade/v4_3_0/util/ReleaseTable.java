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
public class ReleaseTable {

	public static String TABLE_NAME = "Release_";

	public static Object[][] TABLE_COLUMNS = {
		{"releaseId", new Integer(Types.BIGINT)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"buildNumber", new Integer(Types.INTEGER)},
		{"buildDate", new Integer(Types.TIMESTAMP)},
		{"verified", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Release_ (releaseId LONG not null primary key,createDate DATE null,modifiedDate DATE null,buildNumber INTEGER,buildDate DATE null,verified BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Release_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
	};

}