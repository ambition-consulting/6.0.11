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

package com.liferay.portlet.documentlibrary.service;

/**
 * <p>
 * This class is a wrapper for {@link DLFileShortcutService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DLFileShortcutService
 * @generated
 */
public class DLFileShortcutServiceWrapper implements DLFileShortcutService {
	public DLFileShortcutServiceWrapper(
		DLFileShortcutService dlFileShortcutService) {
		_dlFileShortcutService = dlFileShortcutService;
	}

	public com.liferay.portlet.documentlibrary.model.DLFileShortcut addFileShortcut(
		long groupId, long folderId, long toFileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileShortcutService.addFileShortcut(groupId, folderId,
			toFileEntryId, serviceContext);
	}

	public void deleteFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dlFileShortcutService.deleteFileShortcut(fileShortcutId);
	}

	public com.liferay.portlet.documentlibrary.model.DLFileShortcut getFileShortcut(
		long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileShortcutService.getFileShortcut(fileShortcutId);
	}

	public com.liferay.portlet.documentlibrary.model.DLFileShortcut updateFileShortcut(
		long fileShortcutId, long folderId, long toFileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileShortcutService.updateFileShortcut(fileShortcutId,
			folderId, toFileEntryId, serviceContext);
	}

	public DLFileShortcutService getWrappedDLFileShortcutService() {
		return _dlFileShortcutService;
	}

	public void setWrappedDLFileShortcutService(
		DLFileShortcutService dlFileShortcutService) {
		_dlFileShortcutService = dlFileShortcutService;
	}

	private DLFileShortcutService _dlFileShortcutService;
}