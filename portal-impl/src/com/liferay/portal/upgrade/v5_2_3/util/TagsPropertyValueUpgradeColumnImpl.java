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

package com.liferay.portal.upgrade.v5_2_3.util;

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
public class TagsPropertyValueUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public TagsPropertyValueUpgradeColumnImpl(String name) {
		super(name);
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String value = (String)oldValue;

		if (Validator.isNull(value)) {
			return StringPool.BLANK;
		}
		else {
			return StringUtil.shorten(value, 255, StringPool.BLANK);
		}
	}

}