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

package com.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the portlet preferences remote service. This utility wraps {@link com.liferay.portal.service.impl.PortletPreferencesServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletPreferencesService
 * @see com.liferay.portal.service.base.PortletPreferencesServiceBaseImpl
 * @see com.liferay.portal.service.impl.PortletPreferencesServiceImpl
 * @generated
 */
public class PortletPreferencesServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.PortletPreferencesServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void deleteArchivedPreferences(long portletItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteArchivedPreferences(portletItemId);
	}

	public static void restoreArchivedPreferences(long groupId,
		java.lang.String name, java.lang.String portletId,
		javax.portlet.PortletPreferences preferences)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.restoreArchivedPreferences(groupId, name, portletId, preferences);
	}

	public static void updateArchivePreferences(long userId, long groupId,
		java.lang.String name, java.lang.String portletId,
		javax.portlet.PortletPreferences preferences)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateArchivePreferences(userId, groupId, name, portletId,
			preferences);
	}

	public static PortletPreferencesService getService() {
		if (_service == null) {
			_service = (PortletPreferencesService)PortalBeanLocatorUtil.locate(PortletPreferencesService.class.getName());

			ReferenceRegistry.registerReference(PortletPreferencesServiceUtil.class,
				"_service");
			MethodCache.remove(PortletPreferencesService.class);
		}

		return _service;
	}

	public void setService(PortletPreferencesService service) {
		MethodCache.remove(PortletPreferencesService.class);

		_service = service;

		ReferenceRegistry.registerReference(PortletPreferencesServiceUtil.class,
			"_service");
		MethodCache.remove(PortletPreferencesService.class);
	}

	private static PortletPreferencesService _service;
}