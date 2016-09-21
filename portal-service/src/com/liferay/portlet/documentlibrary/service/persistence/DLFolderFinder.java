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

package com.liferay.portlet.documentlibrary.service.persistence;

/**
 * @author Brian Wing Shun Chan
 */
public interface DLFolderFinder {
	public int countF_FE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countFE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int filterCountF_FE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int filterCountFE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> filterFindF_FE_FS_ByG_F_S(
		long groupId, java.util.List<java.lang.Long> folderIds, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> filterFindFE_FS_ByG_F_S(
		long groupId, java.util.List<java.lang.Long> folderIds, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> findF_FE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> findFE_FS_ByG_F_S(long groupId,
		java.util.List<java.lang.Long> folderIds, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}