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

package com.liferay.portal.upgrade.v6_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.upgrade.v6_0_1.util.DLFileEntryTable;
import com.liferay.portal.upgrade.v6_0_1.util.DLFileVersionTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		try {
			runSQL("alter_column_type DLFileEntry size_ LONG");
		}
		catch (Exception e) {

			// DLFileEntry

			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				DLFileEntryTable.TABLE_NAME, DLFileEntryTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(DLFileEntryTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(DLFileEntryTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}

		try {
			runSQL("alter_column_type DLFileVersion size_ LONG");
		}
		catch (Exception e) {

			// DLFileVersion

			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				DLFileVersionTable.TABLE_NAME,
				DLFileVersionTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(DLFileVersionTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(
				DLFileVersionTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}
	}

}