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

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupNameUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public GroupNameUpgradeColumnImpl(
		UpgradeColumn groupIdColumn, UpgradeColumn classPKColumn) {

		super("name", new Integer(Types.VARCHAR));

		_groupIdColumn = groupIdColumn;
		_classPKColumn = classPKColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Long classPK = (Long)_classPKColumn.getNewValue();

		if (classPK.longValue() > 0) {
			return _groupIdColumn.getNewValue().toString();
		}
		else {
			return oldValue;
		}
	}

	private UpgradeColumn _groupIdColumn;
	private UpgradeColumn _classPKColumn;

}