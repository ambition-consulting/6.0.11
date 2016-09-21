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

package com.liferay.portlet.messageboards.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portlet.messageboards.model.MBStatsUser;
import com.liferay.portlet.messageboards.model.impl.MBStatsUserImpl;
import com.liferay.portlet.messageboards.service.base.MBStatsUserLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBStatsUserLocalServiceImpl
	extends MBStatsUserLocalServiceBaseImpl {

	public MBStatsUser addStatsUser(long groupId, long userId)
		throws SystemException {

		long statsUserId = counterLocalService.increment();

		MBStatsUser statsUser = mbStatsUserPersistence.create(statsUserId);

		statsUser.setGroupId(groupId);
		statsUser.setUserId(userId);

		try {
			mbStatsUserPersistence.update(statsUser, false);
		}
		catch (SystemException se) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Add failed, fetch {groupId=" + groupId + ", userId=" +
						userId + "}");
			}

			statsUser = mbStatsUserPersistence.fetchByG_U(
				groupId, userId, false);

			if (statsUser == null) {
				throw se;
			}
		}

		return statsUser;
	}

	public void deleteStatsUsersByGroupId(long groupId)
		throws SystemException {

		mbStatsUserPersistence.removeByGroupId(groupId);
	}

	public void deleteStatsUsersByUserId(long userId) throws SystemException {
		mbStatsUserPersistence.removeByUserId(userId);
	}

	public long getMessageCountByUserId(long userId) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBStatsUser.class, MBStatsUserImpl.TABLE_NAME,
			PortalClassLoaderUtil.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.sum("messageCount"));

		dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));

		return dynamicQueryCount(dynamicQuery);
	}

	public MBStatsUser getStatsUser(long groupId, long userId)
		throws SystemException {

		MBStatsUser statsUser = mbStatsUserPersistence.fetchByG_U(
			groupId, userId);

		if (statsUser == null) {
			statsUser = mbStatsUserLocalService.addStatsUser(groupId, userId);
		}

		return statsUser;
	}

	public List<MBStatsUser> getStatsUsersByGroupId(
			long groupId, int start, int end)
		throws SystemException {

		return mbStatsUserPersistence.findByG_NotM(groupId, 0, start, end);
	}

	public List<MBStatsUser> getStatsUsersByUserId(long userId)
		throws SystemException {

		return mbStatsUserPersistence.findByUserId(userId);
	}

	public int getStatsUsersByGroupIdCount(long groupId)
		throws SystemException {

		return mbStatsUserPersistence.countByG_NotM(groupId, 0);
	}

	public MBStatsUser updateStatsUser(long groupId, long userId)
		throws SystemException {

		return updateStatsUser(groupId, userId, null);
	}

	public MBStatsUser updateStatsUser(
			long groupId, long userId, Date lastPostDate)
		throws SystemException {

		int messageCount = mbMessagePersistence.countByG_U(groupId, userId);

		MBStatsUser statsUser = getStatsUser(groupId, userId);

		statsUser.setMessageCount(messageCount);

		if (lastPostDate != null) {
			statsUser.setLastPostDate(lastPostDate);
		}

		mbStatsUserPersistence.update(statsUser, false);

		return statsUser;
	}

	private static Log _log = LogFactoryUtil.getLog(
		MBStatsUserLocalServiceImpl.class);

}