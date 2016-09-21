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

import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;
import com.liferay.portal.service.ServiceContext;

import java.io.File;
import java.io.InputStream;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class HookProxyBean extends BaseProxyBean implements Hook {

	public void addDirectory(
		long companyId, long repositoryId, String dirName) {

		throw new UnsupportedOperationException();
	}

	public void addFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, long fileEntryId, String properties, Date modifiedDate,
		ServiceContext serviceContext, byte[] bytes) {

		throw new UnsupportedOperationException();
	}

	public void addFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, long fileEntryId, String properties,
		Date modifiedDate, ServiceContext serviceContext, File file) {

		throw new UnsupportedOperationException();
	}

	public void addFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, long fileEntryId, String properties,
		Date modifiedDate, ServiceContext serviceContext, InputStream is) {

		throw new UnsupportedOperationException();
	}

	public void checkRoot(long companyId) {
		throw new UnsupportedOperationException();
	}

	public void deleteDirectory(
		long companyId, String portletId, long repositoryId, String dirName) {

		throw new UnsupportedOperationException();
	}

	public void deleteFile(
		long companyId, String portletId, long repositoryId, String fileName) {

		throw new UnsupportedOperationException();
	}

	public void deleteFile(
		long companyId, String portletId, long repositoryId, String fileName,
		String versionNumber) {

		throw new UnsupportedOperationException();
	}

	public byte[] getFile(long companyId, long repositoryId, String fileName) {
		throw new UnsupportedOperationException();
	}

	public byte[] getFile(
		long companyId, long repositoryId, String fileName,
		String versionNumber) {

		throw new UnsupportedOperationException();
	}

	public InputStream getFileAsStream(
		long companyId, long repositoryId, String fileName) {

		throw new UnsupportedOperationException();
	}

	public InputStream getFileAsStream(
		long companyId, long repositoryId, String fileName,
		String versionNumber) {

		throw new UnsupportedOperationException();
	}

	public String[] getFileNames(
		long companyId, long repositoryId, String dirName) {

		throw new UnsupportedOperationException();
	}

	public long getFileSize(
		long companyId, long repositoryId, String fileName) {

		throw new UnsupportedOperationException();
	}

	public boolean hasFile(
		long companyId, long repositoryId, String fileName,
		String versionNumber) {

		throw new UnsupportedOperationException();
	}

	public void move(String srcDir, String destDir) {
		throw new UnsupportedOperationException();
	}

	public void reindex(String[] ids) {
		throw new UnsupportedOperationException();
	}

	public void updateFile(
		long companyId, String portletId, long groupId, long repositoryId,
		long newRepositoryId, String fileName, long fileEntryId) {

		throw new UnsupportedOperationException();
	}

	public void updateFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, String newFileName, boolean reindex) {

		throw new UnsupportedOperationException();
	}

	public void updateFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, String versionNumber, String sourceFileName,
		long fileEntryId, String properties, Date modifiedDate,
		ServiceContext serviceContext, byte[] bytes) {

		throw new UnsupportedOperationException();
	}

	public void updateFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, String versionNumber, String sourceFileName,
		long fileEntryId, String properties, Date modifiedDate,
		ServiceContext serviceContext, File file) {

		throw new UnsupportedOperationException();
	}

	public void updateFile(
		long companyId, String portletId, long groupId, long repositoryId,
		String fileName, String versionNumber, String sourceFileName,
		long fileEntryId, String properties, Date modifiedDate,
		ServiceContext serviceContext, InputStream is) {

		throw new UnsupportedOperationException();
	}

}