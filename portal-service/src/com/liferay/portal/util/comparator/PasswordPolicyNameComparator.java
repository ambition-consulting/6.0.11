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
import com.liferay.portal.model.PasswordPolicy;

/**
 * @author Brian Wing Shun Chan
 */
public class PasswordPolicyNameComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "PasswordPolicy.name ASC";

	public static String ORDER_BY_DESC = "PasswordPolicy.name DESC";

	public static String[] ORDER_BY_FIELDS = {"name"};

	public PasswordPolicyNameComparator() {
		this(false);
	}

	public PasswordPolicyNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		PasswordPolicy passwordPolicy1 = (PasswordPolicy)obj1;
		PasswordPolicy passwordPolicy2 = (PasswordPolicy)obj2;

		int value = passwordPolicy1.getName().compareTo(
			passwordPolicy2.getName());

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