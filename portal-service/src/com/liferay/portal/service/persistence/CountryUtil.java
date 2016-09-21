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

package com.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the country service. This utility wraps {@link CountryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryPersistence
 * @see CountryPersistenceImpl
 * @generated
 */
public class CountryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Country country) {
		getPersistence().clearCache(country);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Country> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Country> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Country> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Country remove(Country country) throws SystemException {
		return getPersistence().remove(country);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Country update(Country country, boolean merge)
		throws SystemException {
		return getPersistence().update(country, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Country update(Country country, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(country, merge, serviceContext);
	}

	/**
	* Caches the country in the entity cache if it is enabled.
	*
	* @param country the country to cache
	*/
	public static void cacheResult(com.liferay.portal.model.Country country) {
		getPersistence().cacheResult(country);
	}

	/**
	* Caches the countries in the entity cache if it is enabled.
	*
	* @param countries the countries to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.Country> countries) {
		getPersistence().cacheResult(countries);
	}

	/**
	* Creates a new country with the primary key. Does not add the country to the database.
	*
	* @param countryId the primary key for the new country
	* @return the new country
	*/
	public static com.liferay.portal.model.Country create(long countryId) {
		return getPersistence().create(countryId);
	}

	/**
	* Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryId the primary key of the country to remove
	* @return the country that was removed
	* @throws com.liferay.portal.NoSuchCountryException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country remove(long countryId)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(countryId);
	}

	public static com.liferay.portal.model.Country updateImpl(
		com.liferay.portal.model.Country country, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(country, merge);
	}

	/**
	* Finds the country with the primary key or throws a {@link com.liferay.portal.NoSuchCountryException} if it could not be found.
	*
	* @param countryId the primary key of the country to find
	* @return the country
	* @throws com.liferay.portal.NoSuchCountryException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByPrimaryKey(
		long countryId)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(countryId);
	}

	/**
	* Finds the country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryId the primary key of the country to find
	* @return the country, or <code>null</code> if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByPrimaryKey(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(countryId);
	}

	/**
	* Finds the country where name = &#63; or throws a {@link com.liferay.portal.NoSuchCountryException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching country
	* @throws com.liferay.portal.NoSuchCountryException if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByName(
		java.lang.String name)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Finds the country where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Finds the country where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Finds the country where a2 = &#63; or throws a {@link com.liferay.portal.NoSuchCountryException} if it could not be found.
	*
	* @param a2 the a2 to search with
	* @return the matching country
	* @throws com.liferay.portal.NoSuchCountryException if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByA2(java.lang.String a2)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA2(a2);
	}

	/**
	* Finds the country where a2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param a2 the a2 to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByA2(
		java.lang.String a2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA2(a2);
	}

	/**
	* Finds the country where a2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param a2 the a2 to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByA2(
		java.lang.String a2, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA2(a2, retrieveFromCache);
	}

	/**
	* Finds the country where a3 = &#63; or throws a {@link com.liferay.portal.NoSuchCountryException} if it could not be found.
	*
	* @param a3 the a3 to search with
	* @return the matching country
	* @throws com.liferay.portal.NoSuchCountryException if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByA3(java.lang.String a3)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA3(a3);
	}

	/**
	* Finds the country where a3 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param a3 the a3 to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByA3(
		java.lang.String a3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA3(a3);
	}

	/**
	* Finds the country where a3 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param a3 the a3 to search with
	* @return the matching country, or <code>null</code> if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country fetchByA3(
		java.lang.String a3, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA3(a3, retrieveFromCache);
	}

	/**
	* Finds all the countries where active = &#63;.
	*
	* @param active the active to search with
	* @return the matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active);
	}

	/**
	* Finds a range of all the countries where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param start the lower bound of the range of countries to return
	* @param end the upper bound of the range of countries to return (not inclusive)
	* @return the range of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	* Finds an ordered range of all the countries where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param start the lower bound of the range of countries to return
	* @param end the upper bound of the range of countries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive(active, start, end, orderByComparator);
	}

	/**
	* Finds the first country in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching country
	* @throws com.liferay.portal.NoSuchCountryException if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	* Finds the last country in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching country
	* @throws com.liferay.portal.NoSuchCountryException if a matching country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	* Finds the countries before and after the current country in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the primary key of the current country
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next country
	* @throws com.liferay.portal.NoSuchCountryException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Country[] findByActive_PrevAndNext(
		long countryId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive_PrevAndNext(countryId, active,
			orderByComparator);
	}

	/**
	* Finds all the countries.
	*
	* @return the countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of countries to return
	* @param end the upper bound of the range of countries to return (not inclusive)
	* @return the range of countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of countries to return
	* @param end the upper bound of the range of countries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Country> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the country where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes the country where a2 = &#63; from the database.
	*
	* @param a2 the a2 to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA2(java.lang.String a2)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA2(a2);
	}

	/**
	* Removes the country where a3 = &#63; from the database.
	*
	* @param a3 the a3 to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA3(java.lang.String a3)
		throws com.liferay.portal.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA3(a3);
	}

	/**
	* Removes all the countries where active = &#63; from the database.
	*
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActive(active);
	}

	/**
	* Removes all the countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the countries where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Counts all the countries where a2 = &#63;.
	*
	* @param a2 the a2 to search with
	* @return the number of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA2(java.lang.String a2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA2(a2);
	}

	/**
	* Counts all the countries where a3 = &#63;.
	*
	* @param a3 the a3 to search with
	* @return the number of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA3(java.lang.String a3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA3(a3);
	}

	/**
	* Counts all the countries where active = &#63;.
	*
	* @param active the active to search with
	* @return the number of matching countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActive(active);
	}

	/**
	* Counts all the countries.
	*
	* @return the number of countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CountryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CountryPersistence)PortalBeanLocatorUtil.locate(CountryPersistence.class.getName());

			ReferenceRegistry.registerReference(CountryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CountryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CountryUtil.class, "_persistence");
	}

	private static CountryPersistence _persistence;
}