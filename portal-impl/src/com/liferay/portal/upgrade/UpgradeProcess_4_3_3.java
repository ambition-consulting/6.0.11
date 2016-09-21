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

package com.liferay.portal.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.upgrade.v4_3_3.UpgradeSchema;
import com.liferay.portal.upgrade.v4_3_3.UpgradeSoftwareCatalog;
import com.liferay.portal.upgrade.v4_3_3.UpgradeTags;
import com.liferay.portal.upgrade.v4_3_3.UpgradeWebsite;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeProcess_4_3_3 extends UpgradeProcess {

	public int getThreshold() {
		return ReleaseInfo.RELEASE_4_3_3_BUILD_NUMBER;
	}

	protected void doUpgrade() throws Exception {
		upgrade(UpgradeSchema.class);
		upgrade(UpgradeSoftwareCatalog.class);
		upgrade(UpgradeTags.class);
		upgrade(UpgradeWebsite.class);
	}

}