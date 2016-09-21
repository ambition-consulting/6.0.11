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
import com.liferay.portal.util.PortletKeys;

/**
 * @author Brian Wing Shun Chan
 */
public class PrefsPlidUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public PrefsPlidUpgradeColumnImpl(
		PrefsOwnerIdUpgradeColumnImpl ownerIdColumn,
		UpgradeColumn layoutIdColumn, ValueMapper layoutPlidMapper) {

		super("plid");

		_ownerIdColumn = ownerIdColumn;
		_layoutIdColumn = layoutIdColumn;
		_layoutPlidMapper = layoutPlidMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Long oldGroupId = _ownerIdColumn.getOldGroupId();
		Long newGroupId = _ownerIdColumn.getNewGroupId();
		Boolean privateLayout = _ownerIdColumn.isPrivateLayout();
		String layoutId = (String)_layoutIdColumn.getOldValue();

		if ((!layoutId.equals("SHARED")) && (oldGroupId != null) &&
			(newGroupId != null) && (privateLayout != null)) {

			String oldOwnerId = null;

			if (privateLayout.booleanValue()) {
				oldOwnerId = "PRI.";
			}
			else {
				oldOwnerId = "PUB.";
			}

			oldOwnerId += oldGroupId.longValue();

			String oldPlidValue =
				"{layoutId=" + layoutId + ", ownerId=" + oldOwnerId + "}";

			return _layoutPlidMapper.getNewValue(oldPlidValue);
		}
		else {
			return new Long(PortletKeys.PREFS_PLID_SHARED);
		}
	}

	private PrefsOwnerIdUpgradeColumnImpl _ownerIdColumn;
	private UpgradeColumn _layoutIdColumn;
	private ValueMapper _layoutPlidMapper;

}