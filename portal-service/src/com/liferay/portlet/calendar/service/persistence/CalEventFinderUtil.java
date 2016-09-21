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

package com.liferay.portlet.calendar.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CalEventFinderUtil {
	public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> findByNoAssets()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoAssets();
	}

	public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> findByG_SD(
		long groupId, java.util.Date startDateGT, java.util.Date startDateLT,
		boolean timeZoneSensitive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_SD(groupId, startDateGT, startDateLT,
			timeZoneSensitive);
	}

	public static CalEventFinder getFinder() {
		if (_finder == null) {
			_finder = (CalEventFinder)PortalBeanLocatorUtil.locate(CalEventFinder.class.getName());

			ReferenceRegistry.registerReference(CalEventFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CalEventFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CalEventFinderUtil.class, "_finder");
	}

	private static CalEventFinder _finder;
}