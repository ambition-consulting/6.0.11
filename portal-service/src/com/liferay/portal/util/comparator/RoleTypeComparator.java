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
import com.liferay.portal.model.Role;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleTypeComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "Role_.type_ ASC, Role_.name ASC";

	public static String ORDER_BY_DESC = "Role_.type_ DESC, Role_.name DESC";

	public static String[] ORDER_BY_FIELDS = {"type", "name"};

	public RoleTypeComparator() {
		this(false);
	}

	public RoleTypeComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		Role role1 = (Role)obj1;
		Role role2 = (Role)obj2;

		int value = 0;

		if (role1.getType() > role2.getType()) {
			value = 1;
		}
		else if (role1.getType() < role2.getType()) {
			value = -1;
		}

		if (value == 0) {
			value = role1.getName().compareTo(role2.getName());
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