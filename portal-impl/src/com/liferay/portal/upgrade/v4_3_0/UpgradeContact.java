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
import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.ContactIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ContactTable;
import com.liferay.portal.upgrade.v4_3_0.util.UserTable;

import java.sql.Types;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class UpgradeContact extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Contact_

		PKUpgradeColumnImpl upgradePKColumn = new PKUpgradeColumnImpl(
			"contactId", new Integer(Types.VARCHAR), true);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			ContactTable.TABLE_NAME, ContactTable.TABLE_COLUMNS,
			upgradePKColumn);

		upgradeTable.setCreateSQL(ContactTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(ContactTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapper contactIdMapper = new DefaultPKMapper(
			upgradePKColumn.getValueMapper());

		AvailableMappersUtil.setContactIdMapper(contactIdMapper);

		// User_

		UpgradeColumn upgradeScreenNameColumn =
			new TempUpgradeColumnImpl("screenName");

		UpgradeColumn upgradeContactIdColumn = new ContactIdUpgradeColumnImpl(
			upgradeScreenNameColumn, contactIdMapper);

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			UserTable.TABLE_NAME, UserTable.TABLE_COLUMNS,
			upgradeScreenNameColumn, upgradeContactIdColumn);

		upgradeTable.setCreateSQL(UserTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(UserTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();
	}

}