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

package com.liferay.portlet.tasks.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.tasks.model.TasksProposal;
import com.liferay.portlet.tasks.service.TasksProposalLocalServiceUtil;

/**
 * @author Raymond Augé
 */
public class TasksProposalPermission {

	public static void check(
			PermissionChecker permissionChecker, long proposalId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, proposalId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, TasksProposal proposal,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, proposal, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long proposalId,
			String actionId)
		throws PortalException, SystemException {

		TasksProposal proposal =
			TasksProposalLocalServiceUtil.getProposal(proposalId);

		return contains(permissionChecker, proposal, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, TasksProposal proposal,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				proposal.getCompanyId(), TasksProposal.class.getName(),
				proposal.getProposalId(), proposal.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			proposal.getGroupId(), TasksProposal.class.getName(),
			proposal.getProposalId(), actionId);
	}

}