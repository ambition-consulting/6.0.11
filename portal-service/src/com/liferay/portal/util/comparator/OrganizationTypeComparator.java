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
import com.liferay.portal.model.Organization;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationTypeComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "orgType ASC, orgName ASC";

	public static String ORDER_BY_DESC = "orgType DESC, orgName DESC";

	public static String[] ORDER_BY_FIELDS = {"type", "name"};

	public OrganizationTypeComparator() {
		this(false);
	}

	public OrganizationTypeComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		Organization organization1 = (Organization)obj1;
		Organization organization2 = (Organization)obj2;

		int typeOrder1 = organization1.getTypeOrder();
		int typeOrder2 = organization2.getTypeOrder();

		int value = typeOrder1 - typeOrder2;

		if (value == 0) {
			value = organization1.getName().compareTo(organization2.getName());
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