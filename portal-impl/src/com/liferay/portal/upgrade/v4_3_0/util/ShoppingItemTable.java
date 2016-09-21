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
public class ShoppingItemTable {

	public static String TABLE_NAME = "ShoppingItem";

	public static Object[][] TABLE_COLUMNS = {
		{"itemId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"categoryId", new Integer(Types.BIGINT)},
		{"sku", new Integer(Types.VARCHAR)},
		{"name", new Integer(Types.VARCHAR)},
		{"description", new Integer(Types.VARCHAR)},
		{"properties", new Integer(Types.VARCHAR)},
		{"fields_", new Integer(Types.BOOLEAN)},
		{"fieldsQuantities", new Integer(Types.VARCHAR)},
		{"minQuantity", new Integer(Types.INTEGER)},
		{"maxQuantity", new Integer(Types.INTEGER)},
		{"price", new Integer(Types.DOUBLE)},
		{"discount", new Integer(Types.DOUBLE)},
		{"taxable", new Integer(Types.BOOLEAN)},
		{"shipping", new Integer(Types.DOUBLE)},
		{"useShippingFormula", new Integer(Types.BOOLEAN)},
		{"requiresShipping", new Integer(Types.BOOLEAN)},
		{"stockQuantity", new Integer(Types.INTEGER)},
		{"featured_", new Integer(Types.BOOLEAN)},
		{"sale_", new Integer(Types.BOOLEAN)},
		{"smallImage", new Integer(Types.BOOLEAN)},
		{"smallImageId", new Integer(Types.BIGINT)},
		{"smallImageURL", new Integer(Types.VARCHAR)},
		{"mediumImage", new Integer(Types.BOOLEAN)},
		{"mediumImageId", new Integer(Types.BIGINT)},
		{"mediumImageURL", new Integer(Types.VARCHAR)},
		{"largeImage", new Integer(Types.BOOLEAN)},
		{"largeImageId", new Integer(Types.BIGINT)},
		{"largeImageURL", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table ShoppingItem (itemId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,sku VARCHAR(75) null,name VARCHAR(200) null,description STRING null,properties STRING null,fields_ BOOLEAN,fieldsQuantities STRING null,minQuantity INTEGER,maxQuantity INTEGER,price DOUBLE,discount DOUBLE,taxable BOOLEAN,shipping DOUBLE,useShippingFormula BOOLEAN,requiresShipping BOOLEAN,stockQuantity INTEGER,featured_ BOOLEAN,sale_ BOOLEAN,smallImage BOOLEAN,smallImageId LONG,smallImageURL VARCHAR(75) null,mediumImage BOOLEAN,mediumImageId LONG,mediumImageURL VARCHAR(75) null,largeImage BOOLEAN,largeImageId LONG,largeImageURL VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table ShoppingItem";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_C8EACF2E on ShoppingItem (categoryId)",
		"create index IX_1C717CA6 on ShoppingItem (companyId, sku)"
	};

}