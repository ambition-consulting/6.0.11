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

package com.liferay.portal.upgrade.v5_2_3.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class UserTable {

	public static final String TABLE_NAME = "User_";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", new Integer(Types.VARCHAR)},
		{"userId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"createDate", new Integer(Types.TIMESTAMP)},
		{"modifiedDate", new Integer(Types.TIMESTAMP)},
		{"defaultUser", new Integer(Types.BOOLEAN)},
		{"contactId", new Integer(Types.BIGINT)},
		{"password_", new Integer(Types.VARCHAR)},
		{"passwordEncrypted", new Integer(Types.BOOLEAN)},
		{"passwordReset", new Integer(Types.BOOLEAN)},
		{"passwordModifiedDate", new Integer(Types.TIMESTAMP)},
		{"reminderQueryQuestion", new Integer(Types.VARCHAR)},
		{"reminderQueryAnswer", new Integer(Types.VARCHAR)},
		{"graceLoginCount", new Integer(Types.INTEGER)},
		{"screenName", new Integer(Types.VARCHAR)},
		{"emailAddress", new Integer(Types.VARCHAR)},
		{"openId", new Integer(Types.VARCHAR)},
		{"portraitId", new Integer(Types.BIGINT)},
		{"languageId", new Integer(Types.VARCHAR)},
		{"timeZoneId", new Integer(Types.VARCHAR)},
		{"greeting", new Integer(Types.VARCHAR)},
		{"comments", new Integer(Types.VARCHAR)},
		{"firstName", new Integer(Types.VARCHAR)},
		{"middleName", new Integer(Types.VARCHAR)},
		{"lastName", new Integer(Types.VARCHAR)},
		{"jobTitle", new Integer(Types.VARCHAR)},
		{"loginDate", new Integer(Types.TIMESTAMP)},
		{"loginIP", new Integer(Types.VARCHAR)},
		{"lastLoginDate", new Integer(Types.TIMESTAMP)},
		{"lastLoginIP", new Integer(Types.VARCHAR)},
		{"lastFailedLoginDate", new Integer(Types.TIMESTAMP)},
		{"failedLoginAttempts", new Integer(Types.INTEGER)},
		{"lockout", new Integer(Types.BOOLEAN)},
		{"lockoutDate", new Integer(Types.TIMESTAMP)},
		{"agreedToTermsOfUse", new Integer(Types.BOOLEAN)},
		{"active_", new Integer(Types.BOOLEAN)}
	};

	public static final String TABLE_SQL_CREATE = "create table User_ (uuid_ VARCHAR(75) null,userId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,defaultUser BOOLEAN,contactId LONG,password_ VARCHAR(75) null,passwordEncrypted BOOLEAN,passwordReset BOOLEAN,passwordModifiedDate DATE null,reminderQueryQuestion VARCHAR(75) null,reminderQueryAnswer VARCHAR(75) null,graceLoginCount INTEGER,screenName VARCHAR(75) null,emailAddress VARCHAR(75) null,openId VARCHAR(1024) null,portraitId LONG,languageId VARCHAR(75) null,timeZoneId VARCHAR(75) null,greeting VARCHAR(255) null,comments STRING null,firstName VARCHAR(75) null,middleName VARCHAR(75) null,lastName VARCHAR(75) null,jobTitle VARCHAR(75) null,loginDate DATE null,loginIP VARCHAR(75) null,lastLoginDate DATE null,lastLoginIP VARCHAR(75) null,lastFailedLoginDate DATE null,failedLoginAttempts INTEGER,lockout BOOLEAN,lockoutDate DATE null,agreedToTermsOfUse BOOLEAN,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table User_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_3A1E834E on User_ (companyId)",
		"create index IX_6EF03E4E on User_ (companyId, defaultUser)",
		"create unique index IX_615E9F7A on User_ (companyId, emailAddress)",
		"create unique index IX_C5806019 on User_ (companyId, screenName)",
		"create unique index IX_9782AD88 on User_ (companyId, userId)",
		"create unique index IX_5ADBE171 on User_ (contactId)",
		"create index IX_762F63C6 on User_ (emailAddress)",
		"create index IX_A9ED7DD3 on User_ (openId)",
		"create index IX_A18034A4 on User_ (portraitId)",
		"create index IX_E0422BDA on User_ (uuid_)"
	};

}