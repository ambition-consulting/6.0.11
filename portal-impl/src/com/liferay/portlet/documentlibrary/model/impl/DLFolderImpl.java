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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFolderImpl extends DLFolderModelImpl implements DLFolder {

	public DLFolderImpl() {
	}

	public List<DLFolder> getAncestors()
		throws PortalException, SystemException {

		List<DLFolder> ancestors = new ArrayList<DLFolder>();

		DLFolder folder = this;

		while (true) {
			if (!folder.isRoot()) {
				folder = folder.getParentFolder();

				ancestors.add(folder);
			}
			else {
				break;
			}
		}

		return ancestors;
	}

	public DLFolder getParentFolder()
		throws PortalException, SystemException {

		if (getParentFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return null;
		}

		return DLFolderLocalServiceUtil.getFolder(getParentFolderId());
	}

	public String getPath() throws PortalException, SystemException {
		StringBuilder sb = new StringBuilder();

		DLFolder folder = this;

		while (true) {
			sb.insert(0, folder.getName());
			sb.insert(0, StringPool.SLASH);

			if (folder.getParentFolderId() !=
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

				folder = DLFolderLocalServiceUtil.getFolder(
					folder.getParentFolderId());
			}
			else {
				break;
			}
		}

		return sb.toString();
	}

	public String[] getPathArray() throws PortalException, SystemException {
		String path = getPath();

		// Remove leading /

		path = path.substring(1, path.length());

		return StringUtil.split(path, StringPool.SLASH);
	}

	public boolean hasLock(long userId) {
		try {
			return LockLocalServiceUtil.hasLock(
				userId, DLFileEntry.class.getName(), getFolderId());
		}
		catch (Exception e) {
		}

		return false;
	}

	public boolean isLocked() {
		try {
			return LockLocalServiceUtil.isLocked(
				DLFolder.class.getName(), getFolderId());
		}
		catch (Exception e) {
		}

		return false;
	}

	public boolean isRoot() {
		if (getParentFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return true;
		}
		else {
			return false;
		}
	}

}