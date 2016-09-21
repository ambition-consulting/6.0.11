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
import com.liferay.portal.upgrade.v6_0_0.util.ResourceActionTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeResourceAction extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		try {
			runSQL("alter_column_type ResourceAction name VARCHAR(255) null");
		}
		catch (Exception e) {

			// Resource

			UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
				ResourceActionTable.TABLE_NAME,
				ResourceActionTable.TABLE_COLUMNS);

			upgradeTable.setCreateSQL(ResourceActionTable.TABLE_SQL_CREATE);
			upgradeTable.setIndexesSQL(
				ResourceActionTable.TABLE_SQL_ADD_INDEXES);

			upgradeTable.updateTable();
		}
	}

}