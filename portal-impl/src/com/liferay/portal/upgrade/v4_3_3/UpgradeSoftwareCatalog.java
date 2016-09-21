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

package com.liferay.portal.upgrade.v4_3_3;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.upgrade.v4_3_3.util.SCFrameworkVersionTable;
import com.liferay.portal.upgrade.v4_3_3.util.SCLicenseTable;
import com.liferay.portal.upgrade.v4_3_3.util.SCProductEntryTable;
import com.liferay.portal.upgrade.v4_3_3.util.SCProductVersionTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeSoftwareCatalog extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// SCFrameworkVersion

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			SCFrameworkVersionTable.TABLE_NAME,
			SCFrameworkVersionTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(SCFrameworkVersionTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(
			SCFrameworkVersionTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// SCLicense

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			SCLicenseTable.TABLE_NAME, SCLicenseTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(SCLicenseTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(SCLicenseTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// SCProductEntry

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			SCProductEntryTable.TABLE_NAME, SCProductEntryTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(SCProductEntryTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(SCProductEntryTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// SCProductVersion

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			SCProductVersionTable.TABLE_NAME,
			SCProductVersionTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(SCProductVersionTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(SCProductVersionTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}