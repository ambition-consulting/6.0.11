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

package com.liferay.portlet.shopping.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.shopping.model.ShoppingItem;

/**
 * @author Brian Wing Shun Chan
 */
public class ItemSKUComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "categoryId ASC, sku ASC";

	public static String ORDER_BY_DESC = "categoryId DESC, sku DESC";

	public static String[] ORDER_BY_FIELDS = {"categoryId", "sku"};

	public ItemSKUComparator() {
		this(false);
	}

	public ItemSKUComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		ShoppingItem item1 = (ShoppingItem)obj1;
		ShoppingItem item2 = (ShoppingItem)obj2;

		Long categoryId1 = new Long(item1.getCategoryId());
		Long categoryId2 = new Long(item2.getCategoryId());

		int value = categoryId1.compareTo(categoryId2);

		if (value == 0) {
			value = item1.getSku().compareTo(item2.getSku());
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}