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

package com.liferay.portlet.announcements.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.service.permission.RolePermissionUtil;
import com.liferay.portal.service.permission.UserGroupPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.base.AnnouncementsEntryServiceBaseImpl;
import com.liferay.portlet.announcements.service.permission.AnnouncementsEntryPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class AnnouncementsEntryServiceImpl
	extends AnnouncementsEntryServiceBaseImpl {

	public AnnouncementsEntry addEntry(
			long plid, long classNameId, long classPK, String title,
			String content, String url, String type, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute, int priority,
			boolean alert)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();

		PortletPermissionUtil.check(
			permissionChecker, plid, PortletKeys.ANNOUNCEMENTS,
			ActionKeys.ADD_ENTRY);

		if (classNameId == 0) {
			if (!permissionChecker.isOmniadmin()) {
				throw new PrincipalException();
			}
		}
		else {
			String className = PortalUtil.getClassName(classNameId);

			if (className.equals(Group.class.getName()) &&
				!GroupPermissionUtil.contains(
					permissionChecker, classPK,
					ActionKeys.MANAGE_ANNOUNCEMENTS)) {

				throw new PrincipalException();
			}

			if (className.equals(Organization.class.getName()) &&
				!OrganizationPermissionUtil.contains(
					permissionChecker, classPK,
					ActionKeys.MANAGE_ANNOUNCEMENTS)) {

				throw new PrincipalException();
			}

			if (className.equals(Role.class.getName()) &&
				!RolePermissionUtil.contains(
					permissionChecker, classPK,
					ActionKeys.MANAGE_ANNOUNCEMENTS)) {

				throw new PrincipalException();
			}

			if (className.equals(UserGroup.class.getName()) &&
				!UserGroupPermissionUtil.contains(
					permissionChecker, classPK,
					ActionKeys.MANAGE_ANNOUNCEMENTS)) {

				throw new PrincipalException();
			}
		}

		return announcementsEntryLocalService.addEntry(
			getUserId(), classNameId, classPK, title, content, url, type,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			priority, alert);
	}

	public void deleteEntry(long entryId)
		throws PortalException, SystemException {

		AnnouncementsEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		announcementsEntryLocalService.deleteEntry(entryId);
	}

	public AnnouncementsEntry updateEntry(
			long entryId, String title, String content, String url,
			String type, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, int priority)
		throws PortalException, SystemException {

		AnnouncementsEntryPermission.check(
			getPermissionChecker(), entryId, ActionKeys.UPDATE);

		return announcementsEntryLocalService.updateEntry(
			getUserId(), entryId, title, content, url, type, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, priority);
	}

}