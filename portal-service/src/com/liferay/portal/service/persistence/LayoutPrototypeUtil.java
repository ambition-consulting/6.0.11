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
import com.liferay.portal.model.LayoutPrototype;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the layout prototype service. This utility wraps {@link LayoutPrototypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPrototypePersistence
 * @see LayoutPrototypePersistenceImpl
 * @generated
 */
public class LayoutPrototypeUtil {
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
	public static void clearCache(LayoutPrototype layoutPrototype) {
		getPersistence().clearCache(layoutPrototype);
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
	public static List<LayoutPrototype> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LayoutPrototype> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LayoutPrototype> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static LayoutPrototype remove(LayoutPrototype layoutPrototype)
		throws SystemException {
		return getPersistence().remove(layoutPrototype);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LayoutPrototype update(LayoutPrototype layoutPrototype,
		boolean merge) throws SystemException {
		return getPersistence().update(layoutPrototype, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LayoutPrototype update(LayoutPrototype layoutPrototype,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(layoutPrototype, merge, serviceContext);
	}

	/**
	* Caches the layout prototype in the entity cache if it is enabled.
	*
	* @param layoutPrototype the layout prototype to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.LayoutPrototype layoutPrototype) {
		getPersistence().cacheResult(layoutPrototype);
	}

	/**
	* Caches the layout prototypes in the entity cache if it is enabled.
	*
	* @param layoutPrototypes the layout prototypes to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.LayoutPrototype> layoutPrototypes) {
		getPersistence().cacheResult(layoutPrototypes);
	}

	/**
	* Creates a new layout prototype with the primary key. Does not add the layout prototype to the database.
	*
	* @param layoutPrototypeId the primary key for the new layout prototype
	* @return the new layout prototype
	*/
	public static com.liferay.portal.model.LayoutPrototype create(
		long layoutPrototypeId) {
		return getPersistence().create(layoutPrototypeId);
	}

	/**
	* Removes the layout prototype with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layoutPrototypeId the primary key of the layout prototype to remove
	* @return the layout prototype that was removed
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a layout prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype remove(
		long layoutPrototypeId)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(layoutPrototypeId);
	}

	public static com.liferay.portal.model.LayoutPrototype updateImpl(
		com.liferay.portal.model.LayoutPrototype layoutPrototype, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(layoutPrototype, merge);
	}

	/**
	* Finds the layout prototype with the primary key or throws a {@link com.liferay.portal.NoSuchLayoutPrototypeException} if it could not be found.
	*
	* @param layoutPrototypeId the primary key of the layout prototype to find
	* @return the layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a layout prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype findByPrimaryKey(
		long layoutPrototypeId)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(layoutPrototypeId);
	}

	/**
	* Finds the layout prototype with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param layoutPrototypeId the primary key of the layout prototype to find
	* @return the layout prototype, or <code>null</code> if a layout prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype fetchByPrimaryKey(
		long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(layoutPrototypeId);
	}

	/**
	* Finds all the layout prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Finds a range of all the layout prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @return the range of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the layout prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Finds the first layout prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a matching layout prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Finds the last layout prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a matching layout prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Finds the layout prototypes before and after the current layout prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param layoutPrototypeId the primary key of the current layout prototype
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a layout prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype[] findByCompanyId_PrevAndNext(
		long layoutPrototypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(layoutPrototypeId, companyId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the layout prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the layout prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @return the range of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the layout prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_A(companyId, active);
	}

	/**
	* Finds a range of all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @return the range of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_A(companyId, active, start, end);
	}

	/**
	* Finds an ordered range of all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_A(companyId, active, start, end, orderByComparator);
	}

	/**
	* Finds the first layout prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a matching layout prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype findByC_A_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_A_First(companyId, active, orderByComparator);
	}

	/**
	* Finds the last layout prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a matching layout prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype findByC_A_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_A_Last(companyId, active, orderByComparator);
	}

	/**
	* Finds the layout prototypes before and after the current layout prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param layoutPrototypeId the primary key of the current layout prototype
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next layout prototype
	* @throws com.liferay.portal.NoSuchLayoutPrototypeException if a layout prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.LayoutPrototype[] findByC_A_PrevAndNext(
		long layoutPrototypeId, long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_A_PrevAndNext(layoutPrototypeId, companyId, active,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByC_A(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_A(companyId, active);
	}

	/**
	* Filters by the user's permissions and finds a range of all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @return the range of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByC_A(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_A(companyId, active, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> filterFindByC_A(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_A(companyId, active, start, end,
			orderByComparator);
	}

	/**
	* Finds all the layout prototypes.
	*
	* @return the layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the layout prototypes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @return the range of layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the layout prototypes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of layout prototypes to return
	* @param end the upper bound of the range of layout prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.LayoutPrototype> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the layout prototypes where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the layout prototypes where companyId = &#63; and active = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_A(companyId, active);
	}

	/**
	* Removes all the layout prototypes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the layout prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Filters by the user's permissions and counts all the layout prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Counts all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the number of matching layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_A(companyId, active);
	}

	/**
	* Filters by the user's permissions and counts all the layout prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the number of matching layout prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_A(companyId, active);
	}

	/**
	* Counts all the layout prototypes.
	*
	* @return the number of layout prototypes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LayoutPrototypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LayoutPrototypePersistence)PortalBeanLocatorUtil.locate(LayoutPrototypePersistence.class.getName());

			ReferenceRegistry.registerReference(LayoutPrototypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LayoutPrototypePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LayoutPrototypeUtil.class,
			"_persistence");
	}

	private static LayoutPrototypePersistence _persistence;
}