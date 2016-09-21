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
import com.liferay.portal.kernel.upgrade.util.DefaultPKMapper;
import com.liferay.portal.kernel.upgrade.util.SwapUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AccountTable;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.ContactTable;
import com.liferay.portal.upgrade.v4_3_0.util.CyrusUserTable;
import com.liferay.portal.upgrade.v4_3_0.util.CyrusVirtualTable;
import com.liferay.portal.upgrade.v4_3_0.util.PasswordTrackerTable;
import com.liferay.portal.upgrade.v4_3_0.util.UserPortraitIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.UserTable;

import java.sql.Types;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 */
public class UpgradeUser extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// User_

		PKUpgradeColumnImpl upgradePKColumn =
			new PKUpgradeColumnImpl("userId", new Integer(Types.VARCHAR), true);

		UpgradeColumn upgradeCompanyIdColumn = new TempUpgradeColumnImpl(
			"companyId", new Integer(Types.VARCHAR));

		UpgradeColumn upgradeContactIdColumn = new TempUpgradeColumnImpl(
			"contactId", new Integer(Types.VARCHAR));

		UpgradeColumn upgradeUserPortraitIdColumn =
			new UserPortraitIdUpgradeColumnImpl(
				upgradePKColumn, AvailableMappersUtil.getImageIdMapper());

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			UserTable.TABLE_NAME, UserTable.TABLE_COLUMNS, upgradePKColumn,
			upgradeCompanyIdColumn, upgradeContactIdColumn,
			upgradeUserPortraitIdColumn);

		upgradeTable.updateTable();

		ValueMapper userIdMapper = new DefaultPKMapper(
			upgradePKColumn.getValueMapper());

		AvailableMappersUtil.setUserIdMapper(userIdMapper);

		UpgradeColumn upgradeUserIdColumn = new SwapUpgradeColumnImpl(
			"userId", new Integer(Types.VARCHAR), userIdMapper);

		// Account

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			AccountTable.TABLE_NAME, AccountTable.TABLE_COLUMNS,
			upgradeUserIdColumn);

		upgradeTable.setCreateSQL(AccountTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(AccountTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// Contact

		UpgradeColumn upgradeAccountIdColumn = new TempUpgradeColumnImpl(
			"accountId", new Integer(Types.VARCHAR));

		UpgradeColumn upgradeParentContactIdColumn = new TempUpgradeColumnImpl(
			"parentContactId", new Integer(Types.VARCHAR));

		UpgradeColumn upgradePrefixIdColumn = new TempUpgradeColumnImpl(
			"prefixId", new Integer(Types.VARCHAR));

		UpgradeColumn upgradeSuffixIdColumn = new TempUpgradeColumnImpl(
			"suffixId", new Integer(Types.VARCHAR));

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			ContactTable.TABLE_NAME, ContactTable.TABLE_COLUMNS,
			upgradeContactIdColumn, upgradeCompanyIdColumn, upgradeUserIdColumn,
			upgradeAccountIdColumn, upgradeParentContactIdColumn,
			upgradePrefixIdColumn, upgradeSuffixIdColumn);

		upgradeTable.updateTable();

		// CyrusUser

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			CyrusUserTable.TABLE_NAME, CyrusUserTable.TABLE_COLUMNS,
			upgradeUserIdColumn);

		upgradeTable.updateTable();

		// CyrusVirtual

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			CyrusVirtualTable.TABLE_NAME, CyrusVirtualTable.TABLE_COLUMNS,
			upgradeUserIdColumn);

		upgradeTable.updateTable();

		// PasswordTracker

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PasswordTrackerTable.TABLE_NAME, PasswordTrackerTable.TABLE_COLUMNS,
			new PKUpgradeColumnImpl("passwordTrackerId", false),
			upgradeUserIdColumn);

		upgradeTable.setCreateSQL(PasswordTrackerTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(PasswordTrackerTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}