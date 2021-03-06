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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileRank;
import com.liferay.portlet.documentlibrary.service.base.DLFileRankLocalServiceBaseImpl;
import com.liferay.portlet.documentlibrary.util.comparator.FileRankCreateDateComparator;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileRankLocalServiceImpl extends DLFileRankLocalServiceBaseImpl {

	public DLFileRank addFileRank(
			long groupId, long companyId, long userId, long fileEntryId,
			ServiceContext serviceContext)
		throws SystemException {

		long fileRankId = counterLocalService.increment();

		DLFileRank fileRank = dlFileRankPersistence.create(fileRankId);

		fileRank.setGroupId(groupId);
		fileRank.setCompanyId(companyId);
		fileRank.setUserId(userId);
		fileRank.setCreateDate(serviceContext.getCreateDate(null));
		fileRank.setFileEntryId(fileEntryId);

		try {
			dlFileRankPersistence.update(fileRank, false);
		}
		catch (SystemException se) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Add failed, fetch {companyId=" + companyId + ", userId=" +
						userId + ", fileEntryId=" + fileEntryId + "}");
			}

			fileRank = dlFileRankPersistence.fetchByC_U_F(
				companyId, userId, fileEntryId, false);

			if (fileRank == null) {
				throw se;
			}
		}

		return fileRank;
	}

	/**
	 * @deprecated {@link #addFileRank(long, long, long, long, ServiceContext)}
	 */
	public DLFileRank addFileRank(
			long groupId, long companyId, long userId, long folderId,
			String name, ServiceContext serviceContext)
		throws SystemException {

		long fileEntryId = 0;

		try {
			DLFileEntry fileEntry = dlFileEntryPersistence.findByG_F_N(
				groupId, folderId, name);

			fileEntryId = fileEntry.getFileEntryId();
		}
		catch (NoSuchFileEntryException nsfe) {
			return null;
		}

		if (fileEntryId <= 0) {
			return null;
		}

		return addFileRank(
			groupId, companyId, userId, fileEntryId, serviceContext);
	}

	/**
	 * @deprecated {@link #deleteFileRanksByFileEntryId(long)}
	 */
	public void deleteFileRanks(long fileEntryId) throws SystemException {
		deleteFileRanksByFileEntryId(fileEntryId);
	}

	public void deleteFileRanksByFileEntryId(long fileEntryId)
		throws SystemException {

		dlFileRankPersistence.removeByFileEntryId(fileEntryId);
	}

	public void deleteFileRanksByUserId(long userId) throws SystemException {
		dlFileRankPersistence.removeByUserId(userId);
	}

	public List<DLFileRank> getFileRanks(long groupId, long userId)
		throws SystemException {

		return getFileRanks(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<DLFileRank> getFileRanks(
			long groupId, long userId, int start, int end)
		throws SystemException {

		return dlFileRankPersistence.findByG_U(
			groupId, userId, start, end, new FileRankCreateDateComparator());
	}

	public DLFileRank updateFileRank(
			long groupId, long companyId, long userId, long fileEntryId,
			ServiceContext serviceContext)
		throws SystemException {

		if (!PropsValues.DL_FILE_RANK_ENABLED) {
			return null;
		}

		DLFileRank fileRank = dlFileRankPersistence.fetchByC_U_F(
			companyId, userId, fileEntryId);

		if (fileRank != null) {
			fileRank.setCreateDate(serviceContext.getCreateDate(null));

			dlFileRankPersistence.update(fileRank, false);
		}
		else {
			fileRank = addFileRank(
				groupId, companyId, userId, fileEntryId, serviceContext);
		}

		if (dlFileRankPersistence.countByG_U(groupId, userId) > 5) {
			List<DLFileRank> fileRanks = getFileRanks(groupId, userId);

			DLFileRank lastFileRank = fileRanks.get(fileRanks.size() - 1);

			long lastFileRankId = lastFileRank.getFileRankId();

			try {
				dlFileRankPersistence.remove(lastFileRank);
			}
			catch (Exception e) {
				_log.warn(
					"Failed to remove file rank " + lastFileRankId +
						" because another thread already removed it");
			}
		}

		return fileRank;
	}

	/**
	 * @deprecated {@link #updateFileRank(long, long, long, long, ServiceContext)}
	 */
	public DLFileRank updateFileRank(
			long groupId, long companyId, long userId, long folderId,
			String name, ServiceContext serviceContext)
		throws SystemException {

		if (!PropsValues.DL_FILE_RANK_ENABLED) {
			return null;
		}

		long fileEntryId = 0;

		try {
			DLFileEntry fileEntry = dlFileEntryPersistence.findByG_F_N(
				groupId, folderId, name);

			fileEntryId = fileEntry.getFileEntryId();
		}
		catch (NoSuchFileEntryException nsfe) {
			return null;
		}

		if (fileEntryId <= 0) {
			return null;
		}

		return updateFileRank(
			groupId, companyId, userId, fileEntryId, serviceContext);
	}

	private static Log _log = LogFactoryUtil.getLog(
		DLFileRankLocalServiceImpl.class);

}