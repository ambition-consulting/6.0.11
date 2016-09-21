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
import com.liferay.portal.model.Company;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the company service. This utility wraps {@link CompanyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyPersistence
 * @see CompanyPersistenceImpl
 * @generated
 */
public class CompanyUtil {
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
	public static void clearCache(Company company) {
		getPersistence().clearCache(company);
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
	public static List<Company> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Company> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Company> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Company remove(Company company) throws SystemException {
		return getPersistence().remove(company);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Company update(Company company, boolean merge)
		throws SystemException {
		return getPersistence().update(company, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Company update(Company company, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(company, merge, serviceContext);
	}

	/**
	* Caches the company in the entity cache if it is enabled.
	*
	* @param company the company to cache
	*/
	public static void cacheResult(com.liferay.portal.model.Company company) {
		getPersistence().cacheResult(company);
	}

	/**
	* Caches the companies in the entity cache if it is enabled.
	*
	* @param companies the companies to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.Company> companies) {
		getPersistence().cacheResult(companies);
	}

	/**
	* Creates a new company with the primary key. Does not add the company to the database.
	*
	* @param companyId the primary key for the new company
	* @return the new company
	*/
	public static com.liferay.portal.model.Company create(long companyId) {
		return getPersistence().create(companyId);
	}

	/**
	* Removes the company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the company to remove
	* @return the company that was removed
	* @throws com.liferay.portal.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company remove(long companyId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(companyId);
	}

	public static com.liferay.portal.model.Company updateImpl(
		com.liferay.portal.model.Company company, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(company, merge);
	}

	/**
	* Finds the company with the primary key or throws a {@link com.liferay.portal.NoSuchCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the company to find
	* @return the company
	* @throws com.liferay.portal.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findByPrimaryKey(
		long companyId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(companyId);
	}

	/**
	* Finds the company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the company to find
	* @return the company, or <code>null</code> if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByPrimaryKey(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(companyId);
	}

	/**
	* Finds the company where webId = &#63; or throws a {@link com.liferay.portal.NoSuchCompanyException} if it could not be found.
	*
	* @param webId the web id to search with
	* @return the matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findByWebId(
		java.lang.String webId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWebId(webId);
	}

	/**
	* Finds the company where webId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webId the web id to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByWebId(
		java.lang.String webId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWebId(webId);
	}

	/**
	* Finds the company where webId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webId the web id to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByWebId(
		java.lang.String webId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWebId(webId, retrieveFromCache);
	}

	/**
	* Finds the company where virtualHost = &#63; or throws a {@link com.liferay.portal.NoSuchCompanyException} if it could not be found.
	*
	* @param virtualHost the virtual host to search with
	* @return the matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findByVirtualHost(
		java.lang.String virtualHost)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVirtualHost(virtualHost);
	}

	/**
	* Finds the company where virtualHost = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param virtualHost the virtual host to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByVirtualHost(
		java.lang.String virtualHost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVirtualHost(virtualHost);
	}

	/**
	* Finds the company where virtualHost = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param virtualHost the virtual host to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByVirtualHost(
		java.lang.String virtualHost, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVirtualHost(virtualHost, retrieveFromCache);
	}

	/**
	* Finds the company where mx = &#63; or throws a {@link com.liferay.portal.NoSuchCompanyException} if it could not be found.
	*
	* @param mx the mx to search with
	* @return the matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findByMx(java.lang.String mx)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMx(mx);
	}

	/**
	* Finds the company where mx = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mx the mx to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByMx(
		java.lang.String mx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMx(mx);
	}

	/**
	* Finds the company where mx = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mx the mx to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByMx(
		java.lang.String mx, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMx(mx, retrieveFromCache);
	}

	/**
	* Finds the company where logoId = &#63; or throws a {@link com.liferay.portal.NoSuchCompanyException} if it could not be found.
	*
	* @param logoId the logo id to search with
	* @return the matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findByLogoId(long logoId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLogoId(logoId);
	}

	/**
	* Finds the company where logoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param logoId the logo id to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByLogoId(long logoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLogoId(logoId);
	}

	/**
	* Finds the company where logoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param logoId the logo id to search with
	* @return the matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company fetchByLogoId(long logoId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLogoId(logoId, retrieveFromCache);
	}

	/**
	* Finds all the companies where system = &#63;.
	*
	* @param system the system to search with
	* @return the matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findBySystem(
		boolean system)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySystem(system);
	}

	/**
	* Finds a range of all the companies where system = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param system the system to search with
	* @param start the lower bound of the range of companies to return
	* @param end the upper bound of the range of companies to return (not inclusive)
	* @return the range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findBySystem(
		boolean system, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySystem(system, start, end);
	}

	/**
	* Finds an ordered range of all the companies where system = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param system the system to search with
	* @param start the lower bound of the range of companies to return
	* @param end the upper bound of the range of companies to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findBySystem(
		boolean system, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySystem(system, start, end, orderByComparator);
	}

	/**
	* Finds the first company in the ordered set where system = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param system the system to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findBySystem_First(
		boolean system,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySystem_First(system, orderByComparator);
	}

	/**
	* Finds the last company in the ordered set where system = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param system the system to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching company
	* @throws com.liferay.portal.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company findBySystem_Last(
		boolean system,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySystem_Last(system, orderByComparator);
	}

	/**
	* Finds the companies before and after the current company in the ordered set where system = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the primary key of the current company
	* @param system the system to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next company
	* @throws com.liferay.portal.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Company[] findBySystem_PrevAndNext(
		long companyId, boolean system,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySystem_PrevAndNext(companyId, system,
			orderByComparator);
	}

	/**
	* Finds all the companies.
	*
	* @return the companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of companies to return
	* @param end the upper bound of the range of companies to return (not inclusive)
	* @return the range of companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of companies to return
	* @param end the upper bound of the range of companies to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Company> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the company where webId = &#63; from the database.
	*
	* @param webId the web id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWebId(java.lang.String webId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWebId(webId);
	}

	/**
	* Removes the company where virtualHost = &#63; from the database.
	*
	* @param virtualHost the virtual host to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVirtualHost(java.lang.String virtualHost)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVirtualHost(virtualHost);
	}

	/**
	* Removes the company where mx = &#63; from the database.
	*
	* @param mx the mx to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMx(java.lang.String mx)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMx(mx);
	}

	/**
	* Removes the company where logoId = &#63; from the database.
	*
	* @param logoId the logo id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLogoId(long logoId)
		throws com.liferay.portal.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLogoId(logoId);
	}

	/**
	* Removes all the companies where system = &#63; from the database.
	*
	* @param system the system to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySystem(boolean system)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySystem(system);
	}

	/**
	* Removes all the companies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the companies where webId = &#63;.
	*
	* @param webId the web id to search with
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWebId(java.lang.String webId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWebId(webId);
	}

	/**
	* Counts all the companies where virtualHost = &#63;.
	*
	* @param virtualHost the virtual host to search with
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVirtualHost(java.lang.String virtualHost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVirtualHost(virtualHost);
	}

	/**
	* Counts all the companies where mx = &#63;.
	*
	* @param mx the mx to search with
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMx(java.lang.String mx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMx(mx);
	}

	/**
	* Counts all the companies where logoId = &#63;.
	*
	* @param logoId the logo id to search with
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLogoId(long logoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLogoId(logoId);
	}

	/**
	* Counts all the companies where system = &#63;.
	*
	* @param system the system to search with
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySystem(boolean system)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySystem(system);
	}

	/**
	* Counts all the companies.
	*
	* @return the number of companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompanyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompanyPersistence)PortalBeanLocatorUtil.locate(CompanyPersistence.class.getName());

			ReferenceRegistry.registerReference(CompanyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CompanyPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CompanyUtil.class, "_persistence");
	}

	private static CompanyPersistence _persistence;
}