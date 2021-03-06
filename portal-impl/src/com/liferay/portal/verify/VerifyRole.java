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

package com.liferay.portal.verify;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalInstances;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifyRole extends VerifyProcess {

	protected void doVerify() throws Exception {
		long[] companyIds = PortalInstances.getCompanyIdsBySQL();

		for (long companyId : companyIds) {
			RoleLocalServiceUtil.checkSystemRoles(companyId);

			try {
				Role communityMemberRole = RoleLocalServiceUtil.getRole(
					companyId, RoleConstants.COMMUNITY_MEMBER);

				deleteImplicitAssociations(communityMemberRole);
			}
			catch (NoSuchRoleException nsre) {
			}

			try {
				Role organizationMemberRole = RoleLocalServiceUtil.getRole(
					companyId, RoleConstants.ORGANIZATION_MEMBER);

				deleteImplicitAssociations(organizationMemberRole);
			}
			catch (NoSuchRoleException nsre) {
			}
		}
	}

	protected void deleteImplicitAssociations(Role role) throws Exception {
		runSQL(
			"delete from UserGroupGroupRole where roleId = " +
				role.getRoleId());
		runSQL(
			"delete from UserGroupRole where roleId = " + role.getRoleId());
	}

}