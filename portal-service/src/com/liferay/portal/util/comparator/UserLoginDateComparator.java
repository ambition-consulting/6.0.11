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

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;

/**
 * @author Brian Wing Shun Chan
 */
public class UserLoginDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "User_.loginDate ASC";

	public static String ORDER_BY_DESC = "User_.loginDate DESC";

	public static String[] ORDER_BY_FIELDS = {"loginDate"};

	public UserLoginDateComparator() {
		this(false);
	}

	public UserLoginDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		User user1 = (User)obj1;
		User user2 = (User)obj2;

		int value = DateUtil.compareTo(
			user1.getLoginDate(), user2.getLoginDate());

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