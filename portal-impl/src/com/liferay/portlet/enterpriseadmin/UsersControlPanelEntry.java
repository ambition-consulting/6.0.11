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

package com.liferay.portlet.enterpriseadmin;

import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.permission.OrganizationPermissionUtil;
import com.liferay.portlet.BaseControlPanelEntry;

import java.util.List;

/**
 * @author Jorge Ferrer
 */
public class UsersControlPanelEntry extends BaseControlPanelEntry {

	public boolean isVisible(
			PermissionChecker permissionChecker, Portlet portlet)
		throws Exception {

		List<Organization> organizations =
			OrganizationLocalServiceUtil.getUserOrganizations(
				permissionChecker.getUserId());

		for (Organization organization : organizations) {
			if (OrganizationPermissionUtil.contains(
					permissionChecker, organization.getOrganizationId(),
					ActionKeys.MANAGE_USERS)) {

				return true;
			}

			if (OrganizationPermissionUtil.contains(
					permissionChecker, organization.getOrganizationId(),
					ActionKeys.MANAGE_SUBORGANIZATIONS)) {

				return true;
			}

			if (OrganizationPermissionUtil.contains(
					permissionChecker, organization.getOrganizationId(),
					ActionKeys.VIEW)) {

				return true;
			}
		}

		return false;
	}

}