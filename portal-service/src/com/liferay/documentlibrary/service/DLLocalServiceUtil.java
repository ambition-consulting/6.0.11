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

package com.liferay.documentlibrary.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.io.File;
import java.io.InputStream;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class DLLocalServiceUtil {

	public static void addDirectory(
			long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		getService().addDirectory(companyId, repositoryId, dirName);
	}

	public static void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, boolean validateFileExtension, long fileEntryId,
			String properties, Date modifiedDate, ServiceContext serviceContext,
			InputStream is)
		throws PortalException, SystemException {

		getService().addFile(
			companyId, portletId, groupId, repositoryId, fileName,
			validateFileExtension, fileEntryId, properties, modifiedDate,
			serviceContext, is);
	}

	public static void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		getService().addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, bytes);
	}

	public static void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, File file)
		throws PortalException, SystemException {

		getService().addFile(
			companyId, portletId, groupId, repositoryId, fileName, fileEntryId,
			properties, modifiedDate, serviceContext, file);
	}

	public static void checkRoot(long companyId) throws SystemException {
		getService().checkRoot(companyId);
	}

	public static void deleteDirectory(
			long companyId, String portletId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		getService().deleteDirectory(
			companyId, portletId, repositoryId, dirName);
	}

	public static void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName)
		throws PortalException, SystemException {

		getService().deleteFile(
			companyId, portletId, repositoryId, fileName);
	}

	public static void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName, String versionNumber)
		throws PortalException, SystemException {

		getService().deleteFile(
			companyId, portletId, repositoryId, fileName, versionNumber);
	}

	public static byte[] getFile(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return getService().getFile(companyId, repositoryId, fileName);
	}

	public static byte[] getFile(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		return getService().getFile(
			companyId, repositoryId, fileName, versionNumber);
	}

	public static InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return getService().getFileAsStream(companyId, repositoryId, fileName);
	}

	public static InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		return getService().getFileAsStream(
			companyId, repositoryId, fileName, versionNumber);
	}

	public static String[] getFileNames(
			long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		return getService().getFileNames(companyId, repositoryId, dirName);
	}

	public static long getFileSize(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return getService().getFileSize(companyId, repositoryId, fileName);
	}

	public static DLLocalService getService() {
		if (_service == null) {
			_service = (DLLocalService)PortalBeanLocatorUtil.locate(
				DLLocalService.class.getName());

			ReferenceRegistry.registerReference(
				DLLocalServiceUtil.class, "_service");

			MethodCache.remove(DLLocalService.class);
		}

		return _service;
	}

	public static boolean hasFile(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException, SystemException {

		return getService().hasFile(
			companyId, repositoryId, fileName, versionNumber);
	}

	public static void move(String srcDir, String destDir)
		throws SystemException {

		getService().move(srcDir, destDir);
	}

	public static Hits search(
			long companyId, String portletId, long groupId,
			long userId, long[] repositoryIds, String keywords, int start,
			int end)
		throws SystemException {

		return getService().search(
			companyId, portletId, groupId, userId, repositoryIds, keywords,
			start, end);
	}

	public static void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			long newRepositoryId, String fileName, long fileEntryId)
		throws PortalException, SystemException {

		getService().updateFile(
			companyId, portletId, groupId, repositoryId, newRepositoryId,
			fileName, fileEntryId);
	}

	public static void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String newFileName, boolean reindex)
		throws PortalException, SystemException {

		getService().updateFile(
			companyId, portletId, groupId, repositoryId, fileName, newFileName,
			reindex);
	}

	public static void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String fileExtension,
			boolean validateFileExtension, String versionNumber,
			String sourceFileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, InputStream is)
		throws PortalException, SystemException {

		getService().updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			fileExtension, validateFileExtension, versionNumber, sourceFileName,
			fileEntryId, properties, modifiedDate, serviceContext, is);
	}

	public static void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, byte[] bytes)
		throws PortalException, SystemException {

		getService().updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, bytes);
	}

	public static void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, File file)
		throws PortalException, SystemException {

		getService().updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			versionNumber, sourceFileName, fileEntryId, properties,
			modifiedDate, serviceContext, file);
	}

	public static void validate(
			String fileName, boolean validateFileExtension, byte[] bytes)
		throws PortalException, SystemException {

		getService().validate(fileName, validateFileExtension, bytes);
	}

	public static void validate(
			String fileName, boolean validateFileExtension, File file)
		throws PortalException, SystemException {

		getService().validate(fileName, validateFileExtension, file);
	}

	public static void validate(
			String fileName, boolean validateFileExtension, InputStream is)
		throws PortalException, SystemException {

		getService().validate(fileName, validateFileExtension, is);
	}

	public static void validate(
			String fileName, String fileExtension, String sourceFileName,
			boolean validateFileExtension, InputStream is)
		throws PortalException, SystemException {

		getService().validate(
			fileName, fileExtension, sourceFileName, validateFileExtension, is);
	}

	public void setService(DLLocalService service) {
		_service = service;

		ReferenceRegistry.registerReference(
			DLLocalServiceUtil.class, "_service");

		MethodCache.remove(DLLocalService.class);
	}

	private static DLLocalService _service;

}