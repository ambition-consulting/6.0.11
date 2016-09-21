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

package com.liferay.portlet.shopping.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.shopping.model.ShoppingOrderItem;
import com.liferay.portlet.shopping.service.base.ShoppingOrderItemLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderItemLocalServiceImpl
	extends ShoppingOrderItemLocalServiceBaseImpl {

	public List<ShoppingOrderItem> getOrderItems(long orderId)
		throws SystemException {

		return shoppingOrderItemPersistence.findByOrderId(orderId);
	}

}