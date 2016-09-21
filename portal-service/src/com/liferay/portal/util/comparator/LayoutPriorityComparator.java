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

package com.liferay.portal.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Layout;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutPriorityComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "priority ASC";

	public static String[] ORDER_BY_FIELDS = {"priority"};

	public LayoutPriorityComparator(Layout layout, boolean lessThan) {
		_layout = layout;
		_lessThan = lessThan;
	}

	public int compare(Object obj1, Object obj2) {
		Layout layout1 = (Layout)obj1;
		Layout layout2 = (Layout)obj2;

		int priority1 = layout1.getPriority();
		int priority2 = layout2.getPriority();

		if (priority1 > priority2) {
			return 1;
		}
		else if (priority1 < priority2) {
			return -1;
		}
		else {
			if (_layout.equals(layout1)) {
				if (_lessThan) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if (_layout.equals(layout2)) {
				if (_lessThan) {
					return -1;
				}
				else {
					return 1;
				}
			}

			return 0;
		}
	}

	public String getOrderBy() {
		return ORDER_BY_ASC;
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return true;
	}

	private Layout _layout;
	private boolean _lessThan;

}