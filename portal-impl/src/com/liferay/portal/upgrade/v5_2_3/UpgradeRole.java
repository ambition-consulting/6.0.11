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
import com.liferay.portal.model.Role;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeRole extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		long classNameId = PortalUtil.getClassNameId(Role.class.getName());

		runSQL(
			"update Role_ set classNameId = " + classNameId +
				", classPK = roleId where classNameId = 0");
	}

}