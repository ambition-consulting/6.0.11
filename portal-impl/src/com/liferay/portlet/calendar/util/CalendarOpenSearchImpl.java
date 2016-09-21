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

package com.liferay.portlet.calendar.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;

/**
 * @author Brett Swaim
 */
public class CalendarOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/calendar/open_search";

	public static final String TITLE = "Liferay Calendar Search: ";

	public String getPortletId() {
		return CalIndexer.PORTLET_ID;
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}