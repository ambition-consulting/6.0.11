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

/**
 * <p>
 * This class is a wrapper for {@link RegionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RegionService
 * @generated
 */
public class RegionServiceWrapper implements RegionService {
	public RegionServiceWrapper(RegionService regionService) {
		_regionService = regionService;
	}

	public com.liferay.portal.model.Region addRegion(long countryId,
		java.lang.String regionCode, java.lang.String name, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _regionService.addRegion(countryId, regionCode, name, active);
	}

	public java.util.List<com.liferay.portal.model.Region> getRegions()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regionService.getRegions();
	}

	public java.util.List<com.liferay.portal.model.Region> getRegions(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regionService.getRegions(countryId);
	}

	public java.util.List<com.liferay.portal.model.Region> getRegions(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regionService.getRegions(active);
	}

	public java.util.List<com.liferay.portal.model.Region> getRegions(
		long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regionService.getRegions(countryId, active);
	}

	public com.liferay.portal.model.Region getRegion(long regionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _regionService.getRegion(regionId);
	}

	public RegionService getWrappedRegionService() {
		return _regionService;
	}

	public void setWrappedRegionService(RegionService regionService) {
		_regionService = regionService;
	}

	private RegionService _regionService;
}