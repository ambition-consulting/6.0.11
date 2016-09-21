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
public class MBDiscussionTable {

	public static String TABLE_NAME = "MBDiscussion";

	public static Object[][] TABLE_COLUMNS = {
		{"discussionId", new Integer(Types.BIGINT)},
		{"classNameId", new Integer(Types.BIGINT)},
		{"classPK", new Integer(Types.BIGINT)},
		{"threadId", new Integer(Types.BIGINT)}
	};

	public static String TABLE_SQL_CREATE = "create table MBDiscussion (discussionId LONG not null primary key,classNameId LONG,classPK LONG,threadId LONG)";

	public static String TABLE_SQL_DROP = "drop table MBDiscussion";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_33A4DE38 on MBDiscussion (classNameId, classPK)"
	};

}