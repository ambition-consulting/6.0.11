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

package com.liferay.portlet.tasks.service;

/**
 * <p>
 * This class is a wrapper for {@link TasksReviewService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TasksReviewService
 * @generated
 */
public class TasksReviewServiceWrapper implements TasksReviewService {
	public TasksReviewServiceWrapper(TasksReviewService tasksReviewService) {
		_tasksReviewService = tasksReviewService;
	}

	public com.liferay.portlet.tasks.model.TasksReview approveReview(
		long proposalId, int stage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tasksReviewService.approveReview(proposalId, stage);
	}

	public com.liferay.portlet.tasks.model.TasksReview rejectReview(
		long proposalId, int stage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tasksReviewService.rejectReview(proposalId, stage);
	}

	public void updateReviews(long proposalId, long[][] userIdsPerStage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tasksReviewService.updateReviews(proposalId, userIdsPerStage);
	}

	public TasksReviewService getWrappedTasksReviewService() {
		return _tasksReviewService;
	}

	public void setWrappedTasksReviewService(
		TasksReviewService tasksReviewService) {
		_tasksReviewService = tasksReviewService;
	}

	private TasksReviewService _tasksReviewService;
}