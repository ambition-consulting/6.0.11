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
public class PollsVoteTable {

	public static String TABLE_NAME = "PollsVote";

	public static Object[][] TABLE_COLUMNS = {
		{"voteId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"questionId", new Integer(Types.BIGINT)},
		{"choiceId", new Integer(Types.BIGINT)},
		{"voteDate", new Integer(Types.TIMESTAMP)}
	};

	public static String TABLE_SQL_CREATE = "create table PollsVote (voteId LONG not null primary key,userId LONG,questionId LONG,choiceId LONG,voteDate DATE null)";

	public static String TABLE_SQL_DROP = "drop table PollsVote";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_D5DF7B54 on PollsVote (choiceId)",
		"create index IX_12112599 on PollsVote (questionId)",
		"create index IX_1BBFD4D3 on PollsVote (questionId, userId)"
	};

}