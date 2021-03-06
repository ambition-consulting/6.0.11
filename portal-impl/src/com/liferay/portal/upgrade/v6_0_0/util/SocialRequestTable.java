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

package com.liferay.portal.upgrade.v6_0_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class SocialRequestTable {

	public static final String TABLE_NAME = "SocialRequest";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", new Integer(Types.VARCHAR)},
		{"requestId", new Integer(Types.BIGINT)},
		{"groupId", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"createDate", new Integer(Types.BIGINT)},
		{"modifiedDate", new Integer(Types.BIGINT)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"type_", new Integer(Types.INTEGER)},
		{"extraData", new Integer(Types.VARCHAR)},
		{"receiverUserId", new Integer(Types.BIGINT)},
		{"status", new Integer(Types.INTEGER)}
	};

	public static final String TABLE_SQL_CREATE = "create table SocialRequest (uuid_ VARCHAR(75) null,requestId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate LONG,modifiedDate LONG,classNameId LONG,classPK LONG,type_ INTEGER,extraData STRING null,receiverUserId LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table SocialRequest";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_D3425487 on SocialRequest (classNameId, classPK, type_, receiverUserId, status)",
		"create index IX_A90FE5A0 on SocialRequest (companyId)",
		"create index IX_32292ED1 on SocialRequest (receiverUserId)",
		"create index IX_D9380CB7 on SocialRequest (receiverUserId, status)",
		"create index IX_80F7A9C2 on SocialRequest (userId)",
		"create unique index IX_36A90CA7 on SocialRequest (userId, classNameId, classPK, type_, receiverUserId)",
		"create index IX_CC86A444 on SocialRequest (userId, classNameId, classPK, type_, status)",
		"create index IX_AB5906A8 on SocialRequest (userId, status)",
		"create index IX_49D5872C on SocialRequest (uuid_)",
		"create unique index IX_4F973EFE on SocialRequest (uuid_, groupId)"
	};

}