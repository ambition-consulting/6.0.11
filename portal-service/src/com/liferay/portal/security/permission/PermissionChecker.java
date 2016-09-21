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

package com.liferay.portal.security.permission;

import com.liferay.portal.model.User;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public interface PermissionChecker {

	public static final long[] DEFAULT_ROLE_IDS = new long[] {0};

	public long getCompanyId();

	public long getOwnerRoleId();

	public long[] getRoleIds(long userId, long groupId);

	public long getUserId();

	public boolean hasOwnerPermission(
		long companyId, String name, long primKey, long ownerId,
		String actionId);

	public boolean hasOwnerPermission(
		long companyId, String name, String primKey, long ownerId,
		String actionId);

	public boolean hasPermission(
		long groupId, String name, long primKey, String actionId);

	public boolean hasPermission(
		long groupId, String name, String primKey, String actionId);

	public boolean hasUserPermission(
		long groupId, String name, String primKey, String actionId,
		boolean checkAdmin);

	public void init(User user, boolean checkGuest);

	public boolean isCommunityAdmin(long groupId);

	public boolean isCommunityOwner(long groupId);

	public boolean isCompanyAdmin();

	public boolean isCompanyAdmin(long companyId);

	public boolean isOmniadmin();

	public void resetValues();

	public void setCheckGuest(boolean checkGuest);

	public void setValues(PortletRequest portletRequest);

}