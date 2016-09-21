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
import com.liferay.portal.upgrade.v4_3_0.util.RegionTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeRegion extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Region

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			RegionTable.TABLE_NAME, RegionTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(RegionTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(RegionTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}