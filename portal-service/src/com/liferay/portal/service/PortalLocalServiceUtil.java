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
 * The utility for the portal local service. This utility wraps {@link com.liferay.portal.service.impl.PortalLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortalLocalService
 * @see com.liferay.portal.service.base.PortalLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.PortalLocalServiceImpl
 * @generated
 */
public class PortalLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.PortalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static PortalLocalService getService() {
		if (_service == null) {
			_service = (PortalLocalService)PortalBeanLocatorUtil.locate(PortalLocalService.class.getName());

			ReferenceRegistry.registerReference(PortalLocalServiceUtil.class,
				"_service");
			MethodCache.remove(PortalLocalService.class);
		}

		return _service;
	}

	public void setService(PortalLocalService service) {
		MethodCache.remove(PortalLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(PortalLocalServiceUtil.class,
			"_service");
		MethodCache.remove(PortalLocalService.class);
	}

	private static PortalLocalService _service;
}