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

package com.liferay.portlet.documentlibrary.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the d l file version remote service. This utility wraps {@link com.liferay.portlet.documentlibrary.service.impl.DLFileVersionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionService
 * @see com.liferay.portlet.documentlibrary.service.base.DLFileVersionServiceBaseImpl
 * @see com.liferay.portlet.documentlibrary.service.impl.DLFileVersionServiceImpl
 * @generated
 */
public class DLFileVersionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.documentlibrary.service.impl.DLFileVersionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion updateDescription(
		long fileVersionId, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDescription(fileVersionId, description);
	}

	public static DLFileVersionService getService() {
		if (_service == null) {
			_service = (DLFileVersionService)PortalBeanLocatorUtil.locate(DLFileVersionService.class.getName());

			ReferenceRegistry.registerReference(DLFileVersionServiceUtil.class,
				"_service");
			MethodCache.remove(DLFileVersionService.class);
		}

		return _service;
	}

	public void setService(DLFileVersionService service) {
		MethodCache.remove(DLFileVersionService.class);

		_service = service;

		ReferenceRegistry.registerReference(DLFileVersionServiceUtil.class,
			"_service");
		MethodCache.remove(DLFileVersionService.class);
	}

	private static DLFileVersionService _service;
}