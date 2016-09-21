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

package com.liferay.portal.upgrade.v4_3_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.SwapUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.PollsChoiceIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PollsChoiceTable;
import com.liferay.portal.upgrade.v4_3_0.util.PollsQuestionTable;
import com.liferay.portal.upgrade.v4_3_0.util.PollsVoteChoiceIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PollsVoteTable;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradePolls extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// PollsQuestion

		UpgradeColumn upgradeGroupIdColumn = new SwapUpgradeColumnImpl(
			"groupId", AvailableMappersUtil.getGroupIdMapper());

		UpgradeColumn upgradeUserIdColumn = new SwapUpgradeColumnImpl(
			"userId", new Integer(Types.VARCHAR),
			AvailableMappersUtil.getUserIdMapper());

		PKUpgradeColumnImpl upgradePKColumn = new PKUpgradeColumnImpl(
			"questionId", true);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PollsQuestionTable.TABLE_NAME, PollsQuestionTable.TABLE_COLUMNS,
			upgradePKColumn, upgradeGroupIdColumn, upgradeUserIdColumn);

		upgradeTable.setCreateSQL(PollsQuestionTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(PollsQuestionTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapper questionIdMapper = upgradePKColumn.getValueMapper();

		AvailableMappersUtil.setPollsQuestionIdMapper(questionIdMapper);

		UpgradeColumn upgradeQuestionIdColumn = new SwapUpgradeColumnImpl(
			"questionId", questionIdMapper);

		// PollsChoice

		PKUpgradeColumnImpl upgradeChoiceId =
			new PollsChoiceIdUpgradeColumnImpl(upgradeQuestionIdColumn);

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PollsChoiceTable.TABLE_NAME, PollsChoiceTable.TABLE_COLUMNS,
			upgradeQuestionIdColumn, upgradeChoiceId);

		upgradeTable.setCreateSQL(PollsChoiceTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(PollsChoiceTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapper choiceIdMapper = upgradeChoiceId.getValueMapper();

		// PollsVote

		UpgradeColumn upgradeVoteChoiceIdColumn =
			new PollsVoteChoiceIdUpgradeColumnImpl(
				upgradeQuestionIdColumn, choiceIdMapper);

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PollsVoteTable.TABLE_NAME, PollsVoteTable.TABLE_COLUMNS,
			new PKUpgradeColumnImpl("voteId", false), upgradeUserIdColumn,
			upgradeQuestionIdColumn, upgradeVoteChoiceIdColumn);

		upgradeTable.setCreateSQL(PollsVoteTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(PollsVoteTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}