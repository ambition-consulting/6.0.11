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
import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.PortletPreferencesTable;
import com.liferay.portal.upgrade.v4_3_0.util.PrefsOwnerIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PrefsOwnerTypeUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PrefsPlidUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PrefsXMLUpgradeColumnImpl;
import com.liferay.portal.util.PortletKeys;

import java.sql.Types;

import java.util.Iterator;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradePortletPreferences extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// PortletPreferences

		runSQL(
			"delete from PortletPreferences where ownerId = '0' and " +
				"ownerType = " + PortletKeys.PREFS_OWNER_TYPE_COMPANY);

		ValueMapper companyIdMapper = AvailableMappersUtil.getCompanyIdMapper();

		Iterator<Object> itr = companyIdMapper.iterator();

		while (itr.hasNext()) {
			String webId = (String)itr.next();

			Long companyIdObj = (Long)companyIdMapper.getNewValue(webId);

			runSQL(
				"delete from PortletPreferences where ownerId = '" +
					companyIdObj.longValue() + "' and ownerType = " +
						PortletKeys.PREFS_OWNER_TYPE_COMPANY);
		}

		Object[][] preferencesColumns1 =
			{{"layoutId", new Integer(Types.VARCHAR)}};
		Object[][] preferencesColumns2 =
			PortletPreferencesTable.TABLE_COLUMNS.clone();

		Object[][] preferencesColumns = ArrayUtil.append(
			preferencesColumns1, preferencesColumns2);

		PrefsOwnerIdUpgradeColumnImpl upgradeOwnerIdColumn =
			new PrefsOwnerIdUpgradeColumnImpl(
				AvailableMappersUtil.getCompanyIdMapper(),
				AvailableMappersUtil.getGroupIdMapper(),
				AvailableMappersUtil.getUserIdMapper());

		UpgradeColumn upgradeOwnerTypeColumn =
			new PrefsOwnerTypeUpgradeColumnImpl(upgradeOwnerIdColumn);

		UpgradeColumn upgradeLayoutIdColumn =
			new TempUpgradeColumnImpl("layoutId");

		UpgradeColumn upgradePlidColumn = new PrefsPlidUpgradeColumnImpl(
			upgradeOwnerIdColumn, upgradeLayoutIdColumn,
			AvailableMappersUtil.getLayoutPlidMapper());

		UpgradeColumn upgradePortletIdColumn =
			new TempUpgradeColumnImpl("portletId");

		UpgradeColumn upgradePreferencesColumn = new PrefsXMLUpgradeColumnImpl(
			upgradePortletIdColumn,	 AvailableMappersUtil.getGroupIdMapper(),
			AvailableMappersUtil.getPollsQuestionIdMapper(),
			AvailableMappersUtil.getWikiNodeIdMapper());

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PortletPreferencesTable.TABLE_NAME, preferencesColumns,
			new PKUpgradeColumnImpl("portletPreferencesId", false),
			upgradeOwnerIdColumn, upgradeOwnerTypeColumn, upgradeLayoutIdColumn,
			upgradePlidColumn, upgradePortletIdColumn,
			upgradePreferencesColumn);

		String createSQL = PortletPreferencesTable.TABLE_SQL_CREATE;

		createSQL =
			createSQL.substring(0, createSQL.length() - 1) +
				",layoutId VARCHAR(75) null)";

		upgradeTable.setCreateSQL(createSQL);
		upgradeTable.setIndexesSQL(
			PortletPreferencesTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// Schema

		runSQL(_UPGRADE_SCHEMA);
	}

	private static final String[] _UPGRADE_SCHEMA = {
		"alter table PortletPreferences drop column layoutId"
	};

}