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

package com.liferay.portlet.announcements.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the announcements delivery remote service. This utility wraps {@link com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsDeliveryService
 * @see com.liferay.portlet.announcements.service.base.AnnouncementsDeliveryServiceBaseImpl
 * @see com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryServiceImpl
 * @generated
 */
public class AnnouncementsDeliveryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery updateDelivery(
		long userId, java.lang.String type, boolean email, boolean sms,
		boolean website)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDelivery(userId, type, email, sms, website);
	}

	public static AnnouncementsDeliveryService getService() {
		if (_service == null) {
			_service = (AnnouncementsDeliveryService)PortalBeanLocatorUtil.locate(AnnouncementsDeliveryService.class.getName());

			ReferenceRegistry.registerReference(AnnouncementsDeliveryServiceUtil.class,
				"_service");
			MethodCache.remove(AnnouncementsDeliveryService.class);
		}

		return _service;
	}

	public void setService(AnnouncementsDeliveryService service) {
		MethodCache.remove(AnnouncementsDeliveryService.class);

		_service = service;

		ReferenceRegistry.registerReference(AnnouncementsDeliveryServiceUtil.class,
			"_service");
		MethodCache.remove(AnnouncementsDeliveryService.class);
	}

	private static AnnouncementsDeliveryService _service;
}