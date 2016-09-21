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
public class ImageTable {

	public static String TABLE_NAME = "Image";

	public static Object[][] TABLE_COLUMNS = {
		{"imageId", new Integer(Types.BIGINT)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"text_", new Integer(Types.CLOB)},
		{"type_", new Integer(Types.VARCHAR)},
		{"height", new Integer(Types.INTEGER)},
		{"width", new Integer(Types.INTEGER)},
		{"size_", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table Image (imageId LONG not null primary key,modifiedDate DATE null,text_ TEXT null,type_ VARCHAR(75) null,height INTEGER,width INTEGER,size_ INTEGER)";

	public static String TABLE_SQL_DROP = "drop table Image";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
	};

}