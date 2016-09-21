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
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.service.base.BookmarksFolderServiceBaseImpl;
import com.liferay.portlet.bookmarks.service.permission.BookmarksFolderPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksFolderServiceImpl extends BookmarksFolderServiceBaseImpl {

	public BookmarksFolder addFolder(
			long parentFolderId, String name, String description,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		BookmarksFolderPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			parentFolderId, ActionKeys.ADD_FOLDER);

		return bookmarksFolderLocalService.addFolder(
			getUserId(), parentFolderId, name, description, serviceContext);
	}

	public void deleteFolder(long folderId)
		throws PortalException, SystemException {

		BookmarksFolder folder = bookmarksFolderLocalService.getFolder(
			folderId);

		BookmarksFolderPermission.check(
			getPermissionChecker(), folder, ActionKeys.DELETE);

		bookmarksFolderLocalService.deleteFolder(folderId);
	}

	public BookmarksFolder getFolder(long folderId)
		throws PortalException, SystemException {

		BookmarksFolder folder = bookmarksFolderLocalService.getFolder(
			folderId);

		BookmarksFolderPermission.check(
			getPermissionChecker(), folder, ActionKeys.VIEW);

		return folder;
	}

	public BookmarksFolder updateFolder(
			long folderId, long parentFolderId, String name,
			String description, boolean mergeWithParentFolder,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		BookmarksFolder folder = bookmarksFolderLocalService.getFolder(
			folderId);

		BookmarksFolderPermission.check(
			getPermissionChecker(), folder, ActionKeys.UPDATE);

		return bookmarksFolderLocalService.updateFolder(
			folderId, parentFolderId, name, description, mergeWithParentFolder,
			serviceContext);
	}

}