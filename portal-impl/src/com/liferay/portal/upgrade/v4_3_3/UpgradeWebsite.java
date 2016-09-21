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
import com.liferay.portal.upgrade.v4_3_3.util.WebsiteTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeWebsite extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Website

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			WebsiteTable.TABLE_NAME, WebsiteTable.TABLE_COLUMNS);

		upgradeTable.setCreateSQL(WebsiteTable.TABLE_SQL_CREATE);

		upgradeTable.updateTable();
	}

}