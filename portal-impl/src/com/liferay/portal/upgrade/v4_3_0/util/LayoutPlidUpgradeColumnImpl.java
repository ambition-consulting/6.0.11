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

import com.liferay.portal.kernel.upgrade.StagnantRowException;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.upgrade.util.ValueMapperFactoryUtil;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutPlidUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public LayoutPlidUpgradeColumnImpl(
		UpgradeColumn upgradeLayoutOwnerIdColumn,
		LayoutOwnerIdUpgradeColumnImpl groupIdColumn,
		LayoutOwnerIdUpgradeColumnImpl privateLayoutColumn,
		UpgradeColumn layoutIdColumn) {

		super("plid", false);

		_upgradeLayoutOwnerIdColumn = upgradeLayoutOwnerIdColumn;
		_groupIdColumn = groupIdColumn;
		_privateLayoutColumn = privateLayoutColumn;
		_layoutIdColumn = layoutIdColumn;
		_layoutPlidMapper = ValueMapperFactoryUtil.getValueMapper();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Object newValue = super.getNewValue(oldValue);

		Long groupId = _groupIdColumn.getGroupId();
		Boolean privateLayout = _privateLayoutColumn.isPrivateLayout();
		Long layoutId = (Long)_layoutIdColumn.getOldValue();

		if ((groupId == null) || (privateLayout == null) ||
			(layoutId == null)) {

			throw new StagnantRowException(
				"{groupId=" + groupId + ",privateLayout=" + privateLayout +
					",layoutId=" + layoutId + "}");
		}

		String oldOwnerId = (String)_upgradeLayoutOwnerIdColumn.getOldValue();

		String oldPlidValue =
			"{layoutId=" + layoutId + ", ownerId=" + oldOwnerId + "}";

		_layoutPlidMapper.mapValue(oldPlidValue, newValue);

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _layoutPlidMapper;
	}

	private UpgradeColumn _upgradeLayoutOwnerIdColumn;
	private LayoutOwnerIdUpgradeColumnImpl _groupIdColumn;
	private LayoutOwnerIdUpgradeColumnImpl _privateLayoutColumn;
	private UpgradeColumn _layoutIdColumn;
	private ValueMapper _layoutPlidMapper;

}