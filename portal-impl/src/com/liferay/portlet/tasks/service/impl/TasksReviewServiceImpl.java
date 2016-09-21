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

package com.liferay.portlet.tasks.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portlet.tasks.model.TasksProposal;
import com.liferay.portlet.tasks.model.TasksReview;
import com.liferay.portlet.tasks.service.base.TasksReviewServiceBaseImpl;

/**
 * @author Raymond Augé
 * @author Brian Wing Shun Chan
 */
public class TasksReviewServiceImpl extends TasksReviewServiceBaseImpl {

	public TasksReview approveReview(long proposalId, int stage)
		throws PortalException, SystemException {

		TasksProposal proposal = tasksProposalPersistence.findByPrimaryKey(
			proposalId);

		GroupPermissionUtil.check(
			getPermissionChecker(), proposal.getGroupId(),
			ActionKeys.APPROVE_PROPOSAL);

		return tasksReviewLocalService.approveReview(
			getUserId(), proposalId, stage);
	}

	public TasksReview rejectReview(long proposalId, int stage)
		throws PortalException, SystemException {

		TasksProposal proposal = tasksProposalPersistence.findByPrimaryKey(
			proposalId);

		GroupPermissionUtil.check(
			getPermissionChecker(), proposal.getGroupId(),
			ActionKeys.APPROVE_PROPOSAL);

		return tasksReviewLocalService.rejectReview(
			getUserId(), proposalId, stage);
	}

	public void updateReviews(long proposalId, long[][] userIdsPerStage)
		throws PortalException, SystemException {

		TasksProposal proposal = tasksProposalPersistence.findByPrimaryKey(
			proposalId);

		GroupPermissionUtil.check(
			getPermissionChecker(), proposal.getGroupId(),
			ActionKeys.ASSIGN_REVIEWER);

		tasksReviewLocalService.updateReviews(
			proposalId, getUserId(), userIdsPerStage);
	}

}