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

package com.liferay.documentlibrary.service.impl;

import com.liferay.documentlibrary.service.DLLocalService;
import com.liferay.documentlibrary.service.DLService;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.io.File;

import java.util.Date;

/**
 * @author	   Brian Wing Shun Chan
 * @author	   Michael Young
 * @author	   Alexander Chow
 * @deprecated {@link DLLocalServiceImpl}
 */
public class DLServiceImpl implements DLService {

	public static final String GROUP_NAME = DLServiceImpl.class.getName();

	public static final String[] GROUP_NAME_ARRAY = new String[] {GROUP_NAME};

	public void addDirectory(long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		dlLocalService.addDirectory(companyId, repositoryId, dirName);
	}

	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		dlLocalService.addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, bytes);
	}

	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, File file)
		throws PortalException, SystemException {

		dlLocalService.addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, file);
	}

	public void deleteDirectory(
			long companyId, String portletId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		dlLocalService.deleteDirectory(
			companyId, portletId, repositoryId, dirName);
	}

	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName)
		throws PortalException, SystemException {

		dlLocalService.deleteFile(companyId, portletId, repositoryId, fileName);
	}

	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName, String versionNumber)
		throws PortalException, SystemException {

		dlLocalService.deleteFile(
			companyId, portletId, repositoryId, fileName, versionNumber);
	}

	public byte[] getFile(long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return dlLocalService.getFile(companyId, repositoryId, fileName);
	}

	public byte[] getFile(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		return dlLocalService.getFile(
			companyId, repositoryId, fileName, versionNumber);
	}

	public String[] getFileNames(
			long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		return dlLocalService.getFileNames(companyId, repositoryId, dirName);
	}

	public long getFileSize(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return dlLocalService.getFileSize(companyId, repositoryId, fileName);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			long newRepositoryId, String fileName, long fileEntryId)
		throws PortalException, SystemException {

		dlLocalService.updateFile(
			companyId, portletId, groupId, repositoryId, newRepositoryId,
			fileName, fileEntryId);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		dlLocalService.updateFile(
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

		dlLocalService.updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, file);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String newFileName, boolean reindex)
		throws PortalException, SystemException {

		dlLocalService.updateFile(
			companyId, portletId, groupId, repositoryId, fileName, newFileName,
			reindex);
	}

	@BeanReference(type = DLLocalService.class)
	protected DLLocalService dlLocalService;

}