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

package com.liferay.portlet.blogs.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.model.BlogsStatsUser;
import com.liferay.portlet.blogs.service.base.BlogsStatsUserLocalServiceBaseImpl;
import com.liferay.portlet.blogs.util.comparator.EntryDisplayDateComparator;
import com.liferay.portlet.blogs.util.comparator.StatsUserLastPostDateComparator;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsStatsUserLocalServiceImpl
	extends BlogsStatsUserLocalServiceBaseImpl {

	public void deleteStatsUserByGroupId(long groupId)
		throws SystemException {

		blogsStatsUserPersistence.removeByGroupId(groupId);
	}

	public void deleteStatsUserByUserId(long userId) throws SystemException {
		blogsStatsUserPersistence.removeByUserId(userId);
	}

	public List<BlogsStatsUser> getCompanyStatsUsers(
			long companyId, int start, int end)
		throws SystemException {

		return blogsStatsUserPersistence.findByC_NotE(
			companyId, 0, start, end, new StatsUserLastPostDateComparator());
	}

	public List<BlogsStatsUser> getCompanyStatsUsers(
			long companyId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return blogsStatsUserPersistence.findByC_NotE(
			companyId, 0, start, end, obc);
	}

	public int getCompanyStatsUsersCount(long companyId)
		throws SystemException {

		return blogsStatsUserPersistence.countByC_NotE(companyId, 0);
	}

	public List<BlogsStatsUser> getGroupsStatsUsers(
			long companyId, long groupId, int start, int end)
		throws SystemException {

		return blogsStatsUserFinder.findByGroupIds(
			companyId, groupId, start, end);
	}

	public List<BlogsStatsUser> getGroupStatsUsers(
			long groupId, int start, int end)
		throws SystemException {

		return blogsStatsUserPersistence.findByG_NotE(
			groupId, 0, start, end, new StatsUserLastPostDateComparator());
	}

	public List<BlogsStatsUser> getGroupStatsUsers(
			long groupId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return blogsStatsUserPersistence.findByG_NotE(
			groupId, 0, start, end, obc);
	}

	public int getGroupStatsUsersCount(long groupId) throws SystemException {
		return blogsStatsUserPersistence.countByG_NotE(groupId, 0);
	}

	public List<BlogsStatsUser> getOrganizationStatsUsers(
			long organizationId, int start, int end)
		throws SystemException {

		return blogsStatsUserFinder.findByOrganizationId(
			organizationId, start, end, new StatsUserLastPostDateComparator());
	}

	public List<BlogsStatsUser> getOrganizationStatsUsers(
			long organizationId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return blogsStatsUserFinder.findByOrganizationId(
			organizationId, start, end, obc);
	}

	public int getOrganizationStatsUsersCount(long organizationId)
		throws SystemException {

		return blogsStatsUserFinder.countByOrganizationId(organizationId);
	}

	public BlogsStatsUser getStatsUser(long groupId, long userId)
		throws PortalException, SystemException {

		BlogsStatsUser statsUser = blogsStatsUserPersistence.fetchByG_U(
			groupId, userId);

		if (statsUser == null) {
			Group group = groupPersistence.findByPrimaryKey(groupId);

			long statsUserId = counterLocalService.increment();

			statsUser = blogsStatsUserPersistence.create(statsUserId);

			statsUser.setCompanyId(group.getCompanyId());
			statsUser.setGroupId(groupId);
			statsUser.setUserId(userId);

			blogsStatsUserPersistence.update(statsUser, false);
		}

		return statsUser;
	}

	public void updateStatsUser(long groupId, long userId)
		throws PortalException, SystemException {

		updateStatsUser(groupId, userId, null);
	}

	public void updateStatsUser(long groupId, long userId, Date displayDate)
		throws PortalException, SystemException {

		int entryCount = blogsEntryPersistence.countByG_U_S(
			groupId, userId, WorkflowConstants.STATUS_APPROVED);

		BlogsStatsUser statsUser = getStatsUser(groupId, userId);

		statsUser.setEntryCount(entryCount);

		if (displayDate != null) {
			BlogsEntry blogsEntry = blogsEntryPersistence.findByG_U_S_First(
				groupId, userId, WorkflowConstants.STATUS_APPROVED,
				new EntryDisplayDateComparator());

			Date lastDisplayDate = blogsEntry.getDisplayDate();

			Date lastPostDate = statsUser.getLastPostDate();

			if (lastPostDate == null) {
				statsUser.setLastPostDate(displayDate);
			}
			else if (displayDate.after(lastPostDate)) {
				statsUser.setLastPostDate(displayDate);
			}
			else if (lastDisplayDate.before(lastPostDate)) {
				statsUser.setLastPostDate(lastDisplayDate);
			}
		}

		blogsStatsUserPersistence.update(statsUser, false);
	}

}