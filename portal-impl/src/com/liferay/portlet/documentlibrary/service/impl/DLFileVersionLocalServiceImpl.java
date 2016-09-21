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

package com.liferay.portlet.documentlibrary.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileVersionException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.base.DLFileVersionLocalServiceBaseImpl;
import com.liferay.portlet.documentlibrary.util.comparator.FileVersionVersionComparator;

import java.util.Collections;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 * @author Jorge Ferrer
 */
public class DLFileVersionLocalServiceImpl
	extends DLFileVersionLocalServiceBaseImpl {

	public DLFileVersion getFileVersion(long fileVersionId)
		throws PortalException, SystemException {

		return dlFileVersionPersistence.findByPrimaryKey(fileVersionId);
	}

	/**
	 * @deprecated {@link #getFileVersion(long, String)}
	 */
	public DLFileVersion getFileVersion(
			long groupId, long folderId, String name, String version)
		throws PortalException, SystemException {

		long fileEntryId = 0;

		try {
			DLFileEntry fileEntry = dlFileEntryPersistence.findByG_F_N(
				groupId, folderId, name);

			fileEntryId = fileEntry.getFileEntryId();
		}
		catch (NoSuchFileEntryException nsfe) {
			throw new NoSuchFileVersionException();
		}

		return getFileVersion(fileEntryId, version);
	}

	public DLFileVersion getFileVersion(long fileEntryId, String version)
		throws PortalException, SystemException {

		return dlFileVersionPersistence.findByF_V(fileEntryId, version);
	}

	public List<DLFileVersion> getFileVersions(long fileEntryId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return dlFileVersionPersistence.findByFileEntryId(fileEntryId);
		}
		else {
			return dlFileVersionPersistence.findByF_S(fileEntryId, status);
		}
	}

	/**
	 * @deprecated {@link #getFileVersions(long, int)}
	 */
	public List<DLFileVersion> getFileVersions(
			long groupId, long folderId, String name, int status)
		throws SystemException {

		long fileEntryId = 0;

		try {
			DLFileEntry fileEntry = dlFileEntryPersistence.findByG_F_N(
				groupId, folderId, name);

			fileEntryId = fileEntry.getFileEntryId();
		}
		catch (NoSuchFileEntryException nsfe) {
			return Collections.EMPTY_LIST;
		}

		return getFileVersions(fileEntryId, status);
	}

	public DLFileVersion getLatestFileVersion(long fileEntryId)
		throws PortalException, SystemException {

		List<DLFileVersion> fileVersions =
			dlFileVersionPersistence.findByFileEntryId(fileEntryId);

		if (fileVersions.isEmpty()) {
			throw new NoSuchFileVersionException();
		}

		fileVersions = ListUtil.copy(fileVersions);

		Collections.sort(fileVersions, new FileVersionVersionComparator());

		return fileVersions.get(0);
	}

	/**
	 * @deprecated {@link #getLatestFileVersion(long)}
	 */
	public DLFileVersion getLatestFileVersion(
			long groupId, long folderId, String name)
		throws PortalException, SystemException {

		long fileEntryId = 0;

		try {
			DLFileEntry fileEntry = dlFileEntryPersistence.findByG_F_N(
				groupId, folderId, name);

			fileEntryId = fileEntry.getFileEntryId();
		}
		catch (NoSuchFileEntryException nsfe) {
			throw new NoSuchFileVersionException();
		}

		return getLatestFileVersion(fileEntryId);
	}

	public DLFileVersion updateDescription(
			long fileVersionId, String description)
		throws PortalException, SystemException {

		DLFileVersion fileVersion = dlFileVersionPersistence.findByPrimaryKey(
			fileVersionId);

		fileVersion.setDescription(description);

		dlFileVersionPersistence.update(fileVersion, false);

		return fileVersion;
	}

}