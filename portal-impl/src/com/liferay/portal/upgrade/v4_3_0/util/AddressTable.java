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
public class AddressTable {

	public static String TABLE_NAME = "Address";

	public static Object[][] TABLE_COLUMNS = {
		{"addressId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"userName", new Integer(Types.VARCHAR)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"street1", new Integer(Types.VARCHAR)},
		{"street2", new Integer(Types.VARCHAR)},
		{"street3", new Integer(Types.VARCHAR)},
		{"city", new Integer(Types.VARCHAR)},
		{"zip", new Integer(Types.VARCHAR)},
		{"regionId", new Integer(Types.BIGINT)},
		{"countryId", new Integer(Types.BIGINT)},
		{"typeId", new Integer(Types.INTEGER)},
		{"mailing", new Integer(Types.BOOLEAN)},
		{"primary_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Address (addressId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,street1 VARCHAR(75) null,street2 VARCHAR(75) null,street3 VARCHAR(75) null,city VARCHAR(75) null,zip VARCHAR(75) null,regionId LONG,countryId LONG,typeId INTEGER,mailing BOOLEAN,primary_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Address";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_93D5AD4E on Address (companyId)",
		"create index IX_ABD7DAC0 on Address (companyId, classNameId)",
		"create index IX_71CB1123 on Address (companyId, classNameId, classPK)",
		"create index IX_923BD178 on Address (companyId, classNameId, classPK, mailing)",
		"create index IX_9226DBB4 on Address (companyId, classNameId, classPK, primary_)",
		"create index IX_5BC8B0D4 on Address (userId)"
	};

}