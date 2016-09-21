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
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Lock;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class DLFileEntryImpl
	extends DLFileEntryModelImpl implements DLFileEntry {

	public static long getFolderId(long groupId, long repositoryId) {
		if (groupId != repositoryId) {
			return repositoryId;
		}
		else {
			return DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		}
	}

	public static long getRepositoryId(long groupId, long folderId) {
		if (folderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return groupId;
		}
		else {
			return folderId;
		}
	}

	public DLFileEntryImpl() {
	}

	public String getExtraSettings() {
		if (_extraSettingsProperties == null) {
			return super.getExtraSettings();
		}
		else {
			return _extraSettingsProperties.toString();
		}
	}

	public UnicodeProperties getExtraSettingsProperties() {
		if (_extraSettingsProperties == null) {
			_extraSettingsProperties = new UnicodeProperties(true);

			try {
				_extraSettingsProperties.load(super.getExtraSettings());
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}

		return _extraSettingsProperties;
	}

	public DLFileVersion getFileVersion()
		throws PortalException, SystemException {

		return getFileVersion(getVersion());
	}

	public DLFileVersion getFileVersion(String version)
		throws PortalException, SystemException {

		return DLFileVersionLocalServiceUtil.getFileVersion(
			getFileEntryId(), version);
	}

	public List<DLFileVersion> getFileVersions(int status)
		throws SystemException {

		return DLFileVersionLocalServiceUtil.getFileVersions(
			getFileEntryId(), status);
	}

	public DLFolder getFolder() {
		DLFolder folder = null;

		if (getFolderId() > 0) {
			try {
				folder = DLFolderLocalServiceUtil.getFolder(getFolderId());
			}
			catch (Exception e) {
				folder = new DLFolderImpl();

				_log.error(e, e);
			}
		}
		else {
			folder = new DLFolderImpl();
		}

		return folder;
	}

	public String getIcon() {
		return DLUtil.getFileIcon(getExtension());
	}

	public DLFileVersion getLatestFileVersion()
		throws PortalException, SystemException {

		return DLFileVersionLocalServiceUtil.getLatestFileVersion(
			getFileEntryId());
	}

	public Lock getLock() {
		try {
			String lockId = DLUtil.getLockId(
				getGroupId(), getFolderId(), getName());

			return LockLocalServiceUtil.getLock(
				DLFileEntry.class.getName(), lockId);
		}
		catch (Exception e) {
		}

		return null;
	}

	public String getLuceneProperties() {
		UnicodeProperties extraSettingsProps = getExtraSettingsProperties();

		Iterator<Map.Entry<String, String>> itr =
			extraSettingsProps.entrySet().iterator();

		StringBundler sb = new StringBundler(
			extraSettingsProps.entrySet().size() + 4);

		sb.append(FileUtil.stripExtension(getTitle()));
		sb.append(StringPool.SPACE);
		sb.append(getDescription());
		sb.append(StringPool.SPACE);

		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();

			String value = GetterUtil.getString(entry.getValue());

			sb.append(value);
		}

		return sb.toString();
	}

	public long getRepositoryId() {
		return getRepositoryId(getGroupId(), getFolderId());
	}

	public boolean hasLock(long userId) {
		try {
			String lockId = DLUtil.getLockId(
				getGroupId(), getFolderId(), getName());

			return LockLocalServiceUtil.hasLock(
				userId, DLFileEntry.class.getName(), lockId);
		}
		catch (Exception e) {
		}

		return false;
	}

	public boolean isLocked() {
		try {
			String lockId = DLUtil.getLockId(
				getGroupId(), getFolderId(), getName());

			return LockLocalServiceUtil.isLocked(
				DLFileEntry.class.getName(), lockId);
		}
		catch (Exception e) {
		}

		return false;
	}

	public void setExtraSettings(String extraSettings) {
		_extraSettingsProperties = null;

		super.setExtraSettings(extraSettings);
	}

	public void setExtraSettingsProperties(
		UnicodeProperties extraSettingsProperties) {

		_extraSettingsProperties = extraSettingsProperties;

		super.setExtraSettings(_extraSettingsProperties.toString());
	}

	private static Log _log = LogFactoryUtil.getLog(DLFileEntryImpl.class);

	private UnicodeProperties _extraSettingsProperties = null;

}