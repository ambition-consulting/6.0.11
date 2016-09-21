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
import com.liferay.portal.upgrade.v6_0_11.UpgradeDocumentLibrary;
import com.liferay.portal.upgrade.v6_0_11.UpgradeSchema;

/**
 * @author Brian Wing Shun Chan
 * @author Douglas Wong
 */
public class UpgradeProcess_6_0_11 extends UpgradeProcess {

	public int getThreshold() {
		return ReleaseInfo.RELEASE_6_0_11_BUILD_NUMBER;
	}

	protected void doUpgrade() throws Exception {
		upgrade(UpgradeSchema.class);
		upgrade(UpgradeDocumentLibrary.class);
	}

}