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
 * The utility for the class name remote service. This utility wraps {@link com.liferay.portal.service.impl.ClassNameServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassNameService
 * @see com.liferay.portal.service.base.ClassNameServiceBaseImpl
 * @see com.liferay.portal.service.impl.ClassNameServiceImpl
 * @generated
 */
public class ClassNameServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.ClassNameServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.model.ClassName getClassName(
		long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassName(classNameId);
	}

	public static com.liferay.portal.model.ClassName getClassName(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassName(value);
	}

	public static long getClassNameId(java.lang.Class<?> classObj) {
		return getService().getClassNameId(classObj);
	}

	public static long getClassNameId(java.lang.String value) {
		return getService().getClassNameId(value);
	}

	public static ClassNameService getService() {
		if (_service == null) {
			_service = (ClassNameService)PortalBeanLocatorUtil.locate(ClassNameService.class.getName());

			ReferenceRegistry.registerReference(ClassNameServiceUtil.class,
				"_service");
			MethodCache.remove(ClassNameService.class);
		}

		return _service;
	}

	public void setService(ClassNameService service) {
		MethodCache.remove(ClassNameService.class);

		_service = service;

		ReferenceRegistry.registerReference(ClassNameServiceUtil.class,
			"_service");
		MethodCache.remove(ClassNameService.class);
	}

	private static ClassNameService _service;
}