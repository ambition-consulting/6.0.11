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
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.AvailableMappersUtil;
import com.liferay.portal.upgrade.v4_3_0.util.ImageHeightUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ImageSizeUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ImageTable;
import com.liferay.portal.upgrade.v4_3_0.util.ImageTextUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ImageTypeUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.ImageWidthUpgradeColumnImpl;
import com.liferay.portal.upgrade.v4_3_0.util.WebIdUtil;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeImage extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// Company

		String[] webIds = WebIdUtil.getWebIds();

		for (String webId : webIds) {
			runSQL("delete from Image where imageId = '" + webId + "'");

			runSQL("delete from Image where imageId = '" + webId + ".wbmp'");

			runSQL(
				"update Image set imageId = '" + webId + "' where imageId = '" +
					webId + ".png'");
		}

		// Image

		PKUpgradeColumnImpl upgradePKColumn = new PKUpgradeColumnImpl(
			"imageId", new Integer(Types.VARCHAR), true);

		ImageTextUpgradeColumnImpl upgradeTextColumn =
			new ImageTextUpgradeColumnImpl(upgradePKColumn);

		ImageTypeUpgradeColumnImpl upgradeTypeColumn =
			new ImageTypeUpgradeColumnImpl(upgradeTextColumn);

		ImageHeightUpgradeColumnImpl upgradeHeightColumn =
			new ImageHeightUpgradeColumnImpl(upgradeTextColumn);

		ImageWidthUpgradeColumnImpl upgradeWidthColumn =
			new ImageWidthUpgradeColumnImpl(upgradeTextColumn);

		ImageSizeUpgradeColumnImpl upgradeSizeColumn =
			new ImageSizeUpgradeColumnImpl(upgradeTextColumn);

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			ImageTable.TABLE_NAME, ImageTable.TABLE_COLUMNS,
			upgradePKColumn, upgradeTextColumn, upgradeTypeColumn,
			upgradeHeightColumn, upgradeWidthColumn, upgradeSizeColumn);

		upgradeTable.setCreateSQL(ImageTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(ImageTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		ValueMapper imageIdMapper = new DefaultPKMapper(
			upgradePKColumn.getValueMapper());

		AvailableMappersUtil.setImageIdMapper(imageIdMapper);
	}

}