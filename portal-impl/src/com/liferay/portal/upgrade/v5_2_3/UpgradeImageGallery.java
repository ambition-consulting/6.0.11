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

package com.liferay.portal.upgrade.v5_2_3;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeImageGallery extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		StringBundler sb = new StringBundler(2);

		sb.append("update IGImage set groupId = (select groupId from ");
		sb.append("IGFolder where IGFolder.folderId = IGImage.folderId)");

		runSQL(sb.toString());
	}

}