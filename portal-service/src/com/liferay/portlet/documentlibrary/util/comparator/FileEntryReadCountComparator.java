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

package com.liferay.portlet.documentlibrary.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

/**
 * @author Brian Wing Shun Chan
 */
public class FileEntryReadCountComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "readCount ASC";

	public static String ORDER_BY_DESC = "readCount DESC";

	public static String[] ORDER_BY_FIELDS = {"readCount"};

	public FileEntryReadCountComparator() {
		this(false);
	}

	public FileEntryReadCountComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		DLFileEntry fileEntry1 = (DLFileEntry)obj1;
		DLFileEntry fileEntry2 = (DLFileEntry)obj2;

		int value = 0;

		if (fileEntry1.getReadCount() < fileEntry2.getReadCount()) {
			value = -1;
		}
		else if (fileEntry1.getReadCount() > fileEntry2.getReadCount()) {
			value = 1;
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