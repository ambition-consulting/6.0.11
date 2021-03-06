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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the tasks proposal remote service. This utility wraps {@link com.liferay.portlet.tasks.service.impl.TasksProposalServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TasksProposalService
 * @see com.liferay.portlet.tasks.service.base.TasksProposalServiceBaseImpl
 * @see com.liferay.portlet.tasks.service.impl.TasksProposalServiceImpl
 * @generated
 */
public class TasksProposalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.tasks.service.impl.TasksProposalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.tasks.model.TasksProposal addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addProposal(groupId, className, classPK, name, description,
			reviewUserId, addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.tasks.model.TasksProposal addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addProposal(groupId, className, classPK, name, description,
			reviewUserId, communityPermissions, guestPermissions);
	}

	public static void deleteProposal(long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProposal(proposalId);
	}

	public static com.liferay.portlet.tasks.model.TasksProposal updateProposal(
		long proposalId, java.lang.String description, int dueDateMonth,
		int dueDateDay, int dueDateYear, int dueDateHour, int dueDateMinute)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateProposal(proposalId, description, dueDateMonth,
			dueDateDay, dueDateYear, dueDateHour, dueDateMinute);
	}

	public static TasksProposalService getService() {
		if (_service == null) {
			_service = (TasksProposalService)PortalBeanLocatorUtil.locate(TasksProposalService.class.getName());

			ReferenceRegistry.registerReference(TasksProposalServiceUtil.class,
				"_service");
			MethodCache.remove(TasksProposalService.class);
		}

		return _service;
	}

	public void setService(TasksProposalService service) {
		MethodCache.remove(TasksProposalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TasksProposalServiceUtil.class,
			"_service");
		MethodCache.remove(TasksProposalService.class);
	}

	private static TasksProposalService _service;
}