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

package com.liferay.portlet.bookmarks.service;

import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.service.BookmarksEntryServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksEntryServiceTest extends BaseBookmarksServiceTestCase {

	public void testAddEntry() throws Exception {
		addEntry();
	}

	public void testDeleteEntry() throws Exception {
		BookmarksEntry entry = addEntry();

		BookmarksEntryServiceUtil.deleteEntry(entry.getEntryId());
	}

	public void testGetEntry() throws Exception {
		BookmarksEntry entry = addEntry();

		BookmarksEntryServiceUtil.getEntry(entry.getEntryId());
	}

}