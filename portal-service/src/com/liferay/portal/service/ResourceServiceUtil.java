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
 * The utility for the resource remote service. This utility wraps {@link com.liferay.portal.service.impl.ResourceServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceService
 * @see com.liferay.portal.service.base.ResourceServiceBaseImpl
 * @see com.liferay.portal.service.impl.ResourceServiceImpl
 * @generated
 */
public class ResourceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.ResourceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.model.Resource getResource(
		long companyId, java.lang.String name, int scope,
		java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResource(companyId, name, scope, primKey);
	}

	public static ResourceService getService() {
		if (_service == null) {
			_service = (ResourceService)PortalBeanLocatorUtil.locate(ResourceService.class.getName());

			ReferenceRegistry.registerReference(ResourceServiceUtil.class,
				"_service");
			MethodCache.remove(ResourceService.class);
		}

		return _service;
	}

	public void setService(ResourceService service) {
		MethodCache.remove(ResourceService.class);

		_service = service;

		ReferenceRegistry.registerReference(ResourceServiceUtil.class,
			"_service");
		MethodCache.remove(ResourceService.class);
	}

	private static ResourceService _service;
}