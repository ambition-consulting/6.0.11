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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupPermissionImpl implements GroupPermission {

	public void check(
			PermissionChecker permissionChecker, long groupId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public boolean contains(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		if (group.isStagingGroup()) {
			group = group.getLiveGroup();
		}

		if (group.isOrganization()) {
			long organizationId = group.getOrganizationId();

			return OrganizationPermissionUtil.contains(
				permissionChecker, organizationId, actionId);
		}
		else if (group.isUser()) {

			// An individual user would never reach this block because he would
			// be an administrator of his own layouts. However, a user who
			// manages a set of organizations may be modifying pages of a user
			// he manages.

			long userId = group.getClassPK();

			List<Organization> organizations =
				OrganizationLocalServiceUtil.getUserOrganizations(userId);

			for (Organization organization : organizations) {
				if (OrganizationPermissionUtil.contains(
						permissionChecker, organization.getOrganizationId(),
						ActionKeys.MANAGE_USERS)) {

					return true;
				}
			}
		}

		// Group id must be set so that users can modify their personal pages

		return permissionChecker.hasPermission(
			groupId, Group.class.getName(), groupId, actionId);
	}

}