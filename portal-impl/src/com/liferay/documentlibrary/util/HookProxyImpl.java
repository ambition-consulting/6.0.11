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

package com.liferay.documentlibrary.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.service.ServiceContext;

import java.io.File;
import java.io.InputStream;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class HookProxyImpl implements Hook {

	public void addDirectory(long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.addDirectory(companyId, repositoryId, dirName);
	}

	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, bytes);
	}

	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, File file)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, file);
	}

	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, InputStream is)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, is);
	}

	public void checkRoot(long companyId) throws SystemException {
		Hook hook = HookFactory.getInstance();

		hook.checkRoot(companyId);
	}

	public void deleteDirectory(
			long companyId, String portletId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.deleteDirectory(companyId, portletId, repositoryId, dirName);
	}

	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.deleteFile(companyId, portletId, repositoryId, fileName);
	}

	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName, String versionNumber)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.deleteFile(
			companyId, portletId, repositoryId, fileName, versionNumber);
	}

	public byte[] getFile(long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFile(companyId, repositoryId, fileName);
	}

	public byte[] getFile(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFile(companyId, repositoryId, fileName, versionNumber);
	}

	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFileAsStream(companyId, repositoryId, fileName);
	}

	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFileAsStream(
			companyId, repositoryId, fileName, versionNumber);
	}

	public String[] getFileNames(
			long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFileNames(companyId, repositoryId, dirName);
	}

	public long getFileSize(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.getFileSize(companyId, repositoryId, fileName);
	}

	public boolean hasFile(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		return hook.hasFile(companyId, repositoryId, fileName, versionNumber);
	}

	public void move(String srcDir, String destDir) throws SystemException {
		Hook hook = HookFactory.getInstance();

		hook.move(srcDir, destDir);
	}

	public void reindex(String[] ids) throws SearchException {
		Hook hook = HookFactory.getInstance();

		hook.reindex(ids);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			long newRepositoryId, String fileName, long fileEntryId)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.updateFile(
			companyId, portletId, groupId, repositoryId, newRepositoryId,
			fileName, fileEntryId);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String newFileName, boolean reindex)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			newFileName, reindex);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, bytes);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, File file)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, file);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, InputStream is)
		throws PortalException, SystemException {

		Hook hook = HookFactory.getInstance();

		hook.updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, is);
	}

}