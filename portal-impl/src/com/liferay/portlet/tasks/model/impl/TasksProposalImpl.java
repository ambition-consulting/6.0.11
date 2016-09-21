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

package com.liferay.portlet.tasks.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.tasks.model.TasksProposal;
import com.liferay.portlet.tasks.model.TasksReview;
import com.liferay.portlet.tasks.service.TasksReviewLocalServiceUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public class TasksProposalImpl
	extends TasksProposalModelImpl implements TasksProposal {

	public TasksProposalImpl() {
	}

	public String getStatus(Locale locale)
		throws PortalException, SystemException {

		String status = null;
		int stage = 1;

		Group group = GroupLocalServiceUtil.getGroup(getGroupId());

		int stages = group.getWorkflowStages();

		for (; stage <= stages; stage++) {
			status = getStatus(stage);

			if (status.equals(_STATUS_APPROVED)) {
			}
			else if (status.equals(_STATUS_PENDING) ||
					 status.equals(_STATUS_REJECTED)) {

				break;
			}
			else if ((status.equals(_STATUS_UNASSIGNED)) &&
					 (stage > 1)) {
			}
			else if (stage == 0) {
				break;
			}

			if (stage == stages) {
				break;
			}
		}

		return LanguageUtil.format(locale, status, String.valueOf(stage + 1));
	}

	protected String getStatus(int stage) throws SystemException {
		List<TasksReview> reviews = TasksReviewLocalServiceUtil.getReviews(
			getProposalId(), stage);

		if (reviews.size() <= 0) {
			return _STATUS_UNASSIGNED;
		}

		List<TasksReview> completedReviews =
			TasksReviewLocalServiceUtil.getReviews(
				getProposalId(), stage, true);

		if (completedReviews.size() < reviews.size()) {
			return _STATUS_PENDING;
		}

		List<TasksReview> completedRejectedReviews =
			TasksReviewLocalServiceUtil.getReviews(
				getProposalId(), stage, true, true);

		if (completedRejectedReviews.size() > 0) {
			return _STATUS_REJECTED;
		}
		else {
			return _STATUS_APPROVED;
		}
	}

	private static final String _STATUS_APPROVED = "stage-x-review-approved";

	private static final String _STATUS_PENDING = "stage-x-pending-review";

	private static final String _STATUS_REJECTED = "stage-x-review-rejected";

	private static final String _STATUS_UNASSIGNED =
		"stage-x-review-unassigned";

}