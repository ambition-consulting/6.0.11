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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.CountryServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portal.service.CountryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portal.model.CountrySoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portal.model.Country}, that is translated to a
 * {@link com.liferay.portal.model.CountrySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <b>tunnel.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CountryServiceHttp
 * @see       com.liferay.portal.model.CountrySoap
 * @see       com.liferay.portal.service.CountryServiceUtil
 * @generated
 */
public class CountryServiceSoap {
	public static com.liferay.portal.model.CountrySoap addCountry(
		java.lang.String name, java.lang.String a2, java.lang.String a3,
		java.lang.String number, java.lang.String idd, boolean active)
		throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = CountryServiceUtil.addCountry(name,
					a2, a3, number, idd, active);

			return com.liferay.portal.model.CountrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap[] getCountries()
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.Country> returnValue = CountryServiceUtil.getCountries();

			return com.liferay.portal.model.CountrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap[] getCountries(
		boolean active) throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.Country> returnValue = CountryServiceUtil.getCountries(active);

			return com.liferay.portal.model.CountrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap getCountry(
		long countryId) throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = CountryServiceUtil.getCountry(countryId);

			return com.liferay.portal.model.CountrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap getCountryByA2(
		java.lang.String a2) throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = CountryServiceUtil.getCountryByA2(a2);

			return com.liferay.portal.model.CountrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap getCountryByA3(
		java.lang.String a3) throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = CountryServiceUtil.getCountryByA3(a3);

			return com.liferay.portal.model.CountrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap getCountryByName(
		java.lang.String name) throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = CountryServiceUtil.getCountryByName(name);

			return com.liferay.portal.model.CountrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CountryServiceSoap.class);
}