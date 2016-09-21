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
public class ShoppingCartTable {

	public static String TABLE_NAME = "ShoppingCart";

	public static Object[][] TABLE_COLUMNS = {
		{"cartId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"itemIds", new Integer(Types.VARCHAR)},
		{"couponCodes", new Integer(Types.VARCHAR)},
		{"altShipping", new Integer(Types.INTEGER)},
		{"insure", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table ShoppingCart (cartId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,itemIds STRING null,couponCodes VARCHAR(75) null,altShipping INTEGER,insure BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table ShoppingCart";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C28B41DC on ShoppingCart (groupId)",
		"create index IX_FC46FE16 on ShoppingCart (groupId, userId)",
		"create index IX_54101CC8 on ShoppingCart (userId)"
	};

}