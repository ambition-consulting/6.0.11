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

/**
 * <p>
 * This class is a wrapper for {@link BookmarksFolderService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookmarksFolderService
 * @generated
 */
public class BookmarksFolderServiceWrapper implements BookmarksFolderService {
	public BookmarksFolderServiceWrapper(
		BookmarksFolderService bookmarksFolderService) {
		_bookmarksFolderService = bookmarksFolderService;
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder addFolder(
		long parentFolderId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolderService.addFolder(parentFolderId, name,
			description, serviceContext);
	}

	public void deleteFolder(long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_bookmarksFolderService.deleteFolder(folderId);
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder getFolder(
		long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolderService.getFolder(folderId);
	}

	public com.liferay.portlet.bookmarks.model.BookmarksFolder updateFolder(
		long folderId, long parentFolderId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentFolder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookmarksFolderService.updateFolder(folderId, parentFolderId,
			name, description, mergeWithParentFolder, serviceContext);
	}

	public BookmarksFolderService getWrappedBookmarksFolderService() {
		return _bookmarksFolderService;
	}

	public void setWrappedBookmarksFolderService(
		BookmarksFolderService bookmarksFolderService) {
		_bookmarksFolderService = bookmarksFolderService;
	}

	private BookmarksFolderService _bookmarksFolderService;
}