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
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.UserIdMapperTable;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeUserIdMapper extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// UserIdMapper

		UpgradeColumn upgradeUserIdColumn = new SwapUpgradeColumnImpl(
			"userId", new Integer(Types.VARCHAR),
			AvailableMappersUtil.getUserIdMapper());

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			UserIdMapperTable.TABLE_NAME, UserIdMapperTable.TABLE_COLUMNS,
			new PKUpgradeColumnImpl("userIdMapperId", false),
			upgradeUserIdColumn);

		upgradeTable.setCreateSQL(UserIdMapperTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(UserIdMapperTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}