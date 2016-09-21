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
 * The utility for the layout set prototype remote service. This utility wraps {@link com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetPrototypeService
 * @see com.liferay.portal.service.base.LayoutSetPrototypeServiceBaseImpl
 * @see com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl
 * @generated
 */
public class LayoutSetPrototypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.model.LayoutSetPrototype addLayoutSetPrototype(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addLayoutSetPrototype(nameMap, description, active);
	}

	public static void deleteLayoutSetPrototype(long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLayoutSetPrototype(layoutSetPrototypeId);
	}

	public static com.liferay.portal.model.LayoutSetPrototype getLayoutSetPrototype(
		long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLayoutSetPrototype(layoutSetPrototypeId);
	}

	public static java.util.List<com.liferay.portal.model.LayoutSetPrototype> search(
		long companyId, java.lang.Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, active, obc);
	}

	public static com.liferay.portal.model.LayoutSetPrototype updateLayoutSetPrototype(
		long layoutSetPrototypeId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLayoutSetPrototype(layoutSetPrototypeId, nameMap,
			description, active);
	}

	public static LayoutSetPrototypeService getService() {
		if (_service == null) {
			_service = (LayoutSetPrototypeService)PortalBeanLocatorUtil.locate(LayoutSetPrototypeService.class.getName());

			ReferenceRegistry.registerReference(LayoutSetPrototypeServiceUtil.class,
				"_service");
			MethodCache.remove(LayoutSetPrototypeService.class);
		}

		return _service;
	}

	public void setService(LayoutSetPrototypeService service) {
		MethodCache.remove(LayoutSetPrototypeService.class);

		_service = service;

		ReferenceRegistry.registerReference(LayoutSetPrototypeServiceUtil.class,
			"_service");
		MethodCache.remove(LayoutSetPrototypeService.class);
	}

	private static LayoutSetPrototypeService _service;
}