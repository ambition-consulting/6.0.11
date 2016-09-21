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
import com.liferay.portal.upgrade.v4_4_0.UpgradeDocumentLibrary;
import com.liferay.portal.upgrade.v4_4_0.UpgradeGroup;
import com.liferay.portal.upgrade.v4_4_0.UpgradeLayout;
import com.liferay.portal.upgrade.v4_4_0.UpgradePermission;
import com.liferay.portal.upgrade.v4_4_0.UpgradeSchema;
import com.liferay.portal.upgrade.v4_4_0.UpgradeTags;
import com.liferay.portal.upgrade.v4_4_0.UpgradeUUID;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated
 */
public class UpgradeProcess_4_4_0 extends UpgradeProcess {

	public int getThreshold() {
		return ReleaseInfo.RELEASE_4_4_0_BUILD_NUMBER;
	}

	protected void doUpgrade() throws Exception {
		upgrade(UpgradeSchema.class);
		upgrade(UpgradeUUID.class);
		upgrade(UpgradeDocumentLibrary.class);
		upgrade(UpgradeGroup.class);
		upgrade(UpgradeLayout.class);
		upgrade(UpgradePermission.class);
		upgrade(UpgradeTags.class);
	}

}