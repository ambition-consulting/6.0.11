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
 * The utility for the region remote service. This utility wraps {@link com.liferay.portal.service.impl.RegionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegionService
 * @see com.liferay.portal.service.base.RegionServiceBaseImpl
 * @see com.liferay.portal.service.impl.RegionServiceImpl
 * @generated
 */
public class RegionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.RegionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.model.Region addRegion(long countryId,
		java.lang.String regionCode, java.lang.String name, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addRegion(countryId, regionCode, name, active);
	}

	public static java.util.List<com.liferay.portal.model.Region> getRegions()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegions();
	}

	public static java.util.List<com.liferay.portal.model.Region> getRegions(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegions(countryId);
	}

	public static java.util.List<com.liferay.portal.model.Region> getRegions(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegions(active);
	}

	public static java.util.List<com.liferay.portal.model.Region> getRegions(
		long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegions(countryId, active);
	}

	public static com.liferay.portal.model.Region getRegion(long regionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegion(regionId);
	}

	public static RegionService getService() {
		if (_service == null) {
			_service = (RegionService)PortalBeanLocatorUtil.locate(RegionService.class.getName());

			ReferenceRegistry.registerReference(RegionServiceUtil.class,
				"_service");
			MethodCache.remove(RegionService.class);
		}

		return _service;
	}

	public void setService(RegionService service) {
		MethodCache.remove(RegionService.class);

		_service = service;

		ReferenceRegistry.registerReference(RegionServiceUtil.class, "_service");
		MethodCache.remove(RegionService.class);
	}

	private static RegionService _service;
}