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

package com.liferay.portlet.blogs.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.blogs.model.BlogsEntry;

/**
 * @author Alexander Chow
 */
public class EntryDisplayDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "displayDate ASC, entryId ASC";

	public static String ORDER_BY_DESC = "displayDate DESC, entryId DESC";

	public static String[] ORDER_BY_FIELDS = {"displayDate", "entryId"};

	public EntryDisplayDateComparator() {
		this(false);
	}

	public EntryDisplayDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		BlogsEntry entry1 = (BlogsEntry)obj1;
		BlogsEntry entry2 = (BlogsEntry)obj2;

		int value = DateUtil.compareTo(
			entry1.getDisplayDate(), entry2.getDisplayDate());

		if (value == 0) {
			if (entry1.getEntryId() < entry2.getEntryId()) {
				value = -1;
			}
			else if (entry1.getEntryId() > entry2.getEntryId()) {
				value = 1;
			}
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