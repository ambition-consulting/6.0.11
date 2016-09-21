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
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Organization;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.ClassNameIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ClassPKContainer;
import com.liferay.portal.upgrade.v4_3_0.util.ClassPKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.PhoneTable;
import com.liferay.portal.upgrade.v4_3_0.util.ValueMapperUtil;
import com.liferay.portal.util.PortalUtil;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class UpgradePhone extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Phone

		UpgradeColumn upgradeUserIdColumn = new SwapUpgradeColumnImpl(
			"userId", new Integer(Types.VARCHAR),
			AvailableMappersUtil.getUserIdMapper());

		PKUpgradeColumnImpl upgradePKColumn = new PKUpgradeColumnImpl(
			"phoneId", true);

		ClassNameIdUpgradeColumnImpl classNameIdColumn =
			new ClassNameIdUpgradeColumnImpl();

		Map<Long, ClassPKContainer> classPKContainers =
			new HashMap<Long, ClassPKContainer>();

		classPKContainers.put(
			new Long(PortalUtil.getClassNameId(Contact.class.getName())),
			new ClassPKContainer(
				AvailableMappersUtil.getContactIdMapper(), false));

		classPKContainers.put(
			new Long(PortalUtil.getClassNameId(Organization.class.getName())),
			new ClassPKContainer(
				AvailableMappersUtil.getOrganizationIdMapper(), true));

		UpgradeColumn upgradeClassPKColumn = new ClassPKUpgradeColumnImpl(
			classNameIdColumn, classPKContainers);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			PhoneTable.TABLE_NAME, PhoneTable.TABLE_COLUMNS, upgradePKColumn,
			upgradeUserIdColumn, classNameIdColumn, upgradeClassPKColumn);

		upgradeTable.setCreateSQL(PhoneTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(PhoneTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapperUtil.persist(upgradePKColumn.getValueMapper(), "phone-id");
	}

}