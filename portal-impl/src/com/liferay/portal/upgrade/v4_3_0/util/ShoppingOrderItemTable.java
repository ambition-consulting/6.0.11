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
public class ShoppingOrderItemTable {

	public static String TABLE_NAME = "ShoppingOrderItem";

	public static Object[][] TABLE_COLUMNS = {
		{"orderItemId", new Integer(Types.BIGINT)},
		{"orderId", new Integer(Types.BIGINT)},
		{"itemId", new Integer(Types.VARCHAR)},
		{"sku", new Integer(Types.VARCHAR)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"properties", new Integer(Types.VARCHAR)},
		{"price", new Integer(Types.DOUBLE)},
		{"quantity", new Integer(Types.INTEGER)},
		{"shippedDate", new Integer(Types.TIMESTAMP)}
	};

	public static String TABLE_SQL_CREATE = "create table ShoppingOrderItem (orderItemId LONG not null primary key,orderId LONG,itemId VARCHAR(75) null,sku VARCHAR(75) null,name VARCHAR(200) null,description STRING null,properties STRING null,price DOUBLE,quantity INTEGER,shippedDate DATE null)";

	public static String TABLE_SQL_DROP = "drop table ShoppingOrderItem";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_B5F82C7A on ShoppingOrderItem (orderId)"
	};

}