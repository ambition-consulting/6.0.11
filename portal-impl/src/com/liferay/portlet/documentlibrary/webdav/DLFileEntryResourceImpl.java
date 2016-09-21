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

package com.liferay.portlet.documentlibrary.webdav;

import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.webdav.BaseResourceImpl;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.model.Lock;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;

import java.io.InputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileEntryResourceImpl extends BaseResourceImpl {

	public DLFileEntryResourceImpl(
		WebDAVRequest webDavRequest, DLFileEntry fileEntry, String parentPath,
		String name) {

		super(
			parentPath, name, fileEntry.getTitle(), fileEntry.getCreateDate(),
			fileEntry.getModifiedDate(), fileEntry.getSize());

		setModel(fileEntry);
		setClassName(DLFileEntry.class.getName());
		setPrimaryKey(fileEntry.getPrimaryKey());

		_webDavRequest = webDavRequest;
		_fileEntry = fileEntry;
	}

	public boolean isCollection() {
		return false;
	}

	public Lock getLock() {
		try {
			return DLFileEntryServiceUtil.getFileEntryLock(
				_fileEntry.getGroupId(), _fileEntry.getFolderId(),
				_fileEntry.getName());
		}
		catch (Exception e) {
		}

		return null;
	}

	public boolean isLocked() {
		try {
			return DLFileEntryServiceUtil.hasFileEntryLock(
				_fileEntry.getGroupId(), _fileEntry.getFolderId(),
				_fileEntry.getName());
		}
		catch (Exception e) {
		}

		return false;
	}

	public String getContentType() {
		return MimeTypesUtil.getContentType(_fileEntry.getTitle());
	}

	public InputStream getContentAsStream() throws WebDAVException {
		try {
			String version = StringPool.BLANK;

			if (PropsValues.DL_WEBDAV_HOLD_LOCK) {

				// Get last version regardless of status

				DLFileVersion fileVersion = _fileEntry.getLatestFileVersion();

				version = fileVersion.getVersion();
			}

			return DLFileEntryLocalServiceUtil.getFileAsStream(
				_webDavRequest.getCompanyId(), _webDavRequest.getUserId(),
				_fileEntry.getGroupId(), _fileEntry.getFolderId(),
				_fileEntry.getName(), version);
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	private WebDAVRequest _webDavRequest;
	private DLFileEntry _fileEntry;

}