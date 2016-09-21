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

package com.liferay.portlet.polls.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the polls vote remote service. This utility wraps {@link com.liferay.portlet.polls.service.impl.PollsVoteServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsVoteService
 * @see com.liferay.portlet.polls.service.base.PollsVoteServiceBaseImpl
 * @see com.liferay.portlet.polls.service.impl.PollsVoteServiceImpl
 * @generated
 */
public class PollsVoteServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.polls.service.impl.PollsVoteServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.polls.model.PollsVote addVote(
		long questionId, long choiceId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addVote(questionId, choiceId, serviceContext);
	}

	public static PollsVoteService getService() {
		if (_service == null) {
			_service = (PollsVoteService)PortalBeanLocatorUtil.locate(PollsVoteService.class.getName());

			ReferenceRegistry.registerReference(PollsVoteServiceUtil.class,
				"_service");
			MethodCache.remove(PollsVoteService.class);
		}

		return _service;
	}

	public void setService(PollsVoteService service) {
		MethodCache.remove(PollsVoteService.class);

		_service = service;

		ReferenceRegistry.registerReference(PollsVoteServiceUtil.class,
			"_service");
		MethodCache.remove(PollsVoteService.class);
	}

	private static PollsVoteService _service;
}