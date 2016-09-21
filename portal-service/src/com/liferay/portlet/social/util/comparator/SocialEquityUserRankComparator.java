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

package com.liferay.portlet.social.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.social.model.SocialEquityUser;

/**
 * @author Zsolt Berentey
 */
public class SocialEquityUserRankComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "SocialEquityUser.rank ASC";

	public static String ORDER_BY_DESC = "SocialEquityUser.rank DESC";

	public static String[] ORDER_BY_FIELDS = {"rank"};

	public SocialEquityUserRankComparator() {
		this(false);
	}

	public SocialEquityUserRankComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		SocialEquityUser socialEquityUser1 = (SocialEquityUser)obj1;
		SocialEquityUser socialEquityUser2 = (SocialEquityUser)obj2;

		int value = 0;

		if (socialEquityUser1.getRank() > socialEquityUser2.getRank()) {
			value = 1;
		}
		else if (socialEquityUser1.getRank() < socialEquityUser2.getRank()) {
			value = -1;
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