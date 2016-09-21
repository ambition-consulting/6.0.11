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

import com.liferay.portal.model.Layout;
import com.liferay.portal.service.BaseServiceTestCase;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.TestPropsValues;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.model.BookmarksFolderConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseBookmarksServiceTestCase extends BaseServiceTestCase {

	protected BookmarksEntry addEntry() throws Exception {
		BookmarksFolder folder = addFolder();

		String name = "Test Entry";
		String url = "http://www.liferay.com";
		String comments = "This is a test entry.";

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return BookmarksEntryServiceUtil.addEntry(
			folder.getGroupId(), folder.getFolderId(), name, url, comments,
			serviceContext);
	}

	protected BookmarksFolder addFolder() throws Exception {
		long parentFolderId = BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		return addFolder(parentFolderId);
	}

	protected BookmarksFolder addFolder(long parentFolderId) throws Exception {
		String name = "Test Folder";
		String description = "This is a test folder.";

		Layout layout = LayoutLocalServiceUtil.getLayout(
			TestPropsValues.LAYOUT_PLID);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(layout.getGroupId());

		return BookmarksFolderServiceUtil.addFolder(
			parentFolderId, name, description, serviceContext);
	}

}