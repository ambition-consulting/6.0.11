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

package com.liferay.portal.upgrade.v4_4_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.upgrade.v4_4_0.util.TagsAssetGroupIdUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_4_0.util.TagsAssetTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeTags extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// TagsAsset

		UpgradeColumn classNameIdColumn =
			new TempUpgradeColumnImpl("classNameId");

		UpgradeColumn classPKColumn = new TempUpgradeColumnImpl("classPK");

		UpgradeColumn groupIdColumn = new TagsAssetGroupIdUpgradeColumnImpl(
			classNameIdColumn, classPKColumn);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			TagsAssetTable.TABLE_NAME, TagsAssetTable.TABLE_COLUMNS,
			classNameIdColumn, classPKColumn, groupIdColumn);

		upgradeTable.updateTable();
	}

}