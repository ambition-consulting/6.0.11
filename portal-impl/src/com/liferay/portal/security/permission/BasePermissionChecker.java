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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.admin.util.OmniadminUtil;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BasePermissionChecker implements PermissionChecker {

	public long getCompanyId() {
		return user.getCompanyId();
	}

	public long getOwnerRoleId() {
		return ownerRole.getRoleId();
	}

	public long[] getRoleIds(long userId, long groupId) {
		return PermissionChecker.DEFAULT_ROLE_IDS;
	}

	public long getUserId() {
		return user.getUserId();
	}

	public boolean hasOwnerPermission(
		long companyId, String name, long primKey, long ownerId,
		String actionId) {

		return hasOwnerPermission(
			companyId, name, String.valueOf(primKey), ownerId, actionId);
	}

	public boolean hasPermission(
		long groupId, String name, long primKey, String actionId) {

		return hasPermission(groupId, name, String.valueOf(primKey), actionId);
	}

	public void init(User user, boolean checkGuest) {
		this.user = user;

		if (user.isDefaultUser()) {
			this.defaultUserId = user.getUserId();
			this.signedIn = false;
		}
		else {
			try {
				this.defaultUserId = UserLocalServiceUtil.getDefaultUserId(
					user.getCompanyId());
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			this.signedIn = true;
		}

		this.checkGuest = checkGuest;

		try {
			this.ownerRole = RoleLocalServiceUtil.getRole(
				user.getCompanyId(), RoleConstants.OWNER);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public boolean isOmniadmin() {
		if (omniadmin == null) {
			omniadmin = Boolean.valueOf(OmniadminUtil.isOmniadmin(getUserId()));
		}

		return omniadmin.booleanValue();
	}

	public void resetValues() {
	}

	public void setCheckGuest(boolean checkGuest) {
		this.checkGuest = checkGuest;
	}

	public void setValues(PortletRequest portletRequest) {

		// This method is called in com.liferay.portlet.StrutsPortlet to allow
		// developers to hook in additional parameters from the portlet request.
		// Don't overwrite this method unless you're using Liferay in a 2 tier
		// environment and don't expect to make remote calls. Remote calls to
		// service beans will not have any values set from the portlet request.

	}

	protected User user;
	protected long defaultUserId;
	protected boolean signedIn;
	protected boolean checkGuest;
	protected Boolean omniadmin;
	protected Role ownerRole;

	private static Log _log = LogFactoryUtil.getLog(
		BasePermissionChecker.class);

}