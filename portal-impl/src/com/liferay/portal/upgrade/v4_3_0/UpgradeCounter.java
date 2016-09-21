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

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.model.Permission;
import com.liferay.portal.model.Resource;
import com.liferay.portal.model.ResourceCode;
import com.liferay.portal.model.UserTracker;

import java.sql.Types;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeCounter extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Counter

		List<String> names = CounterLocalServiceUtil.getNames();

		for (String name : names) {
			if (name.startsWith("com.liferay.") &&
				!name.equals(Counter.class.getName()) &&
				!name.equals(Permission.class.getName()) &&
				!name.equals(Resource.class.getName()) &&
				!name.equals(ResourceCode.class.getName()) &&
				!name.equals(UserTracker.class.getName())) {

				CounterLocalServiceUtil.reset(name);
			}
		}

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			_TABLE_COUNTER, _COLUMNS_COUNTER);

		upgradeTable.setCreateSQL(_CREATE_COUNTER);

		upgradeTable.updateTable();
	}

	private static final String _TABLE_COUNTER = "Counter";

	private static final Object[][] _COLUMNS_COUNTER = {
		{"name", new Integer(Types.VARCHAR)},
		{"currentId", new Integer(Types.BIGINT)}
	};

	private static final String _CREATE_COUNTER =
		"create table Counter (" +
			"name VARCHAR(75) not null primary key," +
			"currentId LONG" +
		")";

}