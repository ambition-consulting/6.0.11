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
import com.liferay.portal.upgrade.v6_0_0.util.JournalArticleTable;
import com.liferay.portal.upgrade.v6_0_0.util.JournalFeedTable;
import com.liferay.portal.upgrade.v6_0_0.util.JournalTemplateTable;

/**
 * @author Zsigmond Rab
 */
public class UpgradeJournal extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		try {
			runSQL(
				"alter_column_type JournalArticle smallImageURL STRING null");
		}
		catch (Exception e) {
			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				JournalArticleTable.TABLE_NAME,
				JournalArticleTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(JournalArticleTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(
				JournalArticleTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}

		try {
			runSQL(
				"alter_column_type JournalFeed targetLayoutFriendlyUrl " +
					"VARCHAR(255) null");
		}
		catch (Exception e) {
			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				JournalFeedTable.TABLE_NAME, JournalFeedTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(JournalFeedTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(JournalFeedTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}

		try {
			runSQL(
				"alter_column_type JournalTemplate smallImageURL STRING null");
		}
		catch (Exception e) {
			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				JournalTemplateTable.TABLE_NAME,
				JournalTemplateTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(JournalTemplateTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(
				JournalTemplateTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}
	}

}