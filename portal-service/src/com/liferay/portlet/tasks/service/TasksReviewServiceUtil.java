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
 * The utility for the tasks review remote service. This utility wraps {@link com.liferay.portlet.tasks.service.impl.TasksReviewServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TasksReviewService
 * @see com.liferay.portlet.tasks.service.base.TasksReviewServiceBaseImpl
 * @see com.liferay.portlet.tasks.service.impl.TasksReviewServiceImpl
 * @generated
 */
public class TasksReviewServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.tasks.service.impl.TasksReviewServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.tasks.model.TasksReview approveReview(
		long proposalId, int stage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().approveReview(proposalId, stage);
	}

	public static com.liferay.portlet.tasks.model.TasksReview rejectReview(
		long proposalId, int stage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().rejectReview(proposalId, stage);
	}

	public static void updateReviews(long proposalId, long[][] userIdsPerStage)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateReviews(proposalId, userIdsPerStage);
	}

	public static TasksReviewService getService() {
		if (_service == null) {
			_service = (TasksReviewService)PortalBeanLocatorUtil.locate(TasksReviewService.class.getName());

			ReferenceRegistry.registerReference(TasksReviewServiceUtil.class,
				"_service");
			MethodCache.remove(TasksReviewService.class);
		}

		return _service;
	}

	public void setService(TasksReviewService service) {
		MethodCache.remove(TasksReviewService.class);

		_service = service;

		ReferenceRegistry.registerReference(TasksReviewServiceUtil.class,
			"_service");
		MethodCache.remove(TasksReviewService.class);
	}

	private static TasksReviewService _service;
}