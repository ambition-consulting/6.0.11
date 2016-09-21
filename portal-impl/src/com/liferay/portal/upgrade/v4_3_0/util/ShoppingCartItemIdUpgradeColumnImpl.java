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
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCartItemIdUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public ShoppingCartItemIdUpgradeColumnImpl(
		ValueMapper shoppingItemIdMapper) {

		super("itemId");

		_shoppingItemIdMapper = shoppingItemIdMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String itemId = (String)oldValue;

		int pos = itemId.indexOf("|");

		if (pos == -1) {
			return String.valueOf(_shoppingItemIdMapper.getNewValue(
				new Long(GetterUtil.getLong(itemId))));
		}
		else {
			Long oldItemId = new Long(
				GetterUtil.getLong(itemId.substring(0, pos)));

			return _shoppingItemIdMapper.getNewValue(oldItemId) +
				itemId.substring(pos, itemId.length());
		}
	}

	private ValueMapper _shoppingItemIdMapper;

}