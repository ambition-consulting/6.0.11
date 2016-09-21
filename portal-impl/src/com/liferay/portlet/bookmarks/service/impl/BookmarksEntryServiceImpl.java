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

package com.liferay.portlet.bookmarks.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.service.base.BookmarksEntryServiceBaseImpl;
import com.liferay.portlet.bookmarks.service.permission.BookmarksEntryPermission;
import com.liferay.portlet.bookmarks.service.permission.BookmarksFolderPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksEntryServiceImpl extends BookmarksEntryServiceBaseImpl {

	public BookmarksEntry addEntry(
			long groupId, long folderId, String name, String url,
			String comments, ServiceContext serviceContext)
		throws PortalException, SystemException {

		BookmarksFolderPermission.check(
			getPermissionChecker(), groupId, folderId, ActionKeys.ADD_ENTRY);

		return bookmarksEntryLocalService.addEntry(
			getUserId(), groupId, folderId, name, url, comments,
			serviceContext);
	}

	public void deleteEntry(long entryId)
		throws PortalException, SystemException {

		BookmarksEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		bookmarksEntryLocalService.deleteEntry(entryId);
	}

	public BookmarksEntry getEntry(long entryId)
		throws PortalException, SystemException {

		BookmarksEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.VIEW);

		return bookmarksEntryLocalService.getEntry(entryId);
	}

	public BookmarksEntry openEntry(long entryId)
		throws PortalException, SystemException {

		BookmarksEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.VIEW);

		return bookmarksEntryLocalService.openEntry(
			getGuestOrUserId(), entryId);
	}

	public BookmarksEntry updateEntry(
			long entryId, long groupId, long folderId, String name, String url,
			String comments, ServiceContext serviceContext)
		throws PortalException, SystemException {

		BookmarksEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.UPDATE);

		return bookmarksEntryLocalService.updateEntry(
			getUserId(), entryId, groupId, folderId, name, url, comments,
			serviceContext);
	}

}