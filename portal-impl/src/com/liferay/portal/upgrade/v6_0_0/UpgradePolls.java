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

package com.liferay.portal.upgrade.v6_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.upgrade.v6_0_0.util.PollsChoiceTable;
import com.liferay.portal.upgrade.v6_0_0.util.PollsQuestionTable;

/**
 * @author Julio Camarero Puras
 */
public class UpgradePolls extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		try {
			runSQL("alter_column_type PollsChoice description STRING null");
		}
		catch (Exception e) {

			// PollsChoice

			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				PollsChoiceTable.TABLE_NAME, PollsChoiceTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(PollsChoiceTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(PollsChoiceTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}

		try {
			runSQL("alter_column_type PollsQuestion title STRING null");
		}
		catch (Exception e) {

			// PollsQuestion

			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				PollsQuestionTable.TABLE_NAME,
				PollsQuestionTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(PollsQuestionTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(
				PollsQuestionTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}

	}

}