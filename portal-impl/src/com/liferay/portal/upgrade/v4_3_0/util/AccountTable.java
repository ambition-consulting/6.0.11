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
public class AccountTable {

	public static String TABLE_NAME = "Account_";

	public static Object[][] TABLE_COLUMNS = {
		{"accountId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"parentAccountId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"legalName", new Integer(Types.VARCHAR)},
		{"legalId", new Integer(Types.VARCHAR)},
		{"legalType", new Integer(Types.VARCHAR)},
		{"sicCode", new Integer(Types.VARCHAR)},
		{"tickerSymbol", new Integer(Types.VARCHAR)},
		{"industry", new Integer(Types.VARCHAR)},
		{"type_", new Integer(Types.VARCHAR)},
		{"size_", new Integer(Types.VARCHAR)}
	};

	public static String TABLE_SQL_CREATE = "create table Account_ (accountId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentAccountId LONG,name VARCHAR(75) null,legalName VARCHAR(75) null,legalId VARCHAR(75) null,legalType VARCHAR(75) null,sicCode VARCHAR(75) null,tickerSymbol VARCHAR(75) null,industry VARCHAR(75) null,type_ VARCHAR(75) null,size_ VARCHAR(75) null)";

	public static String TABLE_SQL_DROP = "drop table Account_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
	};

}