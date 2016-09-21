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

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class ContactIdUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public ContactIdUpgradeColumnImpl(
		UpgradeColumn screenNameColumn, ValueMapper valueMapper) {

		super("contactId");

		_screenNameColumn = screenNameColumn;
		_valueMapper = valueMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String userId = (String)_screenNameColumn.getOldValue();

		return _valueMapper.getNewValue(userId);
	}

	private UpgradeColumn _screenNameColumn;
	private ValueMapper _valueMapper;

}