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

package com.liferay.portlet.journal.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleDisplayDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "displayDate ASC, version ASC";

	public static String ORDER_BY_DESC = "displayDate DESC, version DESC";

	public static String[] ORDER_BY_FIELDS = {"displayDate", "version"};

	public ArticleDisplayDateComparator() {
		this(false);
	}

	public ArticleDisplayDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		JournalArticle article1 = (JournalArticle)obj1;
		JournalArticle article2 = (JournalArticle)obj2;

		int value = DateUtil.compareTo(
			article1.getDisplayDate(), article2.getDisplayDate());

		if (value == 0) {
			if (article1.getVersion() < article2.getVersion()) {
				value = -1;
			}
			else if (article1.getVersion() > article2.getVersion()) {
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