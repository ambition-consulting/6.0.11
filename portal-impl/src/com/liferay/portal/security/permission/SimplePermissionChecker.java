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

/**
 * @author Brian Wing Shun Chan
 */
public class SimplePermissionChecker extends BasePermissionChecker {

	public boolean hasOwnerPermission(
		long companyId, String name, String primKey, long ownerId,
		String actionId) {

		return hasPermission(actionId);
	}

	public boolean hasPermission(
		long groupId, String name, String primKey, String actionId) {

		return hasPermission(actionId);
	}

	public boolean hasUserPermission(
		long groupId, String name, String primKey, String actionId,
		boolean checkAdmin) {

		return hasPermission(actionId);
	}

	public boolean isCommunityAdmin(long groupId) {
		return signedIn;
	}

	public boolean isCommunityOwner(long groupId) {
		return signedIn;
	}

	public boolean isCompanyAdmin() {
		return signedIn;
	}

	public boolean isCompanyAdmin(long companyId) {
		return signedIn;
	}

	protected boolean hasPermission(String actionId) {
		if (signedIn) {
			return true;
		}

		if (actionId.equals(ActionKeys.VIEW)) {
			return true;
		}
		else {
			return false;
		}
	}

}