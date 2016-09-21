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
 * This class is a wrapper for {@link TasksProposalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TasksProposalService
 * @generated
 */
public class TasksProposalServiceWrapper implements TasksProposalService {
	public TasksProposalServiceWrapper(
		TasksProposalService tasksProposalService) {
		_tasksProposalService = tasksProposalService;
	}

	public com.liferay.portlet.tasks.model.TasksProposal addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tasksProposalService.addProposal(groupId, className, classPK,
			name, description, reviewUserId, addCommunityPermissions,
			addGuestPermissions);
	}

	public com.liferay.portlet.tasks.model.TasksProposal addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tasksProposalService.addProposal(groupId, className, classPK,
			name, description, reviewUserId, communityPermissions,
			guestPermissions);
	}

	public void deleteProposal(long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tasksProposalService.deleteProposal(proposalId);
	}

	public com.liferay.portlet.tasks.model.TasksProposal updateProposal(
		long proposalId, java.lang.String description, int dueDateMonth,
		int dueDateDay, int dueDateYear, int dueDateHour, int dueDateMinute)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tasksProposalService.updateProposal(proposalId, description,
			dueDateMonth, dueDateDay, dueDateYear, dueDateHour, dueDateMinute);
	}

	public TasksProposalService getWrappedTasksProposalService() {
		return _tasksProposalService;
	}

	public void setWrappedTasksProposalService(
		TasksProposalService tasksProposalService) {
		_tasksProposalService = tasksProposalService;
	}

	private TasksProposalService _tasksProposalService;
}