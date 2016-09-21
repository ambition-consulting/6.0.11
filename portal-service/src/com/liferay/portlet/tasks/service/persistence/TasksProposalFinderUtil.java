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

package com.liferay.portlet.tasks.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class TasksProposalFinderUtil {
	public static int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_U(groupId, userId);
	}

	public static java.util.List<com.liferay.portlet.tasks.model.TasksProposal> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_U(groupId, userId, start, end);
	}

	public static TasksProposalFinder getFinder() {
		if (_finder == null) {
			_finder = (TasksProposalFinder)PortalBeanLocatorUtil.locate(TasksProposalFinder.class.getName());

			ReferenceRegistry.registerReference(TasksProposalFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TasksProposalFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TasksProposalFinderUtil.class,
			"_finder");
	}

	private static TasksProposalFinder _finder;
}