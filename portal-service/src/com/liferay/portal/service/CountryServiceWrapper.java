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
 * This class is a wrapper for {@link CountryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CountryService
 * @generated
 */
public class CountryServiceWrapper implements CountryService {
	public CountryServiceWrapper(CountryService countryService) {
		_countryService = countryService;
	}

	public com.liferay.portal.model.Country addCountry(java.lang.String name,
		java.lang.String a2, java.lang.String a3, java.lang.String number,
		java.lang.String idd, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryService.addCountry(name, a2, a3, number, idd, active);
	}

	public java.util.List<com.liferay.portal.model.Country> getCountries()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountries();
	}

	public java.util.List<com.liferay.portal.model.Country> getCountries(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountries(active);
	}

	public com.liferay.portal.model.Country getCountry(long countryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountry(countryId);
	}

	public com.liferay.portal.model.Country getCountryByA2(java.lang.String a2)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountryByA2(a2);
	}

	public com.liferay.portal.model.Country getCountryByA3(java.lang.String a3)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountryByA3(a3);
	}

	public com.liferay.portal.model.Country getCountryByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryService.getCountryByName(name);
	}

	public CountryService getWrappedCountryService() {
		return _countryService;
	}

	public void setWrappedCountryService(CountryService countryService) {
		_countryService = countryService;
	}

	private CountryService _countryService;
}