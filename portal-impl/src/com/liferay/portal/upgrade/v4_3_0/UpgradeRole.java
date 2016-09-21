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
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.RoleTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeRole extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Role

		PKUpgradeColumnImpl upgradePKColumn = new PKUpgradeColumnImpl(
			"roleId", true);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			RoleTable.TABLE_NAME, RoleTable.TABLE_COLUMNS, upgradePKColumn);

		upgradeTable.setCreateSQL(RoleTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(RoleTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapper roleIdMapper = upgradePKColumn.getValueMapper();

		AvailableMappersUtil.setRoleIdMapper(roleIdMapper);
	}

}