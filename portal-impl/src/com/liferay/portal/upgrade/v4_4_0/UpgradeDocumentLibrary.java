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

package com.liferay.portal.upgrade.v4_4_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.upgrade.v4_4_0.util.DLFileEntryTable;
import com.liferay.portal.upgrade.v4_4_0.util.DLFileEntryTitleColumnImpl;
import com.liferay.portal.upgrade.v4_4_0.util.DLFolderNameColumnImpl;
import com.liferay.portal.upgrade.v4_4_0.util.DLFolderTable;

import java.util.Set;

/**
 * @author Alexander Chow
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// DLFolder

		UpgradeColumn groupIdColumn = new TempUpgradeColumnImpl("groupId");

		UpgradeColumn parentFolderIdColumn = new TempUpgradeColumnImpl(
			"parentFolderId");

		DLFolderNameColumnImpl dlFolderNameColumn = new DLFolderNameColumnImpl(
			groupIdColumn, parentFolderIdColumn);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFolderTable.TABLE_NAME, DLFolderTable.TABLE_COLUMNS,
			groupIdColumn, parentFolderIdColumn, dlFolderNameColumn);

		upgradeTable.updateTable();

		Set<String> distinctNames = dlFolderNameColumn.getDistintNames();

		// DLFileEntry

		UpgradeColumn folderIdColumn = new TempUpgradeColumnImpl("folderId");

		UpgradeColumn nameColumn = new TempUpgradeColumnImpl("name");

		BaseUpgradeColumnImpl dlFileEntryTitleColumn =
			new DLFileEntryTitleColumnImpl(
				groupIdColumn, folderIdColumn, nameColumn, distinctNames);

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileEntryTable.TABLE_NAME, DLFileEntryTable.TABLE_COLUMNS,
			folderIdColumn, nameColumn, dlFileEntryTitleColumn);

		upgradeTable.updateTable();
	}

}