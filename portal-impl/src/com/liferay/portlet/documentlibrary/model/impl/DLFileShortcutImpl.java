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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileShortcutImpl
	extends DLFileShortcutModelImpl implements DLFileShortcut {

	public DLFileShortcutImpl() {
	}

	public DLFolder getFolder() {
		DLFolder folder = null;

		if (getFolderId() > 0) {
			try {
				folder = DLFolderLocalServiceUtil.getFolder(getFolderId());
			}
			catch (Exception e) {
				folder = new DLFolderImpl();

				_log.error(e);
			}
		}
		else {
			folder = new DLFolderImpl();
		}

		return folder;
	}

	public DLFileEntry getToFileEntry()
		throws PortalException, SystemException {

		return DLFileEntryLocalServiceUtil.getFileEntry(
			getToFileEntryId());
	}

	/**
	 * @deprecated {@link #getToFileEntry()}
	 */
	public long getToFolderId() throws PortalException, SystemException {
		DLFileEntry fileEntry = getToFileEntry();

		return fileEntry.getFolderId();
	}

	/**
	 * @deprecated {@link #getToFileEntry()}
	 */
	public long getToGroupId() throws PortalException, SystemException {
		DLFileEntry fileEntry = getToFileEntry();

		return fileEntry.getGroupId();
	}

	/**
	 * @deprecated {@link #getToFileEntry()}
	 */
	public String getToName() throws PortalException, SystemException {
		DLFileEntry fileEntry = getToFileEntry();

		return fileEntry.getName();
	}

	public String getToTitle() {
		String toTitle = null;

		try {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
				getToFileEntryId());

			toTitle = fileEntry.getTitle();
		}
		catch (Exception e) {
			_log.error(e);
		}

		return toTitle;
	}

	private static Log _log = LogFactoryUtil.getLog(DLFileShortcutImpl.class);

}