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

package com.liferay.portlet.blogs.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/blogs/open_search";

	public static final String TITLE = "Liferay Blogs Search: ";

	public String getPortletId() {
		return BlogsIndexer.PORTLET_ID;
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}