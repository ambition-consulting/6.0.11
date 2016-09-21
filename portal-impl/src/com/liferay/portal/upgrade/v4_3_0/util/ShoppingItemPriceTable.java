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
public class ShoppingItemPriceTable {

	public static String TABLE_NAME = "ShoppingItemPrice";

	public static Object[][] TABLE_COLUMNS = {
		{"itemPriceId", new Integer(Types.BIGINT)},
		{"itemId", new Integer(Types.BIGINT)},
		{"minQuantity", new Integer(Types.INTEGER)},
		{"maxQuantity", new Integer(Types.INTEGER)},
		{"price", new Integer(Types.DOUBLE)},
		{"discount", new Integer(Types.DOUBLE)},
		{"taxable", new Integer(Types.BOOLEAN)},
		{"shipping", new Integer(Types.DOUBLE)},
		{"useShippingFormula", new Integer(Types.BOOLEAN)},
		{"status", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table ShoppingItemPrice (itemPriceId LONG not null primary key,itemId LONG,minQuantity INTEGER,maxQuantity INTEGER,price DOUBLE,discount DOUBLE,taxable BOOLEAN,shipping DOUBLE,useShippingFormula BOOLEAN,status INTEGER)";

	public static String TABLE_SQL_DROP = "drop table ShoppingItemPrice";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_EA6FD516 on ShoppingItemPrice (itemId)"
	};

}