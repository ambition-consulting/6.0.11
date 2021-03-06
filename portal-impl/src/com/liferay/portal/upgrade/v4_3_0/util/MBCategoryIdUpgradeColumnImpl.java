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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class MBCategoryIdUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public MBCategoryIdUpgradeColumnImpl() {
		super("categoryId", true);
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Long categoryId = (Long)oldValue;

		if (categoryId.longValue() == 0) {
			return new Long(0);
		}
		else {
			return super.getNewValue(oldValue);
		}
	}

}